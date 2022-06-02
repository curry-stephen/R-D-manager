package com.example.server.menhuimpl;

import com.example.entity.menhu.WebHome;
import com.example.mapper.menhu.WebHomeDao;
import com.example.server.IMenhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebHomeService implements IMenhuService<WebHome> {
    @Autowired
    WebHomeDao webHomeDao;
    @CacheEvict(value = "WebHome",key = "1")
    @Override
    public boolean Addinfo(WebHome enty) {
        return webHomeDao.Addinfo(enty);
    }
    @Cacheable(value = "WebHome",key = "1")
    @Override
    public List<WebHome> QueryInfo() {
        return webHomeDao.QueryInfo(WebHome.class);
    }
}
