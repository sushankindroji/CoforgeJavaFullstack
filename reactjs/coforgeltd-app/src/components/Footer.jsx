import React from 'react'
import '../styles/Footer.css'

function Footer() {
  const currentYear = new Date().getFullYear()

  return (
    <footer className="footer">
      <div className="footer-content">
        <div className="footer-section">
          <h3>ReactVite App</h3>
          <p>A modern React application built with Vite and React Router.</p>
        </div>

        <div className="footer-section">
          <h4>Technologies</h4>
          <div className="tech-tags">
            <span className="tech-tag">React 19</span>
            <span className="tech-tag">Vite</span>
            <span className="tech-tag">React Router</span>
            <span className="tech-tag">CSS3</span>
          </div>
        </div>
      </div>

      <div className="footer-bottom">
        <p>&copy; {currentYear} ReactVite App. All rights reserved.</p>
      </div>
    </footer>
  )
}

export default Footer
