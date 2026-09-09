package com.eventTickettingSystem.service;

import com.eventTickettingSystem.data.models.Payment;
import com.eventTickettingSystem.dto.authservicedto.reponse.PaymentResponse;
import com.eventTickettingSystem.dto.authservicedto.request.PaymentRequest;

import java.util.List;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest request);
    List<Payment> getAllPayments();
    Payment getBookingPayment(String bookingId);
}
