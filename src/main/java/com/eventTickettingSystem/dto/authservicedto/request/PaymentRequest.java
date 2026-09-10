package com.eventTickettingSystem.dto.authservicedto.request;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class PaymentRequest {
    String bookingId;
    BigDecimal amount;
}
