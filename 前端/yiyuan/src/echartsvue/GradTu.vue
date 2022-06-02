<template>
  <div id="grad"></div>
</template>

<script>
import * as echarts from "echarts";
export default {
data() {
    return {};
  },
  mounted() {
    this.inittu();
  },
  methods: {
      inittu(){
var chartDom = document.getElementById('grad');
var myChart = echarts.init(chartDom);
var option;

option = {
  series: [
    {
       center: ["50%", "64%"],
       radius:"95%",
      type: 'gauge',
      startAngle: 180,
      endAngle: 0,
      min: 0,
      max: 1,
      splitNumber: 8,
      axisLine: {
        
        lineStyle: {
          width: 4,
          color: [
            [0.25, '#FF6E76'],
            [0.5, '#FDDD60'],
            [0.75, '#58D9F9'],
            [1, '#009100']
          ]
        }
      },
      pointer: {
        icon: 'path://M12.8,0.7l12,40.1H0.7L12.8,0.7z',
        length: '12%',
        width: 20,
        offsetCenter: [0, '-60%'],
        itemStyle: {
          color: 'auto'
        }
      },
      axisTick: {
        length: 12,
        lineStyle: {
          color: 'auto',
          width: 2
        }
      },
      splitLine: {
        length: 20,
        lineStyle: {
          color: 'auto',
          width: 5
        }
      },
      axisLabel: {
        color:"#548C00",
        fontSize: 20,
        distance: -60,
        formatter: function (value) {
          if (value === 0.875) {
            return 'A';
          } else if (value === 0.625) {
            return 'B';
          } else if (value === 0.375) {
            return 'C';
          } else if (value === 0.125) {
            return 'D';
          }
          return '';
        },

      },
      title: {//标题
        offsetCenter: ['2%', '40%'],
        fontSize: 23
      },
      detail: {
        fontSize: 30,
        offsetCenter: ['0%', '0%'],
        valueAnimation: true,
        formatter: function (value) {
          return Math.round(value * 100) + '分';
        },
        color: 'auto'
      },
      data: [
        {
          value:0.98,
          name: '实力认证'
        }
      ]
    }
  ]
};

myChart.setOption(option);

      }
  }
}
</script>

<style>
#grad {
  width: 100%;
  height: 100%;
}
</style>