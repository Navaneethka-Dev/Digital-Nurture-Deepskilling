import React from 'react';
import CalculateScore from './components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore Name="John Doe" School="Cognizant Academy" Total={450} Goal={500} />
    </div>
  );
}

export default App;
