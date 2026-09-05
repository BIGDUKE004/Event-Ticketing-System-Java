package org.data.models;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Event {
    String id;
    String name;
    String description;
    String location;
    LocalDate date;
    String organizerId;
    LocalDateTime time;
    boolean soldOut;
}
