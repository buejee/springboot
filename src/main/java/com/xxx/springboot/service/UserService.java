package com.xxx.springboot.service;
import com.xxx.springboot.dao.UserMapper;
import com.xxx.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findById(Integer id){
        return userMapper.findById(id);
    }

    public User findByUsername(String username){
        return userMapper.findByUsername(username);
    }
}
