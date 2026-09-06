package org.data.repository;

import org.data.models.TicketType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TicketTypeRepository extends MongoRepository<TicketType, String> {

    List<TicketType> findByEventId(String eventId);
}