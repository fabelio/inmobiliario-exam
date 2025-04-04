package com.exam.inmobiliario.paymentmanagement.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.exam.inmobiliario.paymentmanagement.dto.PaymentStatusDto;
import com.exam.inmobiliario.paymentmanagement.model.PaymentStatus;


@Mapper
public interface PaymentStatusMapper {

	PaymentStatusDto toDto(PaymentStatus paymnet);

	@Mapping(target = "payments", ignore = true)
	PaymentStatus toEntity(PaymentStatusDto dto);
}
