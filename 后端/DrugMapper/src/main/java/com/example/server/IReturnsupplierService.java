package com.example.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Owinfo;
import com.example.entity.Returnsupplier;
import com.example.log.UserLog;

public interface IReturnsupplierService extends IService<Returnsupplier> , UserLog<Returnsupplier> {
    IPage<Returnsupplier> QueryPage(Integer pagenum, Integer pagesize, LambdaQueryWrapper wrapper);
    Returnsupplier QueryOneById(Integer id);
}
