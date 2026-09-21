import React, { useEffect, useState } from 'react'
import '../styles/Welcome.css'

function WelcomeChild({ title, message, highlight }) {
  return (
    <div className="welcome-child">
      <h3>{title}</h3>
      <p>{message}</p>
      {highlight && <span className="welcome-badge">{highlight}</span>}
    </div>
  )
}

function Welcome() {
  const [userName, setUserName] = useState('Ayesha')
  const [showChild, setShowChild] = useState(true)
  const welcomeMessage = 'You are learning how to structure parent and child components with props.'

  useEffect(() => {
    // simple side-effect to demonstrate hook usage
    document.title = `Welcome, ${userName}`
    return () => {
      document.title = 'ReactVite App'
    }
  }, [userName])

  return (
    <section className="welcome-page">
      <div className="welcome-card">
        <header className="welcome-header">
          <h1>Welcome Component Demo</h1>
          <p>
            This page shows how a parent component can render a child component and pass data via props.
          </p>
        </header>

        <div className="welcome-info">
          <div className="welcome-intro">
            <p className="welcome-text">
              Hi <strong>{userName}</strong>, thanks for visiting the ES6 React demo app.
            </p>
            <p>{welcomeMessage}</p>

            <div style={{ marginTop: 12 }}>
              <label>
                Edit name:{' '}
                <input value={userName} onChange={(e) => setUserName(e.target.value)} />
              </label>
            </div>

            <div style={{ marginTop: 10 }}>
              <button className="logout-btn" onClick={() => setShowChild((s) => !s)}>
                {showChild ? 'Hide' : 'Show'} Child
              </button>
            </div>
          </div>

          {showChild && (
            <WelcomeChild
              title="Child Component"
              message={`I receive values from the parent. Current name: ${userName}`}
              highlight="Props in action"
            />
          )}
        </div>
      </div>
    </section>
  )
}

export default Welcome
