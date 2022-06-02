package com.example.mapper.menhu;

import com.example.entity.menhu.WebHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WebHomeDao implements Menhu<WebHome>{
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public boolean Addinfo(WebHome enty) {
        return mongoTemplate.save(enty)!=null;
    }

    @Override
    public List<WebHome> QueryInfo(Class<WebHome> clazz) {
        return mongoTemplate.findAll(clazz);
    }
}
