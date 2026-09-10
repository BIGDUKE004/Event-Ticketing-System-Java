package com.data.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookingItem {
    String ticketTypeId;
    int quantity;
    int totalAmount;
}
