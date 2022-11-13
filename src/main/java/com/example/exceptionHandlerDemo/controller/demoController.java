package com.example.exceptionHandlerDemo.controller;

import com.example.exceptionHandlerDemo.common.CommonResult;
import com.example.exceptionHandlerDemo.common.UserException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class demoController {

    @RequestMapping("/helloworld")
    public String getHello() {
        return "hello world!";
    }

    @PostMapping("/userLogin")
    public Object user(@RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return new CommonResult<>(200, "token-待后续添加功能", "登录成功");
        } else
            throw new UserException();
    }
}