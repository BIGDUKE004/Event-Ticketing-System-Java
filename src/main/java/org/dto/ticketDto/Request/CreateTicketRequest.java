package org.dto.ticketDto.Request;

import lombok.Data;

@Data
public class CreateTicketRequest {

    String bookingId;
    String ticketTypeId;
    String ticketCode;
}