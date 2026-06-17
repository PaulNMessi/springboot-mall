package com.messi.springbootmall.service;

import com.messi.springbootmall.dao.CommentDao;
import com.messi.springbootmall.dto.CommentRequest;
import com.messi.springbootmall.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    // 💡 這裡注入的是 Interface！Spring Boot 會自動去尋找實作了這個介面的 @Repository
    @Autowired
    private CommentDao commentDao;

    public List<Comment> getCommentsByArticleId(Integer articleId) {
        return commentDao.getCommentsByArticleId(articleId);
    }

    public Integer createComment(Integer articleId, CommentRequest commentRequest) {
        return commentDao.createComment(articleId, commentRequest);
    }
}