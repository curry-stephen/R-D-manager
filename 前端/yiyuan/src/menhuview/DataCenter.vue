<template>
  <el-scrollbar height="100vh" style="background-color: #ecffff">
    <div class="gudin" style="margin-top: 1.5%">
      <el-affix :offset="20" target=".gudin"><WebHeader /></el-affix>
    </div>
    <el-backtop />
    <div class="datacenter_root">
      <div class="datacenter_left">
        <div class="left_top">
         
          <ZheXian />
           <div class="left_top_qipao">
            <el-tooltip
              effect="light"
              :content="zhexian"
              placement="right-end"
              raw-content
            >
              <el-button class="btn">𝓲</el-button>
            </el-tooltip>
          </div>
        </div>
        <div class="left_up"><BinTu />
        <div class="left_top_qipao">
            <el-tooltip
              effect="light"
              :content="bingtu"
              placement="right-end"
              raw-content
            >
              <el-button class="btn">𝓲</el-button>
            </el-tooltip>
          </div>
        </div>
      </div>
      <div class="datacenter_center">
        <div class="center_main"><LouDou />
        <div class="left_top_qipao">
            <el-tooltip
              effect="light"
              :content="loudou"
              placement="left-end"
              raw-content
            >
              <el-button class="btn">𝓲</el-button>
            </el-tooltip>
          </div>
        </div>
      </div>
      <div class="datacenter_right">
        <div class="right_top"><LeidaTu />
        <div class="left_top_qipao">
            <el-tooltip
              effect="light"
              :content="leida"
              placement="left-end"
              raw-content
            >
              <el-button class="btn">𝓲</el-button>
            </el-tooltip>
          </div>
        </div>
        <div class="right_up"><GradTu />
        <div class="left_top_qipao">
            <el-tooltip
              effect="light"
              :content="gradtu"
              placement="left-end"
              raw-content
            >
              <el-button class="btn">𝓲</el-button>
            </el-tooltip>
          </div>
        </div>
      </div>
    </div>

    <AwFooter style="margin-top: 5%" />
  </el-scrollbar>
</template>

<script>
import WebHeader from "../menhucomponets/public/WebHeader.vue";
import ZheXian from "../echartsvue/Zhexian.vue";
import BinTu from "../echartsvue/BinTu.vue";
import LeidaTu from "../echartsvue/LeiDaTu.vue";
import GradTu from "../echartsvue/GradTu.vue";
import LouDou from "../echartsvue/LouDou.vue";

import AwFooter from "../menhucomponets/public/Footer.vue";
export default {
  components: {
    // product
    WebHeader,
    ZheXian,
    BinTu,
    LeidaTu,
    GradTu,
    AwFooter,
    LouDou,
  },
  data(){
    return{
      visible:false,
      zhexian:"<el-card ><span><strong>介绍：</strong>每年门诊能接纳30多万人次就诊，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp能收治住院病人4万多人次，完成手术近1.1万多台次，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp配备64排进口CT、1.5T进口核磁共振、<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp美国产血管机和胃肠机等高档设备。<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp整个院区全部实行智能化设计，功能健全、布局合理、 环境舒适，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp在国内同级医院中处于领先水平。</span></el-card>",
      bingtu:"<el-card><span><strong>介绍：</strong>每年门诊能接纳30多万人次就诊，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp能收治住院病人4万多人次，完成手术近1.1万多台次，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp配备64排进口CT、1.5T进口核磁共振、<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp美国产血管机和胃肠机等高档设备。<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp整个院区全部实行智能化设计，功能健全、布局合理、 环境舒适，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp在国内同级医院中处于领先水平。</span></el-card>",
      leida:"<el-card><span><strong>介绍：</strong>每年门诊能接纳30多万人次就诊，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp能收治住院病人4万多人次，完成手术近1.1万多台次，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp配备64排进口CT、1.5T进口核磁共振、<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp美国产血管机和胃肠机等高档设备。<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp整个院区全部实行智能化设计，功能健全、布局合理、 环境舒适，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp在国内同级医院中处于领先水平。</span></el-card>",
      gradtu:"<el-card><span><strong>介绍：</strong>每年门诊能接纳30多万人次就诊，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp能收治住院病人4万多人次，完成手术近1.1万多台次，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp配备64排进口CT、1.5T进口核磁共振、<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp美国产血管机和胃肠机等高档设备。<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp整个院区全部实行智能化设计，功能健全、布局合理、 环境舒适，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp在国内同级医院中处于领先水平。</span></el-card>",
      loudou:"<el-card><span><strong>介绍：</strong>每年门诊能接纳30多万人次就诊，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp能收治住院病人4万多人次，完成手术近1.1万多台次，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp配备64排进口CT、1.5T进口核磁共振、<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp美国产血管机和胃肠机等高档设备。<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp整个院区全部实行智能化设计，功能健全、布局合理、 环境舒适，<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp在国内同级医院中处于领先水平。</span></el-card>"
    }
  }
};
</script>

<style>
.datacenter_root {
  width: 100vw;
  height: 100vh;
  display: flex;
  flex-direction: row;
  margin-top: 5%;
}
.datacenter_left {
  width: 30%;
  height: 100%;
  /* background-color: aqua; */
  display: flex;
  flex-direction: column;
  margin-left: 5px;
}
.datacenter_right {
  width: 30%;
  height: 100%;
  /* background-color: 	#FFCBB3; */
  flex-direction: column;
  margin-left: 5px;
  margin-right: 5px;
}
.datacenter_center {
  flex: 1;

  margin-left: 5px;
}
.left_top {
  width: 100%;
  height: 50%;
  background-color: #c4e1ff;
  border-radius: 10px;
  display: flex;
}
.left_up {
  width: 100%;
  height: 49%;
  background-color: #c4e1ff;
  margin-top: 5px;
  border-radius: 10px;
  display: flex;
}
.right_top {
  width: 100%;
  height: 50%;
  background-color: #c4e1ff;
  border-radius: 10px;
  display: flex;
}
.right_up {
  width: 100%;
  height: 49%;
  background-color: #c4e1ff;
  margin-top: 5px;
  border-radius: 10px;
  display: flex;
}
.center_main {
  border-radius: 10px;
  width: 100%;
  height: 100%;
  background-color: #c4e1ff;
  display: flex;
}
.left_top_qipao {
  display: flex;
  float: right;
  margin-top: 1%;
  margin-right:1%;
  font-family: "Arial"
}
.btn{
  border-radius: 130px 130px 130px 130px ;
  width: 6px !important;
}
</style>