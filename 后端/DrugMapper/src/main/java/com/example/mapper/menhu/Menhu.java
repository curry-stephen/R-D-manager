package com.example.mapper.menhu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public interface Menhu<T> {
    boolean Addinfo(T enty);
    List<T> QueryInfo(Class<T> clazz);
}
