package com.eventTickettingSystem.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Event {
    @Id
    String id;
    String name;
    String description;
    String location;
    String organizerId;
    LocalDateTime datetime;
    boolean soldOut;
}
