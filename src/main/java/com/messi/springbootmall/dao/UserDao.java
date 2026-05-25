package com.messi.springbootmall.dao;

import com.messi.springbootmall.dto.UserRegisterRequest;
import com.messi.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
