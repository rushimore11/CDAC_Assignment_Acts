import React, { useState } from 'react';

export default function FriendsList() {
  // State hook to manage our array collection of friend names
  const [friends, setFriends] = useState([]);
  
  // State hook to handle the raw continuous data typing inside our input box
  const [inputValue, setInputValue] = useState('');

  // Form submission interceptor to handle appending records cleanly
  const handleAddFriend = (e) => {
    e.preventDefault(); // Prevents the webpage from doing a hard refresh layout on form dispatch
    
    // Safety sanitation filter to block empty spacing submissions
    if (inputValue.trim() !== '') {
      setFriends([...friends, inputValue.trim()]); // Appends new element onto a copy of our current array
      setInputValue(''); // Wipes input clear for the next entry
    }
  };

  return (
    <div style={{ 
      padding: '20px', 
      border: '2px solid #ccc', 
      borderRadius: '8px', 
      backgroundColor: '#fbfbfb',
      maxWidth: '450px',
      margin: '20px 0',
      fontFamily: 'Arial, sans-serif'
    }}>
      <h3 style={{ marginTop: 0 }}>Question 4: Friends Registry</h3>
      
      {/* Input handling section wrapped inside a form asset block */}
      <form onSubmit={handleAddFriend} style={{ display: 'flex', gap: '10px', marginBottom: '15px' }}>
        <input 
          type="text" 
          value={inputValue} 
          onChange={(e) => setInputValue(e.target.value)} 
          placeholder="Enter friend's name..." 
          style={{ flex: 1, padding: '10px', borderRadius: '4px', border: '1px solid #ccc', fontSize: '14px' }}
        />
        <button 
          type="submit" 
          style={{ 
            padding: '10px 15px', 
            backgroundColor: '#4a148c', 
            color: '#fff', 
            border: 'none', 
            borderRadius: '4px', 
            cursor: 'pointer',
            fontSize: '14px',
            fontWeight: 'bold'
          }}
        >
          Add Name
        </button>
      </form>

      {/* Conditional statement interface to gracefully handle empty registries */}
      <div>
        <h4 style={{ margin: '10px 0 5px 0' }}>Current Network Connection List:</h4>
        {friends.length === 0 ? (
          <p style={{ color: '#777', fontStyle: 'italic', fontSize: '14px' }}>No names added to the network roster yet.</p>
        ) : (
          <ul style={{ paddingLeft: '20px', margin: 0, fontSize: '16px', lineHeight: '1.8' }}>
            {/* Map operator converts text values into distinct list items securely */}
            {friends.map((name, index) => (
              <li key={index} style={{ color: '#333' }}>{name}</li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
}
