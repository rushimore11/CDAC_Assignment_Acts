package org.bits;

public record Book(
    BookId bookId,
    String name,
    String author,
    int yearOfPublication,
    Genre genre
) {
}