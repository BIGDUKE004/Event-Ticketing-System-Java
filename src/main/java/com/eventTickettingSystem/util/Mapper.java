package com.eventTickettingSystem.util;

import com.eventTickettingSystem.data.models.Event;
import com.eventTickettingSystem.data.models.Payment;
import com.eventTickettingSystem.data.models.User;
import com.eventTickettingSystem.dto.authservicedto.reponse.CreateEventResponse;
import com.eventTickettingSystem.dto.authservicedto.reponse.PaymentResponse;
import com.eventTickettingSystem.dto.authservicedto.request.CreateEventRequest;
import com.eventTickettingSystem.dto.authservicedto.request.PaymentRequest;
import com.eventTickettingSystem.dto.authservicedto.request.RegisterUserRequest;
import com.eventTickettingSystem.dto.authservicedto.request.UpdateEventRequest;

public class Mapper {
    public static User mapToUser(RegisterUserRequest registerUserRequest){
        User user = new User();
        user.setId(registerUserRequest.getId());
        user.setEmail(registerUserRequest.getEmail());
        user.setName(registerUserRequest.getName());
        user.setPassword(registerUserRequest.getPassword());
        return user;
    }

    public static Event mapToEvent(CreateEventRequest request){
        Event event = new Event();
        event.setDatetime(request.getDateTime());
        event.setDescription(request.getDescription());
        event.setLocation(request.getLocation());
        event.setName(request.getName());
        event.setOrganizerId(request.getOrganizerId());
        return event;
    }

    public static void updateEventMap(UpdateEventRequest request, Event foundEvent) {
        if (request.getName() != null && !request.getName().isBlank()) {
            foundEvent.setName(request.getName());
        }
        if (request.getDescription() != null && !request.getDescription().isBlank()) {
            foundEvent.setDescription(request.getDescription());
        }
        if (request.getLocation() != null && !request.getLocation().isBlank()) {
            foundEvent.setLocation(request.getLocation());
        }
        if (request.getDateTime() != null) {
            foundEvent.setDatetime(request.getDateTime());
        }
    }

    public static CreateEventResponse mapEventResponse(Event event){
        CreateEventResponse response = new CreateEventResponse();
        response.setDatetime(event.getDatetime());
        response.setDescription(event.getDescription());
        response.setId(event.getId());
        response.setLocation(event.getLocation());
        response.setName(event.getName());
        response.setOrganizerId(event.getOrganizerId());
        response.setSoldOut(event.isSoldOut());
        return response;
    }

    public static Payment mapToPayment(PaymentRequest request){
        Payment payment = new Payment();
        payment.setBookingId(request.getBookingId());
        payment.setAmount(request.getAmount());
        return payment;
    }

    public static PaymentResponse mapPaymentResponse(Payment payment){
        PaymentResponse response = new PaymentResponse();
        response.setAmount(payment.getAmount());
        response.setStatus(payment.getStatus());
        response.setBookingId(payment.getBookingId());
        return response;
    }

}
