package com.exam.inmobiliario.ordersmanagement.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import com.exam.inmobiliario.ordersmanagement.dto.PaymentDto;
import com.exam.inmobiliario.ordersmanagement.model.Payment;

@Mapper(uses = { MethodPaymentMapper.class, PaymentStatusMapper.class })
public interface PaymentMapper {

	@Mapping(target = "orderId", source = "payment.order.id", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	PaymentDto toDto(Payment payment);

	@Mapping(target = "order.id", source = "dto.orderId", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	Payment toEntity(PaymentDto dto);
}
