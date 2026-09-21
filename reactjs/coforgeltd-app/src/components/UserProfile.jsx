import React, { useEffect, useReducer } from 'react'
import '../styles/userprofile.css'

const initialState = {
  user: null,
  loading: true,
  editMode: false,
  draft: { name: '', email: '', role: '', joined: '' },
}

function reducer(state, action) {
  switch (action.type) {
    case 'SET_USER':
      return { ...state, user: action.user, loading: false, draft: { ...action.user } }
    case 'SET_LOADING':
      return { ...state, loading: action.loading }
    case 'LOGOUT':
      return { ...state, user: null, draft: { name: '', email: '', role: '', joined: '' } }
    case 'TOGGLE_EDIT':
      return { ...state, editMode: !state.editMode }
    case 'SET_DRAFT_FIELD':
      return { ...state, draft: { ...state.draft, [action.field]: action.value } }
    case 'SAVE_DRAFT':
      return { ...state, user: { ...state.draft }, editMode: false }
    default:
      return state
  }
}

function UserProfile() {
  const [state, dispatch] = useReducer(reducer, initialState)

  useEffect(() => {
    // Try to load user from localStorage first (signup/login persists here)
    const stored = localStorage.getItem('app_user')
    if (stored) {
      try {
        const parsed = JSON.parse(stored)
        // remove password if present
        const { password, ...safe } = parsed
        dispatch({ type: 'SET_USER', user: safe })
        return
      } catch (e) {
        // fall through to demo load
      }
    }

    // Fallback: simulate loading demo user
    const t = setTimeout(() => {
      const demoUser = {
        name: 'Ayesha Khan',
        email: 'ayesha.khan@example.com',
        role: 'Frontend Developer',
        joined: '2023-04-12',
      }
      dispatch({ type: 'SET_USER', user: demoUser })
    }, 600)
    return () => clearTimeout(t)
  }, [])

  const handleLogout = () => dispatch({ type: 'LOGOUT' })
  const handleSignInDemo = () => dispatch({ type: 'SET_USER', user: { name: 'Ayesha Khan', email: 'ayesha.khan@example.com', role: 'Frontend Developer', joined: '2023-04-12' } })

  if (state.loading) {
    return (
      <div className="page-container">
        <div className="profile-card">
          <h2>Loading profile…</h2>
        </div>
      </div>
    )
  }

  return (
    <div className="page-container">
      <div className="profile-card">
        <h2>User Profile</h2>

        {state.user ? (
          <>
            {state.editMode ? (
              <div>
                <p>
                  <strong>Name:</strong>
                  <input value={state.draft.name} onChange={(e) => dispatch({ type: 'SET_DRAFT_FIELD', field: 'name', value: e.target.value })} />
                </p>
                <p>
                  <strong>Email:</strong>
                  <input value={state.draft.email} onChange={(e) => dispatch({ type: 'SET_DRAFT_FIELD', field: 'email', value: e.target.value })} />
                </p>
                <p>
                  <strong>Role:</strong>
                  <input value={state.draft.role} onChange={(e) => dispatch({ type: 'SET_DRAFT_FIELD', field: 'role', value: e.target.value })} />
                </p>
                <p>
                  <strong>Member Since:</strong>
                  <input value={state.draft.joined} onChange={(e) => dispatch({ type: 'SET_DRAFT_FIELD', field: 'joined', value: e.target.value })} />
                </p>
                <div className="action-row">
                  <button className="logout-btn" onClick={() => dispatch({ type: 'SAVE_DRAFT' })}>Save</button>
                  <button className="logout-btn" onClick={() => dispatch({ type: 'TOGGLE_EDIT' })}>Cancel</button>
                </div>
              </div>
            ) : (
              <>
                <p>
                  <strong>Name:</strong> {state.user.name}
                </p>

                <p>
                  <strong>Email:</strong> {state.user.email}
                </p>

                <p>
                  <strong>Role:</strong> {state.user.role}
                </p>

                <p>
                  <strong>Member Since:</strong> {new Date(state.user.joined).toLocaleDateString()}
                </p>

                <div className="action-row">
                  <button className="logout-btn" onClick={() => dispatch({ type: 'TOGGLE_EDIT' })}>Edit Profile</button>
                  <button className="logout-btn" onClick={handleLogout}>Logout</button>
                </div>
              </>
            )}
          </>
        ) : (
          <>
            <p>No user is currently signed in.</p>
            <button className="logout-btn" onClick={handleSignInDemo}>
              Sign In Demo User
            </button>
          </>
        )}
      </div>
    </div>
  )
}

export default UserProfile
