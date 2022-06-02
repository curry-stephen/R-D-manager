<template>
  <div>
    <div class="item_root" @mousewheel="rollScroll($event)">
      <el-affix :offset="180">
        <div class="icon_root">
          <div
            class="icon_itme"
            v-for="item in iconimg"
            :key="item.id"
            :style="carditem==item.id?iconstyle:'background-color: #ffffff ;margin-left:2.5%'"
          >
            <img :src="item.url" alt="" srcset="" style="width: 100%" />
          </div>
        </div>
      </el-affix>
      <div class="card_a">
        <el-carousel
          direction="vertical"
          :autoplay="false"
          style="width: 100vw; margin-left: 0"
          height="100vh"
          class="item_root_carousel"
          trigger="click"
          ref="carousel"
          @mousewheel="rollScroll($event)"
        >
          <el-carousel-item v-for="item in drugdata" :key="item">
            <div class="imgtext">
              <div v-html="item.title"></div>
              <div class="imgtext_title" v-html="item.text"></div>
              <div class="imgtext_more" style="color:#fff"><span>更多详情，请访问：</span></div>
              <div class="imgtext_http" style="color:#fff"><span>{{item.http}}</span></div>
            </div>

            <div>
              <img
                :src="item.url"
                alt=""
                srcset=""
                style="width: 100%; height: 100vh; margin-top: 0%"
              />
            </div>
          </el-carousel-item>
        </el-carousel>
      </div>
    </div>
  </div>
</template>

<script>
import request from "../utils/mhrequst";
export default {
  data() {
    return {
      iconstyle: "background-color:#D9FFFF;width:27%;",
      carditem: 1,
      currentId: 1,
      listName: [], //滚动的列表
      timeOut: null,
      iconimg: [
        {
          id: 1,
          url: "http://localhost:8090/files/医疗，药物，治疗，疾病，健康..png",
        },
        {
          id: 2,
          url: "http://localhost:8090/files/医疗客服.png",
        },
        {
          id: 3,
          url: "http://localhost:8090/files/全球医疗 (1).png",
        },
        {
          id: 4,
          url: "http://localhost:8090/files/显微镜.png",
        },
      ],
      drugdata: [
        {
          url: "http://localhost:8090/files/01.jpg",
          title:"<h2 style="+'"'+"color: 	#D94600"+'"' +">“我为群众办实事-义诊校园行”</h2>",
          text: "<span style="+'"'+"color:#000000"+'"' +">金秋时节，微风和煦，红枫摇曳，丹桂飘香，正是莘莘学子读书学习的好时节，11月3日下午，<br>人民医院东院内科党总支医务人员一行来到中南财经政法大学南湖校区，进行了健康讲座和义诊活动。<br>11月3日下午14:30，人民医院东院分党委书记鲜于云艳在大会上致辞，内科总书记裴大军书记牵头，副书记消化内科孙军主任联络负责，<br>此次讲座与义诊活动是为响应人民医院党委，大学党委，“我为群众办实事”主题活动之一。<br>本次讲座内容由内分泌科高凌教授为中南财经政法大学教职工进行了健康饮食新观念讲座，50多名教职工参与此次讲座活动。<br>为服务广大老师与学生，提高自我保健意识， 高凌教授讲解了饮食健康，倡导建立科学健康的饮食习惯与生活方式。<br>随后来到中南财经政法大学校艺体中心门前广场举办了义诊活动，我院心内科，呼吸内科，消化内科，肾内科，肿瘤科，全科医学科及中医科均参加了本次义诊活动。<br>义诊活动中，来自中南财经政法大学的学生和老师纷纷前来咨询，医护人员积极为她们测量生命体征，及时为她们予以疾病知识答疑和诊疗，进行健康指导，此次义诊普及了科学的生活方式，增加了我院为人民服务的热情和决心。<br>夕阳西下中，义诊活动结束，参与此次义诊活动近百余人，加深了人民医院与中南财经政法大学的交流与沟通，<br>此次活动是服务百姓健康，学习习近平总书记中国共产党成立一百周年讲话中的精神指引的重要体现，始终贯彻中国共产党坚持全心全意为人民服务的根本宗旨，<br>今后将坚持以人民为中心，继续将改善民生活动，服务广大群众为目标，不断进取，一路前行！</span>",
          http:"http//:localhost:8090://webhome"
        },
        {
          url: "http://localhost:8090/files/222.jpg",
          title:"<h2 style="+'"'+"color:#009393"+'"' +">党史学习教育</h2>",
          text: "<span style="+'"'+"color:#000000"+'"' +">10月29日上午，人民医院委员会举行2021年第12次党委理论学习中心组扩大学习暨党史学习教育第8次专题学习，<br>集中学习了习近平总书记在纪念辛亥革命110 周年大会上的重要讲话、习近平总书记在中央民族工作会议上的重要讲话、<br>习近平总书记在中央人才工作会议上的重要讲话精神、习近平总书记在中央人大工作会议上的重要讲话精神、<br>中共中央政治局召开会议决定召开十九届六中全会、习近平总书记在中共中央政治局第三十三次集体学习关于国家生物安全的重要讲话等内容。<br>余锂镭副书记领学了习近平总书记在纪念辛亥革命110 周年大会上的重要讲话，<br>强调要学习和弘扬革命先驱为振兴中华而矢志不渝的崇高精神，激励和团结海内外全体中华儿女为实现中华民族伟大复兴而共同奋斗。<br>在领学习近平总书记在中央民族工作会议上的重要讲话中，余锂镭书记强调要要增强“四个意识”、坚定“四个自信”、<br>做到“两个维护”，不断提高政治判断力、政治领悟力、政治执行力，牢记“国之大者”，认真履行主体责任，把党的领导贯穿民族工作全过程。<br>万红慧书记就抓好中心组学习和医院党史学习教育提出4点要求。<br>一是学习。今年以来，习近平总书记围绕建党百年和党史学习教育发表了一系列重要讲话，就是提醒全党“不忘初心 牢记使命”，在新的历史起点上，总结经验，更好地奋进第二个百年奋斗目标。<br>全院党员干部要牢牢抓住这一主线，系统跟进学习总书记系列重要讲话。面对百年未有之大变局，我们要牢牢站稳政治立场，牢固树立四个意识，坚定四个自信。坚决做到两个维护，跟进学习习近平总书记系列重要讲话，来指导工作。<br>二是整改。近期学校针对中央巡视的反馈要求，正在紧锣密鼓推进各项整改工作。前些时学校党委专门召开座谈会，请医院去做了整改工作汇报，也受到学校的充分肯定。</span>",
          http:"http//:localhost:8090://webhome"
        },
        {
          url: "http://localhost:8090/files/333.jpg",
          title:"<h2 style="+'"'+"color: #750075"+'"' +">“粉红十月，关爱女性”</h2>",
          text: "<span style="+'"'+"color:#000000"+'"' +">医心向党迎百年，科普义诊护健康。10月23日，人民医院乳腺甲状腺外科党支部联合医务社工部，<br>在读书社区党员群众服务中心开展“粉红十月，关爱女性”乳腺癌防治主题活动。<br>活动以教授乳房保健操、健康讲座、现场义诊等形式服务了100余名社区居民。<br>伴随着动感的音乐，乳腺甲状腺外科医务人员带领居民做起乳房保健操。<br>在健康讲座环节，孙金中和郭跃跃医生分别就乳腺癌和甲状腺疾病的防治做了生动简明的科普，<br>呼吁居民重视两癌筛查，做到早预防、早筛查、早治疗。<br>乳腺甲状腺外科党支部书记魏文、孔德光医生为社区居民提供乳腺和甲状腺义诊咨询服务，<br>杨淑红、王建英、胡琳琳护士长等为社区居民免费测量血压和血糖，进行个体化饮食和运动指导，<br>现场发放“乳腺癌的防治”、“甲状腺疾病的预防与治疗”宣传手册。<br>乳腺甲状腺外科党支部书记魏文表示，本次主题活动充分体现了党员医护工作者的使命担当，<br>发挥了先锋模范作用，切实地为广大居民提供了面对面的便捷医疗服务，增强了居民的乳腺甲状腺健康保健意识。</span>",
          http:"http//:localhost:8090://webhome"
        },
        {
          url: "http://localhost:8090/files/444.jpg",
          title:"<h2 style="+'"'+"color: #D94600"+'"' +">“沿着红色足迹前进”主题党日活动”</h2>",
          text: "<span style="+'"'+"color:#000000"+'"' +">追忆百年党史、汲取信仰力量。六月微雨，华诞将至，为庆祝中国共产党成立100周年，推进党史学习教育走深走实，<br>6月11日产科党支部组织“党员应急岗”队员，<br>前往钟祥市大洪山革命历史纪念馆开展“沿着红色足迹前进”主题党日活动。<br>党支部书记刘谦和胡慧红护士长、陈春丽护士长、程秋霞护士长带领其余党员同志按照原计划前往钟祥市大洪山革命历史纪念馆。<br>一张张珍贵的老照片、一件件革命前辈用过的物品、一个个可歌可泣的英雄人物，党员同志们深入学习了<br>这些激情燃烧的红色故事，被贺龙、李先念、陶铸等老一辈革命家的勇于牺牲的精神和坚定不移的信念深深震撼。<br>结合当前疫情防控常态化形势，党员同志们围绕自身岗位职责展开讨论，<br>一致表示学习革命党史，学习体会党一切为了人民、一切依靠人民，与人民始终心心相印、把人民利益永远放在心中最高位置<br>的坚定信念和深厚情怀，更加坚定了一心一意跟党走的信念。<br>医疗工作如战场，沿着革命先烈的红色足迹，党员医护将永葆初心，<br>以习近平新时代中国特色社会主义思想为指导，落实“一切为了人民健康”的宗旨，<br>时刻将人民群众放在心中，急群众之所急，解群众之所忧，用一颗对人民群众火热的赤子之心，<br>竭尽全力把产科“党员应急岗”工作做得更好，向中国共产党百年华诞献礼！</span>",
          http:"http//:localhost:8090://webhome"
        }
      ],
    };
  },

  created(){
    // this.load()
  },
  methods: {
    rollScroll(event) {
      let _that = this;
      // chrome、ie使用的wheelDelta，火狐使用detail
      let scrollVal = event.wheelDelta || event.detail;
      // 节流
      if (!_that.timeOut) {
        _that.timeOut = setTimeout(() => {
          _that.timeOut = null;

          // ?
          // :
          if (scrollVal > 0) {
            _that.$refs.carousel.prev();
            if (this.carditem < 1 || this.carditem == 1) {
              this.carditem = 4;
            } else {
              this.carditem--;
            }
            console.log(this.carditem);
          } else {
            _that.$refs.carousel.next();
            if (this.carditem > 4 || this.carditem == 4) {
              this.carditem = 1;
            } else {
              this.carditem++;
            }

            console.log(this.carditem);
          }
        }, 300);
      } else {
      }
    },
    load(){
      request.get("/drugandfu/drugandfuitem").then((res)=>{
        this.drugdata=res.data

      })
    }
  },
};
</script>

<style>
.imgtext_http{
  margin-top: 1%;
}
.imgtext_more{
  margin-top: 3%;
}
.item_root {
  width: 100%;
  height: 100vh;
}
.icon_root {
  display: flex;
  flex-direction: column;
  float: right;
  margin-left: 1%;
  position: absolute;
  /* justify-content:center;
align-items:center; */
}
.card_a {
  width: 100%;
  height: 100%;
}
.imgtext {
  width: 74%;
  float: left;
  margin-top: 7%;
  padding: 10px;
  position: absolute;
  margin-left: 15%;
  display: flex;
  flex-direction: column;
  /* background-color: #F5FFE8; */
  /* opacity: 0.5 ; */
  background-color: rgba(255,255,255,0.6);
  border-radius:20px;
}
.icon_itme {
  width: 23%;
  height: 25%;
  margin-top: 3%;
  border-radius:30%;
}
h2{
  color:#01814A;
}
</style>