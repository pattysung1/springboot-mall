package com.pattysung.springbootmall.service.impl;

import com.pattysung.springbootmall.dao.UserDao;
import com.pattysung.springbootmall.dto.UserRegisterRequest;
import com.pattysung.springbootmall.model.User;
import com.pattysung.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
