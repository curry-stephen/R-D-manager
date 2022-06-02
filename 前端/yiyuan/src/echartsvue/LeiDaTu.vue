<template>
  <div id="leidatu"></div>
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
          var chartDom = document.getElementById('leidatu');
var myChart = echarts.init(chartDom);
var option;

option = {
  // title: {
  //   text: '科室'
  // },
  legend: {//标签位置
    data: ['本院总部'],
    left:"2%",
    top:"2%",
    itemStyle :{
 color:"#AE00AE"
    },
    textStyle: { // 图例的公用文本样式。
            fontSize: 15,
            color: '	#000079'
        },
  },
  
  radar: {
    name: { // (圆外的标签)雷达图每个指示器名称的配置项。
            formatter: '{value}',
            textStyle: {
                fontSize: 15,
            }
        },
    axisLine: { // (圆内的几条直线)坐标轴轴线相关设置
            lineStyle: {
                color: '#fff',
                // 坐标轴线线的颜色。
                width: 1,
                // 坐标轴线线宽。
                type: 'solid',
                // 坐标轴线线的类型。
            }
        },
     splitArea: { // 坐标轴在 grid 区域中的分隔区域，默认不显示。
            show: true,
            areaStyle: { // 分隔区域的样式设置。
                color: ['rgba(250,250,250,0.3)', 'rgba(200,200,200,0.3)'],
                // 分隔区域颜色。分隔区域会按数组中颜色的顺序依次循环设置颜色。默认是一个深浅的间隔色。
            }
        },
    // shape: 'circle',
    indicator: [
      { name: '临床科室', max: 25 ,color:"	#5E005E"},
      { name: '医技科室', max: 10 ,color:"	#003D79"},
      { name: '门诊科室', max: 8 ,color:"	#842B00"},
      { name: '医疗中心', max: 10 ,color:"	#820041"},
      { name: '行政管理', max: 15 ,color:"	#006000"}
    ],
    
    axisLine: { // (圆内的几条直线)坐标轴轴线相关设置
            lineStyle: {
                color: '	#81C0C0',
                // 坐标轴线线的颜色。
                width: 1,
                // 坐标轴线线宽。
                type: 'solid',
                // 坐标轴线线的类型。
            }
        },
  },
  series: [
    {
      name: 'Budget vs spending',
      type: 'radar',
       itemStyle: { // 折线拐点标志的样式。
            normal: { // 普通状态时的样式
                lineStyle: {
                    width: 2,
                    color:"	#AE00AE"
                },
                opacity: 0.2
            },
            emphasis: { // 高亮时的样式
                lineStyle: {
                    width:4,
                    color:"#00E3E3"
                },
                opacity: 1
            }
        },
      data: [
        {
          value: [22, 8, 3, 5,10],
          name: '本院总部'
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
#leidatu {
  width: 100%;
  height: 100%;
}
</style>