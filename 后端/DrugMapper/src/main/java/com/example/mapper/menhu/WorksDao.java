package com.example.mapper.menhu;

import com.example.entity.menhu.work.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorksDao implements Menhu<Works>{
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public boolean Addinfo(Works enty) {
        Works save = mongoTemplate.save(enty);
        return save!=null;
    }

    @Override
    public List<Works> QueryInfo(Class<Works> clazz) {
        List<Works> all = mongoTemplate.findAll(clazz);
        return all;
    }
}
