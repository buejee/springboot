package com.xxx.springboot.controller;

import com.xxx.springboot.entity.User;
import com.xxx.springboot.http.ResponseData;
import com.xxx.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseData login(String username,String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            subject.getSession().setAttribute("user",username);
        }catch(Exception e){
            return ResponseData.create("login fail","fail");
        }
        return ResponseData.create("ok");
    }

    @GetMapping("/user-info")
    public User userInfo(){
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getSession().getAttribute("user");
        User user = userService.findByUsername(username);
        return user;
    }

}
