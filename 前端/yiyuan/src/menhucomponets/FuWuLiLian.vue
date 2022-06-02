<template>
  <div class="fu_ti_root">
    <div class="img_fu">
      <img
          :src="bgurl"
          alt=""
          class="li_img"
        />
    </div>
    <div class="bai"></div>
    <div class="content_fu">
      <div class="biaoti"><h2 class="title_fu">服务理念</h2></div>
      <div class="ying"><span>SERVICE IDEA</span></div>
      <div class="tu">
        <img
          :src="bgurlsomll"
          alt=""
          class="img_xiao"
        />

      </div>
      <div class="foot_text">
        <span>我们将会用我们最先进的技术和最好的药品，来医治每一位病人</span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      bgurl: "http://localhost:8090/files/拙简素材 (22).jpg",
      bgurlsomll: "http://localhost:8090/files/拙简素材 (21).jpg",
    };
  },
};
</script>

<style>
.foot_text{
    margin-top: 9%;
}
.tu{
    border:  	#FF8040  dashed 1px;
    padding: 3%;
    margin-top: 6%;
    width: 80%;
}
.title_fu{
    font-size: 40px;
   
}
.bai{
    width: 10%;
}
.fu_ti_root {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: row;
  background-color:		#D2E9FF;
  padding-bottom:0%
}
.img_fu {
  width: 40%;
}
.content_fu {
  flex: 1;
  display: flex;
  flex-direction: column;
}
.img_xiao{
    width: 60%;
    margin-left: 25%;
}
.li_img{
    width: 100%;
    height:100%;
}
.biaoti{
     margin-top: 0%;
}
.ying{
    margin-top: 0%;
}
/* .fuwu_img_root{
    margin-top: 100px;
    display: flex;
    flex-direction: row;
}
.biaoti {
  width: 100%;
  height: 40px;
}
.img_xiao {
  width: 30%;
}
.fu_ti_root {
  display: flex;
  height: 100vh;
  width: 100%;
  flex-direction: column;
}
.content_fu {
  /* display:inline-block; */
/* flex: 1; */
/* float: right; */
/* height: calc(100vh-40px); */
/* display: flex;
    flex-direction: column;
}
.img_fu {
  /* display:inline-block; */
/* float: left;
  width: 60%;
  margin-left: 0%; */
/* height: calc(100vh-40px); */
/* }
.li_img {
  width: 90%;
}
.title_fu {
  font-size: 40px;
  margin-left: 45%; */
/* } */
</style>