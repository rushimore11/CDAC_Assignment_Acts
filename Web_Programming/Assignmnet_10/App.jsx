

//QUESTION 5
import React from 'react';
import { StructureA, StructureB, StructureC, StructureD } from './Question2Components';
import Calculator from './Calculator';
import FriendsList from './FriendsList';
import MovieManager from './MovieManager';

function App() {
  return (
    <div style={{ padding: '30px', fontFamily: 'Segoe UI, sans-serif', maxWidth: '900px', margin: '0 auto' }}>
      <h1>React Lab Assignment Solutions</h1>
      <hr />
      
      <section style={{ margin: '20px 0' }}>
        <h2>Q1: Setup Status</h2>
        <p style={{ fontWeight: 'bold', color: 'green' }}>Hello Rushikesh</p>
      </section>

      <section style={{ margin: '20px 0' }}>
        <h2>Q2: Component Trees</h2>
        <h4>a) A &lt;- B &lt;- C</h4>
        <StructureA />
        <h4>b) B and C in A, A in App</h4>
        <StructureB />
        <h4>c) A, B, C in App</h4>
        <StructureC />
        <h4>d) A in B and C, B and C in App</h4>
        <StructureD />
      </section>

      <section style={{ margin: '20px 0' }}>
        <h2>Q3: Arithmetic Operations</h2>
        <Calculator />
      </section>

      <section style={{ margin: '20px 0' }}>
        <h2>Q4: Add Friends Intake</h2>
        <FriendsList />
      </section>

      <section style={{ margin: '20px 0' }}>
        <h2>Q5: Dynamic Movie Database Matrix (Compulsory)</h2>
        <MovieManager />
      </section>
    </div>
  );
}

export default App;

