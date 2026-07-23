import React, { Component } from 'react';

class Post extends Component {
  render() {
    const { title, body } = this.props;
    return (
      <div style={{ 
        border: '1px solid #ccc', 
        borderRadius: '5px',
        margin: '10px 0', 
        padding: '15px',
        backgroundColor: '#f9f9f9'
      }}>
        <h3 style={{ marginTop: 0 }}>{title}</h3>
        <p style={{ marginBottom: 0 }}>{body}</p>
      </div>
    );
  }
}

export default Post;
