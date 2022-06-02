package com.example.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Matter;
import com.example.entity.Owinfo;
import com.example.log.UserLog;

public interface IMatterService extends IService<Matter> , UserLog<Matter> {
    IPage<Matter> selectPage(Page page, LambdaQueryWrapper lambdaQueryWrapper);
    Matter QueryOneById(Integer id);
}
