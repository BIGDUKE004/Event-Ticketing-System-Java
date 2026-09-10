package com.eventTickettingSystem.data.models;

import lombok.Data;

@Data
public class TIcket {
    String id;
    String bookingId;
    String ticketType;
    String ticketCode;
}
