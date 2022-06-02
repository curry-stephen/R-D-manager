package com.example.controller;

import com.example.entity.User;
import com.example.server.IUserService;
import com.example.utils.LogUtis;
import com.example.utils.ResultLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    IUserService userService;
    //获取bar数据
    @PostMapping("bar")
    public ResultLog QueryAllBar(@RequestBody User user){
        User loadUser = userService.LoadUser(user.getName(), user.getPassword());
        if (loadUser==null){
            return new ResultLog(false,null,null);
        }
        return LogUtis.HandleLog(loadUser);
    }
}
