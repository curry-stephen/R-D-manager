package com.example.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Owinfo;
import com.example.entity.Returnsupplier;
import com.example.mapper.ReturnsupplierMapper;
import com.example.mapper.UserMapper;
import com.example.server.IReturnsupplierService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnsupplierServiceImpl extends ServiceImpl<ReturnsupplierMapper, Returnsupplier> implements IReturnsupplierService {
    @Autowired
    ReturnsupplierMapper returnsupplierMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public IPage<Returnsupplier> QueryPage(Integer pagenum, Integer pagesize, LambdaQueryWrapper wrapper) {
        Page<Returnsupplier> page = new Page<>(pagenum,pagesize);
        Page selectPage = returnsupplierMapper.selectPage(page, wrapper);
        return selectPage;
    }

    @Override
    public Returnsupplier QueryOneById(Integer id) {
        Returnsupplier returnsupplier = returnsupplierMapper.QueryOneById(id);
        return returnsupplier;
    }

    @Override
    public boolean updateLog(Returnsupplier returnsupplier, String key, String username) {
        UpdateResult updateResult = userMapper.updateLog(returnsupplier, key, username);
        return updateResult.getModifiedCount()>0;
    }
}
