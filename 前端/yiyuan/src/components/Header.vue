<template>
  <div
    style="
      height: 50px;
      line-height: 50px;
      border-bottom: 1px solid #ccc;
      display: flex;
    "
  >
    <div
      style="
        width: 200px;
        padding-left: 30px;
        font-weight: bold;
        color: dodgerblue;
        font-size: 23px;
      "
    >
      药品管理系统
    </div>
    <div style="flex: 1"></div>
    <div style="width: 150px;margin-top:1%">
      <el-dropdown>
        <span class="el-dropdown-link">
          当前用户：<span style="font-size:20px;color:	#005757">{{ name }}</span>
          <el-icon class="el-icon--right">
            <arrow-down />
          </el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="$router.push('/updatepwd')"
              >个人信息</el-dropdown-item
            >
            <el-dropdown-item @click="tuichu">退出系统</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      name: "管理员",
    };
  },
  created() {
    let userJson = sessionStorage.getItem("user");
    if (!userJson) {
      this.$router.push("/login");
    } else {
      let user1 = JSON.parse(userJson);
      this.name = user1.name;
    }
  },
  methods: {
    tuichu() {
      this.$router.push("/login");
      sessionStorage.clear();
    },
  },
};
</script>

<style scoped>
</style>