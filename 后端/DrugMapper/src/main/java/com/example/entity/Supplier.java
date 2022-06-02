package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.yaml.snakeyaml.events.Event;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "supplier")
public class Supplier implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String content;
    @DateTimeFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒")
    private Date createtime;
    @TableField(exist=false)
    private String username;//操作人
}
