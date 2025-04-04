package com.exam.inmobiliario.ordersmanagement.service;

import java.util.List;

import com.exam.inmobiliario.ordersmanagement.dto.OrderDto;

public interface OrderService {

	List<OrderDto> listOrders(int pageNumber, int pageSize);

	OrderDto getOrder(String id);

	OrderDto createOrder(OrderDto order);

	void deleteOrder(String id);

	OrderDto updateOrder(String id, OrderDto order);

	OrderDto payOrder(String id);
}
