import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Virat', score: 100 },
    { name: 'Rohit', score: 85 },
    { name: 'Dhoni', score: 95 },
    { name: 'Rahul', score: 65 },
    { name: 'Sachin', score: 120 },
    { name: 'Yuvraj', score: 72 },
    { name: 'Pant', score: 50 },
    { name: 'Hardik', score: 68 },
    { name: 'Jadeja', score: 45 },
    { name: 'Ashwin', score: 30 },
    { name: 'Bumrah', score: 15 }
  ];

  const playersBelow70 = players.filter(player => player.score <= 70);

  return (
    <div>
      <h2>List of Players (Using ES6 map)</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - Score: {player.score}</li>
        ))}
      </ul>
      <h2>Players with scores 70 or below (Using ES6 arrow functions and filter)</h2>
      <ul>
        {playersBelow70.map((player, index) => (
          <li key={index}>{player.name} - Score: {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
