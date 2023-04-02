package com.gabrieibarboza.barboza.firstapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BarbozaMemeController {
    
    @Autowired
    private BarbozaMemeRepository repository;

    //
    //CRUD
    //

    //Create
    @PostMapping("/barboza-first-api")
    public ResponseEntity<BarbozaMeme> registerBarbozaMeme(@RequestBody BarbozaMeme barbozaMeme) {
        BarbozaMeme registeredBarbozaMeme = repository.save(barbozaMeme);
        return new ResponseEntity<>(registeredBarbozaMeme, HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/barboza-first-api")
    public List<BarbozaMeme> getAPIData() {
        List<BarbozaMeme> apiData = repository.findAll();
        return apiData;
    }

    //Read ID
    @GetMapping("/barboza-first-api/{id}")
    public BarbozaMeme getAPIDataByID(@PathVariable String id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //Update
    @PutMapping("/barboza-first-api/{id}")
    public BarbozaMeme updateBarbozaMeme(@PathVariable String id, @RequestBody BarbozaMeme barbozaMeme) {
        
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        barbozaMeme.setId(id);
        return repository.save(barbozaMeme);
    }

    //Delete
    @DeleteMapping("/barboza-first-api/{id}")
    public void deleteBarbozaMeme(@PathVariable String id)
    {
        if(!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            
        repository.deleteById(id);
    }
}
