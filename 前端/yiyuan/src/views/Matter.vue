// 问题药品
<template>
<el-scrollbar height="100vh">
  <div>
    <div style="width: 100%; height: 60px">
      <div style="margin: 10px"><el-button @click="add">新建</el-button></div>
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
    <div style="width: 100%">
      <el-table :data="tableData" border stripe style="width: 100%">
        <el-table-column prop="id" label="序号" sortable />
        <el-table-column prop="drugname" label="药品名称" />
        <el-table-column prop="matternum" label="问题数量" />
        <el-table-column prop="price" label="药品单价" />
        <el-table-column prop="ctime" label="操作时间" />
        <el-table-column label="操作" width="230">
          <template #default="scope">
            <el-button size="mini" @click="handleEdit(scope.row)">
              编辑
            </el-button>
            <el-button size="mini" @click="handleInfo(scope.row)" type="info">
              详情
            </el-button>
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
    <el-dialog v-model="dialogVisible" title="新增问题药品信息" width="30%">
      <el-form :model="form" label-width="120px">
        <el-form-item label="药品名称">
          <el-select
            v-model="form.drugname"
            placeholder="请选择药品名称"
            size="large"
          >
            <el-option
              v-for="item in options"
              :key="item"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="药品数量">
          <el-input-number v-model="form.matternum" :min="1" style="width: 80%" />
        </el-form-item>
        <el-form-item label="药品单价">
          <el-input v-model="form.price" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="问题原因">
          <el-input
            v-model="form.miaos"
            :autosize="{ minRows: 2, maxRows: 6 }"
            type="textarea"
            placeholder="请输入问题"
          />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="save">确定</el-button>
        </span>
      </template>
    </el-dialog>
    <el-dialog v-model="EditdialogVisible" title="编辑问题药品信息" width="30%">
      <el-form :model="editform" label-width="120px">
        <el-form-item label="药品名称">
          <el-input v-model="editform.drugname" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="药品数量">
          <el-input-number v-model="editform.matternum" :min="1" style="width: 80%" />
        </el-form-item>
        <el-form-item label="药品单价">
          <el-input v-model="editform.price" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="问题原因">
          <el-input
            v-model="editform.miaos"
            :autosize="{ minRows: 2, maxRows: 6 }"
            type="textarea"
            placeholder="请输入问题"
          />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="EditdialogVisible = false">取消</el-button>
          <el-button type="primary" @click="Editsave">确定</el-button>
        </span>
      </template>
    </el-dialog>
    <!--详情-->
    <el-dialog v-model="centerDialogVisible" title="详情" width="30%" center>
     <el-form :model="xform" label-width="120px">
        <el-form-item label="药品名称:">
          <label>{{xform.drugname}}</label>
        </el-form-item>
        <el-form-item label="药品数量:">
          <label>{{xform.matternum}}</label>
        </el-form-item>
        <el-form-item label="药品单价:">
          <label>{{xform.price}}元</label>
        </el-form-item>
        <el-form-item label="问题原因:">
          <label>{{xform.miaos}}</label>
        </el-form-item>
        <el-form-item label="药品图片:">
            <el-image
                style="width: 100px; height: 100px"
                :src="xform.img"
            ></el-image>
        </el-form-item>
      </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="centerDialogVisible = false">确定</el-button>
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
export default {
  data() {
    return {
      options: [
      ],
      datavalue: "",
      currentPage: 1,
      pageSize: 10,
      total: 0,
      dialogVisible: false,
      centerDialogVisible:false,
      EditdialogVisible: false,
      form: {},
      editform:{},
      xform:{},
      tableData: [
      ],
      tupian:'',
      search:'',
      name:''
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
    //加载数据
    load() {
      request.get("/matter/"+this.currentPage+"/"+this.pageSize).then(res=>{
        console.log(res);
        this.tableData=res.data.records;
        this.total=res.data.total;
        this.pageSize=res.data.size;
      })
    },
    //添加
    add() {
      console.log("新增");
      this.dialogVisible = true;
      request.get("/druginfo/drugname").then((res) => {
        console.log(res);
        this.options=res.data
      });
    },
    //添加确定
    save(){
      this.form.username=this.name;
      request.post("/matter",this.form).then(res=>{
        console.log(res);
        if(res.falg){
          this.$message.success(res.msg)
        }else{
          this.$message.error(res.msg)
        }
        this.load();
        this.dialogVisible=false;
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
      this.editform.username=this.name
      request.put("/matter",this.editform).then(res=>{
        if(res.falg){
          this.$message.success(res.msg)
        }else{
          this.$message.error(res.msg)
        }
        this.load();
        this.EditdialogVisible = false;
      })
    },
    //删除
    handleDelete(row) {
      request.delete("/matter/"+row+"/"+this.name).then(res=>{
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
      console.log(this.currentPage);
      console.log(this.pageSize);
      console.log(this.search);
      request.get("/matter/"+this.currentPage+"/"+this.pageSize+"/"+this.search).then(res=>{
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
    //详情
    handleInfo(row){
      this.centerDialogVisible=true;
      console.log(row);
      this.xform=row
    },
            //改变每页条数
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.load();
    },
    //改变页数
    handleCurrentChange(pageNum) {
      this.currentPage = pageNum;
      this.load();
    },
  },
};
</script>

<style>
:root {
  --el-color-primary: #409eff;
}
</style>