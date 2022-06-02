package com.example.mapper;

import com.example.entity.Druginfo;
import com.example.entity.Owinfo;
import com.example.entity.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class UserMapper<T> {
    @Autowired
    MongoTemplate mongoTemplate;
    //登录
    public User Login(String name, String password){
        Query query = new Query(Criteria.where("name").is(name).and("password").is(password));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }
    //修改密码
    public UpdateResult Updatepwd(String name,String oldpwd,String newpwd){
        Query query = new Query(Criteria.where("name").is(name).and("password").is(oldpwd));
        Update update = new Update().set("password", newpwd);
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        return result;
    }
    //删除
    public DeleteResult DeleteUser(String name){
        Query query = new Query(Criteria.where("name").is(name));
        DeleteResult remove = mongoTemplate.remove(query, User.class);
        return remove;
    }
    //添加
    public User AddUser(User user){
        user.setRowle(1);
        user.setPassword("111");
        User save = mongoTemplate.save(user);
        return save;
    }
    //修改登录时间
    public void UpdateLoginTime(String name){
        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update().set("lasttime", new Date());
        mongoTemplate.updateFirst(query,update,User.class);
    }
    //添加druginfo
    public UpdateResult AddDrugInfo(Druginfo druginfo,String name){
        Query query = new Query(Criteria.where("name").is(name));
        Update caodruginfo = new Update().push("caodruginfo", druginfo);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, caodruginfo, User.class);
        return updateResult;
    }
    //查询
    public List<User> QueryPage() {
        List<User> userList = mongoTemplate.findAll(User.class);
        return userList;
    }
    //修改User信息
    public UpdateResult UpDateUser(User user){
        Query query = new Query(Criteria.where("name").is(user.getName()).and("password").is(user.getPassword()));
        Update update = new Update().set("position", user.getPosition()).set("age", user.getAge()).set("sex", user.getSex())
                .set("phone", user.getPhone()).set("address", user.getAddress()).set("headimg",user.getHeadimg())
                .set("num",user.getNum());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class);
        return updateResult;
    }
    //操作Owinfo
    public UpdateResult updateLog(T t,String key,String username){
        Query query = new Query(Criteria.where("name").is(username));
        Update update = new Update().addToSet(key, t);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class);
        return updateResult;
    }
}
