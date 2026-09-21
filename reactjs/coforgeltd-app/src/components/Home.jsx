import React from 'react'
import '../styles/Home.css'

function Home() {
  return (
    <section className="home-page">
      <div className="home-banner">
        <h2>Welcome to ReactVite</h2>
        <p>Modern React app powered by Vite and React Router with smooth animations.</p>
      </div>
      <div className="home-cards">
        <article>
          <h3>Fast</h3>
          <p>Instant page loads and minimal setup with Vite.</p>
        </article>
        <article>
          <h3>Reactive</h3>
          <p>Component-driven UI updated with live state changes.</p>
        </article>
        <article>
          <h3>Organized</h3>
          <p>Routes and components make the app easy to extend.</p>
        </article>
      </div>
    </section>
  )
}

export default Home
