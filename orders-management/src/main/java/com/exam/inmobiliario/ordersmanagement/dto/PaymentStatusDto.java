package com.exam.inmobiliario.ordersmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentStatusDto {
	@JsonProperty
	private int id;
	@JsonProperty
	private String code;
	@JsonProperty
	private String name;
}
