package com.eventTickettingSystem.dto.authservicedto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateEventRequest {
    String name;
    String description;
    String location;
    String organizerId;
    LocalDateTime dateTime;
}