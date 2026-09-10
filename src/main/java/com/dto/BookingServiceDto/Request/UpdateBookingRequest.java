package com.dto.BookingServiceDto.Request;

import com.data.models.BookingItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
@Data
public class UpdateBookingRequest {
    String userId;
    String eventId;
    ArrayList<BookingItem> bookings;
    LocalDateTime bookingDate;
    int quantity;
    int totalAmount;

}
