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

 Date: 06/05/2022 13:07:56
*/


// ----------------------------
// Collection structure for works
// ----------------------------
db.getCollection("works").drop();
db.createCollection("works");

// ----------------------------
// Documents of works
// ----------------------------
db.getCollection("works").insert([ {
    _id: ObjectId("623dcf5cc81b723656829998"),
    url: "http://localhost:8090/files/02.jpg",
    content: "医院坚持“聚天下英才而用之”的理念，筑巢引凤，因凤筑巢。对硕博期间以第一作者身份发表SCI一区论文，或单篇影响因子8分及以上或总影响因子20分及以上的毕业生优先录用。医院诚挚邀请国内外人才来院发展，并竭诚提供具有国际竞争力的工作条件、薪酬福利和生活保障。",
    _class: "com.example.entity.menhu.work.Works"
} ]);
db.getCollection("works").insert([ {
    _id: ObjectId("623dcfadc81b723656829999"),
    url: "http://localhost:8090/files/01.jpg",
    content: "医院拥有完备的研究平台，包括中心实验室、模式动物中心、转化医学中心、药物临床试验基地等，配置有高通量测序仪、质谱仪、电镜、膜片钳、流式细胞仪等生命科学研究仪器设备及常规分子生物学、细胞生物学科研设备",
    _class: "com.example.entity.menhu.work.Works"
} ]);
db.getCollection("works").insert([ {
    _id: ObjectId("623dcff4c81b72365682999a"),
    url: "http://localhost:8090/files/7.webp",
    content: "医院落实“一切为了人民健康”的办院理念，牢固树立“求精益、强内涵、铸品牌”发展理念，紧扣“世界一流医院”建设目标，坚持以医疗质量为生命线，以学科建设为龙头，以保障人民健康需要为使命，以加强党的建设为根本保证，不断提升医院竞争实力，实现医院内涵建设、社会服务、医院文化、品牌形象等竞争实力全面提升。",
    _class: "com.example.entity.menhu.work.Works"
} ]);
