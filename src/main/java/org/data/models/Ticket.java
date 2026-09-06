package org.data.models;

import lombok.Data;

@Data
public class Ticket {
    String id;
    String bookingId;
    String ticketType;
    String ticketCode;
}
