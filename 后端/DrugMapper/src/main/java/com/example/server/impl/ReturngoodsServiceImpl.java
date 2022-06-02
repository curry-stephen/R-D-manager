package com.example.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Owinfo;
import com.example.entity.Returngoods;
import com.example.mapper.ReturngoodsMapper;
import com.example.mapper.UserMapper;
import com.example.server.IReturngoodsService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturngoodsServiceImpl extends ServiceImpl<ReturngoodsMapper, Returngoods> implements IReturngoodsService {
    @Autowired
    ReturngoodsMapper returngoodsMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public IPage<Returngoods> QueryPage(int pagenum, int pagesize, LambdaQueryWrapper wrapper) {
        Page<Returngoods> returngoodsPage = new Page<>(pagenum,pagesize);
        Page page = returngoodsMapper.selectPage(returngoodsPage, wrapper);
        return page;
    }

    @Override
    public Returngoods QueryOneById(Integer id) {
        Returngoods returngoods = returngoodsMapper.QueryOneById(id);
        return returngoods;
    }

    @Override
    public boolean updateLog(Returngoods returngoods, String key, String username) {
        UpdateResult updateResult = userMapper.updateLog(returngoods, key, username);
        return updateResult.getModifiedCount()>0;
    }
}
