package com.celso.payment_api.service;

import com.celso.payment_api.entity.Payment;
import com.celso.payment_api.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service = Annotation que marca uma classe como regra de negócio.
 * Centralizar a lógica da aplicação entre Controller e Repository *
 */
@Service
public class PaymentService {

    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public List<Payment> findAll() {
        return repository.findAll();
    }

    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    public Payment findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }

    public Payment update(Long id, Payment payment) {

        Payment existingPayment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        existingPayment.setAmount(payment.getAmount());
        existingPayment.setPaymentMethod(payment.getPaymentMethod());
        existingPayment.setStatus(payment.getStatus());

        return repository.save(existingPayment);
    }

    public void delete(Long id) {

        Payment payment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        repository.delete(payment);
    }

}