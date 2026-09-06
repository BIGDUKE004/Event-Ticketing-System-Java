package org.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Ticket {

    @Id
    String id;

    String bookingId;
    String ticketTypeId;
    String ticketCode;
    LocalDateTime createdAt;
}