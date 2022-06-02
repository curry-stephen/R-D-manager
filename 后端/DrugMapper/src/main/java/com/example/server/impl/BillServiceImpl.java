package com.example.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Bill;
import com.example.entity.Owinfo;
import com.example.mapper.BillMapper;
import com.example.mapper.UserMapper;
import com.example.server.IBillService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements IBillService {
    @Autowired
    BillMapper billMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public IPage<Bill> QueryPage(Integer pagenum, Integer pagesize, LambdaQueryWrapper wrapper) {
        Page<Bill> page = new Page<>(pagenum, pagesize);
        Page selectPage = billMapper.selectPage(page, wrapper);
        return selectPage;
    }

    @Override
    public Bill QueryOneById(Integer id) {
        Bill bill = billMapper.QueryOneById(id);
        return bill;
    }

    @Override
    public boolean updateLog(Bill bill, String key, String username) {
        UpdateResult updateResult = userMapper.updateLog(bill, key, username);
        return updateResult.getModifiedCount()>0;
    }
}
