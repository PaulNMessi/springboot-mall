package com.messi.springbootmall.controller;

import com.messi.springbootmall.model.Message;
import com.messi.springbootmall.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    private final MessageService messageService;

    // 注入 Service (不是 Repository 喔！)
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        // 直接回傳 HTTP 200 (OK) 以及留言列表
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    @PostMapping
    public ResponseEntity<?> addMessage(@RequestBody Message newMessage) {
        try {
            // 讓 Service 去處理邏輯與儲存
            Message savedMessage = messageService.addMessage(newMessage);
            // 成功就回傳 200 (OK) 和存好的資料
            return ResponseEntity.ok(savedMessage);

        } catch (IllegalArgumentException e) {
            // 如果 Service 拋出驗證錯誤，攔截下來並回傳 400 (Bad Request) 給前端
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}