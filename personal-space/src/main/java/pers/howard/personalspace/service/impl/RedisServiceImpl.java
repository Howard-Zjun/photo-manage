package pers.howard.personalspace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import pers.howard.personalspace.config.ToolKit;
import pers.howard.personalspace.service.RedisService;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    ToolKit toolKit;

    public String getTokenItem(String userId) {
        return stringRedisTemplate.opsForValue().get(userId);
    }

    public void setTokenItem(String userId, String token) {
        stringRedisTemplate.opsForValue().set(userId, token, toolKit.getTokenKeepTimeInSecond(), TimeUnit.HOURS);
    }
}
