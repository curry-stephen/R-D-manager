<template>
  <div id="work"></div>
</template>

<script>
import * as echarts from "echarts";
export default {
  data() {
    return {};
  },
  mounted() {
    this.loadecharts();
  },
  methods: {
    loadecharts() {
      var chartDom = document.getElementById("work");
      var myChart = echarts.init(chartDom);
      var option;

      option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow",
          },
        },
        title: {
          text: "工作招聘目标（单位/人）",
          show: true,
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true,
        },
        xAxis: [
          {
            type: "category",
            data: [
              "护士",
              "主治医生",
              "外科医生",
              "主管技师",
              "麻醉医生",
              "检验科医生",
              "实习医生",
            ],
            axisTick: {
              alignWithLabel: true,
            },
            axisLabel: {
              interval: 0,
              rotate: 40,
            },
          },
        ],
        yAxis: [
          {
            type: "value",
          },
        ],
        series: [
          {
            name: "招聘目标：",
            type: "bar",
            barWidth: "60%",
            data: [20, 16, 15, 10, 13, 14, 24],
            itemStyle: {
              barBorderRadius: [50, 50, 0, 0], //设置圆角
              color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [
                {
                  offset: 0,
                  color: "	#01B468", //百分之0时的颜色
                },
                {
                  offset: 0.5,
                  color: "	#C07AB8", //百分之0.5时的颜色
                },
                {
                  offset: 1,
                  color: "#F75000", //百分之百的颜色
                },
              ]),
            },
          },
        ],
      };

      myChart.setOption(option);
    },
  },
};
</script>

<style>
#work {
  width: 400px;
  height: 380px;
}
</style>