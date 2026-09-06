package org.service;

import org.data.models.TicketType;
import org.data.repository.TicketTypeRepository;
import org.dto.ticketTypeServiceDto.Request.CreateTicketTypeRequest;
import org.springframework.stereotype.Service;
import org.util.Mapper;

import java.util.List;
import java.util.Optional;

@Service
public class TicketTypeService {

    private final TicketTypeRepository ticketTypeRepository;
    private final Mapper mapper;

    public TicketTypeService(
            TicketTypeRepository ticketTypeRepository,
            Mapper mapper
    ) {
        this.ticketTypeRepository = ticketTypeRepository;
        this.mapper = mapper;
    }

    public TicketType createTicketType(CreateTicketTypeRequest request) {

        TicketType ticketType = mapper.mapToTicketType(request);

        return ticketTypeRepository.save(ticketType);
    }

    public Optional<TicketType> getTicketTypeById(String id) {
        return ticketTypeRepository.findById(id);
    }

    public List<TicketType> getAllTicketTypes() {
        return ticketTypeRepository.findAll();
    }

    public List<TicketType> getTicketTypesByEventId(String eventId) {
        return ticketTypeRepository.findByEventId(eventId);
    }

    public void deleteTicketType(String id) {
        ticketTypeRepository.deleteById(id);
    }
}