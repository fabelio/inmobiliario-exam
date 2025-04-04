package com.exam.inmobiliario.ordersmanagement.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.exam.inmobiliario.ordersmanagement.dto.PaymentStatusDto;
import com.exam.inmobiliario.ordersmanagement.model.PaymentStatus;

@Mapper
public interface PaymentStatusMapper {

	PaymentStatusDto toDto(PaymentStatus paymnet);

	@Mapping(target = "payments", ignore = true)
	PaymentStatus toEntity(PaymentStatusDto dto);
}
