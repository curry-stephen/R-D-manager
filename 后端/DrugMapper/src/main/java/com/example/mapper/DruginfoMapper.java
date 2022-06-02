package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Druginfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DruginfoMapper extends BaseMapper<Druginfo> {
    @Select("select id,producttime,warrenty from druginfo")
    List<Druginfo> QueryDate();

    @Select("select drugname from druginfo Group by drugname")
    String[] QueryDrugName();

    @Select("select tupian from druginfo where drugname=#{drugname}")
    String QueryTupian(String drugname);

    @Select("select price from druginfo where drugname=#{drugname}")
    Double QueryPrice(String drugname);

    @Select("select number from druginfo where drugname=#{drugname}")
    String QueryNumber(String drugname);

    @Select("select * from druginfo where drugname=#{drugname}")
    Druginfo QueryDrug(String drugname);

    @Select("select * from druginfo where id=#{id}")
    Druginfo QueryOneById(Integer id);
}
