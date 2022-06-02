<template>
  <div class="work_root">
    <div class="work_echarts">
      <div class="tubiao"><WorkEcharts /></div>
      <div class="zhaopin">
        <span>招聘条件：</span>
        <div v-for="item in worksselect" :key="item.id" style="margin-top:5%" @mouseover="mouseOver(item.id)" @mouseleave="mouseLeave">
          <div :style="textid==item.id?textcolor:''">
          <span :style="item.id=='1'?'color: #EA0000 ':item.id=='2'?'color:#FF359A':item.id=='3'?'color:#9F35FF':'color:#272727'">{{item.id}}</span>
          <span :style="item.id=='1'?'color: #EA0000 ':item.id=='2'?'color:#FF359A':item.id=='3'?'color:#9F35FF':'color:#272727'">、</span>
          <span :style="item.id=='1'?'color: #EA0000 ':item.id=='2'?'color:#FF359A':item.id=='3'?'color:#9F35FF':'color:#272727'">{{item.select}}</span>
          </div>
        </div>
      </div>
    </div>
    <div style="margin-left:2%"><el-divider direction="vertical" style="height:100vh"/></div>
    <div class="work_qta">
      <el-card shadow="hover" v-for="item in works" :key="item" style="margin-top:1%;background-color: #F0FFF0;" @mouseover="mouseOvernews(item)" @mouseleave="mouseLeavenews">
        <div class="work_card">
          <div>
            <img :src="item.url" alt="" srcset="" class="work_img"/>
          </div>
          <div style="margin-left:15%;flex:1;">
            <span :style="item==news?newscolor:''">{{item.content}}</span>
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
import request from "../utils/mhrequst";
import WorkEcharts from "../echartsvue/Workecharts.vue";
export default {
  components: {
    WorkEcharts,
  },
  data(){
    return{
      textid:'',
            textcolor:'',
      works: [],
      worksselect:[],
      news:'',
            newscolor:''
    }
  },
  created(){
    this.load()
  },
  methods:{
    load(){
      request.get("/dongtai/works").then((res)=>{
        console.log(res);
        this.works=res.data.works
        this.worksselect=res.data.worksselect
      })
    },
    mouseOver(e){
            this.textid=e
            this.textcolor='color:#2828FF;font-size:17px'
            console.log(e);
            console.log("鼠标移入");
        },
        mouseLeave(){
            this.textcolor=''
        },
        mouseOvernews(e){
            this.news=e
            this.newscolor='color: #D94600 ;font-size:17px'
        },
        mouseLeavenews(){
            this.newscolor=''
        }
  }
};
</script>

<style>
.work_root {
  width: 100%;
  height: 100vh;
  display: flex;
  flex-direction: row;
}
.work_qta {
  /* flex: 1; */
  /* background-color: aqua; */
  width: 55%;
  margin-left: 4.5%;
}
.work_img{
    width: 200px;
    height: 100%;
}
.work_card{
    display: flex;
    flex-direction: row;
    width: 99%;
}
.work_echarts{
  display: flex;
  flex-direction: column;
}
.zhaopin{
  margin-top: 10px;
  background-color: 	#ECF5FF;
  padding:15px;
  border-radius: 10px;
}
.tubiao{
  background-color: 		#FFFFF4;
  border-radius: 10px;
  padding: 5px;
}
</style>