<template>
  <div class="denglu">
    <el-affix :offset="20"><WebHeader /></el-affix>
    <div class="login_root">
      <div  class="login_kuang">
        <div
          style="
            color: #8E8E8E;
            font-size: 30px;
            text-align: center;
            padding: 30px 0;
          "
        >
          欢迎登录
        </div>
        <div>
          <el-form ref="formRef" :model="form" size="normal" :rules="rules">
            <el-form-item prop="name">
              <el-input v-model="form.name" placeholder="请输入账号"
                ><el-icon><avatar /></el-icon
              ></el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input
                v-model="form.password"
                placeholder="请输入密码"
                show-password
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button style="width: 100%" type="primary" @click="login"
                >登 录</el-button
              >
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import request from "../utils/request";
import WebHeader from "../menhucomponets/public/WebHeader.vue";
export default {
  components: {
    WebHeader,
  },
  name: "Login",
  data() {
    return {
      form: {},
      rules: {
        name: [
          {
            required: true,
            message: "请输入用户名",
            trigger: "blur",
          },
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
      },
    };
  },
  methods: {
    login() {
      this.$refs["formRef"].validate((valid) => {
        if (valid) {
          console.log(this.form);
          request.post("/user/login", this.form).then((res) => {
            console.log("登录：");
            console.log(res);
            if (res.falg) {
              this.$message.success(res.msg);
              console.log("存用户数据:" + res);
              sessionStorage.setItem("user", JSON.stringify(res.data)); //缓存用户信息
              this.$router.push("/owinfo"); //登录成功后进行页面跳转
            } else {
              this.$message.error(res.msg);
            }
          });
        }
      });
    },
    logintest() {
      request.get("/user/login", this.form).then((res) => {
        console.log("登录test：" + res);
      });
    },
  },
};
</script>

<style scoped>
.login_root {
  display: flex;
  justify-content: center;
}
.denglu {
  background: url("../assets/images/yp.png") no-repeat;
  /* background-size: 100vw 100vh; */
  /* heigth:100%' */
  /* background-color: aqua; */
  height: 100vh;
  width: 100vw;
}
.login_kuang {
  width: 30%;
  padding-left: 5%;
  padding-right:5%;
  padding-bottom: 3%;
  height: 50%;
  margin-top: 13%;
  background-color: rgba(187,255,255,0.6);
  border-radius:20px;
  border:3px solid rgba(180,255,255,0.6);
}
</style>