package com.celso.payment_api.strategy;

import com.celso.payment_api.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class BoletoStrategy implements PaymentStrategy {

    @Override
    public void process(Payment payment) {
        payment.setStatus("PENDING");
    }

    @Override
    public boolean supports(String paymentMethod) {
        return "BOLETO".equalsIgnoreCase(paymentMethod);
    }
}