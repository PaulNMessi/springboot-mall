package com.messi.springbootmall.controller;

import com.messi.springbootmall.dto.CommentRequest;
import com.messi.springbootmall.model.Comment;
import com.messi.springbootmall.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 如果你之前拔掉了 SecurityConfig，記得加上 @CrossOrigin 讓前端可以呼叫
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 取得某篇文章的所有留言
    @GetMapping("/articles/{articleId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Integer articleId) {
        List<Comment> commentList = commentService.getCommentsByArticleId(articleId);
        return ResponseEntity.status(HttpStatus.OK).body(commentList);
    }

    // 在某篇文章底下新增留言
    @PostMapping("/articles/{articleId}/comments")
    public ResponseEntity<Comment> createComment(
            @PathVariable Integer articleId,
            @RequestBody @Valid CommentRequest commentRequest) {

        // 1. 新增留言到資料庫，並取得新留言的 ID
        Integer commentId = commentService.createComment(articleId, commentRequest);

        // 2. (可選) 為了讓前端立刻顯示新留言，我們可以回傳成功訊息，或直接把完整的留言物件回傳
        Comment comment = new Comment();
        comment.setCommentId(commentId);
        comment.setArticleId(articleId);
        comment.setAuthor(commentRequest.getAuthor());
        comment.setContent(commentRequest.getContent());

        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }
}