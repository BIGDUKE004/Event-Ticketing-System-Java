package org.dto.ticketTypeServiceDto.Request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTicketTypeRequest {
    String eventId;
    String name;
    BigDecimal price;
    int quantity;
}