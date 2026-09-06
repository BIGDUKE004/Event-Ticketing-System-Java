package org.util;

import jdk.jfr.Registered;
import org.data.models.User;
import org.dto.authServiceDto.Request.RegisterUserRequest;

import org.data.models.TicketType;
import org.dto.ticketTypeServiceDto.Request.CreateTicketTypeRequest;

public class Mapper {
    public User mapToUser(RegisterUserRequest request){
        User user = new User();
        user.setId(request.getId());
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        return user;
    }

    public TicketType mapToTicketType(CreateTicketTypeRequest request) {
        TicketType ticketType = new TicketType();

        ticketType.setEventId(request.getEventId());
        ticketType.setName(request.getName());
        ticketType.setPrice(request.getPrice());
        ticketType.setQuantity(request.getQuantity());
        ticketType.setAvailableQuantity(request.getQuantity());
        ticketType.setSoldOut(false);

        return ticketType;
    }

}
