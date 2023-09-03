package com.nocoder.community.service;

import com.nocoder.community.entity.User;

import java.util.Map;

public interface UserService {
    User findById(int id);

    Map<String, Object> register(User user);

    int activation(int userId, String code);
}
