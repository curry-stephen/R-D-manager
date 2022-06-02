package com.example.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Matter;
import com.example.entity.Owinfo;
import com.example.mapper.MatterMapper;
import com.example.mapper.UserMapper;
import com.example.server.IMatterService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IMatterServiceImpl extends ServiceImpl<MatterMapper, Matter> implements IMatterService {
    @Autowired
    private MatterMapper matterMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public IPage<Matter> selectPage(Page page, LambdaQueryWrapper lambdaQueryWrapper) {
        return matterMapper.selectPage(page,lambdaQueryWrapper);
    }

    @Override
    public Matter QueryOneById(Integer id) {
        Matter matter = matterMapper.QueryOneById(id);
        return matter;
    }

    @Override
    public boolean updateLog(Matter matter, String key, String username) {
        UpdateResult updateResult = userMapper.updateLog(matter, key, username);
        return updateResult.getModifiedCount()>0;
    }
}
