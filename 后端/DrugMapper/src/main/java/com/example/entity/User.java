package com.example.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private String name;
    private String password;
    private String position;//职位
    private String headimg;//头像
    private Integer rowle;//权限
    private Integer age;
    private String sex;//性别
    private Date lasttime;//上一次登录时间
    private String phone;
    private String address;
    private String num;//工号

    
    private String newPwd;
    //bill
    private Bill[] addbill;
    private Bill[] updatebill;
    private Bill[] deletebill;

    private Druginfo[] adddruginfo;
    private Druginfo[] updatedrug;
    private Druginfo[] deletedrug;

    private Matter[] addmatter;
    private Matter[] deletematter;
    private Matter[] updatematter;

    private Owinfo[] addowinfo;
    private Owinfo[] deleteowinfo;
    private Owinfo[] updateowinfo;

    private Returngoods[] addreturngoods;
    private Returngoods[] updateretrungoods;
    private Returngoods[] deletereturngoods;

    private Returnsupplier[] addreturnsupplier;
    private Returnsupplier[] updatereturnsupplier;
    private Returnsupplier[] deletereturnsupplier;

    private Saleinfo[] addsaleinfo;
    private Saleinfo[] updatesaleinfo;
    private Saleinfo[] deletesaleinfo;

    private Supplier[] addsupplier;
    private Supplier[] updatesupplier;
    private Supplier[] deletesupplier;
}
