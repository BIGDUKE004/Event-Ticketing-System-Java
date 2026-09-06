package org.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Data
public class TicketType {

    @Id
    String id;

    String eventId;
    String name;
    BigDecimal price;
    int quantity;
    int availableQuantity;
    boolean soldOut;
}