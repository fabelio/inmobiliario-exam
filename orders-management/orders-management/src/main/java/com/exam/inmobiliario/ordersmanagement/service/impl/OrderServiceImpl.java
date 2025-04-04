package com.exam.inmobiliario.ordersmanagement.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exam.inmobiliario.ordersmanagement.dto.MethodPaymentDto;
import com.exam.inmobiliario.ordersmanagement.dto.OrderDto;
import com.exam.inmobiliario.ordersmanagement.dto.PaymentDto;
import com.exam.inmobiliario.ordersmanagement.mappers.OrderMapper;
import com.exam.inmobiliario.ordersmanagement.model.Order;
import com.exam.inmobiliario.ordersmanagement.proxies.PaymentProxy;
import com.exam.inmobiliario.ordersmanagement.repositories.OrderRepository;
import com.exam.inmobiliario.ordersmanagement.repositories.OrderStatusRepository;
import com.exam.inmobiliario.ordersmanagement.service.OrderService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	OrderStatusRepository orderStatusRepository;
	@Autowired
	PaymentProxy paymentProxy;

	@Override
	public List<OrderDto> listOrders(int pageNumber, int pageSize) {
		return orderRepository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber)).toList().stream()
				.map(orderMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public OrderDto getOrder(String id) {
		return orderRepository.findById(Integer.valueOf(id)).map(orderMapper::toDto)
				.orElseThrow(() -> new RuntimeException("Order not found"));
	}

	@Override
	@Transactional
	public OrderDto createOrder(OrderDto order) {

		Order orderEntity = orderMapper.toModel(order);
		orderEntity.setDate(new Date());
		orderEntity.setOrderStatus(orderStatusRepository.findByCode("created"));

		if (orderEntity.getOrderDetails() != null && !orderEntity.getOrderDetails().isEmpty())
			orderEntity.getOrderDetails().stream().forEach(item -> item.setOrder(orderEntity));

		return orderMapper.toDto(orderRepository.saveAndFlush(orderEntity));
	}

	@Override
	public void deleteOrder(String id) {
		Order order = orderRepository.findById(Integer.valueOf(id))
				.orElseThrow(() -> new RuntimeException("Order not found"));
		order.setOrderStatus(orderStatusRepository.findByCode("cancelled"));
		orderRepository.save(order);
	}

	@Override
	public OrderDto updateOrder(String id, OrderDto order) {
		throw new RuntimeException("Not permited");
	}

	@Override
	public OrderDto payOrder(String id) {

		Order order = orderRepository.findById(Integer.valueOf(id))
				.orElseThrow(() -> new RuntimeException("Order not found"));

		PaymentDto payment = new PaymentDto();
		payment.setAmount(orderRepository.getTotalOrder(Integer.valueOf(id)));
		MethodPaymentDto method = new MethodPaymentDto();
		method.setCode("credit-card");
		payment.setMethodPayment(method);
		payment = paymentProxy.payOrder(payment, id).getBody();

		boolean orderPaid = payment.getPaymentStatus() != null && payment.getPaymentStatus().getCode() != null
				&& payment.getPaymentStatus().getCode().equals("approved");

		order.setOrderStatus(orderStatusRepository.findByCode(orderPaid ? "paid" : "rejected"));

		return orderMapper.toDto(orderRepository.saveAndFlush(order));
	}

}
