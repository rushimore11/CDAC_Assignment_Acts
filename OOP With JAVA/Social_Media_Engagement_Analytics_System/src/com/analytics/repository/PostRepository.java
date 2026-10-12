package com.analytics.repository;

import com.analytics.config.DatabaseConfig;
import com.analytics.exception.InvalidPostException;
import com.analytics.model.ContentType;
import com.analytics.model.Post;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {

    public void save(Post post) throws SQLException, InvalidPostException {
   
        if (post.creatorUsername() == null || post.creatorUsername().trim().isEmpty()) {
            throw new InvalidPostException("valid Error: Creator username cannot be empty!");
        }
        if (post.caption() == null || post.caption().trim().isEmpty()) {
            throw new InvalidPostException("validation Error: Post caption cannot be empty!");
        }
        if (post.likeCount() < 0 || post.commentCount() < 0 || post.shareCount() < 0) {
            throw new InvalidPostException("validation Error: Engagement counts cannot be negative!");
        }

        String sql = "INSERT INTO posts (creator_username, caption, content_type, like_count, comment_count, share_count, post_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, post.creatorUsername());
            stmt.setString(2, post.caption());
            stmt.setString(3, post.contentType().name());
            stmt.setInt(4, post.likeCount());
            stmt.setInt(5, post.commentCount());
            stmt.setInt(6, post.shareCount());
            stmt.setDate(7, Date.valueOf(post.postDate()));
            
            stmt.executeUpdate();
        }
    }

    public List<Post> findAll() throws SQLException {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Post post = new Post(
                        rs.getInt("post_id"),
                        rs.getString("creator_username"),
                        rs.getString("caption"),
                        ContentType.valueOf(rs.getString("content_type")),
                        rs.getInt("like_count"),
                        rs.getInt("comment_count"),
                        rs.getInt("share_count"),
                        rs.getDate("post_date").toLocalDate()
                );
                posts.add(post);
            }
        }
        return posts;
    }
}