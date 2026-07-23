import React, { useState } from 'react';
import './App.css';

const GuestPage = ({ onLogin }) => (
  <div style={{ border: '1px solid #ccc', padding: '30px', borderRadius: '8px', backgroundColor: '#f9f9f9', marginTop: '20px' }}>
    <h2 style={{ color: '#333' }}>Welcome Guest!</h2>
    <p style={{ fontSize: '16px' }}>Please browse our available flights below:</p>
    
    <ul style={{ listStyleType: 'none', padding: 0, fontSize: '18px', textAlign: 'left', display: 'inline-block' }}>
      <li style={{ padding: '10px 0', borderBottom: '1px solid #eee' }}>✈️ Flight AI-101: New York to London</li>
      <li style={{ padding: '10px 0', borderBottom: '1px solid #eee' }}>✈️ Flight AI-202: Tokyo to Sydney</li>
      <li style={{ padding: '10px 0', borderBottom: '1px solid #eee' }}>✈️ Flight AI-303: Paris to Berlin</li>
      <li style={{ padding: '10px 0' }}>✈️ Flight AI-404: Dubai to Mumbai</li>
    </ul>

    <div style={{ marginTop: '30px', padding: '15px', backgroundColor: '#ffe6e6', borderRadius: '5px' }}>
      <p style={{ color: '#d32f2f', fontWeight: 'bold', margin: '0 0 15px 0' }}>You must be logged in to book tickets.</p>
      <button 
        onClick={onLogin} 
        style={{ padding: '10px 25px', backgroundColor: '#4CAF50', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer', fontSize: '16px', fontWeight: 'bold' }}>
        Login to Book
      </button>
    </div>
  </div>
);

const UserPage = ({ onLogout }) => (
  <div style={{ border: '1px solid #c8e6c9', padding: '30px', borderRadius: '8px', backgroundColor: '#e8f5e9', marginTop: '20px' }}>
    <h2 style={{ color: '#2e7d32' }}>Welcome Back, User!</h2>
    <p style={{ fontSize: '16px', color: '#1b5e20' }}>You are securely logged in. You can now proceed to book your tickets.</p>
    
    <div style={{ marginTop: '30px' }}>
      <button 
        onClick={() => alert('Booking interface opened!')} 
        style={{ padding: '10px 25px', backgroundColor: '#0288d1', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer', fontSize: '16px', fontWeight: 'bold', marginRight: '15px' }}>
        Book Tickets Now
      </button>
      
      <button 
        onClick={onLogout} 
        style={{ padding: '10px 25px', backgroundColor: '#d32f2f', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer', fontSize: '16px', fontWeight: 'bold' }}>
        Logout
      </button>
    </div>
  </div>
);

function App() {
  // Conditional rendering state
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div className="App" style={{ maxWidth: '700px', margin: '40px auto', fontFamily: 'Arial, sans-serif', textAlign: 'center' }}>
      <h1>Ticket Booking App</h1>
      <p style={{ color: '#666', fontStyle: 'italic' }}>Demonstrating Conditional Rendering in React</p>
      
      {/* Conditional Rendering logic */}
      {isLoggedIn ? (
        <UserPage onLogout={() => setIsLoggedIn(false)} />
      ) : (
        <GuestPage onLogin={() => setIsLoggedIn(true)} />
      )}
      
    </div>
  );
}

export default App;
