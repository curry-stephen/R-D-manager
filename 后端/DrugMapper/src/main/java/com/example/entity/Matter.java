package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "drugmatter")
public class Matter implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String img;
    private String drugname;
    private Integer matternum;
    private Double price;
    private String ctime;
    private String miaos;
    @TableField(exist=false)
    private String username;//操作人
}
