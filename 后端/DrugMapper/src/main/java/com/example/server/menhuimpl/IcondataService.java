package com.example.server.menhuimpl;

import com.example.entity.menhu.myfuwu.Icondata;
import com.example.mapper.menhu.IcondataDao;
import com.example.server.IMenhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IcondataService implements IMenhuService<Icondata> {
    @Autowired
    IcondataDao icondataDao;
    @CacheEvict(value = "Icondata",key = "1")
    @Override
    public boolean Addinfo(Icondata enty) {
        return icondataDao.Addinfo(enty);
    }
    @Cacheable(value = "Icondata",key = "1")
    @Override
    public List<Icondata> QueryInfo() {
        return icondataDao.QueryInfo(Icondata.class);
    }
}
