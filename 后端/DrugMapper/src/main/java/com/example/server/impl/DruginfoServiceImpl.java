package com.example.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Druginfo;
import com.example.entity.Owinfo;
import com.example.mapper.DruginfoMapper;
import com.example.mapper.UserMapper;
import com.example.server.IDruginfoService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DruginfoServiceImpl extends ServiceImpl<DruginfoMapper, Druginfo> implements IDruginfoService {
    @Autowired
    private DruginfoMapper druginfoMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public IPage<Druginfo> SelectPage(Integer pagenum, Integer pagesize, LambdaQueryWrapper wrapper) {
        Page<Druginfo> page = new Page<>(pagenum, pagesize);
        Page selectPage = druginfoMapper.selectPage(page, wrapper);
        return selectPage;
    }

    @Override
    public List<Druginfo> QueryDate() {
        List<Druginfo> druginfo = druginfoMapper.QueryDate();
        return druginfo;
    }

    @Override
    public String[] QueryDrugName() {
        String[] strings = druginfoMapper.QueryDrugName();
        return strings;
    }

    @Override
    public String QueryTupian(String drugname) {
        String tupian = druginfoMapper.QueryTupian(drugname);
        return tupian;
    }

    @Override
    public Double QueryPrice(String drugname) {
        Double aDouble = druginfoMapper.QueryPrice(drugname);
        return aDouble;
    }

    @Override
    public String QueryNumber(String drugname) {
        String number = druginfoMapper.QueryNumber(drugname);
        return number;
    }

    @Override
    public Druginfo QueryDrug(String drugname) {
        Druginfo drug = druginfoMapper.QueryDrug(drugname);
        return drug;
    }

    @Override
    public Druginfo QueryOneById(Integer id) {
        Druginfo druginfo = druginfoMapper.QueryOneById(id);
        return druginfo;
    }

    @Override
    public boolean updateLog(Druginfo druginfo, String key, String username) {
        UpdateResult updateResult = userMapper.updateLog(druginfo, key, username);
        return updateResult.getModifiedCount()>0;
    }
}
