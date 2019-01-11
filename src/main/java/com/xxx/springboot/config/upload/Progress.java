package com.xxx.springboot.config.upload;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class Progress implements Serializable{
	private long read;
	private long size;
	private int items;
}
