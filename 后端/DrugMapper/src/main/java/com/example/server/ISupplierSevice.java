package com.example.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Owinfo;
import com.example.entity.Supplier;
import com.example.log.UserLog;
import com.example.mapper.SupplierMapper;

public interface ISupplierSevice extends IService<Supplier> , UserLog<Supplier> {
    String[] QueryName();
    IPage<Supplier> SeletePage(Integer pagenum, Integer pagesize, LambdaQueryWrapper wrapper);
    Supplier QuerySp(String name);
    Supplier QueryOneById(Integer id);
}
