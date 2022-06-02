package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BillMapper extends BaseMapper<Bill> {
    @Select("select * from bill where id=#{id}")
    Bill QueryOneById(Integer id);
}
