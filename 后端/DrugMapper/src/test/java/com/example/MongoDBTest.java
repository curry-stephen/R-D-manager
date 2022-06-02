package com.example;

import com.example.entity.Bill;
import com.example.entity.Druginfo;
import com.example.entity.LogName;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.utils.LogUtis;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
public class MongoDBTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    MongoTemplate mongoTemplate;
    @Test
    void AddTest(){
        User user = new User();
        user.setPassword("123");
        user.setName("l");
        user.setRowle(1);
        User user1 = userMapper.AddUser(user);
        System.out.println(user1);
    }
    @Test
    void Update(){
        UpdateResult ls = userMapper.Updatepwd("ls", "123", "321");
        System.out.println(ls.getMatchedCount());
        System.out.println(ls.getUpsertedId());
        System.out.println(ls.getModifiedCount());
    }
    @Test
    void Delete(){
        DeleteResult l = userMapper.DeleteUser("l");
        System.out.println(l.getDeletedCount());
    }
    @Test
    void PageTest(){
        List<User> ls = userMapper.QueryPage();
        System.out.println(ls);
    }
    @Test
    void UserTest(){
        User user = new User();
    }
    @Test
    void UserTestQuery(){
        List<User> all = mongoTemplate.findAll(User.class);
        all.forEach(System.out::println);
    }
    //加载数据
    @Test
    void LoadUser(){
        User user = userMapper.Login("杨跃", "123");
        int[] arr= {
                user.getAddbill()!=null?user.getAddbill().length:0,
                user.getAdddruginfo()!=null?user.getAdddruginfo().length:0,
                user.getAddmatter()!=null?user.getAddmatter().length:0,
                user.getAddowinfo()!=null?user.getAddowinfo().length:0,
                user.getAddreturngoods()!=null?user.getAddreturngoods().length:0,
                user.getAddreturnsupplier()!=null?user.getAddreturnsupplier().length:0,
                user.getAddsaleinfo()!=null?user.getAddsaleinfo().length:0,
                user.getAddsupplier()!=null?user.getAddsupplier().length:0,

                user.getDeletebill()!=null?user.getDeletebill().length:0,
                user.getDeletedrug()!=null?user.getDeletedrug().length:0,
                user.getDeletematter()!=null?user.getDeletematter().length:0,
                user.getDeleteowinfo()!=null?user.getDeleteowinfo().length:0,
                user.getDeletereturngoods()!=null?user.getDeletereturngoods().length:0,
                user.getDeletereturnsupplier()!=null?user.getDeletereturnsupplier().length:0,
                user.getDeletesaleinfo()!=null?user.getDeletesaleinfo().length:0,
                user.getDeletesupplier()!=null?user.getDeletesupplier().length:0,

                user.getUpdatebill()!=null?user.getUpdatebill().length:0,
                user.getUpdatedrug()!=null?user.getUpdatedrug().length:0,
                user.getUpdatematter()!=null?user.getUpdatematter().length:0,
                user.getUpdateowinfo()!=null?user.getUpdateowinfo().length:0,
                user.getUpdateretrungoods()!=null?user.getUpdateretrungoods().length:0,
                user.getUpdatereturnsupplier()!=null?user.getUpdatereturnsupplier().length:0,
                user.getUpdatesaleinfo()!=null?user.getUpdatesaleinfo().length:0,
                user.getUpdatesupplier()!=null?user.getUpdatesupplier().length:0
        };
        String[] keys={
                LogName.addbill,
                LogName.adddruginfo,
                LogName.addmatter,
                LogName.addowinfo,
                LogName.addreturngoods,
                LogName.addreturnsupplier,
                LogName.addsaleinfo,
                LogName.addsupplier,

                LogName.deletebill,
                LogName.deletedrug,
                LogName.deletematter,
                LogName.deleteowinfo,
                LogName.deletereturngoods,
                LogName.deletereturnsupplier,
                LogName.deletesaleinfo,
                LogName.deletesupplier,

                LogName.updatebill,
                LogName.updatedrug,
                LogName.updatematter,
                LogName.updateowinfo,
                LogName.updateretrungoods,
                LogName.updatereturnsupplier,
                LogName.updatesaleinfo,
                LogName.updatesupplier,
        };
        for (int i = 0; i < arr.length; i++) {
            System.out.println(keys[i]+" : "+arr[i]);
        }
    }
    @Test
    void LogDataTest(){
        User user = userMapper.Login("杨跃", "123");
        LogUtis.HandleLog(user);
    }
}
