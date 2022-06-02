<template>
  <div class="fuwu" >
      <div class="fuwu_text">
          <h2 class="fuwu_text1">我们的服务</h2>
          <span style="margin-top:40%">我们为患者提供最好的医疗条件</span>
      </div>
      <div class="xunhuan">
          <div v-for="item in icondata" :key="item.id" class="img_item">
              <div><img :src="item.url" alt="" class="yiimg"></div>
                <div class="content"><span style="margin-left:30%">{{item.content}}</span></div>
          </div>
      </div>
  </div>
</template>

<script>
import request from "../utils/mhrequst";
export default {
    name:"MyFuwu",
    data(){
        return{
            icondata:[
                {
                    id:1,
                    url:'http://localhost:8090/files/报告单.png',
                    content:'医疗报告单'
                },
                {
                    id:2,
                    url:'http://localhost:8090/files/药.png',
                    content:'药品中心'
                },
                {
                    id:3,
                    url:'http://localhost:8090/files/S_在线医疗.png',
                    content:'在线医疗'
                },
                {
                    id:4,
                    url:'http://localhost:8090/files/救护车.png',
                    content:'紧急救护车'
                }
            ]
        }
    },
    created(){
         this.load()
    },
    methods:{
         load(){
            request.get("/drugandfu/myfuwu").then((res)=>{
        console.log(res);
      })

        }
    }
}
</script>

<style>
.fuwu{
    display: flex;
    flex-direction: column;
}
.xunhuan{
    display: flex;
    flex-direction: row;
    margin-top: 5%;
}
.img_item{
    display: flex;
    flex-direction: column;
    margin-left: 7%;
}
.fuwu_text{
    margin-left: 40%;
}
.fuwu_text1{
    font-size: 40px;
}
</style>