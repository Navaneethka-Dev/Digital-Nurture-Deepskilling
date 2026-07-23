import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';
import './App.css';

function App() {
  const [view, setView] = useState('');
  const [showCourse, setShowCourse] = useState(false);

  // Method 1: Using if/else statement
  const renderContentIfElse = () => {
    if (view === 'book') {
      return <BookDetails />;
    } else if (view === 'none') {
      return <p>Select an option above to see details.</p>;
    }
    return null;
  };

  // Method 4: Using switch statement
  const renderContentSwitch = () => {
    switch(view) {
      case 'book': return <BookDetails />;
      case 'blog': return <BlogDetails />;
      case 'course': return <CourseDetails />;
      default: return null;
    }
  };

  return (
    <div className="App" style={{ padding: '40px', maxWidth: '800px', margin: '0 auto', fontFamily: 'sans-serif' }}>
      <h1>Blogger App - Conditional Rendering</h1>
      
      <div style={{ marginBottom: '30px', padding: '20px', border: '1px dashed #ccc' }}>
        <h3>Controls</h3>
        <button onClick={() => setView('book')} style={btnStyle}>Show Book (if/else)</button>
        <button onClick={() => setView('blog')} style={btnStyle}>Show Blog (Ternary)</button>
        <button onClick={() => setShowCourse(!showCourse)} style={btnStyle}>Toggle Course (Logical &&)</button>
        <button onClick={() => setView('none')} style={btnStyle}>Clear All</button>
      </div>

      <div style={{ marginBottom: '20px' }}>
        <h3>1. if/else Rendering</h3>
        {renderContentIfElse()}
      </div>

      <div style={{ marginBottom: '20px' }}>
        <h3>2. Ternary Operator Rendering</h3>
        {view === 'blog' ? <BlogDetails /> : <p>Blog is currently hidden.</p>}
      </div>

      <div style={{ marginBottom: '20px' }}>
        <h3>3. Logical && Operator Rendering</h3>
        {showCourse && <CourseDetails />}
        {!showCourse && <p>Course is currently hidden.</p>}
      </div>

      <div style={{ marginBottom: '20px' }}>
        <h3>4. Switch Statement Rendering (All-in-one preview)</h3>
        {renderContentSwitch()}
      </div>

    </div>
  );
}

const btnStyle = {
  marginRight: '10px',
  padding: '10px 15px',
  cursor: 'pointer',
  backgroundColor: '#333',
  color: '#fff',
  border: 'none',
  borderRadius: '4px'
};

export default App;
