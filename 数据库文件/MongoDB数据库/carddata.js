/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MongoDB
 Source Server Version : 40208
 Source Host           : localhost:27017
 Source Schema         : yiyuan

 Target Server Type    : MongoDB
 Target Server Version : 40208
 File Encoding         : 65001

 Date: 06/05/2022 13:07:14
*/


// ----------------------------
// Collection structure for carddata
// ----------------------------
db.getCollection("carddata").drop();
db.createCollection("carddata");

// ----------------------------
// Documents of carddata
// ----------------------------
db.getCollection("carddata").insert([ {
    _id: NumberInt("1"),
    url: "http://localhost:8090/files/1.webp",
    title: "省卫健委调研组来人民医院开展县医改工作调研",
    content: "调研组一行对医院核酸检测区、门诊部、疫苗接种区、国家糖尿病标准化防控分中心等区域进行了现场调研，对医院的各项工作表示了肯定，并提出了意见和指导。",
    time: "2022-3-1",
    _class: "com.example.entity.menhu.nowdataitem.Carddata"
} ]);
db.getCollection("carddata").insert([ {
    _id: NumberInt("2"),
    url: "http://localhost:8090/files/2.webp",
    title: "人民医院祝离退休老同志重阳节快乐",
    content: "重阳与三月初三日“踏春”皆是家族倾室而出，重阳这天所有亲人都要一起登高望远，消灾避难。",
    time: "2021-10-24",
    _class: "com.example.entity.menhu.nowdataitem.Carddata"
} ]);
db.getCollection("carddata").insert([ {
    _id: NumberInt("3"),
    url: "http://localhost:8090/files/3.webp",
    title: "省人民医院与人民医院定点指导医院授牌仪式暨“仁术心连心”博士团专家活动顺利开展",
    content: "省人民医院与我院定点指导医院授牌仪式在县人民医院行管三楼会议室举行，省人民医院“仁术心连心”博士团专家活动顺利开展。",
    time: "2021-6-7",
    _class: "com.example.entity.menhu.nowdataitem.Carddata"
} ]);
db.getCollection("carddata").insert([ {
    _id: NumberInt("4"),
    url: "http://localhost:8090/files/4.jpg",
    title: "做不了急诊是误解，人民医院上线长江网与网民交流",
    content: "人民医院院长张瑶，党委副书记、纪委书记郭涛和副院长王雷，携10个科室负责人，通过长江网城市留言板在线与网民交流答疑。\r\n",
    time: "2021-2-16",
    _class: "com.example.entity.menhu.nowdataitem.Carddata"
} ]);
