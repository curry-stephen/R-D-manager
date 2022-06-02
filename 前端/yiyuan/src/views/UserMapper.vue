<template>
<el-scrollbar height="100vh">
  <div style="padding: 10px">
    <!--    功能区域-->
    <div style="padding: 10px 0">
      <el-button  @click="add">新增</el-button>
    </div>
    <!--    搜索区域-->
    <div
        style="position: absolute; right: 0px; margin-top: -60px; padding: 10px"
      >
      <el-input
        v-model="search"
        placeholder="请输入关键字"
        style="width: 68%;margin: 5px;height: 33px"
        clearable
      />
      <el-button type="primary" style="margin-left: 5px" @click="load"
        >查询</el-button
      >
    </div>
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column prop="num" label="工号" />
      <el-table-column prop="name" label="用户名" />
      <el-table-column prop="position" label="职位" />
      <el-table-column prop="age" label="年龄" />
      <el-table-column prop="sex" label="性别" />
      <el-table-column label="权限">
        <template #default="scope">
          <span v-if="scope.row.rowle == 1">普通用户</span>
          <span v-if="scope.row.rowle == 2">管理员</span>
        </template>
      </el-table-column>
      <el-table-column prop="phone" label="电话号码" />
      <el-table-column prop="password" label="密码">
        <template #default="scope">
          <span v-if="scope.row.name == username || userrowle == 2">{{
            scope.row.password
          }}</span>
          <span v-if="scope.row.name != username && userrowle == 1"
            >没有权限</span
          >
        </template>
      </el-table-column>
      <el-table-column prop="address" label="地址" />
      <el-table-column label="操作" width="170">
        <template #default="scope">
          <span v-if="(scope.row.name != username && userrowle == 1)||
          (scope.row.name != username &&scope.row.rowle == 2)"
            >没有权限</span
          >
          <div v-else>
          <el-button
            size="mini"
           
            @click="handleEdit(scope.row)"
            >编辑</el-button
          >
          
          <el-popconfirm
            confirm-button-text="OK"
            cancel-button-text="取消"
            icon-color="red"
            title="确认删除吗?"
            @confirm="handleDelete(scope.row.name)"
          >
            <template #reference>
              <el-button
                size="mini"
              
                type="danger"
                >删除</el-button
              >
            </template>
          </el-popconfirm>
          </div>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0">
      <el-dialog v-model="dialogVisible" title="新增" width="30%">
        <el-form :model="form" label-width="120px">
          <el-form-item label="用户名">
            <el-input v-model="form.name" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="工号">
            <el-input v-model="form.num" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="职位">
            <el-input v-model="form.position" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="年龄">
            <el-input v-model="form.age" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="电话号码">
            <el-input v-model="form.phone" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio v-model="form.sex" label="男" size="男">男</el-radio>
            <el-radio v-model="form.sex" label="女" size="女">女</el-radio>
            <el-radio v-model="form.sex" label="未知" size="未知"
              >未知</el-radio
            >
          </el-form-item>
          <el-form-item label="地址">
            <el-input
              type="textarea"
              v-model="form.address"
              style="width: 80%"
            ></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="save">确定</el-button>
          </span>
        </template>
      </el-dialog>
      <div style="margin: 10px 0">
        <el-dialog v-model="EditdialogVisible" title="修改信息" width="30%">
          <el-form :model="editform" label-width="120px">
            <el-form-item label="用户名">
              <el-input v-model="editform.name" style="width: 80%"></el-input>
            </el-form-item>
            <el-form-item label="工号">
              <el-input v-model="editform.num" style="width: 80%"></el-input>
            </el-form-item>
            <el-form-item label="职位">
              <el-input
                v-model="editform.position"
                style="width: 80%"
              ></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input
                v-model="editform.password"
                style="width: 80%"
              ></el-input>
            </el-form-item>
            <el-form-item label="年龄">
              <el-input v-model="editform.age" style="width: 80%"></el-input>
            </el-form-item>
            <el-form-item label="电话号码">
              <el-input v-model="editform.phone" style="width: 80%"></el-input>
            </el-form-item>
            <el-form-item label="性别">
              <el-radio v-model="editform.sex" label="男" size="男"
                >男</el-radio
              >
              <el-radio v-model="editform.sex" label="女" size="女"
                >女</el-radio
              >
              <el-radio v-model="editform.sex" label="未知" size="未知"
                >未知</el-radio
              >
            </el-form-item>
            <el-form-item label="地址">
              <el-input
                type="textarea"
                v-model="editform.address"
                style="width: 80%"
              ></el-input>
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
    </div>
  </div>
</el-scrollbar>
</template>

<script>
// @ is an alias to /src

import request from "../utils/request";
import router from "../router";
export default {
  name: "User",
  components: {},
  data() {
    return {
      form: {},
      editform: {},
      dialogVisible: false,
      EditdialogVisible: false,
      search: "",
      username: "",
      userrowle: "",
      tableData: [],
    };
  },
  created() {
    this.load();
    let userJson = sessionStorage.getItem("user");
    if(!userJson){
       alert("请先登录!")
        router.push('/login')
    }else{
        let user1 = JSON.parse(userJson);
    this.username = user1.name;
    this.userrowle = user1.rowle;
    }
  
  },
  methods: {
    load() {
      request.get("/user").then((res) => {
        this.tableData = res.data;
      });
    },
    handleEdit(row) {
      this.editform = JSON.parse(JSON.stringify(row)); //<!--深拷贝，与源数据完全隔离-->
      this.EditdialogVisible = true;
    },
    add() {
      this.dialogVisible = true;
      this.form = {};
    },
    save() {
      request.post("/user", this.form).then((res) => {
        if (res.falg) {
          this.$message.success(res.msg);
        } else {
          this.$message.error(res.msg);
        }
        this.load();
        this.dialogVisible = false;
      });
    },
    Editsave() {
      request.put("/user/up", this.editform).then((res) => {
        if (res.falg) {
          this.$message.success(res.msg);
        } else {
          this.$message.error(res.msg);
        }
        this.load();
        this.EditdialogVisible = false;
      });
    },
    handleDelete(row) {
      request.delete("/user/" + row).then((res) => {
        if (res.falg) {
          this.$message.success(res.msg);
        } else {
          this.$message.error(res.msg);
        }
        this.load();
      });
    },
  },
};
</script>
