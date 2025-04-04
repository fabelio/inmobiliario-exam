package com.exam.inmobiliario.paymentmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.inmobiliario.paymentmanagement.dto.PaymentDto;
import com.exam.inmobiliario.paymentmanagement.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentService service;

	@GetMapping("/{id}")
	public ResponseEntity<PaymentDto> getPayment(@PathVariable String id) {
		return new ResponseEntity<PaymentDto>(this.service.getPayment(id), HttpStatus.OK);
	}

	@PostMapping("/order/{id}")
	public ResponseEntity<PaymentDto> payOrder(@RequestBody(required = true) PaymentDto payment,
			@PathVariable String id) {
		return new ResponseEntity<PaymentDto>(this.service.payOrder(payment, id), HttpStatus.OK);
	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<PaymentDto> getOrderPayment(@PathVariable String orderId) {
		return new ResponseEntity<PaymentDto>(this.service.getOrderPayment(orderId), HttpStatus.OK);
	}

	@GetMapping("/order/{orderId}/list")
	public ResponseEntity<List<PaymentDto>> getOrderPayments(@PathVariable String orderId) {
		return new ResponseEntity<List<PaymentDto>>(this.service.getOrderPayments(orderId), HttpStatus.OK);
	}

}
