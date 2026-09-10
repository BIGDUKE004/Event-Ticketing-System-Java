package com.util;

import com.data.models.Booking;
import com.data.models.BookingItem;
import com.data.models.Status;
import com.data.models.User;
import com.dto.BookingServiceDto.Request.CreateBookingRequest;
import com.dto.BookingServiceDto.Request.UpdateBookingRequest;
import com.dto.authservicedto.request.RegisterUserRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Mapper {
    public static User mapToUser(RegisterUserRequest registerUserRequest){
        User user = new User();
        user.setEmail(registerUserRequest.getEmail());
        user.setName(registerUserRequest.getName());
        user.setPassword(registerUserRequest.getPassword());
        return user;
    }

    public static Booking updateBookingMapToDrug(UpdateBookingRequest updateBookingRequest) {
        Booking booking = new Booking();
        booking.setBookings(updateBookingRequest.getBookings());
        booking.setBookingDate(updateBookingRequest.getBookingDate());
        booking.setEventId(updateBookingRequest.getEventId());
        booking.setQuantity(updateBookingRequest.getQuantity());
        booking.setTotalAmount(BigDecimal.valueOf(updateBookingRequest.getTotalAmount()));
        booking.setUserId(updateBookingRequest.getUserId());
        return booking;
    }

    public static Booking createBookingMapToDrug(CreateBookingRequest createBookingRequest) {
        Booking booking = new Booking();
        booking.setBookings(createBookingRequest.getBookings());
        booking.setBookingDate(createBookingRequest.getBookingDate());
        booking.setEventId(createBookingRequest.getEventId());
        booking.setQuantity(createBookingRequest.getQuantity());
        booking.setTotalAmount(BigDecimal.valueOf(createBookingRequest.getTotalAmount()));
        booking.setUserId(createBookingRequest.getUserId());
        return booking;
    }
}
