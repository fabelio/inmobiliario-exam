package com.exam.inmobiliario.paymentmanagement.respositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.inmobiliario.paymentmanagement.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	List<Payment> findByOrderId(Integer orderId);
	Optional<Payment> findTop1ByOrderIdOrderByIdDesc(Integer orderId);
}
