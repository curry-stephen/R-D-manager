<!--账单信息-->
<template>
<el-scrollbar height="100vh">
  <div>
    <div style="width: 100%; height: 40px; margin-top: 10px">
      <div style="margin: 10px">
        <el-button @click="add2" >添加账单</el-button>
      </div>
      <div
        style="position: absolute; right: 0px; margin-top: -60px; padding: 10px"
      >
        <el-input
          v-model="search"
          placeholder="请输入关键字"
          style="width: 68%; margin: 5px; height: 33px"
          clearable
        />
        <el-button type="primary" :icon="Search" @click="queryinfo"
          ><el-icon><search /></el-icon>
        </el-button>
      </div>
    </div>
    <div style="width: 100%">
      <el-table :data="tableData" border stripe style="width: 100%">
        <el-table-column prop="id" label="序号" sortable />
        <el-table-column prop="num" label="药品编号" />
        <el-table-column prop="drugname" label="药品名" />
        <el-table-column prop="count" label="药品数量" />
        <el-table-column prop="tupian" label="药品图">
          <template #default="scope">
            <el-image
              style="width: 100px; height: 100px"
              :src="scope.row.tupian"
              :preview-src-list="[scope.row.tupian]"
            ></el-image>
          </template>
        </el-table-column>
        <el-table-column prop="price" label="单价" />
        <el-table-column
          prop="createtime"
          label="创建时间"
          :formatter="dateFormat"
        />
        <el-table-column label="操作" width="230">
          <template #default="scope">
            <el-button size="mini" @click="handleEdit(scope.row)">
              编辑
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
    <el-dialog v-model="dialogVisible" title="账单信息" width="30%">
      <el-form :model="bform" label-width="120px">
                <el-form-item label="药品名称:">
          <el-select
            v-model="bform.drugname"
            placeholder="请选择药品名称"
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
        <el-form-item label="药品编号:">
          <el-input v-model="bform.num" disabled style="width: 218px" />
        </el-form-item>
        <el-form-item label="药品数量:">
          <el-input-number v-model="bform.count" :min="1" style="width: 80%" />
        </el-form-item>

        <el-form-item label="单价:">
          <el-input v-model="bform.price" disabled style="width: 218px"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="addsave">确定</el-button>
        </span>
      </template>
    </el-dialog>

    <el-dialog v-model="EditdialogVisible" title="编辑账单信息" width="30%">
      <el-form :model="editform" label-width="120px">
        <el-form-item label="药品编号:">
          <el-input v-model="editform.num" disabled style="width: 218px" />
        </el-form-item>
        <el-form-item label="药品数量:">
          <el-input-number v-model="editform.count" :min="1" style="width: 80%" />
        </el-form-item>
        <el-form-item label="药品名称:">
          <el-select
            v-model="editform.drugname"
            placeholder="请选择药品名称"
            size="large"
            @change="EditSelectprice"
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
        <el-form-item label="单价:">
          <el-input v-model="editform.price" disabled style="width: 218px"></el-input>
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
import moment from "moment";
import router from "../router";
let imgurl;
export default {
  data() {
    return {
      currentPage: 1,
      pageSize: 10,
      total: 0,
      dialogVisible: false,
      EditdialogVisible: false,
      bform: {},
      editform: {},
      tableData: [],
      search: "",
      options: "",
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
    //格式化日期
    dateFormat(date) {
      return moment(date).format("YYYY-MM-DD");
    },
    //上传图片
    filesccuss(res) {
      this.imgurl = res.data;
      if (res.falg) {
        this.$message.success(res.msg);
      } else {
        this.$message.error(res.msg);
      }
      console.log(res);
    },
    //加载数据
    load() {
      console.log("初始化");
      request
        .get("/bill/" + this.currentPage + "/" + this.pageSize)
        .then((res) => {
          console.log(res);
          this.tableData = res.data.records;
          this.total = res.data.total;
          this.pageSize = res.data.size;
        });
    },
    //添加
    add2() {
      console.log("添加");
      this.dialogVisible = true;
      request.get("/druginfo/drugname").then((res) => {
        console.log(res);
        this.options = res.data;
      });
    },
    //查询编号
    Selectprice(row) {
      request.get("/druginfo/price/"+row).then(res=>{
        this.bform.price=res.data
        console.log(this.price);
      })
      request.get("/druginfo/number/" + row).then((res) => {
        this.bform.num = res.data;
      });
    },
    EditSelectprice(row){
      request.get("/druginfo/price/"+row).then(res=>{
        this.editform.price=res.data
        console.log(this.price);
      })
      request.get("/druginfo/number/" + row).then((res) => {
        this.editform.num = res.data;
      });
    },
    //添加确定
    addsave() {
      this.bform.username=this.name
      this.bform.tupian = this.imgurl;
      request.post("/bill", this.bform).then((res) => {
        console.log(res);
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
      this.editform = JSON.parse(JSON.stringify(row)); //<!--深拷贝，与源数据完全隔离-->
    },
    //编辑确定
    Editsave() {
      this.editform.username=this.name
      this.editform.tupian = this.imgurl;
      request.put("/bill", this.editform).then((res) => {
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
      console.log(row);
      request.delete("/bill/" + row+"/"+this.name).then((res) => {
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
      console.log(this.currentPage);
      console.log(this.pageSize);
      console.log(this.search);
      request
        .get(
          "/bill/" + this.currentPage + "/" + this.pageSize + "/" + this.search
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
      console.log("每页数据条数");
      console.log(pageSize);
      this.pageSize = pageSize;
      this.load();
    },
    //改变页数
    handleCurrentChange(pageNum) {
      console.log(pageNum);
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

<style>
</style>