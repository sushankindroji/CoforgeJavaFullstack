import React from 'react'
import { NavLink } from 'react-router-dom'
import '../styles/NavBar.css'

function NavBar() {
  return (
    <nav className="nav-bar">
      <NavLink className="nav-logo" to="/">ReactVite</NavLink>
      <div className="nav-links">
        <NavLink to="/" end>Home</NavLink>
        <NavLink to="/about">About</NavLink>
        <NavLink to="/addition">Addition</NavLink>
        <NavLink to="/jsx-demo">JSX Demo</NavLink>
        <NavLink to="/jsx-demo1">JSX Demo 1</NavLink>
        <NavLink to="/jsx-demo2">JSX Demo 2</NavLink>
        <NavLink to="/props-demo">Props</NavLink>
        <NavLink to="/customer-form">Customer Form</NavLink>
        <NavLink to="/display-customers">Customers</NavLink>
        <NavLink to="/hooks-demo">Hooks</NavLink>
        <NavLink to="/shopping">Shopping</NavLink>
        <NavLink to="/student-manager">Students</NavLink>
        <NavLink to="/survey-result">Survey</NavLink>
        <NavLink to="/welcome">Welcome</NavLink>
        <NavLink to="/user-profile">Profile</NavLink>
        <NavLink to="/login">Login</NavLink>
        <NavLink to="/login-1">Login 1</NavLink>
      </div>
    </nav>
  )
}

export default NavBar
