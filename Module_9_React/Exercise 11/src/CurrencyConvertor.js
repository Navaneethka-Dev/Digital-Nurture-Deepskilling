import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!rupees || isNaN(rupees)) {
      alert('Please enter a valid amount in Rupees');
      return;
    }
    // Assuming an arbitrary conversion rate, e.g., 1 Euro = 90 Rupees
    const converted = (parseFloat(rupees) / 90).toFixed(2);
    setEuros(converted);
  };

  return (
    <div style={{ marginTop: '30px', padding: '20px', border: '1px solid #ddd', borderRadius: '5px' }}>
      <h2>Currency Convertor</h2>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label>Indian Rupees: </label>
          <input 
            type="number" 
            value={rupees} 
            onChange={(e) => setRupees(e.target.value)} 
            placeholder="Enter INR amount" 
            style={{ marginLeft: '10px', padding: '5px' }}
          />
        </div>
        <button type="submit" style={{ padding: '8px 15px' }}>Convert</button>
      </form>
      
      {euros !== null && (
        <h3 style={{ marginTop: '20px', color: '#2c3e50' }}>
          Equivalent Euros: €{euros}
        </h3>
      )}
    </div>
  );
};

export default CurrencyConvertor;
