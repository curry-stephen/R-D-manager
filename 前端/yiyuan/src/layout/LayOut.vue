<template>
<el-scrollbar height="100vh">
  <div>

    <!--    头部-->
    <Header/>
    <!--    主体-->
    <div style="display: flex">
      <!--侧边栏-->
      <Aside/>
      <!--      内容-->
      <router-view style="flex: 1"/>
    </div>
  </div>
</el-scrollbar>
</template>

<script>
import Header from "../components/Header.vue";
import Aside from "../components/Aside.vue";

export default {
  name: "Layout",
  components: {
    Aside,
    Header,
  }
}
</script>

<style scoped>

</style>