package com.xxx.springboot.entity;

import lombok.Data;

@Data
public class Product extends BaseEntity{
	private String name;
	private Double price;
	private Double batchPrice;
	private Integer stock;
	private Integer batchCount;
	private Integer batchAmount;
	private String desc;
	
}
