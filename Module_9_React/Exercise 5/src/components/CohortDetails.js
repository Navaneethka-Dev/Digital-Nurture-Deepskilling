import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ cohort }) {
  const h3Style = {
    color: cohort.status.toLowerCase() === 'ongoing' ? 'green' : 'blue'
  };

  return (
    <div className={styles.box}>
      <dl>
        <dt>Cohort Name: {cohort.name}</dt>
        <dt>Status: {cohort.status}</dt>
        <dt>Students: {cohort.students}</dt>
      </dl>
      <h3 style={h3Style}>
        {cohort.status === 'Ongoing' ? 'In Progress' : 'Completed'}
      </h3>
    </div>
  );
}

export default CohortDetails;
