package com.eventTickettingSystem.service;

import com.eventTickettingSystem.data.models.Payment;
import com.eventTickettingSystem.data.repository.PaymentRepository;
import com.eventTickettingSystem.dto.authservicedto.reponse.PaymentResponse;
import com.eventTickettingSystem.dto.authservicedto.request.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        return null;
    }

    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    @Override
    public Payment getBookingPayment(String bookingId) {
        return null;
    }

}
