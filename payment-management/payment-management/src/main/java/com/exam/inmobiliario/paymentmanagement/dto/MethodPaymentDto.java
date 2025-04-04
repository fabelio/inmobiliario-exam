package com.exam.inmobiliario.paymentmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MethodPaymentDto {
	@JsonProperty
	private int id;
	@JsonProperty
	private String code;
	@JsonProperty
	private String name;
}
