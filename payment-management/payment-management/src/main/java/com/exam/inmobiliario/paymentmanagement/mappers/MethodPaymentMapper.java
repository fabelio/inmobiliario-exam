package com.exam.inmobiliario.paymentmanagement.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.exam.inmobiliario.paymentmanagement.dto.MethodPaymentDto;
import com.exam.inmobiliario.paymentmanagement.model.MethodPayment;


@Mapper
public interface MethodPaymentMapper {

	MethodPaymentDto toDto(MethodPayment method);

	@Mapping(target = "payments", ignore = true)
	MethodPayment toEntity(MethodPaymentDto dto);
}
