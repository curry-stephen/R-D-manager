<template>
  <div class="tongzhi_root">
    <div class="tongzhi_time">
      <el-timeline>
        <el-timeline-item
          :timestamp="item.time"
          placement="top"
          v-for="item in tongzhi"
          :key="item"
          @mouseover="mouseOver(item)"
          @mouseleave="mouseLeave"
        >
          <el-card :style="textid == item ? textcolor : ''" class="card_item">
            <h4>{{ item.title }}</h4>
            <span>{{ item.content }}</span>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
    <div class="tongzhi_qita">
      <div><h2 style="margin-left: 47%">详情</h2></div>
      <div style="width: 80%; margin-left: 10%">
        <el-card style="background-color: #fffaf4">
          <div class="xiang">
            <el-scrollbar>
            <div>
              <span style="margin-left: 30%; font-size: 17px">{{
                xiangqin.title
              }}</span>
            </div>
            <div style="margin-top: 3%">
              <span style="margin-left: 40%">{{ xiangqin.time }}</span>
            </div>
            <div style="margin-top: 3%">
              <span>{{ xiangqin.content }}</span>
            </div>
            </el-scrollbar>
          </div>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
import request from "../utils/mhrequst";
export default {
  data() {
    return {
      tongzhi: [
        // {
        //   time:'2022-1-23',
        //   title:'省长到我院来视察',
        //   content:'1月23日，省长XXX到我们医院来视察，关心我们的工作'
        // },
        // {
        //   time:'2022-1-28',
        //   title:'市长到我院来视察',
        //   content:'1月23日，市长XXX到我们医院来视察，关心我们的工作'
        // },
        // {
        //   time:'2022-1-30',
        //   title:'习近平到我院来视察',
        //   content:'1月23日，习近平XXX到我们医院来视察，关心我们的工作'
        // }
      ],
      textid: "",
      textcolor: "",
      xiangqin: {},
    };
  },
  created() {
    this.load();
  },
  methods: {
    load() {
      request.get("/dongtai/tongzhi").then((res) => {
        this.tongzhi = res.data;
      });
    },
    mouseOver(e) {
      this.xiangqin = e;
      this.textid = e;
      this.textcolor = "color:#2828FF;font-size:16px";
    },
    mouseLeave() {
      this.textcolor = "";
    },
  },
};
</script>

<style>
.card_item {
  overflow: hidden;
  white-space: nowrap;
  background-color: #F3F3FA;
    /* height: 10%; */
}
.xiang {
  display: flex;
  flex-direction: column;
  /* background-color: aqua; */
  height: 560px;
  /* overflow-x: hidden;
  overflow-y: scroll; */
  text-overflow: ellipsis;
}
.tongzhi_root {
  height: 100%;
  display: flex;
  flex-direction: row;
}
.tongzhi_time {
  width: 55%;
}
.tongzhi_qita {
  flex: 1;
  display: flex;
  flex-direction: column;
}
</style>