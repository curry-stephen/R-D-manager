package com.example.mapper.menhu;

import com.example.entity.menhu.Tongzhi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TongzhiDao implements Menhu<Tongzhi>{
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public boolean Addinfo(Tongzhi enty) {
        return mongoTemplate.save(enty)!=null;
    }

    @Override
    public List<Tongzhi> QueryInfo(Class<Tongzhi> clazz) {
        return mongoTemplate.findAll(clazz);
    }
}
