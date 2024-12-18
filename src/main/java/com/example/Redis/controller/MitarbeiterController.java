package com.example.Redis.controller;

import com.example.Redis.model.MitarbeiterEntity;
import com.example.Redis.services.MitarbeiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MitarbeiterController {

    private final MitarbeiterService mitarbeiterService;

    @GetMapping("/createEmployee/{name}/{role}")
    public void createEmployee(@PathVariable String name, @PathVariable String role) {
        MitarbeiterEntity mitarbeiterEntity = new MitarbeiterEntity(UUID.randomUUID().toString(), name, role);
        mitarbeiterService.save(mitarbeiterEntity);
    }

    @GetMapping("/getEmployee/{id}")
    public MitarbeiterEntity getEmployee(@PathVariable String id) {
        return mitarbeiterService.get(id);
    }

    private String createHash(String name, String role) {
        return String.valueOf(Objects.hash(name, role));
    }
}
