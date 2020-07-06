package com.junlog.springbaijuan.controller;

import com.junlog.springbaijuan.pojo.User;
import com.junlog.springbaijuan.result.Result;
import com.junlog.springbaijuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result Login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
//        if(!Objects.equals("admin",username) || !Objects.equals("123456",requestUser.getPassword())){
//            String message = "账号密码错误";
//            System.out.println("test");
//            return new Result(400);
//        }else {
//            return new Result(200);
        if(null == user){
            return new Result(400);
        }else {
            return new Result(200);
        }
    }
}
