package com.data.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TicketType {
    String id;
    String eventId;
    String name;
    BigDecimal price;
    int quantity;
    int availableQuantity;
}
