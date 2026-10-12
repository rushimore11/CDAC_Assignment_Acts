package com.analytics.main;

import com.analytics.exception.InvalidPostException;
import com.analytics.model.ContentType;
import com.analytics.model.Post;
import com.analytics.repository.PostRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    private static final PostRepository repository = new PostRepository();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] telemedicine) {
        while (true) {
            System.out.println("\n===== SOCIAL MEDIA ENGAGEMENT ANALYTICS =");
            System.out.println("1. Create New Post");
            System.out.println("2. Search Posts by Creator");
            System.out.println("3. Calculate & Display All Engagement Scores");
            System.out.println("4. Display Posts Sorted by Engagement (Desc)");
            System.out.println("5. Find the Most Engaging Post");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> createPost();
                    case 2 -> searchPostsByCreator();
                    case 3 -> displayEngagementScores();
                    case 4 -> displayPostsSortedByEngagement();
                    case 5 -> findMostEngagingPost();
                    case 6 -> {
                        System.out.println("Exiting System. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid.....! Please select between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numerical choice.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void createPost() {
        try {
            System.out.print("enter creator username: ");
            String username = scanner.nextLine();

            System.out.print("enter Caption: ");
            String caption = scanner.nextLine();

            System.out.print("Enter content Type (IMAGE, VIDEO, REEL, CAROUSEL, TEXT): ");
            ContentType type = ContentType.fromString(scanner.nextLine());

            System.out.print("Enterlikes Count: ");
            int likes = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter comments Count: ");
            int comments = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Shares Count: ");
            int shares = Integer.parseInt(scanner.nextLine());

 
            Post newPost = new Post(0, username, caption, type, likes, comments, shares, LocalDate.now());
            repository.save(newPost);
            
            System.out.println("Post successfully published and persisted to Database!");

        } catch (InvalidPostException e) {
            System.err.println("Input Policy Error: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database Error: Failed to save post. " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Format Error: " + e.getMessage());
        }
    }

    private static void searchPostsByCreator() {
        try {
            System.out.print("Enter Username to search: ");
            String username = scanner.nextLine().trim();

            List<Post> allPosts = repository.findAll();

            // Reusable Predicate
            Predicate<Post> matchesCreator = post -> post.creatorUsername().equalsIgnoreCase(username);

            System.out.println("\n--- Search Results-");
            allPosts.stream()
                    .filter(matchesCreator)
                    .forEach(System.out::println);

        } catch (SQLException e) {
            System.err.println("Database Error: Could not fetch posts. " + e.getMessage());
        }
    }

    private static void displayEngagementScores() {
        try {
            List<Post> allPosts = repository.findAll();
            if (allPosts.isEmpty()) {
                System.out.println("No posts found in database.");
                return;
            }
            System.out.println("\n--- Engagement Calculations --");
            allPosts.forEach(post -> System.out.printf("Post ID %d by @%s | Engagement Score: %d (Likes: %d, Comments: %d, Shares: %d)\n",
                    post.postId(), post.creatorUsername(), post.getEngagementScore(), post.likeCount(), post.commentCount(), post.shareCount()));
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    private static void displayPostsSortedByEngagement() {
        try {
            List<Post> allPosts = repository.findAll();

            System.out.println("\n--- Posts Sorted by Engagement (Highest First) -");
            allPosts.stream()
                    .sorted(Comparator.comparingInt(Post::getEngagementScore).reversed())
                    .forEach(System.out::println);

        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    private static void findMostEngagingPost() {
        try {
            List<Post> allPosts = repository.findAll();

            Optional<Post> topPost = allPosts.stream()
                    .max(Comparator.comparingInt(Post::getEngagementScore));

            System.out.println("\n--- Leaderboard Winner -");
            topPost.ifPresentOrElse(
                    post -> System.out.println("Most Engaging Post:\n" + post),
                    () -> System.out.println("No posts exist in the system yet.")
            );

        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }
}