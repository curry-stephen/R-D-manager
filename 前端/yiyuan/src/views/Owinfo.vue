// 登记出入库信息
<template>
<el-scrollbar height="100vh">
  <div>
    <div style="width: 100%; height: 60px;margin: 10px">
      <div style="margin: 10px"><el-button @click="add" >新建</el-button></div>
      <div
        style="position: absolute; right: 0px; margin-top: -60px; padding: 10px"
      >
     <el-input v-model="search" placeholder="请输入关键字" style="width: 68%;margin: 5px;height: 33px" clearable/>
      <el-button type="primary" :icon="Search" @click="queryinfo"
      ><el-icon><search /></el-icon>
      </el-button
      >
      </div>
    </div>
    <div style="width: 100%;">
      <el-table :data="tableData" border stripe style="width: 100%">
        <el-table-column prop="id" label="序号" sortable/>
        <el-table-column prop="tupian" label="图片">
          <template #default="scope">
            <el-image
                style="width: 100px; height: 100px"
                :src="scope.row.tupian"
                :preview-src-list="[scope.row.tupian]"
            ></el-image>
          </template>
        </el-table-column>
        <el-table-column prop="drugname" label="药品名称"/>
        <el-table-column prop="outin" label="出库\入库"/>
        <el-table-column prop="nums" label="数量"/>
        <el-table-column prop="druguser" label="操作人"/>
        <el-table-column prop="ctime" label="操作时间"/>
        <el-table-column label="操作" width="200">
          <template #default="scope">
            <el-button size="mini" @click="handleEdit(scope.row)"
            >编辑
            </el-button
            >
            <el-popconfirm
                confirm-button-text="OK"
                cancel-button-text="取消"
                icon-color="red"
                title="确认删除吗?"
                @confirm="handleDelete(scope.row.id)"
            >
              <template #reference>
                <el-button size="mini" type="danger">删除</el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
          v-model:currentPage="currentPage"
          :page-sizes="[5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
    </div>
    <el-dialog v-model="dialogVisible" title="新增" width="30%">
      <el-form :model="form" label-width="120px">
        <el-form-item label="药品名">
          <el-input v-model="form.drugname" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="出库\入库">
          <el-radio v-model="form.outin" label="出库">出库</el-radio>
          <el-radio v-model="form.outin" label="入库">入库</el-radio>
        </el-form-item>
        <el-form-item label="数量">
          <el-input v-model="form.nums" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="保质期（月）">
          <el-input v-model="form.warrenty" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="厂商名称">
          <el-input v-model="form.spname" style="width: 80%" />
        </el-form-item>
        <el-form-item label="生产日期">
          <el-date-picker
        v-model="form.producttime"
        type="date"
        placeholder="请选择日期"
        :default-value="new Date()"
      >
      </el-date-picker>
        </el-form-item>
        <el-form-item label="图片" v-model="form.tupian">
            <el-upload
                class="upload-demo"
                action="http://localhost:8090/files/upload" :on-success="filesccuss" ref="upload">
              <el-button type="primary" >上传</el-button>
            </el-upload>
          </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="addsave">确定</el-button>
        </span>
      </template>
    </el-dialog>
    <el-dialog v-model="EditdialogVisible" title="编辑" width="30%">
      <el-form :model="editform" label-width="120px">
        <el-form-item label="药品名">
          <el-input v-model="editform.drugname" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="出库\入库">
          <el-radio v-model="editform.outin" label="出库">出库</el-radio>
          <el-radio v-model="editform.outin" label="入库">入库</el-radio>
        </el-form-item>
        <el-form-item label="数量">
          <el-input v-model="editform.nums" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="保质期（月）">
          <el-input v-model="editform.warrenty" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="厂商名称">
          <el-input v-model="editform.spname" style="width: 80%" />
        </el-form-item>
        <el-form-item label="生产日期">
          <el-date-picker
        v-model="editform.producttime"
        type="date"
        placeholder="请选择日期"
        :default-value="new Date()"
      >
      </el-date-picker>
        </el-form-item>
        <el-form-item label="图片" v-model="editform.tupian">
            <el-upload
                class="upload-demo"
                action="http://localhost:7788/files/upload" :on-success="filesccuss" ref="upload">
              <el-button type="primary" >上传</el-button>
            </el-upload>
          </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="EditdialogVisible = false">取消</el-button>
          <el-button type="primary" @click="Editsave">确定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</el-scrollbar>
</template>

<script>
import { Edit, Share, Delete, Search, Upload } from '@element-plus/icons-vue'
import request from "../utils/request";
import router from "../router";
import axios from "axios"
let imgurl;
export default {
  components: {
            Search
        },
  data() {
    return {
      currentPage:1,
      pageSize:10,
      total:0,
      dialogVisible: false,
      EditdialogVisible: false,
      form: {},
      editform:{},
      tableData: [],
      search:'',
      name:""
    };
  },
  components: {
    Search,
  },
  created() {
    this.load();
    let userJson=sessionStorage.getItem('user')
    if(!userJson){
      alert("请先登录!")
        router.push('/login')
    }else{
      let user1=JSON.parse(userJson);
    this.name=user1.name;
    }
    
  },
  methods: {
    //上传图片
    filesccuss(res){
      this.imgurl=res.data;
       if(res.falg){
          this.$message.success(res.msg)
        }else{
          this.$message.error(res.msg)
        }
      console.log(res);
    },
    //加载数据
    load() {
      request.get("/owinfo/"+this.currentPage+"/"+this.pageSize).then(res=>{
        console.log(res);
        this.tableData=res.data.records;
        this.total=res.data.total;
        this.pageSize=res.data.size;
      })
    },
    //添加
    add() {
      this.dialogVisible = true;
    },
    //添加确定
    addsave(){
      this.form.druguser=this.name
      this.form.tupian=this.imgurl
      request.post("/owinfo",this.form).then(res=>{
        console.log(res);
        if(res.falg){
          this.$message.success(res.msg)
        }else{
          this.$message.error(res.msg)
        }
        this.load();
        this.dialogVisible = false;
      })
      
    },
    //编辑
    handleEdit(row) {
      console.log(row);
      this.EditdialogVisible = true;
      this.editform=JSON.parse(JSON.stringify(row))//<!--深拷贝，与源数据完全隔离-->
    },
    //编辑确定
    Editsave(){
      this.editform.druguser=this.name
      this.editform.tupian=this.imgurl
      request.put("/owinfo",this.editform).then(res=>{
        if(res.falg){
          this.$message.success(res.msg)
        }else{
          this.$message.error(res.msg)
        }
        this.load();
        this.EditdialogVisible =false;
      })

    },
    //删除
    handleDelete(row) {
      console.log(row);
      request.delete("/owinfo/"+row+"/"+this.name).then(res=>{
        if(res.falg){
          this.$message.success(res.msg)
        }else{
          this.$message.error(res.msg)
        }
        this.load();
      })
    },
    //查询
    queryinfo() {
      request.get("/owinfo/"+this.currentPage+"/"+this.pageSize+"/"+this.search).then(res=>{
        this.tableData=res.data.records;
        this.total=res.data.total;
        this.pageSize=res.data.size;
        if(res.falg){
          this.$message.success(res.msg)
        }else{
          this.$message.error(res.msg)
        }
      })
    },
    //改变每页条数
    handleSizeChange(pageSize){
      this.pageSize=pageSize
      this.load()
    },
    //改变页数
    handleCurrentChange(pageNum){
      this.currentPage=pageNum
      this.load()
    },
  },
};
</script>

<style>
:root {
  --el-color-primary: #409eff;
}
</style>