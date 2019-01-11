package com.xxx.springboot.bean;

import java.util.List;

import lombok.Data;
@Data
public class Pager<T> {
	private int page;
	private int size;
	private long total;
	private List<T> rows;
}
