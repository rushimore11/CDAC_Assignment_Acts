import React, { useState } from 'react';

// ==========================================
// Sub-Components for Operations
// ==========================================
const Addition = ({ num1, num2 }) => (
  <div style={{ padding: '5px 0', color: '#1b5e20' }}>
    <strong>Addition:</strong> {num1} + {num2} = {num1 + num2}
  </div>
);

const Subtraction = ({ num1, num2 }) => (
  <div style={{ padding: '5px 0', color: '#b71c1c' }}>
    <strong>Subtraction:</strong> {num1} - {num2} = {num1 - num2}
  </div>
);

const Multiplication = ({ num1, num2 }) => (
  <div style={{ padding: '5px 0', color: '#e65100' }}>
    <strong>Multiplication:</strong> {num1} × {num2} = {num1 * num2}
  </div>
);

const Division = ({ num1, num2 }) => (
  <div style={{ padding: '5px 0', color: '#0d47a1' }}>
    <strong>Division:</strong> {num2 !== 0 ? `${num1} ÷ ${num2} = ${(num1 / num2).toFixed(2)}` : "Cannot divide by zero"}
  </div>
);

// ==========================================
// Main Calculator Dashboard
// ==========================================
export default function Calculator() {
  const [n1, setN1] = useState(0);
  const [n2, setN2] = useState(0);

  return (
    <div style={{ 
      padding: '20px', 
      border: '2px solid #ccc', 
      borderRadius: '8px',
      backgroundColor: '#f9f9f9',
      maxWidth: '450px',
      margin: '20px 0'
    }}>
      <h3 style={{ marginTop: 0 }}>Question 3: Arithmetic Calculator</h3>
      
      {/* Input Group Controllers */}
      <div style={{ marginBottom: '15px', display: 'flex', gap: '10px' }}>
        <div style={{ flex: 1 }}>
          <label style={{ display: 'block', marginBottom: '5px' }}>Number 1:</label>
          <input 
            type="number" 
            value={n1}
            onChange={(e) => setN1(Number(e.target.value))} 
            style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
            placeholder="Enter first number" 
          />
        </div>
        <div style={{ flex: 1 }}>
          <label style={{ display: 'block', marginBottom: '5px' }}>Number 2:</label>
          <input 
            type="number" 
            value={n2}
            onChange={(e) => setN2(Number(e.target.value))} 
            style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
            placeholder="Enter second number" 
          />
        </div>
      </div>
      
      {/* Rendering the four distinct mathematical sub-components */}
      <div style={{ 
        borderTop: '1px solid #ddd', 
        paddingTop: '10px', 
        fontSize: '16px',
        lineHeight: '1.6' 
      }}>
        <h4 style={{ margin: '5px 0' }}>Results Matrix:</h4>
        <Addition num1={n1} num2={n2} />
        <Subtraction num1={n1} num2={n2} />
        <Multiplication num1={n1} num2={n2} />
        <Division num1={n1} num2={n2} />
      </div>
    </div>
  );
}
