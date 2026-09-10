package com.eventTickettingSystem.data.repository;

import com.eventTickettingSystem.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByEmail(String email);
}
