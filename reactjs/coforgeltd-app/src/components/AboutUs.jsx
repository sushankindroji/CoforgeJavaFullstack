import React from 'react'
import '../styles/AboutUs.css'

function AboutUs() {
  return (
    <section className="about-us">
      <div className="about-heading">
        <h2>About ReactVite App</h2>
        <p>A clean starter project built with React 19, Vite, and React Router.</p>
      </div>
      <div className="about-grid">
        <article>
          <h3>Lightweight</h3>
          <p>Fast development and optimized builds with Vite.</p>
        </article>
        <article>
          <h3>Flexible</h3>
          <p>Easy to extend with more pages and reusable components.</p>
        </article>
        <article>
          <h3>Interactive</h3>
          <p>Routes, animations, and layouts all already wired for you.</p>
        </article>
      </div>
    </section>
  )
}

export default AboutUs
