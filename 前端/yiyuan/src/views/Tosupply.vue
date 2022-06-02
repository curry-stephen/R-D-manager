<!--退货-->
<template>
<el-scrollbar height="100vh">
  <div>
    <div style="width: 100%; height: 40px;margin-top: 10px">
      <div style="margin: 10px"><el-button @click="add2" >创建退货单</el-button></div>
      <div style="position: absolute;
           right: 0px;
         margin-top: -60px;
    padding: 10px"><el-input
              v-model="search"
              placeholder="请输入关键字"
              style="width: 68%;margin: 5px;height: 33px"
              clearable
              
      />
      <el-button type="primary" :icon="Search" @click="queryinfo"
      ><el-icon><search /></el-icon>
      </el-button></div>
    </div>
    <div style="width: 100%">
      <el-table :data="tableData" border stripe style="width: 100%">
        <el-table-column prop="id" label="订单编号" sortable />
        <el-table-column prop="drugname" label="退货药品名称" />
        <el-table-column prop="tupian" label="图片">
          <template #default="scope">
            <el-image
              style="width: 100px; height: 100px"
              :src="scope.row.tupian"
              :preview-src-list="[scope.row.tupian]"
            ></el-image>
          </template>
        </el-table-column>
        <el-table-column prop="count" label="退货数量" />
        <el-table-column prop="pay" label="支付方式" />
        <el-table-column prop="reason" label="退货原因" />
        <el-table-column prop="createtime" label="退货时间" :formatter="dateFormat"/>
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
    <el-dialog v-model="dialogVisible" title="退货信息" width="30%">
      <el-form :model="form" label-width="120px">
        <el-form-item label="退货药品名称">
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
        <el-form-item label="支付方式">
          <el-select
                  v-model="form.pay"
                  type="textarea"
                  placeholder="支付方式"
          >
            <!--            有需要更改value-->
            <el-option v-for="item in pays"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value"/>
          </el-select>
        </el-form-item>
        <el-form-item label="药品数量">
          <el-input-number v-model="form.count" :min="1" style="width: 80%" />
        </el-form-item>
        <el-form-item label="退货原因">
          <el-input
                  v-model="form.reason"
                  type="textarea"
                  placeholder="请填写"
                  style="width: 76%"
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
    
    <el-dialog v-model="EditdialogVisible" title="编辑订单信息" width="30%">
      <el-form :model="editform" label-width="120px">
        <el-form-item label="退货药品名称">
          <el-select
            v-model="editform.drugname"
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
        <el-form-item label="支付方式">
          <el-select
                  v-model="editform.pay"
                  type="textarea"
                  placeholder="支付方式"
          >
            <!--            有需要更改value-->
            <el-option v-for="item in pays"
                       :key="item.value"
                       :label="item.label"
                       :value="item.value"/>
          </el-select>
        </el-form-item>
        <el-form-item label="药品数量">
          <el-input-number v-model="editform.count" :min="1" style="width: 80%" />
        </el-form-item>
        <el-form-item label="退货原因">
          <el-input
                  v-model="editform.reason"
                  type="textarea"
                  placeholder="请填写"
                  style="width: 76%"
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
        datavalue: "",
        currentPage: 1,
        pageSize: 10,
        total: 0,
        dialogVisible: false,
        centerDialogVisible: false,
        EditdialogVisible: false,
        form: {},
        editform: {},
        tableData: [],
        search: "",
        options:"",
        conditions: [{
          value: '未退货',
          label: '未退货'
        }, {
          value: '退货中',
          label: '退货中'
        }, {
          value: '已退货',
          label: '已退货'
        }],
        pays: [{
          value: '支付宝支付',
          label: '支付宝支付'
        }, {
          value: '微信支付',
          label: '微信支付'
        }, {
          value: '货到付款',
          label: '货到付款'
        }],
        value:'',
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
      dateFormat(date){
        return moment(date).format("YYYY-MM-DD")
      },
      //加载数据
      load() {
        request
                .get("/returnsupplier/" + this.currentPage + "/" + this.pageSize)
                .then((res) => {
                  this.tableData = res.data.records;
                  this.total = res.data.total;
                  this.pageSize = res.data.size;
                });
      },
      //添加
      add2() {
        this.dialogVisible = true;
      request.get("/druginfo/drugname").then((res) => {
        console.log(res);
        this.options=res.data
      });
      },
      //添加确定
      save() {
        this.form.username=this.name;
        request.post("/returnsupplier", this.form).then((res) => {
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
        this.EditdialogVisible = true;
        this.editform = JSON.parse(JSON.stringify(row)); //<!--深拷贝，与源数据完全隔离-->
      },
      //编辑确定
      Editsave() {
        this.editform.username=this.name;
        request.put("/returnsupplier", this.editform).then((res) => {
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
        request.delete("/returnsupplier/" + row+"/"+this.name).then((res) => {
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
                        "/returnsupplier/" +
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
      }
    },
  };
</script>

<style>
</style>