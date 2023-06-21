package com.pattysung.springbootmall.service;

import com.pattysung.springbootmall.dto.UserRegisterRequest;
import com.pattysung.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);
}
