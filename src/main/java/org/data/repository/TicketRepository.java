package org.data.repository;

import org.data.models.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TicketRepository extends MongoRepository<Ticket, String> {

    List<Ticket> findByBookingId(String bookingId);

    List<Ticket> findByTicketType(String ticketType);
}