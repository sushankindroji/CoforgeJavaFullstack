import React, { useState } from 'react'
import '../styles/CustomerForm.css'

function CustomerForm() {
  const [name, setName] = useState('')
  const [email, setEmail] = useState('')
  const [message, setMessage] = useState('')
  const [submitted, setSubmitted] = useState(false)

  const handleSubmit = (e) => {
    e.preventDefault()
    setSubmitted(true)
  }

  return (
    <section className="customer-form">
      <div className="customer-heading">
        <h2>Customer Form</h2>
        <p>Enter the details below and submit to preview the response.</p>
      </div>

      <form className="customer-form-inner" onSubmit={handleSubmit}>
        <label>
          Name
          <input value={name} onChange={(e) => setName(e.target.value)} placeholder="Jane Doe" />
        </label>
        <label>
          Email
          <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder="jane@example.com" />
        </label>
        <label>
          Message
          <textarea value={message} onChange={(e) => setMessage(e.target.value)} placeholder="How can we assist you?" />
        </label>
        <button type="submit">Submit</button>
      </form>

      {submitted && (
        <div className="customer-response">
          <h3>Form submitted!</h3>
          <p>Name: {name || 'Not provided'}</p>
          <p>Email: {email || 'Not provided'}</p>
          <p>Message: {message || 'Not provided'}</p>
        </div>
      )}
    </section>
  )
}

export default CustomerForm
