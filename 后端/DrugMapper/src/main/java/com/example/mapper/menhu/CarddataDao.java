package com.example.mapper.menhu;

import com.example.entity.menhu.nowdataitem.Carddata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarddataDao implements Menhu<Carddata>{
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public boolean Addinfo(Carddata enty) {
        return mongoTemplate.save(enty)!=null;
    }

    @Override
    public List<Carddata> QueryInfo(Class<Carddata> clazz) {
        return mongoTemplate.findAll(clazz);
    }
}
