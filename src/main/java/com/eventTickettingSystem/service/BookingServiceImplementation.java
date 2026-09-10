package com.service;

import com.data.models.Booking;
import com.data.models.User;
import com.data.repository.BookingRepository;
import com.data.repository.UserRepository;
import com.dto.BookingServiceDto.Request.*;
import com.dto.BookingServiceDto.Response.*;
import com.exceptions.BookingServiceExceptions.AccountNotLoggedInExceptions;
import com.exceptions.BookingServiceExceptions.BookingNotFoundException;
import com.exceptions.authServiceExceptions.InvalidDataInputException;
import com.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BookingServiceImplementation implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CreateBookingResponse createBooking(CreateBookingRequest createBookingRequest) {
        if(createBookingRequest.getUserId().isBlank() || createBookingRequest.getEventId().isBlank() || createBookingRequest.getQuantity() == 0 || createBookingRequest.getTotalAmount() == 0){
            throw new InvalidDataInputException("fill all required fields");
        }
        Optional<User> user = userRepository.findById(createBookingRequest.getUserId());
        if(user.isEmpty()){
            throw new AccountNotLoggedInExceptions("Account not logged in");
        }
        if(!user.get().isLoggedIn()){
            throw new AccountNotLoggedInExceptions("Account not logged in");
        }
        int amount = 0;
        for(int count = 0; count < createBookingRequest.getBookings().size(); count++){
            amount += createBookingRequest.getBookings().get(count).getTotalAmount();
        }
        Booking booking = Mapper.createBookingMapToDrug(createBookingRequest);
        booking.setTotalAmount(BigDecimal.valueOf(amount));
        this.bookingRepository.insert(booking);
        CreateBookingResponse response = new CreateBookingResponse();
        response.setId(booking.getId());
        response.setBookingDate(createBookingRequest.getBookingDate());
        response.setEventId(createBookingRequest.getEventId());
        response.setBookings(createBookingRequest.getBookings());
        response.setQuantity(createBookingRequest.getQuantity());
        response.setUserId(createBookingRequest.getUserId());
        response.setTotalAmount(BigDecimal.valueOf(createBookingRequest.getTotalAmount()));
        return response;
    }


    @Override
    public GetUserBookingResponse getUserBooking(GetUserBookingRequest getUserBookingRequest) {
        Optional<User> user = userRepository.findById(getUserBookingRequest.getId());
        if(user.isEmpty()){
            throw new AccountNotLoggedInExceptions("Account not logged in");
        }
        if(!user.get().isLoggedIn()){
            throw new AccountNotLoggedInExceptions("Account not logged in");
        }
        Booking booking = bookingRepository.findByUserId(getUserBookingRequest.getId());
        if(booking == null){
            throw new BookingNotFoundException("Booking not found");
        }
        GetUserBookingResponse getUserBookingResponse = new GetUserBookingResponse();
        getUserBookingResponse.setBookingDate(booking.getBookingDate());
        getUserBookingResponse.setId(booking.getId());
        getUserBookingResponse.setBookings(booking.getBookings());
        getUserBookingResponse.setEventId(booking.getEventId());
        getUserBookingResponse.setQuantity(booking.getQuantity());
        getUserBookingResponse.setTotalAmount(booking.getTotalAmount());
        getUserBookingResponse.setUserId(booking.getUserId());
        
        return getUserBookingResponse;
    }

    @Override
    public CancelBookingResponse cancelBooking(CancelBookingRequest cancelBookingRequest) {
        boolean check = bookingRepository.existsById(cancelBookingRequest.getId());
        if(check == false){
            throw new BookingNotFoundException("booking does not exist");
        }
        bookingRepository.deleteById(cancelBookingRequest.getId());
        CancelBookingResponse response = new CancelBookingResponse();
        response.setMessage("Booking deleted successfully");
        return response;
    }

    @Override
    public UpdateBookingResponse updateBooking(UpdateBookingRequest updateBookingRequest) {
        if(updateBookingRequest.getUserId().isBlank() || updateBookingRequest.getEventId().isBlank() || updateBookingRequest.getQuantity() == 0 || updateBookingRequest.getTotalAmount() == 0){
            throw new InvalidDataInputException("fill all required fields");
        }
        Optional<User> user = userRepository.findById(updateBookingRequest.getUserId());
        if(user.isEmpty()){
            throw new AccountNotLoggedInExceptions("Account not logged in");
        }
        if(!user.get().isLoggedIn()){
            throw new AccountNotLoggedInExceptions("Account not logged in");
        }
        int amount = 0;
        for(int count = 0; count < updateBookingRequest.getBookings().size(); count++){
            amount += updateBookingRequest.getBookings().get(count).getTotalAmount();
        }
        Booking oldBooking = this.bookingRepository.findByUserId(updateBookingRequest.getUserId());
        Booking booking = Mapper.updateBookingMapToDrug(updateBookingRequest);
        booking.setId(oldBooking.getId());
        booking.setTotalAmount(BigDecimal.valueOf(amount));
        this.bookingRepository.save(booking);
        UpdateBookingResponse response = new UpdateBookingResponse();
        response.setId(booking.getId());
        response.setBookingDate(updateBookingRequest.getBookingDate());
        response.setEventId(updateBookingRequest.getEventId());
        response.setBookings(updateBookingRequest.getBookings());
        response.setQuantity(updateBookingRequest.getQuantity());
        response.setUserId(updateBookingRequest.getUserId());
        response.setTotalAmount(BigDecimal.valueOf(updateBookingRequest.getTotalAmount()));
        return response;
    }
}
