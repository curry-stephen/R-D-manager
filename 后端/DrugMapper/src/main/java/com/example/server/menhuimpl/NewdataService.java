package com.example.server.menhuimpl;

import com.example.entity.menhu.nowdataitem.Newdata;
import com.example.mapper.menhu.NewdataDao;
import com.example.server.IMenhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewdataService implements IMenhuService<Newdata> {
    @Autowired
    NewdataDao newdataDao;
    @CacheEvict(value = "Newdata",key = "1")
    @Override
    public boolean Addinfo(Newdata enty) {
        return newdataDao.Addinfo(enty);
    }
    @Cacheable(value = "Newdata",key = "1")
    @Override
    public List<Newdata> QueryInfo() {
        return newdataDao.QueryInfo(Newdata.class);
    }
}
