package com.data.repository;

import com.data.models.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
    Booking findByUserId(String id);
}
