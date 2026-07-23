import React from 'react';
import './Stylesheets/mystyle.css';

function CalculateScore({ Name, School, Total, Goal }) {
  const average = Goal > 0 ? ((Total / Goal) * 100).toFixed(2) : 0;

  return (
    <div className="score-container">
      <h2>Student Details</h2>
      <div className="student-info">
        <p><strong>Name:</strong> {Name}</p>
        <p><strong>School:</strong> {School}</p>
        <p><strong>Total Marks:</strong> {Total}</p>
        <p><strong>Goal (Max Marks):</strong> {Goal}</p>
        <p className="average"><strong>Average Score:</strong> {average}%</p>
      </div>
    </div>
  );
}

export default CalculateScore;
