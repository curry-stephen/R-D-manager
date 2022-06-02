package com.example.server.menhuimpl;

import com.example.entity.menhu.nowdataitem.Carddata;
import com.example.mapper.menhu.CarddataDao;
import com.example.server.IMenhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarddataService implements IMenhuService<Carddata> {
    @Autowired
    CarddataDao carddataDao;
    @CacheEvict(value = "Carddata",key = "1")
    @Override
    public boolean Addinfo(Carddata enty) {
        return carddataDao.Addinfo(enty);
    }
    @Cacheable(value = "Carddata",key = "1")
    @Override
    public List<Carddata> QueryInfo() {
        return carddataDao.QueryInfo(Carddata.class);
    }
}
