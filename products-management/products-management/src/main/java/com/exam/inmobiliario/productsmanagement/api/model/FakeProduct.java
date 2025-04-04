package com.exam.inmobiliario.productsmanagement.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FakeProduct {
	@JsonProperty
	private Integer id;
	@JsonProperty
	private String title;
	@JsonProperty
	private float price;
	@JsonProperty
	private String description;
	@JsonProperty
	private String category;
	@JsonProperty
	private String image;

}
