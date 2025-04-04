package com.exam.inmobiliario.ordersmanagement.service;

import java.util.List;

import com.exam.inmobiliario.ordersmanagement.dto.OrderDetailDto;

public interface OrderDetailService {

	OrderDetailDto getOrderDeail(String id);

	OrderDetailDto createOrderDetail(OrderDetailDto orderDetail, String id);

	List<OrderDetailDto> createOrderDetailList(List<OrderDetailDto> orderDetail, String id);

	void deleteOrderDetail(String id);

	OrderDetailDto updateOrderDetail(String id, OrderDetailDto orderDetail);

	List<OrderDetailDto> getOrderDetailListByOrderId(String orderId);

}
