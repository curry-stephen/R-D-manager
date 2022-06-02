package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Returngoods;
import com.example.entity.Returnsupplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReturnsupplierMapper extends BaseMapper<Returnsupplier> {
    @Select("select * from returnsupplier where id=#{id}")
    Returnsupplier QueryOneById(Integer id);
}
