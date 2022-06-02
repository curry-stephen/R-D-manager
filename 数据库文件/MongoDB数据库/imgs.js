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

 Date: 06/05/2022 13:07:28
*/


// ----------------------------
// Collection structure for imgs
// ----------------------------
db.getCollection("imgs").drop();
db.createCollection("imgs");

// ----------------------------
// Documents of imgs
// ----------------------------
db.getCollection("imgs").insert([ {
    _id: ObjectId("623d94083b80a255b71dc316"),
    url: "http://localhost:8090/files/05.jpg",
    text: "重点专科建设专题会",
    _class: "com.example.entity.menhu.dongtaiimg.Imgs"
} ]);
db.getCollection("imgs").insert([ {
    _id: ObjectId("623d94423b80a255b71dc317"),
    url: "http://localhost:8090/files/06.jpg",
    text: "呼吸与危重症医学Ⅰ科党支部主题党日活动",
    _class: "com.example.entity.menhu.dongtaiimg.Imgs"
} ]);
db.getCollection("imgs").insert([ {
    _id: ObjectId("623d94543b80a255b71dc318"),
    url: "http://localhost:8090/files/08.jpg",
    text: "深度打磨专业教师的教学基本功",
    _class: "com.example.entity.menhu.dongtaiimg.Imgs"
} ]);
db.getCollection("imgs").insert([ {
    _id: ObjectId("623d946a3b80a255b71dc319"),
    url: "http://localhost:8090/files/09.jpg",
    text: "学术交流",
    _class: "com.example.entity.menhu.dongtaiimg.Imgs"
} ]);
