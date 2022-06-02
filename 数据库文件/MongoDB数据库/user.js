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

 Date: 06/05/2022 13:07:49
*/


// ----------------------------
// Collection structure for user
// ----------------------------
db.getCollection("user").drop();
db.createCollection("user");

// ----------------------------
// Documents of user
// ----------------------------
db.getCollection("user").insert([ {
    _id: ObjectId("620e0b92f53f2d239950f163"),
    name: "马超",
    password: "123",
    rowle: NumberInt("2"),
    _class: "com.example.entity.User",
    lasttime: ISODate("2022-04-28T12:06:46.908Z"),
    updateowinfo: [
        {
            _id: NumberInt("1"),
            drugname: "云南白药",
            outin: "出库",
            nums: NumberInt("3"),
            druguser: "杨跃",
            ctime: "2022年02月17日 16时49分02秒"
        },
        {
            _id: NumberInt("3"),
            drugname: "云南白药",
            outin: "入库",
            nums: NumberInt("12"),
            druguser: "杨跃",
            ctime: "2022年02月17日 17时01分42秒"
        },
        {
            _id: NumberInt("13"),
            drugname: "创口贴",
            outin: "入库",
            nums: NumberInt("124"),
            druguser: "杨跃",
            ctime: "2022年02月17日 19时29分46秒"
        },
        {
            _id: NumberInt("1"),
            drugname: "云南白药",
            outin: "出库",
            nums: NumberInt("3"),
            druguser: "杨跃",
            ctime: "2022年02月18日 12时46分51秒"
        },
        {
            _id: NumberInt("5"),
            drugname: "999感冒灵",
            outin: "入库",
            nums: NumberInt("99"),
            druguser: "杨跃",
            ctime: "2022年02月18日 12时46分54秒"
        },
        {
            _id: NumberInt("1"),
            drugname: "云南白药",
            outin: "出库",
            nums: NumberInt("3"),
            druguser: "杨跃",
            ctime: "2022年02月18日 15时53分53秒"
        }
    ],
    address: "西凉",
    age: NumberInt("21"),
    phone: "10086",
    position: "医生",
    sex: "男",
    headimg: "http://localhost:8090/files/屏幕截图 2022-04-28 200811.png",
    num: "020201",
    updatematter: [
        {
            _id: NumberInt("1"),
            img: "http://localhost:8090/files/lula.jpg",
            drugname: "云南白药",
            matternum: NumberInt("3"),
            price: 2,
            ctime: "2022年02月18日 12时47分45秒",
            miaos: "李帅买贵了",
            username: "杨跃"
        }
    ],
    updatesaleinfo: [
        {
            _id: NumberInt("1"),
            drugname: "耗子药",
            number: "1234",
            count: NumberInt("3"),
            money: 96,
            operator: "杨跃",
            operatetime: ISODate("2022-02-18T04:47:53.271Z"),
            tupian: "http://localhost:8090/files/lula.jpg"
        },
        {
            _id: NumberInt("2"),
            drugname: "胃痛药",
            number: "1234",
            count: NumberInt("1"),
            money: 32,
            operator: "杨跃",
            operatetime: ISODate("2022-02-18T04:47:55.993Z"),
            tupian: "http://localhost:8090/files/lula.jpg"
        }
    ],
    updateretrungoods: [
        {
            _id: NumberInt("1"),
            drugname: "耗子药",
            count: NumberInt("1"),
            reason: "李帅坑了",
            money: 32,
            operatetime: ISODate("2022-02-18T04:47:58.895Z"),
            tupian: "http://localhost:8090/files/lula.jpg",
            username: "杨跃"
        }
    ],
    updatedrug: [
        {
            _id: NumberInt("10"),
            drugname: "李帅",
            suppliername: "哈药六厂",
            producttime: ISODate("2021-12-13T16:00:00.000Z"),
            warrenty: NumberInt("12"),
            price: 0,
            stock: NumberInt("21"),
            guo: true,
            guotime: "剩余保质期 10月3日",
            username: "杨跃"
        }
    ],
    deletedrug: [
        {
            _id: NumberInt("8"),
            tupian: "http://localhost:8090/files/元歌3.560.png",
            drugname: "痔疮药",
            suppliername: "",
            producttime: ISODate("2021-12-01T16:00:00.000Z"),
            warrenty: NumberInt("12"),
            price: 0,
            stock: NumberInt("123"),
            guo: true,
            guotime: "剩余保质期 10月15日"
        }
    ],
    updatesupplier: [
        {
            _id: NumberInt("4"),
            name: "杨跃小药铺",
            content: "卖草药的",
            createtime: ISODate("2022-02-18T04:48:13.136Z"),
            username: "杨跃"
        }
    ],
    updatereturnsupplier: [
        {
            _id: NumberInt("4"),
            count: NumberInt("3"),
            drugname: "999感冒灵",
            reason: "李帅",
            createtime: ISODate("2022-02-18T04:48:16.374Z"),
            pay: "微信支付",
            username: "杨跃"
        }
    ],
    updatebill: [
        {
            _id: NumberInt("1"),
            num: "123",
            drugname: "云南白药",
            count: NumberInt("12"),
            tupian: "http://localhost:8090/files/wangzhe.jpg",
            price: 1,
            createtime: ISODate("2022-02-18T04:48:20.741Z"),
            username: "杨跃"
        }
    ],
    deleteowinfo: [
        {
            _id: NumberInt("8"),
            tupian: "http://localhost:8090/files/wangzhe.jpg",
            drugname: "西瓜霜",
            outin: "入库",
            nums: NumberInt("130"),
            ctime: "2022年02月09日 21时58分33秒"
        }
    ]
} ]);
db.getCollection("user").insert([ {
    _id: ObjectId("620f77cf957aff6d575d4732"),
    name: "李帅",
    password: "111",
    position: "院长",
    rowle: NumberInt("1"),
    age: NumberInt("20"),
    sex: "男",
    phone: "10086",
    address: "湖南岳阳",
    num: "010110",
    _class: "com.example.entity.User",
    lasttime: ISODate("2022-04-28T12:10:36.347Z"),
    headimg: "http://localhost:8090/files/屏幕截图 2022-04-28 201106.png",
    updateowinfo: [
        {
            _id: NumberInt("1"),
            drugname: "云南白药",
            outin: "出库",
            nums: NumberInt("3"),
            druguser: "李帅",
            ctime: "2022年02月18日 18时54分34秒"
        },
        {
            _id: NumberInt("1"),
            drugname: "云南白药",
            outin: "出库",
            nums: NumberInt("3"),
            druguser: "李帅",
            ctime: "2022年02月18日 20时14分39秒"
        }
    ],
    updatesaleinfo: [
        {
            _id: NumberInt("1"),
            drugname: "耗子药",
            number: "1234",
            count: NumberInt("3"),
            money: 96,
            operator: "李帅",
            operatetime: ISODate("2022-02-18T12:14:28.625Z"),
            tupian: "http://localhost:8090/files/lula.jpg"
        },
        {
            _id: NumberInt("1"),
            drugname: "耗子药",
            number: "1234",
            count: NumberInt("3"),
            money: 96,
            operator: "李帅",
            operatetime: ISODate("2022-02-18T12:14:30.771Z"),
            tupian: "http://localhost:8090/files/lula.jpg"
        },
        {
            _id: NumberInt("2"),
            drugname: "胃痛药",
            number: "1234",
            count: NumberInt("1"),
            money: 32,
            operator: "李帅",
            operatetime: ISODate("2022-02-18T12:14:32.471Z"),
            tupian: "http://localhost:8090/files/lula.jpg"
        }
    ],
    updateretrungoods: [
        {
            _id: NumberInt("1"),
            drugname: "耗子药",
            count: NumberInt("1"),
            reason: "李帅坑了",
            money: 32,
            operatetime: ISODate("2022-02-18T12:14:34.871Z"),
            tupian: "http://localhost:8090/files/lula.jpg",
            username: "李帅"
        }
    ],
    updatematter: [
        {
            _id: NumberInt("3"),
            img: "http://localhost:8090/files/QQ浏览器截图20210909145907.png",
            drugname: "六味地黄丸",
            matternum: NumberInt("2"),
            price: 5,
            ctime: "2022年02月18日 20时14分45秒",
            miaos: "杨跃买的",
            username: "李帅"
        }
    ],
    updatedrug: [
        {
            _id: NumberInt("3"),
            drugname: "云南白药",
            suppliername: "哈药",
            producttime: ISODate("2021-11-23T16:00:00.000Z"),
            warrenty: NumberInt("12"),
            number: "4566",
            price: 78,
            stock: NumberInt("56"),
            guo: true,
            guotime: "剩余保质期 10月23日",
            username: "李帅"
        }
    ],
    updatesupplier: [
        {
            _id: NumberInt("6"),
            name: "哈药六厂",
            createtime: ISODate("2022-02-18T12:14:55.088Z"),
            username: "李帅"
        }
    ],
    updatereturnsupplier: [
        {
            _id: NumberInt("4"),
            count: NumberInt("3"),
            drugname: "999感冒灵",
            reason: "李帅",
            createtime: ISODate("2022-02-18T12:14:57.729Z"),
            pay: "微信支付",
            username: "李帅"
        }
    ],
    updatebill: [
        {
            _id: NumberInt("1"),
            num: "123",
            drugname: "云南白药",
            count: NumberInt("12"),
            tupian: "http://localhost:8090/files/wangzhe.jpg",
            price: 1,
            createtime: ISODate("2022-02-18T12:15:02.546Z"),
            username: "李帅"
        }
    ],
    deleteowinfo: [
        {
            _id: NumberInt("14"),
            tupian: "http://localhost:8090/files/元歌3.560.png",
            drugname: "痔疮药",
            outin: "入库",
            nums: NumberInt("123"),
            ctime: "2022年02月15日 12时58分44秒"
        }
    ]
} ]);
