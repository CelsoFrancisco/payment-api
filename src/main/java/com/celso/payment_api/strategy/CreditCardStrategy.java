package com.celso.payment_api.strategy;

import com.celso.payment_api.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class CreditCardStrategy implements PaymentStrategy {

    @Override
    public void process(Payment payment) {
        payment.setStatus("APPROVED");
    }

    @Override
    public boolean supports(String paymentMethod) {
        return "CREDIT_CARD".equalsIgnoreCase(paymentMethod);
    }
}