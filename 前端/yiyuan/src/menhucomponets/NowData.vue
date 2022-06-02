<template>
  <div class="nowdata_root"><el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
    <el-tab-pane label="最新动态" name="first"><NowDataItem/></el-tab-pane>
    <el-tab-pane label="工作招聘" name="second"><Work/></el-tab-pane>
    <el-tab-pane label="媒体报道" name="third"><TongZHi/></el-tab-pane>
  </el-tabs></div>
</template>

<script>
import NowDataItem from './NowDataItem.vue'
import Work from './Works.vue'
import TongZHi from './TongZHi.vue'
export default {
  components:{
      NowDataItem,
      Work,
      TongZHi
  },
    data(){
        return{
            activeName:'first'
        }
    }
}
</script>

<style>
.nowdata_root{
    padding-left: 20px;
}
</style>