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

 Date: 06/05/2022 13:08:02
*/


// ----------------------------
// Collection structure for worksselect
// ----------------------------
db.getCollection("worksselect").drop();
db.createCollection("worksselect");

// ----------------------------
// Documents of worksselect
// ----------------------------
db.getCollection("worksselect").insert([ {
    _id: NumberInt("1"),
    select: "本科学历及本科以上",
    _class: "com.example.entity.menhu.work.Worksselect"
} ]);
db.getCollection("worksselect").insert([ {
    _id: NumberInt("2"),
    select: "研究生及研究生以上优先",
    _class: "com.example.entity.menhu.work.Worksselect"
} ]);
db.getCollection("worksselect").insert([ {
    _id: NumberInt("3"),
    select: "211或985院校毕业生优先",
    _class: "com.example.entity.menhu.work.Worksselect"
} ]);
db.getCollection("worksselect").insert([ {
    _id: NumberInt("4"),
    select: "有工作经验优先",
    _class: "com.example.entity.menhu.work.Worksselect"
} ]);
