package com.messi.springbootmall.model;

import java.util.Date;

public class Message {
    private Long id;
    private String author;
    private String content;
    private Date createdAt;

    // 預設建構子 (Spring Boot 轉換 JSON 時需要)
    public Message() {
    }

    public Message(Long id, String author, String content, Date createdAt) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}