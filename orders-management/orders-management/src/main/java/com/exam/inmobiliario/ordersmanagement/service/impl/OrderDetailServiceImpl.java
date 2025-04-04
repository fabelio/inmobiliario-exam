package com.exam.inmobiliario.ordersmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.inmobiliario.ordersmanagement.dto.OrderDetailDto;
import com.exam.inmobiliario.ordersmanagement.mappers.OrderDetailMapper;
import com.exam.inmobiliario.ordersmanagement.model.Order;
import com.exam.inmobiliario.ordersmanagement.model.OrderDetail;
import com.exam.inmobiliario.ordersmanagement.repositories.OrderDetailRepository;
import com.exam.inmobiliario.ordersmanagement.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailRepository orderDetailRepository;
	@Autowired
	OrderDetailMapper mapper;

	@Override
	public OrderDetailDto getOrderDeail(String id) {
		return orderDetailRepository.findById(Integer.valueOf(id)).map(mapper::toDto)
				.orElseThrow(() -> new RuntimeException("Order detail not found"));
	}

	@Override
	public OrderDetailDto createOrderDetail(OrderDetailDto orderDetail, String id) {

		return mapper.toDto(orderDetailRepository.saveAndFlush(buildOrderDetailEntity(orderDetail, id)));
	}

	private OrderDetail buildOrderDetailEntity(OrderDetailDto orderDetail, String id) {
		OrderDetail detail = mapper.toModel(orderDetail);
		if (detail.getOrder() == null) {
			detail.setOrder(new Order());
			detail.getOrder().setId(Integer.valueOf(id));
		}
		return detail;
	}

	@Override
	public void deleteOrderDetail(String id) {
		orderDetailRepository.deleteById(Integer.valueOf(id));
	}

	@Override
	public OrderDetailDto updateOrderDetail(String id, OrderDetailDto orderDetail) {
		OrderDetail detail = orderDetailRepository.findById(Integer.valueOf(id))
				.orElseThrow(() -> new RuntimeException("Order detail doesnt exist"));
		detail.setQuantity(orderDetail.getQuantity());
		if (orderDetail.getPrice() != null)
			detail.setPrice(orderDetail.getPrice());
		return mapper.toDto(orderDetailRepository.save(detail));
	}

	@Override
	public List<OrderDetailDto> createOrderDetailList(List<OrderDetailDto> orderDetail, String id) {
		return orderDetailRepository
				.saveAllAndFlush(orderDetail.stream().map(item -> this.buildOrderDetailEntity(item, id)).toList())
				.stream().map(mapper::toDto).toList();
	}

	@Override
	public List<OrderDetailDto> getOrderDetailListByOrderId(String orderId) {
		return orderDetailRepository.findByOrderId(Integer.valueOf(orderId)).stream().map(mapper::toDto).toList();
	}

}
