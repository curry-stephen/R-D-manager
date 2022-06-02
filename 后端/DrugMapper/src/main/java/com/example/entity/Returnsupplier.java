package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "returnsupplier")
public class Returnsupplier implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer count;
    private String tupian;
    private String drugname;
    private String reason;
    private Date createtime;
    private String pay;
    @TableField(exist=false)
    private String username;//操作人
}
