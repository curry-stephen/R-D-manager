package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Matter;
import com.example.entity.Returngoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReturngoodsMapper extends BaseMapper<Returngoods> {
    @Select("select * from returngoods where id=#{id}")
    Returngoods QueryOneById(Integer id);
}
