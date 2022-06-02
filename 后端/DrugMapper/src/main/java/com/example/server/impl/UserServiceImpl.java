package com.example.server.impl;

import com.example.entity.Druginfo;
import com.example.entity.Owinfo;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.server.IUserService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl<T> implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User Login(String name, String password) {
        User login = userMapper.Login(name, password);
        if (login!=null){
            userMapper.UpdateLoginTime(name);
        }
        return login;
    }

    @Override
    public boolean Updatepwd(String name, String oldpwd, String newpwd) {
        UpdateResult updatepwd = userMapper.Updatepwd(name, oldpwd, newpwd);
        return updatepwd.getModifiedCount()>0;
    }

    @Override
    public boolean DeleteUser(String name) {
        DeleteResult deleteResult = userMapper.DeleteUser(name);
        return deleteResult.getDeletedCount()>0;
    }

    @Override
    public boolean AddUser(User user) {
        User addUser = userMapper.AddUser(user);
        return addUser.getName()!=null;
    }

    @Override
    public boolean AddDrugInfo(Druginfo druginfo, String name) {
        UpdateResult updateResult = userMapper.AddDrugInfo(druginfo, name);
        return updateResult.getModifiedCount()>0;
    }

    @Override
    public List<User> QueryPage() {
        List<User> users = userMapper.QueryPage();
        return users;
    }

    @Override
    public boolean UpDateUser(User user) {
        UpdateResult updateResult = userMapper.UpDateUser(user);
        return updateResult.getModifiedCount()>0;
    }

    @Override
    public User LoadUser(String name, String password) {
        User load = userMapper.Login(name, password);
        return load;
    }

    @Override
    public boolean updateLog(User user, String key, String username) {
        UpdateResult updateResult = userMapper.updateLog(user, key, username);
        return updateResult.getModifiedCount()>0;
    }
}
