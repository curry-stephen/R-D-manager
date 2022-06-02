package com.example.server;

import com.example.entity.Druginfo;
import com.example.entity.Owinfo;
import com.example.entity.User;
import com.example.log.UserLog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService extends UserLog<User>{
    //登录
    User Login(String name, String password);
    //修改密码
    boolean Updatepwd(String name,String oldpwd,String newpwd);
    //删除
    boolean DeleteUser(String name);
    //添加
    boolean AddUser(User user);
    //添加druginfo
    boolean AddDrugInfo(Druginfo druginfo, String name);

    List<User> QueryPage();
    boolean UpDateUser(User user);
    //加载当前用户信息
    User LoadUser(String name, String password);

}
