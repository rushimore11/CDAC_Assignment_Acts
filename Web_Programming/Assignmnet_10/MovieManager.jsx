import React, { useState } from 'react';

export default function MovieManager() {
  const [movies, setMovies] = useState([]);
  const [formData, setFormData] = useState({
    movieName: '',
    actor: '',
    releaseDate: '',
    movieTypes: [], 
    state: ''
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleCheckboxChange = (e) => {
    const { value, checked } = e.target;
    let updatedTypes = [...formData.movieTypes];
    if (checked) {
      updatedTypes.push(value);
    } else {
      updatedTypes = updatedTypes.filter((type) => type !== value);
    }
    setFormData({ ...formData, movieTypes: updatedTypes });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!formData.movieName || !formData.actor || !formData.state) {
      alert("Please fill all required fields");
      return;
    }
    setMovies([...movies, formData]);
    // Reset Form
    setFormData({ movieName: '', actor: '', releaseDate: '', movieTypes: [], state: '' });
  };

  return (
    <div style={{ padding: '20px', border: '1px solid #ccc', marginTop: '20px' }}>
      <h2>Movie Manager (Compulsory Q5)</h2>
      <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '10px', maxWidth: '400px' }}>
        <input type="text" name="movieName" value={formData.movieName} onChange={handleInputChange} placeholder="Movie Name" required />
        <input type="text" name="actor" value={formData.actor} onChange={handleInputChange} placeholder="Actor" required />
        <input type="date" name="releaseDate" value={formData.releaseDate} onChange={handleInputChange} required />
        
        <div>
          <label>Movie Type: </label>
          <label><input type="checkbox" value="2D" checked={formData.movieTypes.includes("2D")} onChange={handleCheckboxChange} /> 2D</label>
          <label style={{ marginLeft: '10px' }}><input type="checkbox" value="3D" checked={formData.movieTypes.includes("3D")} onChange={handleCheckboxChange} /> 3D</label>
          <label style={{ marginLeft: '10px' }}><input type="checkbox" value="IMAX" checked={formData.movieTypes.includes("IMAX")} onChange={handleCheckboxChange} /> IMAX</label>
        </div>

        <select name="state" value={formData.state} onChange={handleInputChange} required>
          <option value="">--Select State--</option>
          <option value="Maharashtra">Maharashtra</option>
          <option value="Delhi">Delhi</option>
          <option value="Karnataka">Karnataka</option>
          <option value="Gujarat">Gujarat</option>
        </select>

        <button type="submit">Add Movie</button>
      </form>

      <table border="1" cellPadding="8" style={{ marginTop: '20px', width: '100%', borderCollapse: 'collapse', textAlign: 'left' }}>
        <thead>
          <tr style={{ backgroundColor: '#f2f2f2' }}>
            <th>Movie Name</th>
            <th>Actor</th>
            <th>Release Date</th>
            <th>Movie Type</th>
            <th>State</th>
          </tr>
        </thead>
        <tbody>
          {movies.length === 0 ? (
            <tr><td colSpan="5" style={{ textAlign: 'center' }}>No movie records added yet.</td></tr>
          ) : (
            movies.map((movie, index) => (
              <tr key={index}>
                <td>{movie.movieName}</td>
                <td>{movie.actor}</td>
                <td>{movie.releaseDate}</td>
                <td>{movie.movieTypes.join(', ') || 'N/A'}</td>
                <td>{movie.state}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}
