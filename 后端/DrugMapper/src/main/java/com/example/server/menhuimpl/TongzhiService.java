package com.example.server.menhuimpl;

import com.example.entity.menhu.Tongzhi;
import com.example.mapper.menhu.TongzhiDao;
import com.example.server.IMenhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TongzhiService implements IMenhuService<Tongzhi> {
    @Autowired
    TongzhiDao tongzhiDao;
    @CacheEvict(value = "Tongzhi",key = "1")
    @Override
    public boolean Addinfo(Tongzhi enty) {
        return tongzhiDao.Addinfo(enty);
    }
    @Cacheable(value = "Tongzhi",key = "1")
    @Override
    public List<Tongzhi> QueryInfo() {
        return tongzhiDao.QueryInfo(Tongzhi.class);
    }
}
