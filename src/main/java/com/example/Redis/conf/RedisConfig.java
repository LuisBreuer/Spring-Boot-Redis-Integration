package com.example.Redis.conf;

import com.example.Redis.model.MitarbeiterEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, MitarbeiterEntity> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, MitarbeiterEntity> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // Setze den Jackson Serializer
        RedisSerializer<Object> serializer = new GenericJackson2JsonRedisSerializer();
        template.setValueSerializer(serializer);
        template.setHashValueSerializer(serializer);

        return template;
    }
}
