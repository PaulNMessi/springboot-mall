package com.messi.springbootmall.service;

import com.messi.springbootmall.model.Message;
import com.messi.springbootmall.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageDao messageDao;

    @Autowired
    public MessageService(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public List<Message> getAllMessages() {
        return messageDao.findAll();
    }

    public Message addMessage(Message msg) {

        // 🚨 變更邏輯 1: 嚴格禁止匿名留言 (防呆升級為阻擋)
        String author = msg.getAuthor();
        if (author == null || author.trim().isEmpty()) {
            // 直接拋出錯誤，這段錯誤訊息會被 Controller 捕捉並回傳 400 給前端
            throw new IllegalArgumentException("必須填寫暱稱，本站不接受匿名留言！");
        }
        msg.setAuthor(author.trim());

        // 邏輯 2: 處理內容字數驗證 (維持不變)
        String content = msg.getContent();
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("留言內容不能為空！");
        }
        if (content.length() > 500) {
            throw new IllegalArgumentException("留言內容太長啦！不能超過 500 個字。");
        }
        msg.setContent(content.trim());

        // 邏輯通過，交給 Dao 儲存
        return messageDao.save(msg);
    }
}