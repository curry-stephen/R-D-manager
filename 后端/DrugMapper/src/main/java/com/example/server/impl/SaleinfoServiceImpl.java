package com.example.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Owinfo;
import com.example.entity.Saleinfo;
import com.example.entity.Supplier;
import com.example.mapper.SaleinfoMapper;
import com.example.mapper.UserMapper;
import com.example.server.ISaleinfoService;
import com.mongodb.client.result.UpdateResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleinfoServiceImpl extends ServiceImpl<SaleinfoMapper, Saleinfo> implements ISaleinfoService {
    @Autowired
    SaleinfoMapper saleinfoMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public IPage<Supplier> QueryPage(int pagenum, int pagesize, LambdaQueryWrapper wrapper) {
        Page<Saleinfo> page = new Page<>(pagenum, pagesize);
        IPage iPage = saleinfoMapper.selectPage(page, wrapper);
        return iPage;
    }

    @Override
    public Saleinfo QueryOneById(Integer id) {
        return saleinfoMapper.QueryOneById(id);
    }

    @Override
    public boolean updateLog(Saleinfo saleinfo, String key, String username) {
        UpdateResult updateResult = userMapper.updateLog(saleinfo, key, username);
        return updateResult.getModifiedCount()>0;
    }
}
