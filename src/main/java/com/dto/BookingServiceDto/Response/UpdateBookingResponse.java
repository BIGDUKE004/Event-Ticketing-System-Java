package com.dto.BookingServiceDto.Response;

import com.data.models.BookingItem;
import com.data.models.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class UpdateBookingResponse {
    String id;
    String userId;
    String eventId;
    ArrayList<BookingItem> bookings;
    LocalDateTime bookingDate;
    int quantity;
    BigDecimal totalAmount;
    Status status = Status.PENDING;
}
