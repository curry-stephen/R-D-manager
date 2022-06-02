package com.example.controller;

import com.example.entity.User;
import com.example.server.IUserService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping("login")
    public Result Login(@RequestBody User user){
        User login = userService.Login(user.getName(), user.getPassword());
        return new Result(login!=null,login!=null?"登录成功":"账号或者密码错误",login);
    }
    @PostMapping
    public Result AddUser(@RequestBody User user){
        boolean addUser = userService.AddUser(user);
        return new Result(addUser,addUser?"添加成功":"添加失败",null);
    }
    @DeleteMapping("{name}")
    public Result DeleteUser(@PathVariable String name){
        boolean user = userService.DeleteUser(name);
        return new Result(user,user?"删除成功":"删除失败",null);
    }
    //修改密码
    @PutMapping
    public Result UpdateUser(@RequestBody User user){
        boolean updatepwd = userService.Updatepwd(user.getName(), user.getPassword(), user.getNewPwd());
        return new Result(updatepwd,updatepwd?"修改成功":"修改失败",null);
    }
    //修改User信息
    @PutMapping("up")
    public Result UpdateUserinfo(@RequestBody User user){
        boolean update = userService.UpDateUser(user);
        return new Result(update,update?"修改成功":"修改失败",null);
    }
    //分页
    @GetMapping()
    public Result SelectPage(){
        List<User> users = userService.QueryPage();
        return new Result(!users.isEmpty(),!users.isEmpty()?"查询成功":"查询失败",users);
    }
    //加载当前用户信息
    @PostMapping("/load")
    public Result GetUser(@RequestBody User user){
        User loadUser = userService.LoadUser(user.getName(), user.getPassword());
        return new Result(loadUser!=null,loadUser!=null?"加载成功":"加载失败",loadUser);
    }
}
