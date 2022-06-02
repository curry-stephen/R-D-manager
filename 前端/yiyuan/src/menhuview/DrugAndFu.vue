<template>
<div class="fu_root">
<el-affix :offset="20"><WebHeader/></el-affix>
  <DrugAndFuItem class="item"/>
  </div>
</template>

<script>
import WebHeader from '../menhucomponets/public/WebHeader.vue'
import DrugAndFuItem from '../menhucomponets/DrugAndFuItem.vue'
export default {
 components: {
    WebHeader,
    DrugAndFuItem
  },
  
}
</script>

<style>
.fu_root{
  height: 100vh;
  width: 100%;
  padding: 0%;
  margin-left: 0%;
}
.web_header{
  float: right;
}
.item{
  width: 100%;
  height: 100vh;
  margin-left: 0%;
}
</style>