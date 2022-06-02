package com.example.server.menhuimpl;

import com.example.entity.menhu.work.Works;
import com.example.mapper.menhu.WorksDao;
import com.example.server.IMenhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksService implements IMenhuService<Works> {
    @Autowired
    WorksDao worksDao;
    @CacheEvict(value = "Works",key = "1")
    @Override
    public boolean Addinfo(Works enty) {
        return worksDao.Addinfo(enty);
    }
    @Cacheable(value = "Works",key = "1")
    @Override
    public List<Works> QueryInfo() {
        return worksDao.QueryInfo(Works.class);
    }
}
