package com.xxx.springboot.entity;

import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
public class User extends BaseEntity implements Serializable{
    private String username;
    private String password;
    private String mobile;
    private Integer status;
}
