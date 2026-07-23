import React from 'react';
import './Dashboard.css';
import CohortDetails from './CohortDetails';

function Dashboard() {
  const cohorts = [
    { id: 1, name: 'React Developers', status: 'Ongoing', students: 25 },
    { id: 2, name: 'Java Spring Boot', status: 'Completed', students: 30 },
    { id: 3, name: 'Data Engineering', status: 'Ongoing', students: 20 },
  ];

  return (
    <div className="dashboard">
      <header className="dashboard-header">
        <h1>My Academy Dashboard</h1>
      </header>
      <div className="cohorts-grid">
        {cohorts.map(c => (
          <CohortDetails key={c.id} cohort={c} />
        ))}
      </div>
    </div>
  );
}

export default Dashboard;
