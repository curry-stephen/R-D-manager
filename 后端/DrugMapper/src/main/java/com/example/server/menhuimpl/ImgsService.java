package com.example.server.menhuimpl;

import com.example.entity.menhu.dongtaiimg.Imgs;
import com.example.mapper.menhu.ImgsDao;
import com.example.server.IMenhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgsService implements IMenhuService<Imgs> {
    @Autowired
    ImgsDao imgsDao;
    @CacheEvict(value = "Imgs",key = "1")
    @Override
    public boolean Addinfo(Imgs enty) {
        return imgsDao.Addinfo(enty);
    }
    @Cacheable(value = "Imgs",key = "1")
    @Override
    public List<Imgs> QueryInfo() {
        return imgsDao.QueryInfo(Imgs.class);
    }
}
