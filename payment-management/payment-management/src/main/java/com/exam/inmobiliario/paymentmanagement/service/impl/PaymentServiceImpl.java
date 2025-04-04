package com.exam.inmobiliario.paymentmanagement.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.inmobiliario.paymentmanagement.dto.PaymentDto;
import com.exam.inmobiliario.paymentmanagement.mappers.PaymentMapper;
import com.exam.inmobiliario.paymentmanagement.model.Payment;
import com.exam.inmobiliario.paymentmanagement.respositories.impl.MethodPaymentRepository;
import com.exam.inmobiliario.paymentmanagement.respositories.impl.PaymentRepository;
import com.exam.inmobiliario.paymentmanagement.respositories.impl.PaymentStatusRespository;
import com.exam.inmobiliario.paymentmanagement.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository repository;
	@Autowired
	PaymentStatusRespository statusRepository;
	@Autowired
	MethodPaymentRepository methodRepository;
	@Autowired
	PaymentMapper mapper;

	@Override
	public PaymentDto getPayment(String id) {
		return repository.findById(Integer.valueOf(id)).map(mapper::toDto)
				.orElseThrow(() -> new RuntimeException("payment not found"));
	}

	@Override
	public PaymentDto payOrder(PaymentDto payment, String orderId) {
		Payment paymentEntity = mapper.toEntity(payment);
		Boolean approved = doPayment();
		paymentEntity.setOrderId(Integer.valueOf(orderId));
		paymentEntity.setPaymentStatus(statusRepository.findByCode(approved ? "approved" : "rejected"));
		paymentEntity.setDate(new Date());
		if (paymentEntity.getMethodPayment() != null && paymentEntity.getMethodPayment().getId() < 1
				&& paymentEntity.getMethodPayment().getCode() != null)
			paymentEntity.setMethodPayment(methodRepository.findByCode(paymentEntity.getMethodPayment().getCode()));
		return mapper.toDto(repository.saveAndFlush(paymentEntity));
	}

	private boolean doPayment() {
		return getRandomNumber(1, 100) < 80;
	}

	private int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	@Override
	public PaymentDto getOrderPayment(String orderId) {
		return repository.findTop1ByOrderIdOrderByIdDesc(Integer.valueOf(orderId)).map(mapper::toDto)
				.orElseThrow(() -> new RuntimeException("payment not found"));
	}

	@Override
	public List<PaymentDto> getOrderPayments(String orderId) {

		return repository.findByOrderId(Integer.valueOf(orderId)).stream().map(mapper::toDto).toList();
	}

}
