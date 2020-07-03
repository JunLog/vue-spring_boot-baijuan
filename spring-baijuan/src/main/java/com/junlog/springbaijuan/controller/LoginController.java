package com.junlog.springbaijuan.controller;

import com.junlog.springbaijuan.pojo.User;
import com.junlog.springbaijuan.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginController {
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result Login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if(!Objects.equals("admin",username) || !Objects.equals("123456",requestUser.getPassword())){
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        }else {
            return new Result(200);
        }
    }
}
