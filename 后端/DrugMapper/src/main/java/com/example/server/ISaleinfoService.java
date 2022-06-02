package com.example.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Owinfo;
import com.example.entity.Saleinfo;
import com.example.entity.Supplier;
import com.example.log.UserLog;

public interface ISaleinfoService extends IService<Saleinfo> , UserLog<Saleinfo> {
    IPage<Supplier> QueryPage(int pagenum, int pagesize, LambdaQueryWrapper wrapper);
    Saleinfo QueryOneById(Integer id);
}
