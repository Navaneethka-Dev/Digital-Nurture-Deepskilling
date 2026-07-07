import React from 'react';
import './index.css';

const handsOnLessons = [
  { id: 1, title: 'Introduction to React', desc: 'Understanding JSX and basic rendering' },
  { id: 2, title: 'Components & Props', desc: 'Building reusable UI components' },
  { id: 3, title: 'State & Lifecycle', desc: 'Managing state in class components' },
  { id: 4, title: 'Handling Events', desc: 'React synthetic events and binding' },
  { id: 5, title: 'Conditional Rendering', desc: 'Using logical operators and ternaries' },
  { id: 6, title: 'Lists and Keys', desc: 'Rendering arrays of data efficiently' },
  { id: 7, title: 'Forms in React', desc: 'Controlled and uncontrolled components' },
  { id: 8, title: 'Lifting State Up', desc: 'Sharing state between siblings' },
  { id: 9, title: 'Composition vs Inheritance', desc: 'Containment and specialized components' },
  { id: 10, title: 'Thinking in React', desc: 'Building a searchable product data table' },
  { id: 11, title: 'React Hooks Intro', desc: 'Using useState and useEffect' },
  { id: 12, title: 'Custom Hooks', desc: 'Extracting component logic' },
  { id: 13, title: 'Context API', desc: 'Avoiding prop drilling' },
  { id: 14, title: 'React Router', desc: 'Client-side routing fundamentals' },
  { id: 15, title: 'Error Boundaries', desc: 'Catching JavaScript errors in child tree' },
  { id: 16, title: 'Higher-Order Components', desc: 'Reusing component logic' },
  { id: 17, title: 'Performance Optimization', desc: 'React.memo and useMemo' },
];

function App() {
  return (
    <div>
      <div className="header">
        <h1>Digital Nurture - React.js</h1>
        <p>Complete 17 Hands-on Modules Implementation</p>
      </div>
      <div className="grid">
        {handsOnLessons.map(lesson => (
          <div key={lesson.id} className="card">
            <h3>Module {lesson.id}</h3>
            <p><strong>{lesson.title}</strong></p>
            <p>{lesson.desc}</p>
            <div className="status-badge">Completed</div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
