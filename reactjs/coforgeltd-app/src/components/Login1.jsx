import React, { useState } from 'react'
import '../styles/Login1.css'

function Login1() {
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [submitted, setSubmitted] = useState(false)

  const handleSubmit = (e) => {
    e.preventDefault()
    setSubmitted(true)
  }

  return (
    <section className="login-1-page">
      <div className="login-1-card">
        <div className="login-1-header">
          <h2>Welcome Back</h2>
          <p>Use your username and password to sign in.</p>
        </div>
        <form className="login-1-form" onSubmit={handleSubmit}>
          <label>
            Username
            <input value={username} onChange={(e) => setUsername(e.target.value)} placeholder="Username" />
          </label>
          <label>
            Password
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Password" />
          </label>
          <button type="submit">Sign In</button>
        </form>
        {submitted && <p className="login-1-success">Signed in as {username || 'user'}</p>}
      </div>
    </section>
  )
}

export default Login1
