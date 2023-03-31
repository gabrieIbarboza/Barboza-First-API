package com.gabrieibarboza.barboza.firstapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BarbozaMemeController {
    
    @Autowired
    private BarbozaMemeRepository repository;

    @GetMapping("/barboza-first-api")
    public List<BarbozaMeme> getAPIData() {
        List<BarbozaMeme> apiData = repository.findAll();
        return apiData;
    }

    @PostMapping("/barboza-first-api")
    public ResponseEntity<BarbozaMeme> registerBarbozaMeme(@RequestBody BarbozaMeme barbozaMeme) {
        BarbozaMeme registeredBarbozaMeme = repository.save(barbozaMeme);
        return new ResponseEntity<>(registeredBarbozaMeme, HttpStatus.CREATED);
    }

}
