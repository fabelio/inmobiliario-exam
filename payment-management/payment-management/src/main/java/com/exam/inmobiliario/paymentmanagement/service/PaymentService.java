package com.exam.inmobiliario.paymentmanagement.service;

import java.util.List;

import com.exam.inmobiliario.paymentmanagement.dto.PaymentDto;

public interface PaymentService {

	PaymentDto getPayment(String id);

	PaymentDto payOrder(PaymentDto payment, String orderId);

	PaymentDto getOrderPayment(String orderId);

	List<PaymentDto> getOrderPayments(String orderId);
}
