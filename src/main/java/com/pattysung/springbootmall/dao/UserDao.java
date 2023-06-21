package com.pattysung.springbootmall.dao;

import com.pattysung.springbootmall.dto.UserRegisterRequest;
import com.pattysung.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
