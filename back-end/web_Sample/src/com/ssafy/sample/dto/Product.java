package com.ssafy.sample.dto;

public class Product {
	private String code;
	private String model;
	private Integer price;
	
	public Product(String code, String model, Integer price) {
		super();
		this.code = code;
		this.model = model;
		this.price = price;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
