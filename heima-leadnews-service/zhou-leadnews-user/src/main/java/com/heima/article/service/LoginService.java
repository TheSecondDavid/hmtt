package com.heima.article.service;

import com.heima.article.pojo.LoginDto;
import com.heima.model.common.dtos.ResponseResult;

public interface LoginService {
    public ResponseResult login(LoginDto dto);
}
