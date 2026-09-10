package com.service;

import com.dto.BookingServiceDto.Request.*;
import com.dto.BookingServiceDto.Response.*;

public interface BookingService {
    CreateBookingResponse createBooking(CreateBookingRequest createBookingRequest);
    GetUserBookingResponse getUserBooking (GetUserBookingRequest getUserBookingRequest);
    CancelBookingResponse cancelBooking (CancelBookingRequest cancelBookingRequest);
    UpdateBookingResponse updateBooking (UpdateBookingRequest updateBookingRequest);
}
