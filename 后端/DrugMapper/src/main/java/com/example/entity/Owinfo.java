package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "drug")
public class Owinfo implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String tupian;
    private String drugname;
    private String outin;
    private Integer nums;
    private String druguser;
    private String ctime;
    @TableField(exist=false)
    private Integer warrenty;
    @TableField(exist=false)
    private Date producttime;
    @TableField(exist = false)
    private String spname;//厂商名
}
