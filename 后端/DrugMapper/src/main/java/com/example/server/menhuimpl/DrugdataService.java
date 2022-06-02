package com.example.server.menhuimpl;

import com.example.entity.menhu.Drugdata;
import com.example.mapper.menhu.DrugdataDao;
import com.example.server.IMenhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugdataService implements IMenhuService<Drugdata> {
    @Autowired
    DrugdataDao drugdataDao;
    @CacheEvict(value = "Drugdata",key = "1")
    @Override
    public boolean Addinfo(Drugdata enty) {
        return drugdataDao.Addinfo(enty);
    }
    @Cacheable(value = "Drugdata",key = "1")
    @Override
    public List<Drugdata> QueryInfo() {
        return drugdataDao.QueryInfo(Drugdata.class);
    }
}
