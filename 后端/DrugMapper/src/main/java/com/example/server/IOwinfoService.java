package com.example.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Owinfo;
import com.example.log.UserLog;

import java.util.List;

public interface IOwinfoService extends IService<Owinfo>,UserLog<Owinfo> {
    IPage<Owinfo> newselectPage(int current, int size);
    Page<Owinfo> selectPage(Page page, LambdaQueryWrapper wrappers);
    List<Owinfo> queryallname();
    String QueryTupian(String drugname);
    Owinfo QueryOneById(Integer id);
}
