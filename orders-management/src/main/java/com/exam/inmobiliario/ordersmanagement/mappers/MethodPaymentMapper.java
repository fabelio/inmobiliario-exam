package com.exam.inmobiliario.ordersmanagement.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.exam.inmobiliario.ordersmanagement.dto.MethodPaymentDto;
import com.exam.inmobiliario.ordersmanagement.model.MethodPayment;

@Mapper
public interface MethodPaymentMapper {

	MethodPaymentDto toDto(MethodPayment method);

	@Mapping(target = "payments", ignore = true)
	MethodPayment toEntity(MethodPaymentDto dto);
}
