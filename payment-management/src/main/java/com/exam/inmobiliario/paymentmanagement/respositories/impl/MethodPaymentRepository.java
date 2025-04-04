package com.exam.inmobiliario.paymentmanagement.respositories.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.inmobiliario.paymentmanagement.model.MethodPayment;

public interface MethodPaymentRepository extends JpaRepository<MethodPayment, Integer> {
	MethodPayment findByCode(String code);
}
