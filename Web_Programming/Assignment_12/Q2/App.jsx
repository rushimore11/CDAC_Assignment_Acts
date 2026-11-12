import React, { useState, useContext } from "react";
import { BookContext } from "./BookContext";

function App() {

    const { books, addBook, deleteBook } = useContext(BookContext);

    const [bookname, setBookname] = useState("");
    const [author, setAuthor] = useState("");
    const [publish_year, setPublishYear] = useState("");
    const [ISBN_no, setISBN] = useState("");

    function handleSubmit(e) {

        e.preventDefault();

        const book = {
            bookname,
            author,
            publish_year: Number(publish_year),
            ISBN_no
        };

        addBook(book);

        setBookname("");
        setAuthor("");
        setPublishYear("");
        setISBN("");
    }

    return (
        <div>

            <h1>Book Management System</h1>

            <h2>Create Book</h2>

            <form onSubmit={handleSubmit}>

                Book Name:
                <input
                    type="text"
                    value={bookname}
                    onChange={e => setBookname(e.target.value)}
                    required
                />

                <br /><br />

                Author:
                <input
                    type="text"
                    value={author}
                    onChange={e => setAuthor(e.target.value)}
                    required
                />

                <br /><br />

                Publish Year:
                <input
                    type="number"
                    value={publish_year}
                    onChange={e => setPublishYear(e.target.value)}
                    required
                />

                <br /><br />

                ISBN Number:
                <input
                    type="text"
                    value={ISBN_no}
                    onChange={e => setISBN(e.target.value)}
                    required
                />

                <br /><br />

                <button type="submit">Create Book</button>

            </form>

            <h2>Display Books</h2>

            <table border="1" cellPadding="10">

                <thead>
                    <tr>
                        <th>Book Name</th>
                        <th>Author</th>
                        <th>Publish Year</th>
                        <th>ISBN Number</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>

                    {books.map(book => (

                        <tr key={book.id}>

                            <td>{book.bookname}</td>
                            <td>{book.author}</td>
                            <td>{book.publish_year}</td>
                            <td>{book.ISBN_no}</td>

                            <td>
                                <button
                                    onClick={() => deleteBook(book.id)}
                                >
                                    Delete
                                </button>
                            </td>

                        </tr>

                    ))}

                </tbody>

            </table>

        </div>
    );
}

export default App;