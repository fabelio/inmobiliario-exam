package com.exam.inmobiliario.paymentmanagement.respositories.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.inmobiliario.paymentmanagement.model.PaymentStatus;

public interface PaymentStatusRespository extends JpaRepository<PaymentStatus, Integer> {
	PaymentStatus findByCode(String code);
}
