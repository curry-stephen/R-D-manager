package com.example.mapper.menhu;

import com.example.entity.menhu.Drugdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DrugdataDao implements Menhu<Drugdata>{
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public boolean Addinfo(Drugdata enty) {
        return mongoTemplate.save(enty)!=null;
    }

    @Override
    public List<Drugdata> QueryInfo(Class<Drugdata> clazz) {
        return mongoTemplate.findAll(clazz);
    }
}
