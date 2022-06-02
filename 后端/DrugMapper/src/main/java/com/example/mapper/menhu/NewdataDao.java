package com.example.mapper.menhu;

import com.example.entity.menhu.nowdataitem.Newdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewdataDao implements Menhu<Newdata>{
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public boolean Addinfo(Newdata enty) {
        return mongoTemplate.save(enty)!=null;
    }

    @Override
    public List<Newdata> QueryInfo(Class<Newdata> clazz) {
        return mongoTemplate.findAll(clazz);
    }
}
