const express = require('express');
const cors = require('cors');

const app = express();
const PORT = 5000;

// ==========================================
// MIDDLEWARES
// ==========================================
app.use(cors()); // Enables cross-origin requests from your React App port
app.use(express.json()); // Essential body-parser middleware to read incoming req.body data

// In-memory array data structure mock acting as the movie database
let localMoviesDB = [
  {
    id: "1",
    movieName: "Inception",
    price: "250",
    seat: "80",
    description: "A thief who steals corporate secrets through the use of dream-sharing technology.",
    releaseDate: "2010-07-16",
    movieType: ["2D", "IMAX"],
    state: "Maharashtra"
  }
];

// ==========================================
// ROUTES (SECTION B FEATURES)
// ==========================================

// 1. SHOW MOVIE FEATURE (Read All Movies)
// HTTP Method: GET | Endpoint: http://localhost:5000/api/movies
app.get('/api/movies', (req, res) => {
  try {
    res.status(200).json(localMoviesDB);
  } catch (error) {
    res.status(500).json({ message: "Error retrieving movies from database.", error: error.message });
  }
});

// 2. ADD MOVIE FEATURE (Create a New Entry)
// HTTP Method: POST | Endpoint: http://localhost:5000/api/movies
app.post('/api/movies', (req, res) => {
  try {
    const { movieName, price, seat, description, releaseDate, movieType, state } = req.body; //

    // Compulsory Validation Rule check
    if (!movieName || !releaseDate || !state) {
      return res.status(400).json({ message: "Validation error: Missing mandatory movie fields." });
    }

    const newMovie = {
      id: Date.now().toString(), // Generates unique identifier string dynamically
      movieName,
      price: price || "0",
      seat: seat || "0",
      description: description || "",
      releaseDate,
      movieType: Array.isArray(movieType) ? movieType : [movieType],
      state
    };

    localMoviesDB.push(newMovie); //
    res.status(201).json({ message: "Movie added successfully!", data: newMovie }); //
  } catch (error) {
    res.status(500).json({ message: "Server encountered error parsing payload.", error: error.message });
  }
});

// 3. DELETE MOVIE FEATURE (Remove via ID)
// HTTP Method: DELETE | Endpoint: http://localhost:5000/api/movies/:id
app.delete('/api/movies/:id', (req, res) => {
  try {
    const movieId = req.params.id; // Extracts parameters safely from the request URL string
    
    // Checks if target record exists inside array index references
    const recordExists = localMoviesDB.some(movie => movie.id === movieId);
    
    if (!recordExists) {
      return res.status(404).json({ message: "Movie entry ID matching request target parameters not found." });
    }

    // Filter array to strip out target movie index match
    localMoviesDB = localMoviesDB.filter(movie => movie.id !== movieId);
    
    res.status(200).json({ message: `Movie with ID: ${movieId} dropped successfully.` });
  } catch (error) {
    res.status(500).json({ message: "Internal server cancellation error.", error: error.message });
  }
});

// ==========================================
// SERVER INITIALIZATION
// ==========================================
app.listen(PORT, () => {
  console.log(`🚀 Movie Backend Server running on: http://localhost:5000`);
});
