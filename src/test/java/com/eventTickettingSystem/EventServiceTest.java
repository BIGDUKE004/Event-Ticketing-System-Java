package com.eventTickettingSystem;

import com.eventTickettingSystem.data.models.Event;
import com.eventTickettingSystem.data.repository.EventRepository;
import com.eventTickettingSystem.dto.authservicedto.request.CreateEventRequest;
import com.eventTickettingSystem.dto.authservicedto.reponse.CreateEventResponse;
import com.eventTickettingSystem.dto.authservicedto.request.UpdateEventRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.eventTickettingSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class EventServiceTest {
    @Autowired
    private EventRepository events;

    @Autowired
    private EventService eventService;

    @BeforeEach
    public void setUp() {
        events.deleteAll();
    }

    @Test
    public void CreateEventWithValidRequestTest() {
        CreateEventRequest request = new CreateEventRequest();
        request.setName("Tech conference");
        request.setDescription("network and job");
        request.setLocation("Yaba, Lagos");
        request.setDateTime(LocalDateTime.of(2026, 10, 9, 10, 0));
        request.setOrganizerId("1234");

        CreateEventResponse event = eventService.createEvent(request);
        assertEquals(1, events.count());
        assertEquals("Tech conference", event.getName());
    }

    @Test
    public void CreateEventEmptyName_throwExceptionTest() {
        CreateEventRequest request = new CreateEventRequest();
        request.setName("");
        request.setDescription("network and job");
        request.setLocation("Yaba, Lagos");
        request.setDateTime(LocalDateTime.of(2026, 10, 9, 10, 0));
        request.setOrganizerId("1234");

        assertThrows(IllegalArgumentException.class, () -> eventService.createEvent(request));

    }

    @Test
    public void CreateEventBlankName_throwExceptionTest() {
        CreateEventRequest request = new CreateEventRequest();
        request.setName(" ");
        request.setDescription("network and job");
        request.setLocation("Yaba, Lagos");
        request.setDateTime(LocalDateTime.of(2026, 10, 9, 10, 0));
        request.setOrganizerId("1234");

        assertThrows(IllegalArgumentException.class, () -> eventService.createEvent(request));

    }

    @Test
    public void CreateEvent_updateLocationOfEventTest() {
        CreateEventRequest request = new CreateEventRequest();
        request.setName("Tech conference");
        request.setDescription("network and job");
        request.setLocation("Yaba, Lagos");
        request.setDateTime(LocalDateTime.of(2026, 10, 9, 10, 0));
        request.setOrganizerId("1234");

        CreateEventResponse event = eventService.createEvent(request);
        assertEquals(1, events.count());
        String eventId = event.getId();
        UpdateEventRequest newRequest = new UpdateEventRequest();
        newRequest.setLocation("Lekki, Lagos");
        CreateEventResponse updatedEvent = eventService.updateEvent(eventId, newRequest);

        assertEquals("Lekki, Lagos", updatedEvent.getLocation());

    }

    @Test
    public void findExistingEventTest() {
        CreateEventRequest request = new CreateEventRequest();
        request.setName("Tech conference");
        request.setDescription("network and job");
        request.setLocation("Yaba, Lagos");
        request.setDateTime(LocalDateTime.of(2026, 10, 9, 10, 0));
        request.setOrganizerId("1234");

        CreateEventResponse event = eventService.createEvent(request);
        Event foundEvent = eventService.findEvent(event.getId());
        assertEquals("Tech conference", foundEvent.getName());
    }

    @Test
    public void findEventThatDoesNotExist_throwExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> eventService.findEvent("1256"));
    }

    @Test
    public void CreateTwoEvents_countIsTwo() {
        CreateEventRequest request = new CreateEventRequest();
        request.setName("Tech conference");
        request.setDescription("network and job");
        request.setLocation("Yaba, Lagos");
        request.setDateTime(LocalDateTime.of(2026, 10, 9, 10, 0));
        request.setOrganizerId("1234");

        eventService.createEvent(request);

        CreateEventRequest requestTwo = new CreateEventRequest();
        requestTwo.setName("music concert");
        requestTwo.setDescription("relax and have fun");
        requestTwo.setLocation("VI, Lagos");
        requestTwo.setDateTime(LocalDateTime.of(2026, 12, 23, 20, 0));
        requestTwo.setOrganizerId("1243");

        eventService.createEvent(requestTwo);
        assertEquals(2, events.count());
        assertEquals(2, eventService.getAllEvents().size());
    }

    @Test
    public void deleteAnExistingEvent_countIs0() {
        CreateEventRequest request = new CreateEventRequest();
        request.setName("Tech conference");
        request.setDescription("network and job");
        request.setLocation("Yaba, Lagos");
        request.setDateTime(LocalDateTime.of(2026, 10, 9, 10, 0));
        request.setOrganizerId("1234");

        CreateEventResponse event = eventService.createEvent(request);
        assertEquals(1, events.count());

        eventService.deleteEvent(event.getId());
        assertEquals(0, events.count());
    }

    @Test
    public void deleteAnEventThatDoesNotExist_throwException() {
        assertThrows(IllegalArgumentException.class, () -> eventService.deleteEvent("1123"));
    }

    @Test
    public void SearchForEventsByName_returnEvent() {
        CreateEventRequest request = new CreateEventRequest();
        request.setName("Tech conference");
        request.setDescription("network and job");
        request.setLocation("Yaba, Lagos");
        request.setDateTime(LocalDateTime.of(2026, 10, 9, 10, 0));
        request.setOrganizerId("1234");

        eventService.createEvent(request);

        CreateEventRequest requestTwo = new CreateEventRequest();
        requestTwo.setName("music concert");
        requestTwo.setDescription("relax and have fun");
        requestTwo.setLocation("VI, Lagos");
        requestTwo.setDateTime(LocalDateTime.of(2026, 12, 23, 20, 0));
        requestTwo.setOrganizerId("1243");

        eventService.createEvent(requestTwo);
        List<Event> foundEvents = eventService.searchForEvents("tech");
        assertEquals(1, foundEvents.size());
    }

    @Test
    public void SearchForEventsByLocation_returnEvent() {
        CreateEventRequest request = new CreateEventRequest();
        request.setName("Tech conference");
        request.setDescription("network and job");
        request.setLocation("Yaba, Lagos");
        request.setDateTime(LocalDateTime.of(2026, 10, 9, 10, 0));
        request.setOrganizerId("1234");

        eventService.createEvent(request);

        CreateEventRequest requestTwo = new CreateEventRequest();
        requestTwo.setName("music concert");
        requestTwo.setDescription("relax and have fun");
        requestTwo.setLocation("VI, Lagos");
        requestTwo.setDateTime(LocalDateTime.of(2026, 12, 23, 20, 0));
        requestTwo.setOrganizerId("1243");

        eventService.createEvent(requestTwo);
        List<Event> foundEvents = eventService.searchForEvents("Lagos");
        assertEquals(2, foundEvents.size());
    }

    @Test
    public void SearchForEventsByDescription_returnEvent() {
        CreateEventRequest request = new CreateEventRequest();
        request.setName("Tech conference");
        request.setDescription("network and job");
        request.setLocation("Yaba, Lagos");
        request.setDateTime(LocalDateTime.of(2026, 10, 9, 10, 0));
        request.setOrganizerId("1234");

        eventService.createEvent(request);

        CreateEventRequest requestTwo = new CreateEventRequest();
        requestTwo.setName("music concert");
        requestTwo.setDescription("relax and have fun");
        requestTwo.setLocation("VI, Lagos");
        requestTwo.setDateTime(LocalDateTime.of(2026, 12, 23, 20, 0));
        requestTwo.setOrganizerId("1243");

        eventService.createEvent(requestTwo);
        List<Event> foundEvents = eventService.searchForEvents("fun");
        assertEquals(1, foundEvents.size());
    }

    @Test
    public void SearchForEventsWithAKeywordDoesNotExist_returnEvent() {
        CreateEventRequest request = new CreateEventRequest();
        request.setName("Tech conference");
        request.setDescription("network and job");
        request.setLocation("Yaba, Lagos");
        request.setDateTime(LocalDateTime.of(2026, 10, 9, 10, 0));
        request.setOrganizerId("1234");

        eventService.createEvent(request);

        CreateEventRequest requestTwo = new CreateEventRequest();
        requestTwo.setName("music concert");
        requestTwo.setDescription("relax and have fun");
        requestTwo.setLocation("VI, Lagos");
        requestTwo.setDateTime(LocalDateTime.of(2026, 12, 23, 20, 0));
        requestTwo.setOrganizerId("1243");

        eventService.createEvent(requestTwo);
        List<Event> foundEvents = eventService.searchForEvents("hangout");
        assertEquals(0, foundEvents.size());
    }
}