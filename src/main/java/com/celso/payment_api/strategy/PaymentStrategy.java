package com.celso.payment_api.strategy;

import com.celso.payment_api.entity.Payment;

public interface PaymentStrategy {

    void process(Payment payment);

    boolean supports(String paymentMethod);
}