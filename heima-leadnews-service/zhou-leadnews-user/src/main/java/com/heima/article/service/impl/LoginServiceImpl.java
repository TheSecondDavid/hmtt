package com.heima.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.heima.article.pojo.ApUser;
import com.heima.article.pojo.LoginDto;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.utils.common.AppJwtUtil;
import com.heima.article.mapper.LoginMapper;
import com.heima.article.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public ResponseResult login(LoginDto dto) {
        if(StringUtils.isBlank(dto.getPhone()) && StringUtils.isBlank(dto.getPassword())){
            String token = AppJwtUtil.getToken(0L);
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            return ResponseResult.okResult(token);
        }

        // 1. 密码错误
        LambdaQueryWrapper<ApUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ApUser::getPhone, dto.getPhone());
        ApUser apUser = loginMapper.selectOne(queryWrapper);
        String encode = DigestUtils.md5DigestAsHex((dto.getPassword() + apUser.getSalt()).getBytes());
        if(!encode.equals(apUser.getPassword()))
            return ResponseResult.errorResult(400, "密码错误");

        // 2. 成功
        String token = AppJwtUtil.getToken(Long.valueOf(apUser.getId()));
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        return ResponseResult.okResult(map);
    }
}
