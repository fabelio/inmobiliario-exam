package com.exam.inmobiliario.paymentmanagement.mappers;

import org.mapstruct.Mapper;

import com.exam.inmobiliario.paymentmanagement.dto.PaymentDto;
import com.exam.inmobiliario.paymentmanagement.model.Payment;


@Mapper(uses = { MethodPaymentMapper.class, PaymentStatusMapper.class })
public interface PaymentMapper {


	PaymentDto toDto(Payment payment);

	Payment toEntity(PaymentDto dto);
}
