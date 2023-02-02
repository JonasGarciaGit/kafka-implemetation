package com.messenger.paymentservice.service;

import com.messenger.paymentservice.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}
