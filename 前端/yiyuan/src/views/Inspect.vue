// 保质期
<template>
<el-scrollbar height="100vh">
  <div>
    <div style="width: 100%; height: 60px">
      <el-input
          v-model="search"
          placeholder="根据药品名称查询"
          style="width: 68%;margin: 5px;height: 33px"
          clearable
      />
      <el-button type="primary" :icon="Search" @click="queryinfo"
      ><el-icon><search /></el-icon>
      </el-button
      >
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
        <el-table-column prop="warrenty" label="保质期（月）"/>
        <el-table-column prop="producttime" label="生产日期" :formatter="dateFormat"/>
        <el-table-column prop="guotime" label="是否已经过期"/>
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
      currentPage: 1,
      pageSize: 10,
      total: 0,
      tableData: [
      ],
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
    //格式化日期
    dateFormat(date){
        return moment(date).format("YYYY-MM-DD")
      },
    //加载数据
    load() {
      request
        .get("/druginfo/" + this.currentPage + "/" + this.pageSize)
        .then((res) => {
          this.tableData = res.data.records;
          console.log(this.tableData[0]);
          this.total = res.data.total;
          this.pageSize = res.data.size;
        });
    },
    //查询
    queryinfo() {
      console.log(this.currentPage);
      console.log(this.pageSize);
      console.log(this.search);
      request
        .get(
          "/druginfo/" +
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
  },
};
</script>

<style>
.weiguoqi{
        color:#009100
      }
      .guoqi {
        color: #CE0000
      }
</style>