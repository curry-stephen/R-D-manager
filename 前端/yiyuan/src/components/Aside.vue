<template>
  <div>
    <!--router实现路由跳转-->
    <el-menu
      style="width: 200px; min-height: calc(100vh - 50px)"
      :default-active="path"
      router
      class="el-menu-vertical-demo"
    >
      <el-menu-item index="/usermapper" v-if="rowle == 2"
        >用户管理
      </el-menu-item>
      <el-sub-menu index="1">
        <template #title>药品库存管理</template>
        <el-menu-item index="/owinfo">登记出入库信息</el-menu-item>
        <el-menu-item index="/matter">问题药品记录</el-menu-item>
        <el-menu-item index="/inspect">药品保质期检查</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="2">
        <template #title>药品销售管理</template>
        <el-menu-item index="/sale">销售记录</el-menu-item>
        <el-menu-item index="/rgoods">收到退货</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="3">
        <template #title>药品明细查询</template>
        <el-menu-item index="/druginfo">药品信息</el-menu-item>
        <el-menu-item index="/supplyinfo">供应商信息</el-menu-item>
        <el-menu-item index="/tosupply">退货给供应商</el-menu-item>
        <el-menu-item index="/bill">账单信息</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="4">
        <template #title>系统设置</template>
        <el-menu-item index="/updatepwd">个人信息</el-menu-item>
        <el-menu-item index="/signout" @click="tuichu"
          >退出登录</el-menu-item
        >
      </el-sub-menu>
    </el-menu>
  </div>
</template>
<script>
export default {
  name: "Aside",
  data() {
    return {
      path: this.$router.path,
      rowle: "",
    };
  },
  created() {
    let userJson = sessionStorage.getItem("user");
    if (!userJson) {
      this.$router.push("/login");
    } else {
      let user1 = JSON.parse(userJson);
      this.rowle = user1.rowle;
    }
  },
  methods:{
    tuichu() {
      this.$router.push("/login");
      sessionStorage.clear();
    }
  }
};
</script>

<style scoped>
</style>