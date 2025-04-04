package com.exam.inmobiliario.ordersmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderStatusDto {
	@JsonProperty
	private int id;
	@JsonProperty
	private String code;
	@JsonProperty
	private String name;
}
