package com.example.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Druginfo;
import com.example.entity.Owinfo;
import com.example.log.UserLog;

import java.util.List;

public interface IDruginfoService extends IService<Druginfo>, UserLog<Druginfo> {
    IPage<Druginfo> SelectPage(Integer pagenum, Integer pagesize, LambdaQueryWrapper wrapper);
    List<Druginfo> QueryDate();
    String[] QueryDrugName();
    String QueryTupian(String drugname);
    Double QueryPrice(String drugname);
    String QueryNumber(String drugname);
    Druginfo QueryDrug(String drugname);
    Druginfo QueryOneById(Integer id);
}
