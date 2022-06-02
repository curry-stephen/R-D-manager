<template>
  <div>
    <div class="card_style">
      <el-card shadow="hover" class="item_card" v-for="item in carddata" :key="item.id"  @mouseover="mouseOver(item.id)" @mouseleave="mouseLeave">
        <div class="card_root">
        <div><img
          :src="item.url"
          alt=""
          srcset=""
          class="itemimg"
        /></div>
        <div class="card_text" :style="textid==item.id?textcolor:''">
          
          <div class="title_sty" ><span>{{item.title}}</span></div>
          <div class="content_sty"><span>{{item.content}}</span></div>
          <div class="time_sty"><span>{{item.time}}</span></div>
        </div>
        </div>
      </el-card>
    </div>
    <div class="table_sty">
        <el-card class="newcard">
            <div class="new_title"><h2>热门新闻</h2></div>
            <el-divider></el-divider>
            <div v-for="newitem in newsdata" :key="newitem.id" @mouseover="mouseOvernews(newitem.id)" @mouseleave="mouseLeavenews">
                <div class="new_id" :style="newitem.id=='1'?'background: #EA0000 ':newitem.id=='2'?'background:#FF359A':newitem.id=='3'?'background:#9F35FF':'background:#ADADAD'">
                    <span style="margin-left:20%;color: #ffffff ">{{newitem.id}}</span></div>
                    <div :style="news==newitem.id?newscolor:''">
                <div class="new_content"><span>{{newitem.content}}</span></div>
                <div class="new_time"><span>{{newitem.time}}</span></div></div>
                <el-divider border-style="dashed" />
                
            </div>
        </el-card>
    </div>
  </div>
</template>

<script>
import request from "../utils/mhrequst";
export default {
    components:{
        
    },
    data(){
        return{
            carddata:[
                // {
                //     id:1,
                //     url:'http://localhost:8090/files/shucai1.jpg',
                //     title:'标题',
                //     content:'正文',
                //     time:'时间'
                // },
                // {
                //     id:2,
                //     url:'http://localhost:8090/files/shucai1.jpg',
                //     title:'标题',
                //     content:'正文',
                //     time:'时间'
                // },
                // {
                //     id:3,
                //     url:'http://localhost:8090/files/shucai1.jpg',
                //     title:'标题',
                //     content:'正文',
                //     time:'时间'
                // }
            ],
            newsdata:[
                // {
                //     id:1,
                //     content:'李帅就喜欢天天卷',
                //     time:'2019年10月2日'
                // },
                // {
                //     id:2,
                //     content:'杨跃也是',
                //     time:'2019年10月4日'
                // },
                // {
                //     id:3,
                //     content:'小包也开始卷',
                //     time:'2019年10月2日'
                // },
                // {
                //     id:4,
                //     content:'王志卷不动了',
                //     time:'2019年10月2日'
                // }
            ],
            textid:'',
            textcolor:'',
            news:'',
            newscolor:''
        }
    },
    created(){
        this.load()
    },
    methods:{
        load(){
            request.get("/dongtai/nowdataitem").then((res)=>{
                console.log(res);
                this.carddata=res.data.carddata
                this.newsdata=res.data.newsdata
            })
        },
        mouseOver(e){
            this.textid=e
            this.textcolor='color:#00AEAE;font-size:17px'
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
.card_root{
    display: flex;
    flex-direction: row;
    
}
.new_id{
    float: left;
    margin-left: 0;
    width: 6%;
    height: 100%;

}
.new_content{
    margin-left: 20%;
    /* float: right; */
    width: 80%;
    height: 50%;
    /* background: rosybrown; */
}
.new_time{
    margin-left: 18%;
    /* float: right; */
    width: 80%;
    height: 50%;
    /* background: royalblue; */
    font-size: 13px;
    color: #8E8E8E;
}
.new_title{
    text-align: center;
}
.newcard{
    width: 100%;
    background-color: 	#ECFFFF;

}
.tables{
    width: 100%;
}
.table_sty{
    margin-right: 40px;
    float:right;
    width: 25%;
    background: rosybrown;
}
.card_style {
    float: left;
  width: 65%;
}
.itemimg {
  width: 200px;
}
.item_card {
    margin-top: 20px;
  height: 150px;
  background-color: #E8FFF5;
}
.card_text{
    display: flex;
    flex-direction: column;
    height: 100%;
    margin-left:5%
}
.title_sty{
    font-weight: bold;
    font-size: 20px;
    margin-left: 0%;
    width: 100%;
}
.content_sty{
    margin-left: 0%;
    width: 100%;
    margin-top: 2%;
}
.time_sty{
    color:  #8E8E8E ;
    font-size: 14px;
    margin-left: 0%;
    width: 100%;
    margin-bottom: 2%;
    margin-top: 2%;
}
</style>