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

 Date: 06/05/2022 13:07:35
*/


// ----------------------------
// Collection structure for newdata
// ----------------------------
db.getCollection("newdata").drop();
db.createCollection("newdata");

// ----------------------------
// Documents of newdata
// ----------------------------
db.getCollection("newdata").insert([ {
    _id: NumberInt("1"),
    content: "【招生啦！】人民医院2021年度助理全科医生培训招生简章",
    time: "2021-12-3",
    _class: "com.example.entity.menhu.nowdataitem.Newdata"
} ]);
db.getCollection("newdata").insert([ {
    _id: NumberInt("2"),
    content: "99岁奶奶骨科手术成功，成为人民医院骨科史上最高龄患者",
    time: "2021-9-3",
    _class: "com.example.entity.menhu.nowdataitem.Newdata"
} ]);
db.getCollection("newdata").insert([ {
    _id: NumberInt("3"),
    content: "“关爱女性，关注健康”女性健康知识科普讲座在人民医院开讲",
    time: "2021-11-3",
    _class: "com.example.entity.menhu.nowdataitem.Newdata"
} ]);
db.getCollection("newdata").insert([ {
    _id: NumberInt("4"),
    content: "县长余建新一行督查人民医院疫情防控工作",
    time: "2021-12-3",
    _class: "com.example.entity.menhu.nowdataitem.Newdata"
} ]);
db.getCollection("newdata").insert([ {
    _id: NumberInt("5"),
    content: "人民医院迎接第26个全国爱眼日——“关注普遍的眼健康”",
    time: "2021-12-20",
    _class: "com.example.entity.menhu.nowdataitem.Newdata"
} ]);
