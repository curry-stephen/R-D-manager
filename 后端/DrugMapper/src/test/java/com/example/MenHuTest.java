package com.example;

import com.example.entity.menhu.dongtaiimg.Imgs;
import com.example.mapper.menhu.ImgsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MenHuTest {
    @Autowired
    ImgsDao imgsDao;
    @Test
    void addTest(){
        Imgs imgs=new Imgs("http://","杨跃");
        boolean addinfo = imgsDao.Addinfo(imgs);
        System.out.println(addinfo);
    }
    @Test
    void query(){
        List<Imgs> imgs = imgsDao.QueryInfo(Imgs.class);
        imgs.forEach(System.out::println);
    }
}
