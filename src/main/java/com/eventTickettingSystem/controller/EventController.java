package com.eventTickettingSystem.controller;

import com.eventTickettingSystem.data.models.Event;
import com.eventTickettingSystem.dto.authservicedto.reponse.CreateEventResponse;
import com.eventTickettingSystem.dto.authservicedto.request.UpdateEventRequest;
import com.eventTickettingSystem.service.EventService;
import com.eventTickettingSystem.dto.authservicedto.request.CreateEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/createEvent")
    public CreateEventResponse createEvent(@RequestBody CreateEventRequest request){
        return eventService.createEvent(request);
    }

    @PatchMapping("/updateEvent/{eventId}")
    public CreateEventResponse updateEvent(@PathVariable("eventId") String eventId, @RequestBody UpdateEventRequest request){
        return eventService.updateEvent(eventId, request);
    }

    @GetMapping("/findEvent/{eventId}")
    public Event findEvent(@PathVariable("eventId") String eventId){
        return eventService.findEvent(eventId);
    }

    @GetMapping("/getAllEvents")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @DeleteMapping("/deleteEvent/{eventId}")
    public String deleteEvent(@PathVariable("eventId") String eventId){
        try {
            eventService.deleteEvent(eventId);
            return "deleted successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/searchForEvents")
    public List<Event> search(@RequestParam("keyword") String keyword){
        return eventService.searchForEvents(keyword);
    }
}
