package com.exam.inmobiliario.ordersmanagement.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.exam.inmobiliario.ordersmanagement.dto.CustomerDto;
import com.exam.inmobiliario.ordersmanagement.model.Customer;

@Mapper
public interface CustomerMapper {

	CustomerDto toDto(Customer customer);

	@Mapping(target = "orders", ignore = true)
	Customer toEntity(CustomerDto dto);
}
