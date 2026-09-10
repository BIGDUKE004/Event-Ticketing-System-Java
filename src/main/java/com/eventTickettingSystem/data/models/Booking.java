package com.eventTickettingSystem.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Document
@Data
public class Booking {
    @Id
    String id;
    String userId;
    String eventId;
    ArrayList<BookingItem> bookings;
    LocalDateTime  bookingDate;
    int quantity;
    BigDecimal totalAmount;
    Status status = Status.PENDING;
}
