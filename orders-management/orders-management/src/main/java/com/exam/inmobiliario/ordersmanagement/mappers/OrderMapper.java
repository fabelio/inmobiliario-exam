package com.exam.inmobiliario.ordersmanagement.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.exam.inmobiliario.ordersmanagement.dto.OrderDto;
import com.exam.inmobiliario.ordersmanagement.model.Order;

@Mapper(uses = { OrderDetailMapper.class, PaymentMapper.class, OrderStatusMapper.class, CustomerMapper.class })
public interface OrderMapper {

	@Mapping(target = "payments", ignore = true)
	OrderDto toDto(Order order);

	Order toModel(OrderDto dto);
}
