package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Returnsupplier;
import com.example.entity.Saleinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SaleinfoMapper extends BaseMapper<Saleinfo> {
    @Select("select * from saleinfo where id=#{id}")
    Saleinfo QueryOneById(Integer id);
}
