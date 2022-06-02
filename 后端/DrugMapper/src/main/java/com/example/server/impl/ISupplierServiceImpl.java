package com.example.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Owinfo;
import com.example.entity.Supplier;
import com.example.mapper.SupplierMapper;
import com.example.mapper.UserMapper;
import com.example.server.ISupplierSevice;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierSevice {
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public String[] QueryName() {
        String[] strings = supplierMapper.QueryAllName();
        return strings;
    }

    @Override
    public IPage<Supplier> SeletePage(Integer pagenum, Integer pagesize, LambdaQueryWrapper wrapper) {
        Page<Supplier> supplierPage = new Page<>(pagenum, pagesize);
        Page<Supplier> selectPage = supplierMapper.selectPage(supplierPage, wrapper);
        return selectPage;
    }

    @Override
    public Supplier QuerySp(String name) {
        Supplier supplier = supplierMapper.QuerySp(name);
        return supplier;
    }

    @Override
    public Supplier QueryOneById(Integer id) {
        return supplierMapper.QueryOneById(id);
    }

    @Override
    public boolean updateLog(Supplier supplier, String key, String username) {
        UpdateResult updateResult = userMapper.updateLog(supplier, key, username);
        return updateResult.getModifiedCount()>0;
    }
}
