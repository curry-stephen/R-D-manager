<template>
  <div class="tiaoxing" style="height: 100%; width: 100%" ref="log_ref"></div>
</template>

<script>
import * as echarts from "echarts";
import request from "../utils/request";
import router from "../router";
let user1;
export default {
  data() {
    return {
      chartInstance: null,
      xData: [],
      yData: [],
      userform: {},
      startValue: 0,
      endValue: 6,
      timeId: null,
    };
  },
  created() {
    let userJson = sessionStorage.getItem("user");
    if (!userJson) {
      router.push("/login");
    } else {
      user1 = JSON.parse(userJson);
      this.userform.name = user1.name;
      this.userform.password = user1.password;
    }
  },
  mounted() {
    if (this.userform) {
      this.initChart();
      this.getData();
      //window.addEventListener("resize", this.screenAdapter);
      this.screenAdapter();
    }
  },
  destroyed() {
    //window.removeEventListener("resize", this.screenAdapter);
    clearInterval(this.timeId);
  },
  methods: {
    async getData() {
      //   request.post("/log/bar", this.userform).then((res) => {
      //     if (res.flag) {
      //       this.xData = res.keys.map((item) => {
      //         return item;
      //       });
      //       this.yData = res.data.map((item) => {
      //         return item;
      //       });
      //       this.updataChart();
      //       this.startInterval();
      //     }
      //   });
      const resdata = await request.post("/log/bar", this.userform);
      this.xData = resdata.keys;
      this.yData = resdata.data;
      this.updataChart();
      this.startInterval();
    },
    //初始化图表
    initChart() {
      this.chartInstance = echarts.init(this.$refs.log_ref);
      const initOption = {
        title: {
          text: "操作日志（次数）",
        },
        tooltip: {
          show: true,
        },
        xAxis: {
          type: "category",
          boundaryGap: true,
          axisLabel: {
            interval: 0,
            formatter: function (value) {
              var ret = ""; //拼接加\n返回的类目项
              var maxLength = 2; //每项显示文字个数
              var valLength = value.length; //X轴类目项的文字个数
              var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数
              if (rowN > 1) {
                //如果类目项的文字大于3,
                for (var i = 0; i < rowN; i++) {
                  var temp = ""; //每次截取的字符串
                  var start = i * maxLength; //开始截取的位置
                  var end = start + maxLength; //结束截取的位置
                  //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧
                  temp = value.substring(start, end) + "\n";
                  ret += temp; //凭借最终的字符串
                }
                return ret;
              } else {
                return value;
              }
            },
          },
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            name: "日志",
            type: "bar",
            markPoint: {
              data: [
                { type: "max", name: "最大次数" },
                { type: "min", name: "最小次数" },
              ],
            },
            label: {
              show: true, //开启显示
              position: "insideTop", //在上方显示
              textStyle: {
                //数值样式
                color: "black",
                fontSize: 16,
                fontWeight: 600,
              },
              formatter: function (value) {
                return value.data + "次";
              },
            },
            itemStyle: {
              barBorderRadius: [90, 90, 0, 0], //设置圆角
            },
          },
        ],
      };
      this.chartInstance.setOption(initOption);
      this.chartInstance.on("mouseover", () => {
        clearInterval(this.timeId);
      });
      this.chartInstance.on("mouseout", () => {
        this.startInterval();
      });
    },
    //将数据绑定到图表
    updataChart() {
      const colorArr = [
        ["#0BA82C", "#4FF778"],
        ["#2E72BF", "#23E5E5"],
        ["#5052EE", "#AB6EE5"],
      ];
      const dataOption = {
        xAxis: {
          data: this.xData,
        },
        dataZoom: {
          show: false,
          startValue: this.startValue,
          endValue: this.endValue,
        },
        series: [
          {
            data: this.yData,
            
            itemStyle: {
              barBorderRadius: [50, 50, 0, 0], //设置圆角
              color: (arg) => {
                let targetColorArr = null;
                if (arg.value > 300) {
                  targetColorArr = colorArr[0];
                } else if (arg.value > 200) {
                  targetColorArr = colorArr[1];
                } else {
                  targetColorArr = colorArr[2];
                }
                return new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  { offset: 0, color: targetColorArr[0] },
                  { offset: 1, color: targetColorArr[1] },
                ]);
              },
            },
          },
        ],
      };
      this.chartInstance.setOption(dataOption);
    },
    screenAdapter() {
      const titleFontSize = 50;
      const adapterOption = {
        title: {
          textStyle: {
            fontSize: titleFontSize / 2.2,
          },
        },
        series: [
          {
            // barWidth: titleFontSize,
            itemStyle: {
              barBorderRadius: [50, 50, 0, 0], //设置圆角
            },
          },
        ],
      };
      this.chartInstance.setOption(adapterOption);
      //this.chartInstance.resize();
    },
    startInterval() {
      if (this.timeId) {
        clearInterval(this.timeId);
      }
      this.timeId = setInterval(() => {
        this.startValue++;
        this.endValue++;
        if (this.endValue > this.xData.length - 1) {
          this.startValue = 0;
          this.endValue = 6;
        }
        this.updataChart();
      }, 2000);
    },
  },
};
</script>

<style>
</style>