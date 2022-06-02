package com.example.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Bill;
import com.example.entity.Owinfo;
import com.example.log.UserLog;

public interface IBillService extends IService<Bill>, UserLog<Bill> {
    IPage<Bill> QueryPage(Integer pagenum, Integer pagesize, LambdaQueryWrapper wrapper);
    Bill QueryOneById(Integer id);
}
