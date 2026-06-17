package com.messi.springbootmall.dao;

import com.messi.springbootmall.dto.CommentRequest;
import com.messi.springbootmall.model.Comment;

import java.util.List;

public interface CommentDao {

    // 取得某篇文章的所有留言
    List<Comment> getCommentsByArticleId(Integer articleId);

    // 新增留言
    Integer createComment(Integer articleId, CommentRequest commentRequest);

}