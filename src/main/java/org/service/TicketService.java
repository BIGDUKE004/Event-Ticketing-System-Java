package org.service;

import org.data.models.Ticket;
import org.data.models.TicketType;
import org.data.repository.TicketRepository;
import org.data.repository.TicketTypeRepository;
import org.dto.ticketDto.Request.CreateTicketRequest;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketTypeRepository ticketTypeRepository;

    public TicketService(
            TicketRepository ticketRepository,
            TicketTypeRepository ticketTypeRepository
    ) {
        this.ticketRepository = ticketRepository;
        this.ticketTypeRepository = ticketTypeRepository;
    }

    public Ticket createTicket(CreateTicketRequest request) {


        TicketType ticketType = ticketTypeRepository
                .findById(request.getTicketTypeId())
                .orElseThrow(() ->
                        new RuntimeException("Ticket type not found")
                );


        if (ticketType.getAvailableQuantity() <= 0) {
            throw new RuntimeException("Ticket type is sold out");
        }


        ticketType.setAvailableQuantity(
                ticketType.getAvailableQuantity() - 1
        );


        if (ticketType.getAvailableQuantity() == 0) {
            ticketType.setSoldOut(true);
        }


        ticketTypeRepository.save(ticketType);


        Ticket ticket = new Ticket();

        ticket.setBookingId(request.getBookingId());
        ticket.setTicketTypeId(request.getTicketTypeId());
        ticket.setTicketCode(request.getTicketCode());


        return ticketRepository.save(ticket);
    }
}