package org.bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class program {

    public static void main(String[] args) {
        Library library = new Library();

        // Adding initial sample data
        library.addBook(new Book(new BookId(100), "Harry Potter", "J.K Rowling", 1997, Genre.FICTIOUS));
        library.addBook(new Book(new BookId(101), "Java", "James Gosling", 1995, Genre.TECHNOLOGY));
        library.addBook(new Book(new BookId(102), "C Programming", "Dennis Ritchie", 1972, Genre.TECHNOLOGY));
        library.addBook(new Book(new BookId(103), "Ikigai", "Hector Garcia", 2016, Genre.MYTHOLOGY));

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean running = true;

            while (running) {
                printMenu();
                System.out.print("Enter your choice (1-8): ");
                String input = reader.readLine();

                if (input == null) {
                    break;
                }

                switch (input.trim()) {
                    case "1" -> handleAddBook(reader, library);
                    case "2" -> handleFindBookById(reader, library);
                    case "3" -> handleFindIdByBook(reader, library);
                    case "4" -> handleRemoveBook(reader, library);
                    case "5" -> {
                        System.out.println("\n--- All Books in Library ---");
                        library.displayBooks();
                    }
                    case "6" -> library.sortAndDisplayByName();
                    case "7" -> handleDisplayByGenre(reader, library);
                    case "8" -> {
                        System.out.println("Exiting Library Management System. Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println("=========================================");
        System.out.println("      LIBRARY MANAGEMENT SYSTEM         ");
        System.out.println("=========================================");
        System.out.println("1. Add a New Book");
        System.out.println("2. Find Book by Book ID");
        System.out.println("3. Find Book ID by Book Details");
        System.out.println("4. Remove Book by Book ID");
        System.out.println("5. Display All Books");
        System.out.println("6. Sort and Display Books by Name");
        System.out.println("7. Display Books by Genre");
        System.out.println("8. Exit");
        System.out.println("=========================================");
    }

    private static void handleAddBook(BufferedReader reader, Library library) throws IOException {
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter Book ID (integer): ");
        int id = Integer.parseInt(reader.readLine().trim());

        System.out.print("Enter Book Name: ");
        String name = reader.readLine().trim();

        System.out.print("Enter Author Name: ");
        String author = reader.readLine().trim();

        System.out.print("Enter Year of Publication: ");
        int year = Integer.parseInt(reader.readLine().trim());

        Genre genre = parseGenre(reader);

        Book book = new Book(new BookId(id), name, author, year, genre);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void handleFindBookById(BufferedReader reader, Library library) throws IOException {
        System.out.println("\n--- Find Book by ID ---");
        System.out.print("Enter Book ID to search: ");
        int id = Integer.parseInt(reader.readLine().trim());

        Book book = library.findBookById(new BookId(id));
        if (book != null) {
            System.out.println("Found Book: " + book);
        } else {
            System.out.println("No book found with ID: " + id);
        }
    }

    private static void handleFindIdByBook(BufferedReader reader, Library library) throws IOException {
        System.out.println("\n--- Find Book ID by Details ---");
        System.out.print("Enter Book ID (for object construction): ");
        int id = Integer.parseInt(reader.readLine().trim());

        System.out.print("Enter Book Name: ");
        String name = reader.readLine().trim();

        System.out.print("Enter Author Name: ");
        String author = reader.readLine().trim();

        System.out.print("Enter Year of Publication: ");
        int year = Integer.parseInt(reader.readLine().trim());

        Genre genre = parseGenre(reader);

        Book targetBook = new Book(new BookId(id), name, author, year, genre);
        BookId bookId = library.findIdByBook(targetBook);

        if (bookId != null) {
            System.out.println("Found Book ID key in Map: " + bookId);
        } else {
            System.out.println("Book record does not match any key in the map.");
        }
    }

    private static void handleRemoveBook(BufferedReader reader, Library library) throws IOException {
        System.out.println("\n--- Remove Book ---");
        System.out.print("Enter Book ID to remove: ");
        int id = Integer.parseInt(reader.readLine().trim());

        Book removed = library.removeBook(new BookId(id));
        if (removed != null) {
            System.out.println("Successfully removed book: " + removed);
        } else {
            System.out.println("No book found with ID: " + id);
        }
    }

    private static void handleDisplayByGenre(BufferedReader reader, Library library) throws IOException {
        System.out.println("\n--- Filter Books by Genre ---");
        Genre genre = parseGenre(reader);
        library.displayBooksByGenre(genre);
    }

    private static Genre parseGenre(BufferedReader reader) throws IOException {
        System.out.println("Available Genres:");
        Genre[] genres = Genre.values();
        for (int i = 0; i < genres.length; i++) {
            System.out.println((i + 1) + ". " + genres[i]);
        }
        System.out.print("Select Genre number (1-" + genres.length + "): ");

        try {
            int choice = Integer.parseInt(reader.readLine().trim());
            if (choice >= 1 && choice <= genres.length) {
                return genres[choice - 1];
            }
        } catch (NumberFormatException ignored) {
        }

        System.out.println("Invalid selection. Defaulting to TECHNOLOGY.");
        return Genre.TECHNOLOGY;
    }
}