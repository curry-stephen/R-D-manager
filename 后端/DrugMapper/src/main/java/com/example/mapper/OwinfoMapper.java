package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Owinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OwinfoMapper extends BaseMapper<Owinfo> {
    @Select("select drugname from drug Group by drugname")
    List<Owinfo> queryallname();
    @Select("select tupian from drug where drugname=#{drugname} limit 1")
    String Querytupian(String drugname);
    @Select("select * from drug where id=#{id}")
    Owinfo QueryOneById(Integer id);
}
