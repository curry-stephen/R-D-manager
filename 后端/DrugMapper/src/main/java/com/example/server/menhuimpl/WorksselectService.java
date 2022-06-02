package com.example.server.menhuimpl;

import com.example.entity.menhu.work.Worksselect;
import com.example.mapper.menhu.WorksselectDao;
import com.example.server.IMenhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksselectService implements IMenhuService<Worksselect> {
    @Autowired
    WorksselectDao worksselectDao;
    @CacheEvict(value = "Worksselect",key = "1")
    @Override
    public boolean Addinfo(Worksselect enty) {
        return worksselectDao.Addinfo(enty);
    }
    @Cacheable(value = "Worksselect",key = "1")
    @Override
    public List<Worksselect> QueryInfo() {
        return worksselectDao.QueryInfo(Worksselect.class);
    }
}
