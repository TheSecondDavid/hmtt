package com.heima.article.controller;

import com.heima.article.pojo.LoginDto;
import com.heima.article.service.LoginService;
import com.heima.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("all")
@RestController
@RequestMapping("/api/v1/login")
@Api(value = "app端用户登录", tags = "ap_user", description = "app端用户登录API")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login_auth")
    public ResponseResult login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }

    @PostMapping("test")
    public void test(){
    }
}
