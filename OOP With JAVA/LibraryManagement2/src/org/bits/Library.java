package org.bits;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    // 1. Map using BookId as Key and Book as Value
    private final Map<BookId, Book> mapIdToBook = new HashMap<>();

    // 2. Map using Book object as Key and BookId as Value
    private final Map<Book, BookId> mapBookToId = new HashMap<>();

    // 3. Enum-based storage grouping books by Genre
    private final Map<Genre, List<Book>> genreStorage = new EnumMap<>(Genre.class);

    public Library() {
        // Initialize lists for every genre in EnumMap
        for (Genre g : Genre.values()) {
            genreStorage.put(g, new ArrayList<>());
        }
    }

    public void addBook(Book book) {
        mapIdToBook.put(book.bookId(), book);
        mapBookToId.put(book, book.bookId());
        genreStorage.get(book.genre()).add(book);
    }

    public Book findBookById(BookId bookId) {
        return mapIdToBook.get(bookId);
    }

    public BookId findIdByBook(Book book) {
        return mapBookToId.get(book);
    }

    public Book removeBook(BookId bookId) {
        Book removedBook = mapIdToBook.remove(bookId);
        if (removedBook != null) {
            mapBookToId.remove(removedBook);
            genreStorage.get(removedBook.genre()).remove(removedBook);
        }
        return removedBook;
    }

    public void displayBooks() {
        if (mapIdToBook.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (Book book : mapIdToBook.values()) {
            System.out.println(book);
        }
    }

    public void sortAndDisplayByName() {
        List<Book> bookList = new ArrayList<>(mapIdToBook.values());
        if (bookList.isEmpty()) {
            System.out.println("The list is empty");
            return;
        }

        bookList.sort(Comparator.comparing(Book::name));

        System.out.println("--- Sorted Books by Name ---");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void displayBooksByGenre(Genre genre) {
        System.out.println("--- Books under Genre: " + genre + " ---");
        List<Book> books = genreStorage.get(genre);
        if (books.isEmpty()) {
            System.out.println("No books found for this genre.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }
}