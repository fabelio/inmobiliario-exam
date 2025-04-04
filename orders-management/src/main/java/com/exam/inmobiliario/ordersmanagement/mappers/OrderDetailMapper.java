package com.exam.inmobiliario.ordersmanagement.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.exam.inmobiliario.ordersmanagement.dto.OrderDetailDto;
import com.exam.inmobiliario.ordersmanagement.model.OrderDetail;

@Mapper
public interface OrderDetailMapper {
	OrderDetailDto toDto(OrderDetail orderDetail);

	@Mapping(target = "order", ignore = true)
	OrderDetail toModel(OrderDetailDto dto);
}
