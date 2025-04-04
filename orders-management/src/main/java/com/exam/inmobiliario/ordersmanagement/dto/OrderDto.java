package com.exam.inmobiliario.ordersmanagement.dto;

import java.util.Date;
import java.util.List;

import com.exam.inmobiliario.ordersmanagement.model.Customer;
import com.exam.inmobiliario.ordersmanagement.model.OrderDetail;
import com.exam.inmobiliario.ordersmanagement.model.OrderStatus;
import com.exam.inmobiliario.ordersmanagement.model.Payment;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderDto {
	@JsonProperty
	private int id;
	@JsonProperty
	private Date date;
	@JsonProperty
	private List<OrderDetailDto> orderDetails;
	@JsonProperty
	private CustomerDto customer;
	@JsonProperty
	private OrderStatusDto orderStatus;
	@JsonProperty
	private List<PaymentDto> payments;
}
