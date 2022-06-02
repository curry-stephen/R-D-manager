package com.example.mapper.menhu;

import com.example.entity.menhu.work.Worksselect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorksselectDao implements Menhu<Worksselect>{
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public boolean Addinfo(Worksselect enty) {
        Worksselect save = mongoTemplate.save(enty);
        return save!=null;
    }

    @Override
    public List<Worksselect> QueryInfo(Class<Worksselect> clazz) {
        return mongoTemplate.findAll(clazz);
    }
}
