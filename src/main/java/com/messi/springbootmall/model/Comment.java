package com.messi.springbootmall.model;

import java.util.Date;

public class Comment {

    private Integer commentId;  // 留言本身的流水號 ID

    private Integer articleId;  // 📌 核心關鍵：這張便利貼是屬於哪一張海報的？

    private String author;      // 留言者姓名 (或會員 ID)

    private String content;     // 留言的具體內容

    private Date createdDate;   // 留言建立的時間

    // ========================================== //
    // 以下為 Getters and Setters (請用 IDE 自動產生) //
    // ========================================== //

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
