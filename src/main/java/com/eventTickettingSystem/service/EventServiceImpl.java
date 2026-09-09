package com.eventTickettingSystem.service;

import com.eventTickettingSystem.data.models.Event;
import com.eventTickettingSystem.data.repository.EventRepository;
import com.eventTickettingSystem.data.repository.UserRepository;
import com.eventTickettingSystem.dto.authservicedto.request.CreateEventRequest;
import com.eventTickettingSystem.dto.authservicedto.reponse.CreateEventResponse;
import com.eventTickettingSystem.dto.authservicedto.request.UpdateEventRequest;
import com.eventTickettingSystem.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.eventTickettingSystem.util.Mapper.*;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public CreateEventResponse createEvent(CreateEventRequest request){
        Validator.validateEventRequest(request);
        Event event = mapToEvent(request);
        eventRepository.save(event);
        return mapEventResponse(event);
    }

    public CreateEventResponse updateEvent(String eventId, UpdateEventRequest request){
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Event does not exist"));
        updateEventMap(request, event);
        Event updatedEvent = eventRepository.save(event);
        return mapEventResponse(updatedEvent);
    }

    public Event findEvent(String eventId){
        return eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Event does not exist"));
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public void deleteEvent(String eventId){
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Event does not exist"));
        eventRepository.delete(event);
    }

    public List<Event> searchForEvents(String keyword){
        return eventRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrLocationContainingIgnoreCase(keyword, keyword, keyword);
    }

}