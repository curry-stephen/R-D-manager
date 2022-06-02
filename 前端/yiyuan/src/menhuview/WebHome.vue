<template>
<el-backtop/>
<el-scrollbar height="100vh">
  
  <div class="home_root" >
    
    
    <!-- <div style="position:absolute; z-index:2; right:5%; top:5%"><WebHeader/></div> -->
    <div class="gudin">
      <el-affix target=".gudin" :offset="20" ><WebHeader/></el-affix>
      <div class="ma">
        <div class="hu_yi"><span style="margin-left:12%">互联网+医疗</span><br><span class="hu_yi_ying">S E R V E&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;T H E&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;P E O P L E</span></div>
    <el-carousel :interval="4000" type="always" height="100vh" style="width:100%">
      
    <el-carousel-item v-for="item in imgs" :key="item">
      
      <div class="img_con" >
        <!-- :style="{backgroundImage: 'url('+item.url+')',backgroundRepeat: 'no-repeat',backgroundSize:'100% 100%'}" -->
      <img :src="item.url" alt="" srcset="" style="width:100%;height:100%;margin-top: 0%;">
      <!-- <div class="imgtext">{{item.text}}</div> -->
      <!-- <div class="imgtext" style="position:absolute; z-index:2; left:50%; top:50%">{{item.text}}</div> -->
      </div>
    </el-carousel-item>
  </el-carousel>
  </div>
  
  
  
  </div>
  
  <div style="margin-top:6%">
  <FuWu/></div>
   <div style="margin-top:10%"><FuWuLi/></div>
  <AwFooter style="margin-top:10%"></AwFooter>
  </div>
</el-scrollbar>
</template>

<script>

import WebHeader from '../menhucomponets/public/WebHeader.vue'
import AwFooter from '../menhucomponets/public/Footer.vue'
import FuWu from '../menhucomponets/MyFuwu.vue'
import FuWuLi from '../menhucomponets/FuWuLiLian.vue'
import request from "../utils/mhrequst";
export default {
  name:"WebHome",
  components: {
    WebHeader,
    AwFooter,
    FuWu,
    FuWuLi
  },
  data(){
    return{
      imgs:[
        {
          id:1,
          url:'http://localhost:8090/files/shucai1.jpg',
        text:'医院'},
        {
          id:2,
          url:'http://localhost:8090/files/拙简素材 (5).jpg',
        text:'合作'},
        {
          id:3,
          url:'http://localhost:8090/files/拙简素材 (7).jpg',
        text:'药品'}
      ]
      // imgs:{}
    }
  },
  created(){
      // this.load();
  },
  methods:{
    async load(){
      
      const imgdata=await request.get("/drugandfu/webhome")
      this.$forceUpdate();
      this.imgs=imgdata.data
      console.log(imgdata);
    }
  }
}
</script>
<style scoped>
.hu_yi_ying{
  font-size: 23px;
  color:		#FFCBB3;
}
.ma{
  position:relative
}
.hu_yi{
  position:absolute; z-index:2; left:40%; top:40%;
  font-size:40px;
  font-weight:bold;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  color:	#ffffff;
  -webkit-text-stroke:1px 	#9D9D9D;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.imgtext{
  font-size: 25px;
  color: aquamarine;
  
}
.img_con {
  width: 100%;
  height: 100%;
}
.home_root{
  margin-top: 0%;
}
.webhead{
  position:absolute; z-index:2; left:50%; top:50%
}
</style>