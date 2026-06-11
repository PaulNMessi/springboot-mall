package com.messi.springbootmall.controller;

import com.messi.springbootmall.dto.UserRegisterRequest;
import com.messi.springbootmall.dto.UserLoginRequest;
import com.messi.springbootmall.model.User;
import com.messi.springbootmall.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200") // 🌟 核心修正：允許前端 Angular 跨域連線拿貨！
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        Integer userId = userService.register(userRegisterRequest);

        User user = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/users/login")
    public ResponseEntity<User> login(@RequestBody @Valid UserLoginRequest userloginRequest) {
        User user  = userService.login(userloginRequest);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    // 這是未來在你的 UserController.java 裡準備加開的對接管道示範：
//    @PostMapping("/users/google-login")
//    public ResponseEntity<User> googleLogin(@RequestBody Map<String, String> data) {
//        String idTokenString = data.get("idToken");
//
//        // 1. 呼叫 Google 官方套件解密並驗證 idTokenString
//        // 2. 拆出裡面的 Email: user@gmail.com, Name: 湧元
//        // 3. 檢查資料庫：如果此 Email 不存在，就自動執行 userService.register()
//        // 4. 回傳正式的 User 物件給前端 Angular
//
//        // return ResponseEntity.status(HttpStatus.OK).body(user);
//    }




}
