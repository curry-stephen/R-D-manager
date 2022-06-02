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

 Date: 06/05/2022 13:07:20
*/


// ----------------------------
// Collection structure for drugdata
// ----------------------------
db.getCollection("drugdata").drop();
db.createCollection("drugdata");

// ----------------------------
// Documents of drugdata
// ----------------------------
db.getCollection("drugdata").insert([ {
    _id: "1",
    url: "http://localhost:8090/files/拙简素材 (10).jpg\"",
    title: "标题",
    text: "李帅喜欢干饭",
    http: "http//:localhost:8090://",
    _class: "com.example.entity.menhu.Drugdata"
} ]);
db.getCollection("drugdata").insert([ {
    _id: "2",
    url: "http://localhost:8090/files/拙简素材 (4).jpg",
    title: "标题",
    text: "王志喜欢卷",
    http: "http//:localhost:8090://",
    _class: "com.example.entity.menhu.Drugdata"
} ]);
db.getCollection("drugdata").insert([ {
    _id: "4",
    url: "http://localhost:8090/files/拙简素材 (8).jpg",
    title: "标题",
    text: "热干面真的很好吃",
    http: "http//:localhost:8090://",
    _class: "com.example.entity.menhu.Drugdata"
} ]);
db.getCollection("drugdata").insert([ {
    _id: "3",
    url: "http://localhost:8090/files/shucai1.jpg",
    title: "标题",
    text: "里子不曾爱过",
    http: "http//:localhost:8090://",
    _class: "com.example.entity.menhu.Drugdata"
} ]);
