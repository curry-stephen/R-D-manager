// 销售记录
<template>
<el-scrollbar height="100vh">
  <div>
    <div style="width: 100%; height: 60px">
      <div style="margin: 10px"><el-button @click="add" >新建</el-button></div>
      <div
        style="position: absolute; right: 0px; margin-top: -60px; padding: 10px"
      >
      <el-input
        v-model="search"
        placeholder="请输入关键字"
        style="width: 68%;margin: 5px;height: 33px"
        clearable
      />
      <el-button type="primary" :icon="Search" @click="queryinfo"
        ><el-icon><search /></el-icon>
      </el-button>
      </div>
    </div>
    <div style="width: 100%">
      <el-table :data="tableData" border stripe style="width: 100%">
        <el-table-column prop="id" label="序号" sortable width="70" />
        <el-table-column prop="tupian" label="图片">
          <template #default="scope">
            <el-image
              style="width: 100px; height: 100px"
              :src="scope.row.tupian"
              :preview-src-list="[scope.row.tupian]"
            ></el-image>
          </template>
        </el-table-column>
        <el-table-column prop="drugname" label="药品名称" />
        <el-table-column prop="number" label="药品编码" />
        <el-table-column prop="count" label="数量" />
        <el-table-column prop="money" label="金额" />
        <el-table-column prop="operator" label="操作人" />
        <el-table-column prop="operatetime" label="操作时间"  :formatter="dateFormat"/>
        <el-table-column label="操作" width="160">
          <template #default="scope">
            <el-button size="mini" @click="handleEdit(scope.row)"
              >编辑
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
    <el-dialog v-model="dialogVisible" title="新增" width="30%">
      <el-form :model="form" label-width="120px">
        <el-form-item label="药品名称">
          <el-select
            v-model="form.drugname"
            placeholder="请选择药品"
            size="large"
            @change="Selectprice"
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
        <el-form-item label="药品编号">
          <el-input v-model="form.number" disabled style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="数量">
          <el-input-number v-model="form.count" :min="1" style="width: 80%" @input="jine"/>
        </el-form-item>
        <el-form-item label="金额">
          <el-input v-model="form.money" disabled style="width: 80%"></el-input>
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
        <el-form-item label="药品名称">
          <el-select
            v-model="editform.drugname"
            placeholder="请选择药品"
            size="large"
            @change="Selectprice"
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
        <el-form-item label="药品编号">
          <el-input v-model="editform.number" disabled style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="数量">
          <el-input-number v-model="editform.count" :min="1" style="width: 80%" @input="Editjine"/>
        </el-form-item>
        <el-form-item label="金额">
          <el-input v-model="editform.money" disabled style="width: 80%"></el-input>
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
import moment from 'moment'
import router from "../router";
export default {
  data() {
    return {
      options: [],
      currentPage: 1,
      pageSize: 10,
      total: 0,
      dialogVisible: false,
      EditdialogVisible: false,
      form: {},
      editform: {},
      tableData: [],
      search: "",
      price:"",
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
  computed:{
    
  },
  methods: {
    //计算总价格
    jine(){
      this.form.money=this.price*this.form.count
    },
    Editjine(){
      this.editform.money=this.price*this.editform.count
    },
    //查询单价
    Selectprice(row){
      console.log("查询单价");
      console.log(row);
      request.get("/druginfo/price/"+row).then(res=>{
        this.price=res.data
        console.log(this.price);
      })
      this.querynumber(row);
    },
    //格式化日期
    dateFormat(date){
        return moment(date).format("YYYY-MM-DD")
      },
    //加载数据
    load() {
      request
        .get("/saleinfo/" + this.currentPage + "/" + this.pageSize)
        .then((res) => {
          this.tableData = res.data.records;
          this.total = res.data.total;
          this.pageSize = res.data.size;
        });
    },
    //添加
    add() {
      this.dialogVisible = true;
      request.get("/druginfo/drugname").then((res) => {
        console.log(res);
        this.options = res.data;
      });
    },
    //添加确定
    addsave() {
      this.jine();
      this.form.tupian = this.imgurl;
      this.form.operator=this.name;
      request.post("/saleinfo", this.form).then((res) => {
        if (res.falg) {
          this.$message.success(res.msg);
        } else {
          this.$message.error(res.msg);
        }
        this.load();
        this.dialogVisible = false;
      });
    },
    //编辑
    handleEdit(row) {
      console.log(row);
      this.EditdialogVisible = true;
      request.get("/druginfo/drugname").then((res) => {
        this.options = res.data;
      });
      this.editform = JSON.parse(JSON.stringify(row)); //<!--深拷贝，与源数据完全隔离-->
      this.Selectprice(this.editform.drugname)
    },
    //编辑确定
    Editsave() {
      
      this.Editjine();
      this.editform.tupian = this.imgurl;
      this.editform.operator=this.name;
      console.log(this.name);
      request.put("/saleinfo", this.editform).then((res) => {
        if (res.falg) {
          this.$message.success(res.msg);
        } else {
          this.$message.error(res.msg);
        }
        this.load();
        this.EditdialogVisible = false;
      });
    },
    //删除
    handleDelete(row) {
      request.delete("/saleinfo/" + row+"/"+this.name).then((res) => {
        if (res.falg) {
          this.$message.success(res.msg);
        } else {
          this.$message.error(res.msg);
        }
        this.load();
      });
    },
    //查询
    queryinfo() {
      request
        .get(
          "/saleinfo/" +
            this.currentPage +
            "/" +
            this.pageSize +
            "/" +
            this.search
        )
        .then((res) => {
          this.tableData = res.data.records;
          this.total = res.data.total;
          this.pageSize = res.data.size;
          if (res.falg) {
            this.$message.success(res.msg);
          } else {
            this.$message.error(res.msg);
          }
        });
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
    //查询编号
    querynumber(drugname){
      request.get("/druginfo/number/"+drugname).then(res=>{
        this.form.number=res.data
      })
    }
  },
};
</script>

<style>
</style>