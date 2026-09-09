package com.eventTickettingSystem.dto.authservicedto.reponse;

import com.eventTickettingSystem.data.models.Status;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class PaymentResponse {
    String bookingId;
    BigDecimal amount;
    Status status;
}
