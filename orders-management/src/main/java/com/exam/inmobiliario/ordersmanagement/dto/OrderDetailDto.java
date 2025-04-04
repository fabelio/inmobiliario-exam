package com.exam.inmobiliario.ordersmanagement.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderDetailDto {
	@JsonProperty
	private int id;
	@JsonProperty
	private BigDecimal price;
	@JsonProperty
	private String productId;
	@JsonProperty
	private int quantity;
}
