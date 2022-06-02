<template>
  <div id="loudoutu"></div>
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
          var chartDom = document.getElementById('loudoutu');
var myChart = echarts.init(chartDom);
var option;

option = {
  // title: {
  //   text: '医资力量'
  // },

  tooltip: {
    trigger: 'item',
    formatter: '{a} <br/>{b} : {c}%'
  },

  // toolbox: {
  //   feature: {
  //     dataView: { readOnly: false },
  //     restore: {},
  //     saveAsImage: {}
  //   }
  // },
  legend: {
    data: ['医疗专业人员', '高级职称医护人员', '中级职称医护人员', '省级医学专业学术会委员', '市级医疗卫生首席专家'],
    top:"2%"
  },
  series: [
    // {
    //   name: 'Expected',
    //   type: 'funnel',
    //   left: '10%',
    //   width: '80%',
    //   label: {
    //     formatter: '{b}Expected'
    //   },
    //   labelLine: {
    //     show: false
    //   },
    //   itemStyle: {
    //     opacity: 0.7
    //   },
    //   emphasis: {
    //     label: {
    //       position: 'inside',
    //       formatter: '{b}Expected: {c}%'
    //     }
    //   },
    //   data: [
    //     { value: 40, name: '医疗专业人员' },
    //     { value: 23, name: '高级职称医护人员' },
    //     { value: 20, name: '中级职称医护人员' },
    //     { value: 12, name: '省级医学专业学术会委员' },
    //     { value: 18, name: '市级医疗卫生首席专家' }
    //   ]
    // },
    {
      name: '所有医护人员',
      type: 'funnel',
      top:"14%",
      left: '10%',
      bottom:"5%",
      width: '80%',
      maxSize: '100%',
      label: {
        position: 'inside',
        formatter: '{c}%',
        color: '#fff'
      },
      itemStyle: {
        opacity: 0.8,
        borderColor: '#fff',
        borderWidth: 1
      },
      emphasis: {
        label: {
          position: 'inside',
          formatter: '{b}占比: {c}%'
        }
      },
      data: [
        { value: 35, name: '医疗专业人员' },
        { value: 18, name: '高级职称医护人员' },
        { value: 25, name: '中级职称医护人员' },
        { value: 9, name: '省级医学专业学术会委员' },
        { value: 13, name: '市级医疗卫生首席专家' }
      ],
      // Ensure outer shape will not be over inner shape when hover.
      z: 1000
    }
  ],

};

myChart.setOption(option);

      }
  }
}
</script>

<style>
#loudoutu{
  width: 100%;
  height: 100%;
}
</style>