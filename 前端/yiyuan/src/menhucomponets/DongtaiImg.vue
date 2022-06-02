<template>

  <div class="dong">
      <div class="dong_imgs" v-for="item in imgs" :key="item" @mouseover="mouseOver(item)" @mouseleave="mouseLeave">
          <img :src="item.url" alt="" srcset="" class="imgst">
          <div class="imgtext" >
          <span :style="textimg===item?textcolor:''">{{item.text}}</span>
          </div>
      </div>
  </div>
</template>

<script>
import request from "../utils/mhrequst";
export default {
    data(){
        return{
            imgs:[],
            textimg:'',
            textcolor:'',
        }
    },
    created(){
        this.load()
    },
    methods:{
        load(){
            request.get("/dongtai/dongtai").then((res)=>{
                console.log(res);
                this.imgs=res.data
            })
        },
        mouseOver(e){
            console.log(e);
            this.textimg=e
            this.textcolor='color: 	#336666;font-size:18px'
        },
        mouseLeave(){
            this.textcolor=''
        },
    }
}
</script>

<style>
.dong{
    display: flex;
    flex-direction: row;
}
.imgst{
    width: 100%;
}
.dong_imgs{
    width: 20%;
    margin-left: 4%;
}
</style>