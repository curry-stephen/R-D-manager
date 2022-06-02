package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Bill;
import com.example.entity.Matter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatterMapper extends BaseMapper<Matter> {
    @Select("select * from drugmatter where id=#{id}")
    Matter QueryOneById(Integer id);
}
