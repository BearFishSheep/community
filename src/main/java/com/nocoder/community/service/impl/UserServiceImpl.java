package com.nocoder.community.service.impl;

import com.nocoder.community.dao.UserMapper;
import com.nocoder.community.entity.User;
import com.nocoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(int id) {
        return userMapper.selectById(id);
    }
}
