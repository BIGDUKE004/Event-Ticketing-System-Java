package com.dto.BookingServiceDto.Request;

import com.data.models.BookingItem;
import com.data.models.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@Data
public class CreateBookingRequest {
    String userId;
    String eventId;
    ArrayList<BookingItem> bookings;
    LocalDateTime bookingDate;
    int quantity;
    int totalAmount;

}
