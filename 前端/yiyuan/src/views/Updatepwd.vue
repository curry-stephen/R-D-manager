<template>
  <el-scrollbar height="100vh">
    <div class="user_root">
    <div
      style="
        height: 100%;
        width: 30%;
        border-right: 1px solid #ccc;
        display: flex;
      "
    >
      <div style="height: 100%; width: 100%">
        <!--    修改密码界面-->
        <el-form :model="form" label-width="140px" class="demo-ruleForm">
          <el-form-item>
            <el-image
              style="width: 100px; height: 100px"
              :src="form.headimg"
              :preview-src-list="[form.headimg]"
            ></el-image>
          </el-form-item>
          <el-form-item label="工号:" prop="name">
            <span>{{ form.num }}</span>
          </el-form-item>
          <el-form-item label="用户名:" prop="name">
            <span>{{ form.name }}</span>
          </el-form-item>
          <el-form-item label="性别:" prop="sex">
            <span>{{ form.sex }}</span>
          </el-form-item>
          <el-form-item label="职位:" required>
            <span>{{ form.position }}</span>
          </el-form-item>
          <!--      <el-form-item label="即时配送" prop="delivery">-->
          <!--        <el-switch v-model="ruleForm.delivery"></el-switch>-->
          <!--      </el-form-item>-->
          <el-form-item label="权限:" prop="rowle">
            <span v-if="form.rowle === 1">普通用户</span>
            <span v-if="form.rowle === 2">管理员</span>
          </el-form-item>
          <el-form-item label="电话号码:" prop="phone">
            <span>{{ form.phone }}</span>
          </el-form-item>
          <el-form-item label="家庭地址:" prop="phone">
            <span>{{ form.address }}</span>
          </el-form-item>
          <el-form-item label="上一次登录时间:" prop="lasttime">
            <span>{{ form.lasttime }}</span>
          </el-form-item>
        </el-form>
      </div>
      <div class="btn">
        <div class="btn_erji">
          <div>
        <el-button type="primary" circle @click="modify">
          <el-icon><edit /></el-icon>
        </el-button>
        </div>
        <div style="margin-top:20%">
        <el-button type="primary" circle @click="updatepassword">
          <el-icon><warning /></el-icon>
        </el-button>
        </div>
        </div>
        <!-- 编辑信息弹窗 -->
        <el-dialog v-model="EditdialogVisible" title="修改信息" width="30%">
          <el-form :model="editform" label-width="120px">
            <el-form-item label="用户名">
              <el-input v-model="editform.name" style="width: 80%"></el-input>
            </el-form-item>
            <el-form-item label="工号:" prop="name">
              <span>{{ editform.num }}</span>
            </el-form-item>
            <el-form-item label="性别">
              <el-radio v-model="editform.sex" label="男" size="男"
                >男</el-radio
              >
              <el-radio v-model="editform.sex" label="女" size="女"
                >女</el-radio
              >
            </el-form-item>
            <el-form-item label="电话号码">
              <el-input v-model="editform.phone" style="width: 80%"></el-input>
            </el-form-item>
            <el-form-item label="头像" v-model="editform.headimg">
              <el-upload
                class="upload-demo"
                action="http://localhost:8090/files/upload"
                :on-success="filesccuss"
                ref="upload"
              >
                <el-button type="primary">上传</el-button>
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
        <!-- 修改密码弹窗 -->
        <el-dialog v-model="EditPwddialogVisible" title="修改密码" width="30%">
          <el-form :model="pwdform" label-width="120px">
            <el-form-item label="原始密码">
              <el-input
                v-model="pwdform.password"
                style="width: 80%"
                show-password
              ></el-input>
            </el-form-item>
            <el-form-item label="新密码:">
              <el-input
                v-model="pwdform.newPwd"
                style="width: 80%"
                show-password
              ></el-input>
            </el-form-item>
          </el-form>
          <template #footer>
            <span class="dialog-footer">
              <el-button @click="EditPwddialogVisible = false">取消</el-button>
              <el-button type="primary" @click="EditPwdsave">确定</el-button>
            </span>
          </template>
        </el-dialog>
      </div>
    </div>
    <div style="height: 518px;margin-left:5%;flex:1">
      <UserLog />
    </div>
    </div>
  </el-scrollbar>
</template>

<script>
import { Edit, Warning } from "@element-plus/icons-vue";
import moment from "moment";
import request from "../utils/request";
import * as echarts from "echarts";
import UserLog from "./UserLog.vue";
import router from "../router";
let imgurl;
let user1;
export default {
  data() {
    return {
      form: {},
      EditdialogVisible: false,
      EditPwddialogVisible: false,
      editform: {},
      loadform: {},
      pwdform: {},
    };
  },
  components: {
    Edit,
    Warning,
    UserLog,
  },
  created() {
    let userJson = sessionStorage.getItem("user");
    if (!userJson) {
      alert("请先登录!");
      router.push("/login");
    } else {
      user1 = JSON.parse(userJson);
      this.form = user1;
      this.load();
    }
  },
  mounted() {},
  methods: {
    updatepassword() {
      this.EditPwddialogVisible = true;
    },
    //修改密码
    EditPwdsave() {
      this.pwdform.name = user1.name;
      request.put("/user", this.pwdform).then((res) => {
        if (res.falg) {
          this.$message.success(res.msg);
          alert("密码修改成功，请重新登录!");
          this.$router.push("/login");
        } else {
          this.$message.error(res.msg);
          this.EditPwddialogVisible = false;
        }
      });
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
    //格式化日期
    dateFormat(date) {
      return moment(date).format("YYYY-MM-DD HH:mm:ss");
    },
    //修改信息按钮
    modify() {
      this.EditdialogVisible = true;
      this.editform = JSON.parse(JSON.stringify(this.form));
    },
    //加载数据
    load() {
      this.loadform.name = user1.name;
      this.loadform.password = user1.password;
      request.post("/user/load", this.loadform).then((res) => {
        this.form = res.data;
        this.form.lasttime = this.dateFormat(this.form.lasttime);
        sessionStorage.setItem("user", JSON.stringify(res.data));
      });
    },
    //确定修改信息
    Editsave() {
      if (this.imgurl != null) {
        this.editform.headimg = this.imgurl;
      }
      this.editform.lasttime = "";
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
  },
};
</script>

<style>
.btn{
  margin-right: 2%;
}
.user_root{
  display: flex;
  flex-direction: row;
}
.btn_erji{
  display: flex;
  flex-direction: column;
}
</style>