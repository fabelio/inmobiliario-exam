package com.exam.inmobiliario.ordersmanagement.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentDto {
	@JsonProperty
	private int id;
	@JsonProperty
	private BigDecimal amount;
	@JsonProperty
	private Date date;
	@JsonProperty
	private String message;
	@JsonProperty
	private MethodPaymentDto methodPayment;
	@JsonProperty
	private String orderId;
	@JsonProperty
	private PaymentStatusDto paymentStatus;
}
