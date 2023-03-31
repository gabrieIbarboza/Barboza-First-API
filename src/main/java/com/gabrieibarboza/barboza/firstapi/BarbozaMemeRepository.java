package com.gabrieibarboza.barboza.firstapi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BarbozaMemeRepository extends MongoRepository<BarbozaMeme, String> {
    
}
