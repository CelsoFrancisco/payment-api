package com.celso.payment_api.facade;

import com.celso.payment_api.entity.Payment;
import com.celso.payment_api.repository.PaymentRepository;
import com.celso.payment_api.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentFacade {

    private final PaymentRepository repository;
    private final List<PaymentStrategy> strategies;

    public PaymentFacade(
            PaymentRepository repository,
            List<PaymentStrategy> strategies) {

        this.repository = repository;
        this.strategies = strategies;
    }

    public Payment processPayment(Payment payment) {

        PaymentStrategy strategy = strategies.stream()
                .filter(s -> s.supports(payment.getPaymentMethod()))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Método de pagamento inválido"));

        strategy.process(payment);

        return repository.save(payment);
    }
}