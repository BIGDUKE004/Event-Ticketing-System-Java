package com.eventTickettingSystem.service;

import com.eventTickettingSystem.data.models.Event;
import com.eventTickettingSystem.dto.authservicedto.request.CreateEventRequest;
import com.eventTickettingSystem.dto.authservicedto.reponse.CreateEventResponse;
import com.eventTickettingSystem.dto.authservicedto.request.UpdateEventRequest;

import java.util.List;

public interface EventService {
    CreateEventResponse createEvent(CreateEventRequest request);
    CreateEventResponse updateEvent(String eventId, UpdateEventRequest request);
    Event findEvent(String eventId);
    List<Event> getAllEvents();
    void deleteEvent(String eventId);
    List<Event> searchForEvents(String keyword);
}