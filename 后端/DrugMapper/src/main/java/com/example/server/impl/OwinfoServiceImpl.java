package com.example.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Owinfo;
import com.example.log.UserLog;
import com.example.mapper.OwinfoMapper;
import com.example.mapper.UserMapper;
import com.example.server.IOwinfoService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwinfoServiceImpl extends ServiceImpl<OwinfoMapper, Owinfo> implements IOwinfoService{
    @Autowired
    OwinfoMapper owinfoMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public IPage<Owinfo> newselectPage(int current, int size) {
        Page<Owinfo> page = new Page<Owinfo>(current, size);
        return owinfoMapper.selectPage(page,null);
    }

    @Override
    public Page<Owinfo> selectPage(Page page, LambdaQueryWrapper wrappers) {
        Page selectPage = owinfoMapper.selectPage(page, wrappers);
        return selectPage;
    }

    @Override
    public List<Owinfo> queryallname() {
        List<Owinfo> queryallname = owinfoMapper.queryallname();
        return queryallname;
    }

    @Override
    public String QueryTupian(String drugname) {
        String querytupian = owinfoMapper.Querytupian(drugname);
        return querytupian;
    }

    @Override
    public Owinfo QueryOneById(Integer id) {
        Owinfo owinfo = owinfoMapper.QueryOneById(id);
        return owinfo;
    }


    @Override
    public boolean updateLog(Owinfo owinfo, String key, String username) {
        UpdateResult updateResult = userMapper.<Owinfo>updateLog(owinfo, key, username);
        return updateResult.getModifiedCount()>0;
    }
}
