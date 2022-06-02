package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "druginfo")
public class Druginfo implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String tupian;
    private String drugname;
    private String suppliername;
    private Date producttime;
    private Integer warrenty;
    private String number;
    private Double price;
    private Integer stock;
    //@TableField(exist=false)
    private boolean guo;
    private String guotime;
    @TableField(exist=false)
    private String username;//操作人
}
