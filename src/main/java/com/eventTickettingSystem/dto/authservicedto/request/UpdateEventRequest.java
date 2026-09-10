package com.eventTickettingSystem.dto.authservicedto.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UpdateEventRequest {
    String name;
    String description;
    String location;
    LocalDateTime dateTime;
}
