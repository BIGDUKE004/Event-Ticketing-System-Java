package com.eventTickettingSystem.dto.authservicedto.reponse;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CreateEventResponse {
    String id;
    String name;
    String description;
    String location;
    String organizerId;
    LocalDateTime datetime;
    boolean soldOut;
}