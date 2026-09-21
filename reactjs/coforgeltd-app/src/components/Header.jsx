import React from "react";
import '../styles/Header.css';
import reactLogo from '../assets/react.svg';

function Header() {
  return (
     <header className="header">
      <div className="header-container">
        <div className="logo-section">
          <img src={reactLogo} className="react-logo" alt="React logo" />
          <h1 className="logo">ReactVite App</h1>
        </div>
        <p className="tagline">Built with React 19 & Vite</p>
      </div>
    </header>
  );
}

export default Header