<template>
  <div id="bin"></div>
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
var chartDom = document.getElementById('bin');
var myChart = echarts.init(chartDom);
var option;

option = {
  legend: {
    top: 'bottom'
  },
  toolbox: {
    show: true,
    // feature: {
    //   mark: { show: true },
    //   dataView: { show: true, readOnly: false },
    //   restore: { show: true },
    //   saveAsImage: { show: true }
    // }
  },
  series: [
    {
      name: '在职医护人员',
      type: 'pie',
      radius: [30, 130],
      center: ['50%', '50%'],
      roseType: 'area',
      itemStyle: {
        borderRadius: 8
      },
      data: [
        { value: 563, name: '临床科室' },
        { value: 456, name: '医技科室' },
        { value: 322, name: '门诊部' },
        { value: 260, name: '医疗中心' }
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
#bin {
  width: 100%;
  height: 100%;
}
</style>