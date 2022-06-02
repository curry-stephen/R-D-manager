<template>
<el-scrollbar height="100vh">
  <div class="dongtai_root">
    <div class="dongtai_img">
      <el-affix target=".dongtai_img" :offset="20" ><WebHeader/></el-affix>
      <img src="http://localhost:8090/files/拙简素材(16)" alt="" srcset="" style="width:100%">
    </div>
    <div style="margin-top:2%"><Dongtaiimg/></div>
    <div style="margin-top:2%"><NowData/></div>
    <div style="margin-top:2%"><AwFooter/></div>
  </div>
  <!-- </div> -->
</el-scrollbar>
</template>

<script>
import WebHeader from '../menhucomponets/public/WebHeader.vue'
 import Dongtaiimg from '../menhucomponets/DongtaiImg.vue'
import NowData from '../menhucomponets/NowData.vue'
import AwFooter from '../menhucomponets/public/Footer.vue'
export default {
  components:{
    WebHeader,
     Dongtaiimg,
    NowData,
    AwFooter
  },
  data(){
    return{
    }
  }
}
</script>

<style>
.dongtai_root{
  display: flex;
  flex-direction: column;
}
/* .nowdata{
  min-height: 100vh;
}
.dongtai{
  
  background-size: 100% 100%;
  width: 100%;
  height: 400px;
}

.foot_st{
  margin-top: 20px;
} */
</style>