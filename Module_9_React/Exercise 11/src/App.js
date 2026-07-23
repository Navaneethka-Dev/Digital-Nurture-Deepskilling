import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';
import './App.css';

function App() {
  const [counter, setCounter] = useState(0);

  const handleIncrement = () => {
    setCounter(prev => prev + 1);
    alert('Say Hello! - Static message triggered by Increment button');
  };

  const handleDecrement = () => {
    setCounter(prev => prev - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handleOnPress = (event) => {
    alert('I was clicked! Event type: ' + event.type);
  };

  return (
    <div className="App" style={{ padding: '20px', textAlign: 'left', maxWidth: '800px', margin: '0 auto' }}>
      <h1>Exercise 11: React Events</h1>
      
      <div style={{ marginBottom: '30px', padding: '20px', backgroundColor: '#f0f8ff', borderRadius: '5px' }}>
        <h2>Counter: {counter}</h2>
        <button onClick={handleIncrement} style={{ marginRight: '10px', padding: '10px' }}>Increment</button>
        <button onClick={handleDecrement} style={{ padding: '10px' }}>Decrement</button>
      </div>

      <div style={{ marginBottom: '30px', padding: '20px', backgroundColor: '#f5f5f5', borderRadius: '5px' }}>
        <h2>Say Welcome Event</h2>
        <button onClick={() => sayWelcome('welcome')} style={{ padding: '10px' }}>Say Welcome</button>
      </div>

      <div style={{ marginBottom: '30px', padding: '20px', backgroundColor: '#fff5ee', borderRadius: '5px' }}>
        <h2>Synthetic Event</h2>
        <button onClick={handleOnPress} style={{ padding: '10px' }}>OnPress Button</button>
      </div>

      <CurrencyConvertor />
    </div>
  );
}

export default App;
