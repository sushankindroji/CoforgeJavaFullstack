import React, { useEffect, useReducer } from 'react'
import { useNavigate } from 'react-router-dom'
import '../styles/Login.css'

const initialState = {
  email: '',
  password: '',
  name: '',
  mode: 'login', // 'login' or 'signup'
  loading: false,
  submitted: false,
  error: null,
  showPassword: false,
}

function reducer(state, action) {
  switch (action.type) {
    case 'SET_FIELD':
      return { ...state, [action.field]: action.value, error: null }
    case 'TOGGLE_SHOW':
      return { ...state, showPassword: !state.showPassword }
    case 'SUBMIT_START':
      return { ...state, loading: true, error: null }
    case 'SUBMIT_SUCCESS':
      return { ...state, loading: false, submitted: true }
    case 'SUBMIT_FAILURE':
      return { ...state, loading: false, error: action.error }
    case 'RESET':
      return initialState
    default:
      return state
  }
}

function Login() {
  const [state, dispatch] = useReducer(reducer, initialState)

  useEffect(() => {
    if (state.submitted) {
      const t = setTimeout(() => dispatch({ type: 'RESET' }), 2500)
      return () => clearTimeout(t)
    }
  }, [state.submitted])

  const validate = () => {
    if (!state.email || !state.email.includes('@')) {
      return 'Please enter a valid email address.'
    }
    if (!state.password || state.password.length < 6) {
      return 'Password must be at least 6 characters.'
    }
    if (state.mode === 'signup' && (!state.name || state.name.trim().length < 2)) {
      return 'Please enter a name for signup.'
    }
    return null
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    const err = validate()
    if (err) {
      dispatch({ type: 'SUBMIT_FAILURE', error: err })
      return
    }

    dispatch({ type: 'SUBMIT_START' })
    // Simulate async login/signup
    setTimeout(() => {
      if (state.mode === 'signup') {
        const newUser = {
          name: state.name,
          email: state.email,
          role: 'User',
          joined: new Date().toISOString().split('T')[0],
        }
        // store user (demo) including password for this local example
        const stored = { ...newUser, password: state.password }
        localStorage.setItem('app_user', JSON.stringify(stored))
        dispatch({ type: 'SUBMIT_SUCCESS' })
        navigate('/user-profile')
        return
      }

      // login: check localStorage for matching user
      const stored = localStorage.getItem('app_user')
      if (stored) {
        const parsed = JSON.parse(stored)
        if (parsed.email === state.email && parsed.password === state.password) {
          dispatch({ type: 'SUBMIT_SUCCESS' })
          navigate('/user-profile')
          return
        }
      }
      dispatch({ type: 'SUBMIT_FAILURE', error: 'No matching user found. Try signing up.' })
    }, 900)
  }

  return (
    <section className="login-page">
      <div className="login-heading">
        <h2>Login</h2>
        <p>Sign in to access your dashboard and app features.</p>
      </div>

      <form className="login-form" onSubmit={handleSubmit}>
        <div className="mode-toggle">
          <button type="button" className={`mode-btn ${state.mode === 'login' ? 'active' : ''}`} onClick={() => dispatch({ type: 'SET_FIELD', field: 'mode', value: 'login' })} disabled={state.mode === 'login'}>Login</button>
          <button type="button" className={`mode-btn ${state.mode === 'signup' ? 'active' : ''}`} onClick={() => dispatch({ type: 'SET_FIELD', field: 'mode', value: 'signup' })} disabled={state.mode === 'signup'}>Sign Up</button>
        </div>
        {state.mode === 'signup' && (
          <label>
            Name
            <input type="text" value={state.name} onChange={(e) => dispatch({ type: 'SET_FIELD', field: 'name', value: e.target.value })} placeholder="Your name" />
          </label>
        )}
        <label>
          Email
          <input
            type="email"
            value={state.email}
            onChange={(e) => dispatch({ type: 'SET_FIELD', field: 'email', value: e.target.value })}
            placeholder="email@example.com"
            required
          />
        </label>

        <label>
          Password
          <div className="password-row">
            <input
              type={state.showPassword ? 'text' : 'password'}
              value={state.password}
              onChange={(e) => dispatch({ type: 'SET_FIELD', field: 'password', value: e.target.value })}
              placeholder="••••••••"
              required
            />
            <button type="button" className="show-toggle" onClick={() => dispatch({ type: 'TOGGLE_SHOW' })}>
              {state.showPassword ? 'Hide' : 'Show'}
            </button>
          </div>
        </label>

        <button type="submit" className="primary-submit" disabled={state.loading}>
          {state.loading ? (state.mode === 'signup' ? 'Signing up...' : 'Signing in...') : (state.mode === 'signup' ? 'Sign Up' : 'Login')}
        </button>

        {state.error && <div className="login-error">{state.error}</div>}
      </form>

      {state.submitted && (
        <div className="login-response">
          <p>Signed in as: {state.email}</p>
        </div>
      )}
    </section>
  )
}

export default Login
