<template>
  <div id="nav">
    <div class="shou" @mouseover="mouseOver(1)" @mouseleave="mouseLeave" :style="textimg===1?textcolor:''"><router-link to="/webhome">首页</router-link></div>
    <div class="dong" @mouseover="mouseOver(2)" @mouseleave="mouseLeave" :style="textimg===2?textcolor:''"><router-link to="/dongtai">动态分享</router-link></div>
    <div class="drug" @mouseover="mouseOver(3)" @mouseleave="mouseLeave" :style="textimg===3?textcolor:''"><router-link to="/drugandfu">医院党建</router-link></div>
    <div class="data" @mouseover="mouseOver(4)" @mouseleave="mouseLeave" :style="textimg===4?textcolor:''"><router-link to="/datacenter">数据中心</router-link></div>
    <div class="shu" ><span style="color:#fffff">|</span></div>
    <div class="login" @mouseover="mouseOver(5)" @mouseleave="mouseLeave" :style="textimg===5?textcolor:''"><router-link to="/login">登录</router-link></div>
  </div>
  <router-view/>
</template>
<script>
export default {
  data(){
    return{
      textimg:'',
            textcolor:'',
    }
  },
  methods:{
    mouseOver(e){
            console.log(e);
            this.textimg=e
            this.textcolor='color: #4DFFFF ;font-size:21px'
        },
        mouseLeave(){
            this.textcolor=''
        },
  }
}
</script>
<style>
.router-link-active {
  text-decoration: none;
  color:  #28004D ;
  font-size:21px;
}
a{
  text-decoration: none;
  color: #003E3E;
}
#nav{
  width: 400px;
  float:right;
  display: flex;
  flex-direction: row;
  font-size: 18px;
}
.dong,.drug,.data{
  margin-left: 13px;
}
.login,.shu{
  margin-left:6px;
}
</style>
