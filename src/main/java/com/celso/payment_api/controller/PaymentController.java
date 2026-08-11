package com.celso.payment_api.controller;

import com.celso.payment_api.entity.Payment;
import com.celso.payment_api.facade.PaymentFacade;
import com.celso.payment_api.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;
    private final PaymentFacade facade;

    public PaymentController(
            PaymentService service,
            PaymentFacade facade) {

        this.service = service;
        this.facade = facade;
    }

    @GetMapping
    public List<Payment> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Payment findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Payment create(@RequestBody Payment payment) {
        return facade.processPayment(payment);
    }

    @PutMapping("/{id}")
    public Payment update(
            @PathVariable Long id,
            @RequestBody Payment payment) {

        return service.update(id, payment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}