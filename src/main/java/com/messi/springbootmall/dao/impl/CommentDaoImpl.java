package com.messi.springbootmall.dao.impl;

import com.messi.springbootmall.dao.CommentDao;
import com.messi.springbootmall.dto.CommentRequest;
import com.messi.springbootmall.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getCommentsByArticleId(Integer articleId) {
        String sql = "SELECT comment_id, article_id, author, content, created_date " +
                "FROM comments WHERE article_id = :articleId ORDER BY created_date DESC";

        Map<String, Object> map = new HashMap<>();
        map.put("articleId", articleId);

        return jdbcTemplate.query(sql, map, new CommentRowMapper());
    }

    @Override
    public Integer createComment(Integer articleId, CommentRequest commentRequest) {
        String sql = "INSERT INTO comments (article_id, author, content, created_date) " +
                "VALUES (:articleId, :author, :content, :createdDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("articleId", articleId);
        map.put("author", commentRequest.getAuthor());
        map.put("content", commentRequest.getContent());
        map.put("createdDate", new Date());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        return keyHolder.getKey().intValue();
    }

    private static class CommentRowMapper implements RowMapper<Comment> {
        @Override
        public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
            Comment comment = new Comment();
            comment.setCommentId(rs.getInt("comment_id"));
            comment.setArticleId(rs.getInt("article_id"));
            comment.setAuthor(rs.getString("author"));
            comment.setContent(rs.getString("content"));
            comment.setCreatedDate(rs.getTimestamp("created_date"));
            return comment;
        }
    }
}