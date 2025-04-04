package com.exam.inmobiliario.ordersmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerDto {
	@JsonProperty
	private int id;
	@JsonProperty
	private String address;
	@JsonProperty
	private String email;
	@JsonProperty
	private String lastname;
	@JsonProperty
	private String name;
	@JsonProperty
	private String phone;
}
