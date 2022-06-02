package com.example.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Owinfo;
import com.example.entity.Returngoods;
import com.example.log.UserLog;
import com.example.mapper.ReturngoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface IReturngoodsService extends IService<Returngoods> , UserLog<Returngoods> {
    IPage<Returngoods> QueryPage(int pagenum, int pagesize, LambdaQueryWrapper wrapper);
    Returngoods QueryOneById(Integer id);
}
