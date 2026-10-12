package com.analytics.model;

import java.time.LocalDate;

public record Post(
    int postId,
    String creatorUsername,
    String caption,
    ContentType contentType,
    int likeCount,
    int commentCount,
    int shareCount,
    LocalDate postDate
) {
    
    public int getEngagementScore() {
        return likeCount + (commentCount * 2) + (shareCount * 3);
    }

    @Override
    public String toString() {
        return String.format(
            "Post ID: %d | Creator: @%s | Type: %s | Likes: %d, Comments: %d, Shares: %d | Engagement Score: %d | Date: %s\nCaption: \"%s\" \n----------------------",
            postId, creatorUsername, contentType, likeCount, commentCount, shareCount, getEngagementScore(), postDate, caption
        );
    }
}
