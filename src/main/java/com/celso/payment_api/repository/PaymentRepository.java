package com.celso.payment_api.repository;

import com.celso.payment_api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
/*
 * JpaRepository = Uma interface do Spring Data JPA.
 * Fornece métodos prontos para acessar o banco de dados sem escrever SQL
 * save(), findById(), findAll(), deleteById(), existsById(), count()*
 */
