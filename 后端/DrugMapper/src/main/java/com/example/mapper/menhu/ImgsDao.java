package com.example.mapper.menhu;

import com.example.entity.menhu.dongtaiimg.Imgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ImgsDao implements Menhu<Imgs> {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public boolean Addinfo(Imgs enty) {
        Imgs save = mongoTemplate.save(enty);
        return save!=null;
    }

    @Override
    public List<Imgs> QueryInfo(Class<Imgs> clazz) {
        List<Imgs> all = mongoTemplate.findAll(clazz);
        return all;
    }
}
