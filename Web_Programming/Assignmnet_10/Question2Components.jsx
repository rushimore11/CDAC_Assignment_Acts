import React from 'react';

// ==========================================
// Base Components Definition
// ==========================================
export const ComponentC = ({ children }) => (
  <div style={{ border: '2px solid red', padding: '10px', margin: '8px', borderRadius: '4px' }}>
    <strong>Component C</strong>
    {children}
  </div>
);

export const ComponentB = ({ children }) => (
  <div style={{ border: '2px solid green', padding: '10px', margin: '8px', borderRadius: '4px' }}>
    <strong>Component B</strong>
    {children}
  </div>
);

export const ComponentA = ({ children }) => (
  <div style={{ border: '2px solid blue', padding: '10px', margin: '8px', borderRadius: '4px' }}>
    <strong>Component A</strong>
    {children}
  </div>
);

// ==========================================
// Structural Tree Variations
// ==========================================

// Structure a) A <- B <- C (C inside B, B inside A)
export const StructureA = () => (
  <ComponentA>
    <ComponentB>
      <ComponentC />
    </ComponentB>
  </ComponentA>
);

// Structure b) Use B and C in A, Use A in App
export const StructureB = () => (
  <ComponentA>
    <ComponentB />
    <ComponentC />
  </ComponentA>
);

// Structure c) Use A and B and C parallelly in App
export const StructureC = () => (
  <>
    <ComponentA />
    <ComponentB />
    <ComponentC />
  </>
);

// Structure d) Use A in B and C, Use B and C in App
export const StructureD = () => (
  <>
    <ComponentB>
      <ComponentA />
    </ComponentB>
    <ComponentC>
      <ComponentA />
    </ComponentC>
  </>
);
