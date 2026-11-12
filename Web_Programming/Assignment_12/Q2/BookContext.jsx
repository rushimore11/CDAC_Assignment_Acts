import React, { createContext, useState, useEffect } from "react";

export const BookContext = createContext();

export function BookProvider({ children }) {

    const [books, setBooks] = useState([]);

    // Fetch Books
    useEffect(() => {

        fetch("http://localhost:5000/books")
            .then(res => res.json())
            .then(data => setBooks(data))
            .catch(err => console.log(err));

    }, []);

    // Add Book
    function addBook(book) {

        fetch("http://localhost:5000/books", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(book)
        })
        .then(res => res.json())
        .then(data => {
            setBooks(prevBooks => [...prevBooks, data]);
        })
        .catch(err => console.log(err));
    }

    // Delete Book
    function deleteBook(id) {

        fetch(`http://localhost:5000/books/${id}`, {
            method: "DELETE"
        })
        .then(res => res.json())
        .then(() => {
            setBooks(prevBooks =>
                prevBooks.filter(book => book.id !== id)
            );
        })
        .catch(err => console.log(err));
    }

    return (
        <BookContext.Provider value={{ books, addBook, deleteBook }}>
            {children}
        </BookContext.Provider>
    );
}