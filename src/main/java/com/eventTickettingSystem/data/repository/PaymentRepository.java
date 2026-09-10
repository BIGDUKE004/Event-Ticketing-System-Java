package com.eventTickettingSystem.data.repository;

import com.eventTickettingSystem.data.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}