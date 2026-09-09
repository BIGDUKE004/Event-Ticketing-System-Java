package com.eventTickettingSystem.data.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Payment {
    String id;
    String bookingId;
    BigDecimal amount;
    Status status;
    LocalDateTime paymentDate;
}
