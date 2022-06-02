package com.example.mapper.menhu;

import com.example.entity.menhu.myfuwu.Icondata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IcondataDao implements Menhu<Icondata>{
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public boolean Addinfo(Icondata enty) {
        return mongoTemplate.save(enty)!=null;
    }

    @Override
    public List<Icondata> QueryInfo(Class<Icondata> clazz) {
        return mongoTemplate.findAll(clazz);
    }
}
