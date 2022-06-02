package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Saleinfo;
import com.example.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SupplierMapper extends BaseMapper<Supplier> {
    @Select("select name from supplier")
    String[] QueryAllName();

    @Select("select * from supplier where name=#{name}")
    Supplier QuerySp(String name);

    @Select("select * from supplier where id=#{id}")
    Supplier QueryOneById(Integer id);
}
