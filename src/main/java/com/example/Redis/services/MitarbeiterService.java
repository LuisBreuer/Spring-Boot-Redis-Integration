package com.example.Redis.services;

import com.example.Redis.model.MitarbeiterEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class MitarbeiterService {

    @Autowired
    private RedisTemplate<String, MitarbeiterEntity> redisTemplate;

    public void save(String key, MitarbeiterEntity value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public MitarbeiterEntity get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
