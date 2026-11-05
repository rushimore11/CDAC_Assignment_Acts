import React, { useState, useEffect } from 'react';

// ==========================================
// 1. MOVIE TABLE COMPONENT (Child Component)
// ==========================================
function MovieTable({ movies, onDeleteMovie }) {
  return (
    <div style={{ marginTop: '30px', overflowX: 'auto' }}>
      <h2 style={{ color: '#61dafb', borderBottom: '1px solid #333', paddingBottom: '10px' }}> Published Movies</h2>
      {movies.length === 0 ? (
        <p style={{ color: '#aaa', italic: 'true' }}>No movies added yet. Use the form above to add one!</p>
      ) : (
        <table style={{ width: '100%', borderCollapse: 'collapse', marginTop: '10px', color: '#e0e0e0' }}>
          <thead>
            <tr style={{ backgroundColor: '#20232a', textAlign: 'left', color: '#61dafb' }}>
              <th style={tableHeaderStyle}>Movie Name</th>
              <th style={tableHeaderStyle}>Actor / Description</th>
              <th style={tableHeaderStyle}>Release Date</th>
              <th style={tableHeaderStyle}>Format (Type)</th>
              <th style={tableHeaderStyle}>State / Location</th>
              <th style={tableHeaderStyle}>Price</th>
              <th style={tableHeaderStyle}>Seats Available</th>
              <th style={tableHeaderStyle}>Actions</th>
            </tr>
          </thead>
          <tbody>
            {movies.map((movie) => (
              <tr key={movie.id || movie._id} style={{ borderBottom: '1px solid #282c34', backgroundColor: '#1a1c22' }}>
                <td style={tableCellStyle}><strong style={{ color: '#ffffff' }}>{movie.movieName}</strong></td>
                <td style={tableCellStyle}>{movie.actor || movie.description}</td>
                <td style={tableCellStyle}>{movie.releaseDate || movie.release}</td>
                <td style={tableCellStyle}>
                  <span style={{ backgroundColor: '#282c34', padding: '3px 8px', borderRadius: '4px', border: '1px solid #444' }}>
                    {Array.isArray(movie.movieType) ? movie.movieType.join(', ') : movie.movieType}
                  </span>
                </td>
                <td style={tableCellStyle}>{movie.state}</td>
                <td style={{ ...tableCellStyle, color: '#4caf50', fontWeight: 'bold' }}>₹{movie.price || 'N/A'}</td>
                <td style={tableCellStyle}>{movie.seat || 'N/A'}</td>
                <td style={tableCellStyle}>
                  <button 
                    onClick={() => onDeleteMovie(movie.id || movie._id)}
                    style={{ backgroundColor: '#ff4d4d', color: 'white', border: 'none', padding: '6px 12px', borderRadius: '4px', cursor: 'pointer', fontWeight: 'bold' }}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

// ==========================================
// 2. MAIN APP COMPONENT (Parent Component)
// ==========================================
export default function App() {
  const [movies, setMovies] = useState([]);
  const [formData, setFormData] = useState({
    movieName: '',
    actor: '',
    description: '',
    releaseDate: '',
    price: '',
    seat: '',
    movieType: [],
    state: ''
  });

  const API_URL = 'https://example.com'; 

  const fetchMovies = async () => {
    try {
      const response = await fetch(API_URL);
      if (response.ok) {
        const data = await response.json();
        setMovies(data);
      }
    } catch (error) {
      console.log("Running in dark-mode offline fallback layout.");
    }
  };

  useEffect(() => {
    fetchMovies();
  }, []);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleCheckboxChange = (e) => {
    const { value, checked } = e.target;
    let updatedTypes = [...formData.movieType];
    if (checked) {
      updatedTypes.push(value);
    } else {
      updatedTypes = updatedTypes.filter((type) => type !== value);
    }
    setFormData({ ...formData, movieType: updatedTypes });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const payload = { ...formData, release: formData.releaseDate };

    try {
      const response = await fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload),
      });
      if (response.ok) {
        fetchMovies();
      } else {
        setMovies([...movies, { ...payload, id: Date.now().toString() }]);
      }
    } catch (error) {
      setMovies([...movies, { ...payload, id: Date.now().toString() }]);
    }

    setFormData({
      movieName: '', actor: '', description: '', releaseDate: '', price: '', seat: '', movieType: [], state: ''
    });
  };

  const handleDeleteMovie = async (id) => {
    try {
      const response = await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
      if (response.ok) { fetchMovies(); } 
      else { setMovies(movies.filter((movie) => (movie.id || movie._id) !== id)); }
    } catch (error) {
      setMovies(movies.filter((movie) => (movie.id || movie._id) !== id));
    }
  };

  return (
    <div style={globalContainerStyle}>
      <h1 style={{ textAlign: 'center', color: '#61dafb', marginBottom: '25px' }}> Movie Management Dashboard</h1>
      
      {/* Dark Styled Movie Form */}
      <form onSubmit={handleSubmit} style={formStyle}>
        <h2 style={{ color: '#ffffff', marginTop: 0, marginBottom: '20px', borderBottom: '1px solid #444', paddingBottom: '10px' }}> Add New Movie</h2>
        
        <div style={inputGroupStyle}>
          <label style={labelStyle}>Movie Name:</label>
          <input type="text" name="movieName" value={formData.movieName} onChange={handleInputChange} required style={inputStyle} />
        </div>

        <div style={inputGroupStyle}>
          <label style={labelStyle}>Actor Name:</label>
          <input type="text" name="actor" value={formData.actor} onChange={handleInputChange} style={inputStyle} />
        </div>

        <div style={inputGroupStyle}>
          <label style={labelStyle}>Description:</label>
          <textarea name="description" value={formData.description} onChange={handleInputChange} style={{ ...inputStyle, minHeight: '60px', resize: 'vertical' }} />
        </div>

        <div style={inputGroupStyle}>
          <label style={labelStyle}>Release Date:</label>
          <input type="date" name="releaseDate" value={formData.releaseDate} onChange={handleInputChange} required style={inputStyle} />
        </div>

        <div style={{ display: 'flex', gap: '15px' }}>
          <div style={{ ...inputGroupStyle, flex: 1 }}>
            <label style={labelStyle}>Ticket Price (₹):</label>
            <input type="number" name="price" value={formData.price} onChange={handleInputChange} style={inputStyle} />
          </div>
          <div style={{ ...inputGroupStyle, flex: 1 }}>
            <label style={labelStyle}>Seats Available:</label>
            <input type="number" name="seat" value={formData.seat} onChange={handleInputChange} style={inputStyle} />
          </div>
        </div>

        {/* Checkboxes in Dark Mode */}
        <div style={inputGroupStyle}>
          <label style={labelStyle}>Movie Type (Formats):</label>
          <div style={{ display: 'flex', gap: '20px', marginTop: '8px' }}>
            {['2D', '3D', 'IMAX'].map((type) => (
              <label key={type} style={{ color: '#e0e0e0', fontWeight: 'normal', cursor: 'pointer', display: 'flex', alignItems: 'center' }}>
                <input 
                  type="checkbox" 
                  value={type} 
                  checked={formData.movieType.includes(type)} 
                  onChange={handleCheckboxChange} 
                  style={{ marginRight: '8px', width: '16px', height: '16px', accentColor: '#61dafb' }}
                />
                {type}
              </label>
            ))}
          </div>
        </div>

        {/* Custom Dropdown in Dark Mode */}
        <div style={inputGroupStyle}>
          <label style={labelStyle}>State / Region:</label>
          <select name="state" value={formData.state} onChange={handleInputChange} required style={selectStyle}>
            <option value="" style={{ backgroundColor: '#21252b' }}>-- Select a State --</option>
            <option value="Maharashtra" style={{ backgroundColor: '#21252b' }}>Maharashtra</option>
            <option value="Delhi" style={{ backgroundColor: '#21252b' }}>Delhi</option>
            <option value="Karnataka" style={{ backgroundColor: '#21252b' }}>Karnataka</option>
            <option value="Gujarat" style={{ backgroundColor: '#21252b' }}>Gujarat</option>
          </select>
        </div>

        <button type="submit" style={submitButtonStyle}>Save Movie</button>
      </form>

      {/* Lifted Table */}
      <MovieTable movies={movies} onDeleteMovie={handleDeleteMovie} />
    </div>
  );
}

// ==========================================
// 3. DARK EMISSIVE VISUAL STYLE VARIABLES
// ==========================================
const globalContainerStyle = {
  backgroundColor: '#1c1e22',
  minHeight: '100vh',
  padding: '30px 20px',
  fontFamily: '"Segoe UI", Roboto, Helvetica, Arial, sans-serif',
  color: '#e0e0e0'
};
const formStyle = {
  background: '#21252b',
  padding: '25px',
  borderRadius: '8px',
  boxShadow: '0 4px 12px rgba(0,0,0,0.3)',
  border: '1px solid #2d3139'
};
const inputGroupStyle = {
  marginBottom: '20px', display: 'flex', flexDirection: 'column'
};
const labelStyle = {
  color: '#9da5b4', fontSize: '14px', fontWeight: '500', marginBottom: '5px'
};
const inputStyle = {
  padding: '10px',
  marginTop: '5px',
  borderRadius: '4px',
  border: '1px solid #3e4451',
  backgroundColor: '#282c34',
  color: '#ffffff',
  fontSize: '14px',
  outline: 'none'
};
const selectStyle = {
  ...inputStyle,
cursor: 'pointer'
};
const submitButtonStyle = {
width: '100%',
padding: '12px',
backgroundColor: '#61dafb',
color: '#1c1e22',
border: 'none',
borderRadius: '4px',
fontSize: '16px',
cursor: 'pointer',
fontWeight: 'bold',
transition: 'background-color 0.2s',
marginTop: '10px'
};
const tableHeaderStyle = {
padding: '14px 10px', borderBottom: '2px solid #3e4451', fontWeight: '600'
};
const tableCellStyle = {
padding: '12px 10px', color: '#ccc'
};