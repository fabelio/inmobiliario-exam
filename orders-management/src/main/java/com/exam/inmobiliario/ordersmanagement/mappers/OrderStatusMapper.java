package com.exam.inmobiliario.ordersmanagement.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.exam.inmobiliario.ordersmanagement.dto.OrderStatusDto;
import com.exam.inmobiliario.ordersmanagement.model.OrderStatus;

@Mapper
public interface OrderStatusMapper {

	OrderStatusDto toDto(OrderStatus status);

	@Mapping(target = "orders", ignore = true)
	OrderStatus toEntity(OrderStatusDto dto);
}
