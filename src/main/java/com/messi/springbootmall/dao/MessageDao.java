package com.messi.springbootmall.dao;

import com.messi.springbootmall.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

@Repository // 依然保留這個註解讓 Spring 管理
public class MessageDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Message> findAll() {
        String sql = "SELECT * FROM messages ORDER BY created_at DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Message msg = new Message();
            msg.setId(rs.getLong("id"));
            msg.setAuthor(rs.getString("author"));
            msg.setContent(rs.getString("content"));
            msg.setCreatedAt(rs.getTimestamp("created_at"));
            return msg;
        });
    }

    public Message save(Message msg) {
        String sql = "INSERT INTO messages (author, content, created_at) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Timestamp now = new Timestamp(System.currentTimeMillis());

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, msg.getAuthor());
            ps.setString(2, msg.getContent());
            ps.setTimestamp(3, now);
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            msg.setId(keyHolder.getKey().longValue());
        }
        msg.setCreatedAt(now);
        return msg;
    }
}




