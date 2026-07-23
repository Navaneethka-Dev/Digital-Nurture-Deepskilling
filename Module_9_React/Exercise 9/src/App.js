import React, { useState } from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';
import './App.css';

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div className="App" style={{ padding: '20px', textAlign: 'left' }}>
      <h1>Exercise 9</h1>
      <button onClick={() => setFlag(!flag)} style={{ marginBottom: '20px', padding: '10px' }}>
        Toggle Flag (Current: {flag.toString()})
      </button>
      
      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;
