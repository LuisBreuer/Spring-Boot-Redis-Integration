package com.example.Redis.services;

import com.example.Redis.model.MitarbeiterEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MitarbeiterService {

    @Autowired
    private RedisTemplate<String, MitarbeiterEntity> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(MitarbeiterService.class);

    public void save(MitarbeiterEntity mitarbeiterEntity) {
        logger.info("Speichere Mitarbeiter mit ID: {}", mitarbeiterEntity.getId());
        redisTemplate.opsForHash().put("Mitarbeiter", mitarbeiterEntity.getId(), mitarbeiterEntity);
    }

    public MitarbeiterEntity get(String id) {
        return (MitarbeiterEntity) redisTemplate.opsForHash().get("Mitarbeiter", id);
    }
}
