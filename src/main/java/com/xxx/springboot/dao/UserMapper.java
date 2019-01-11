package com.xxx.springboot.dao;

import com.xxx.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from xx_user where id = #{id}")
    public User findById(Integer id);
    @Select("select * from xx_user where username = #{username}")
    public User findByUsername(String username);
}
