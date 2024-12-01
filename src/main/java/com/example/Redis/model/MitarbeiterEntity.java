package com.example.Redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@RedisHash(value = "Mitarbeiter", timeToLive = 3600)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MitarbeiterEntity {

    @Indexed
    private String id;
    private String name;
    private String role;
}