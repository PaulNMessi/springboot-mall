package com.messi.springbootmall.service;

import com.messi.springbootmall.dto.UserLoginRequest;
import com.messi.springbootmall.dto.UserRegisterRequest;
import com.messi.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
