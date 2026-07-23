import React from 'react';

const IndianPlayers = () => {
  const oddTeam = ['Sachin', 'Dhoni', 'Yuvraj'];
  const evenTeam = ['Virat', 'Rohit', 'Rahul'];
  
  
  const [odd1, odd2, odd3] = oddTeam;
  const [even1, even2, even3] = evenTeam;

  const T20players = ['Hardik', 'Pant', 'Bumrah'];
  const RanjiTrophyPlayers = ['Jadeja', 'Ashwin', 'Shami'];

  
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Team Players (Using Destructuring)</h2>
      <p>Player 1: {odd1}</p>
      <p>Player 2: {odd2}</p>
      <p>Player 3: {odd3}</p>
      
      <h2>Even Team Players (Using Destructuring)</h2>
      <p>Player 1: {even1}</p>
      <p>Player 2: {even2}</p>
      <p>Player 3: {even3}</p>
      
      <h2>Merged Team Players (Using Spread Operator)</h2>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
