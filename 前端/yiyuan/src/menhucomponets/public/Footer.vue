<template>
  <div class="foot">
    <div class="foot_left">
      <div class="foot_ico">
        <div class="foot_ico_left"><img src="../../assets/logo.png"/></div>
        <div class="foot_ico_right">R&D_Management</div>
      </div>
      <div class="foot_left_font">
        <p class="foot_left_text">© 2020-2021 R&D_Management</p>
        <p class="foot_left_text">
          X公网安备 xxxxxxxxxxxxxx号 I ICP备xxxxxxxx号-1
        </p>
      </div>
    </div>
    <div class="foot_cent">
      <div class="foot_cent1">
        <div style="margin-top:50%">
          <span class="guanyutext">关于我们</span>
        </div>
        <div style="margin-top:13%;margin-left:8%">
          <span style="font-size: 16px">医院文化</span>
        </div>
      </div>
      <div class="foot_cent2" >
        <div style="margin-top:50%">
          <div>
            <span class="lianxitext">联系我们</span>
          </div>
          <div
            v-for="item in lianxidata"
            :key="item.id"
            style="font-size: 16px;margin-top:13%;margin-left:8%"
          >
            <span style="font-size: 17px">
              {{ item.text }}
            </span>
          </div>
        </div>
      </div>
    </div>
    <div class="foot_right">
      
      <!-- <img src="../../assets/img/focus/weibo.png" class="imgstyle" />
      <img src="../../assets/img/focus/bilibili.png" class="imgstyle" />
      <img src="../../assets/img/focus/weixin.svg" class="imgstyle" /> -->
      <div style="font-size: 20px;margin-top:10%;margin-left:15%;color: #d0d0d0;">
        <span>实时动态，扫码关注我们</span>
      </div>
      <div class="guanzu_img">
        <div><img src="../../assets/img/focus/weibo.png" class="imgstyle" /></div>
        <div><img src="../../assets/img/focus/bilibili.png" class="imgstyle" /></div>
        <div><img src="../../assets/img/focus/weixin.svg" class="imgstyle" /></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      lianxidata: [
        {
          id: 1,
          text: "媒体咨询",
        },
        {
          id: 2,
          text: "招聘相关",
        },
        {
          id: 3,
          text: "商务合作",
        },
        {
          id: 4,
          text: "广告相关",
        },
      ],
      guanzhu: [
        {
          name: "weibo",
          path: "http://localhost:8090/files/weibo.png",
          qr: "http://localhost:8090/files/qr_weibo.png",
          info: "关注官方微博",
        },
        {
          path:'http://localhost:8090/files/weixin.svg'
        }
      ],
    };
  },
};
</script>

<style>
.foot_ico_right{
  /* width:100%; */
  flex:1;
  margin-left: 2%;
  margin-top:9%;
  font-size: 30px;
  font-weight:bold;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
.foot_ico_left>img{
  width: 100%;
  /* height: 23%; */
}
.foot_ico_left{
  width: 30%;
}
.foot_ico{
  margin-top:5%;
  display: flex;
  margin-left:4%;

}
.foot_left_font {
  margin-top: -3%;
  font-size: 17px;
  margin-left: 7%;
  display:flex;
  flex-direction: column;
}
.foot {
  width: 100%;
  height: 250px;
  background: #272727;
  color: #ffffff;
  display: flex;
  flex-direction: row;
}
.foot_left {
  margin: 0 auto;
  /* display: flex; */
  width: 30%;
  height: 100%;
  /* background: lemonchiffon; */
}
.foot_cent {
  margin: 0 auto;
  display: flex;
  width: 40%;
  height: 100%;
  /* background: lightblue; */
}
.foot_right {
  width: 30%;
  height: 100%;
  display: flex;
  flex-direction: column;
  /* background: lightgreen; */
}
.foot_cent1 {
  margin-left: 80px;
  /* background: rosybrown; */
}
.foot_cent2 {
  margin-left: 150px;
  /* background: royalblue; */
}
.lianxitext,
.guanyutext,
.shaoma {
  color: #d0d0d0;
  font-size: 20px;
}
.imgstyle {
  width: 60px;
  margin-left: 40px;
}
.foot_left_text {
  font-size: 13px;
  color: #d0d0d0;
  margin-top: 1%;
}
.guanzu_img{
  display: flex;
  flex-direction: row;
  margin-top: 10%;
}
</style>