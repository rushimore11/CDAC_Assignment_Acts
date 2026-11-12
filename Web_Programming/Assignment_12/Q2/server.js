import express from "express";
import cors from "cors";

const app = express();

app.use(cors());
app.use(express.json());

let books = [];

// Display Books
app.get("/books", (req, res) => {
    res.json(books);
});

// Create Book
app.post("/books", (req, res) => {

    const book = {
        id: Date.now(),
        bookname: req.body.bookname,
        author: req.body.author,
        publish_year: req.body.publish_year,
        ISBN_no: req.body.ISBN_no
    };

    books.push(book);

    res.status(201).json(book);
});

// Delete Book
app.delete("/books/:id", (req, res) => {

    const id = Number(req.params.id);

    books = books.filter(book => book.id !== id);

    res.json({
        message: "Book deleted successfully"
    });
});

// Start Server
app.listen(5000, () => {
    console.log("Server running on port 5000");
});