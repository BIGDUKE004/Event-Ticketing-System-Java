package com.eventTickettingSystem.data.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Booking {
    String id;
    String userId;
    String eventId;
    String ticketType;
    LocalDateTime  bookingDate;
    int quantity;
    BigDecimal totalAmount;
    Status status;
}
