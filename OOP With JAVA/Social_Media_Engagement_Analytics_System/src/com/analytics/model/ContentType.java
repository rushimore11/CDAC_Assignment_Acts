package com.analytics.model;

public enum ContentType {
    IMAGE, VIDEO, REEL, CAROUSEL, TEXT;

    public static ContentType fromString(String type) {
        try {
            return ContentType.valueOf(type.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid content type..... Choose from: IMAGE, VIDEO, REEL, CAROUSEL, TEXT.");
        }
    }
}
