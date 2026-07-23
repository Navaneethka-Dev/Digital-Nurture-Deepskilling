import React from 'react';
import './App.css';

function App() {
  const pageHeading = <h1>Office Space Rental App</h1>;
  const officeImage = <img src="https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&w=800&q=80" alt="Office Space" style={{ width: '100%', maxHeight: '400px', objectFit: 'cover', borderRadius: '10px' }} />;

  const offices = [
    { id: 1, name: 'Downtown Tech Hub', rent: 75000, address: '123 Main St, Cityville' },
    { id: 2, name: 'Startup Garage', rent: 45000, address: '456 Innovation Blvd, Tech Town' },
    { id: 3, name: 'Corporate Tower Suite', rent: 120000, address: '789 Business Ave, Metropolis' },
    { id: 4, name: 'Co-working Corner', rent: 30000, address: '101 Shared Space Rd, Suburbia' }
  ];

  return (
    <div className="App" style={{ padding: '20px', fontFamily: 'Arial, sans-serif', maxWidth: '1200px', margin: '0 auto', textAlign: 'left' }}>
      {pageHeading}
      <div style={{ marginBottom: '30px' }}>
        {officeImage}
      </div>
      
      <h2>Available Office Spaces</h2>
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(250px, 1fr))', gap: '20px' }}>
        {offices.map(office => (
          <div key={office.id} style={{ border: '1px solid #ddd', padding: '20px', borderRadius: '8px', backgroundColor: '#f9f9f9' }}>
            <h3 style={{ marginTop: 0 }}>{office.name}</h3>
            <p><strong>Address:</strong> {office.address}</p>
            <p style={{ fontSize: '18px' }}>
              <strong>Rent:</strong> 
              <span style={{ 
                color: office.rent < 60000 ? 'red' : 'green',
                fontWeight: 'bold',
                marginLeft: '10px'
              }}>
                Rs. {office.rent.toLocaleString()}
              </span>
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
