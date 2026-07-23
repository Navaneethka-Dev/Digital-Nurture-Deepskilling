import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  componentDidCatch(error, errorInfo) {
    alert("Error occurred in Posts component: " + error);
    this.setState({ hasError: true });
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        this.setState({ posts: data });
      })
      .catch(error => {
        alert("Error fetching posts: " + error);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  render() {
    if (this.state.hasError) {
      return <div>Something went wrong.</div>;
    }

    return (
      <div style={{ padding: '20px' }}>
        <h2>Blog Posts</h2>
        {this.state.posts.map(post => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}

export default Posts;
