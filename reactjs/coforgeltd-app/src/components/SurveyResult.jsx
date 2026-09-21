import React, { useEffect, useMemo, useState } from 'react'
import '../styles/SurveyResult.css'

function SurveyResult() {
  const [surveyData, setSurveyData] = useState(() => {
    try {
      const raw = localStorage.getItem('survey_data')
      return raw ? JSON.parse(raw) : []
    } catch (e) {
      return []
    }
  })
  const [name, setName] = useState('')
  const [email, setEmail] = useState('')
  const [feedback, setFeedback] = useState('')
  const [rating, setRating] = useState(5)
  const [status, setStatus] = useState('')

  useEffect(() => {
    try {
      localStorage.setItem('survey_data', JSON.stringify(surveyData))
    } catch (e) {
      console.error('Unable to save survey data', e)
    }
  }, [surveyData])

  const averageRating = useMemo(() => {
    if (surveyData.length === 0) return 0
    return surveyData.reduce((sum, item) => sum + item.rating, 0) / surveyData.length
  }, [surveyData])

  const handleSubmit = (e) => {
    e.preventDefault()
    if (!name.trim() || !email.trim() || !feedback.trim()) {
      setStatus('Please complete every field before submitting.')
      return
    }

    const nextEntry = {
      id: Date.now(),
      name: name.trim(),
      email: email.trim(),
      feedback: feedback.trim(),
      rating: Number(rating),
    }

    setSurveyData((current) => [nextEntry, ...current])
    setName('')
    setEmail('')
    setFeedback('')
    setRating(5)
    setStatus('Thank you! Your response has been added.')
  }

  return (
    <section className="survey-page">
      <div className="survey-header">
        <h2>Survey Results</h2>
        <p>Collect user-submitted ratings, feedback, and contact details.</p>
      </div>

      <form className="survey-form" onSubmit={handleSubmit}>
        <div className="survey-form-grid">
          <label>
            Name
            <input type="text" value={name} onChange={(e) => setName(e.target.value)} placeholder="Your name" />
          </label>
          <label>
            Email
            <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder="you@example.com" />
          </label>
          <label>
            Rating
            <select value={rating} onChange={(e) => setRating(e.target.value)}>
              {[5, 4, 3, 2, 1].map((score) => (
                <option key={score} value={score}>
                  {score} star{score > 1 ? 's' : ''}
                </option>
              ))}
            </select>
          </label>
          <label className="full-width">
            Feedback
            <textarea value={feedback} onChange={(e) => setFeedback(e.target.value)} rows={4} placeholder="Share your experience" />
          </label>
        </div>
        <div className="survey-actions">
          <button type="submit">Submit Survey</button>
          <span className="survey-status">{status}</span>
        </div>
      </form>

      <div className="survey-summary">
        <div>
          <span>Total responses</span>
          <strong>{surveyData.length}</strong>
        </div>
        <div>
          <span>Average rating</span>
          <strong>{averageRating.toFixed(1)} / 5</strong>
        </div>
      </div>

      <div className="survey-grid">
        {surveyData.length === 0 ? (
          <div className="empty-response">No survey responses yet. Be the first to submit!</div>
        ) : (
          surveyData.map((item) => (
            <article key={item.id} className="survey-card">
              <div className="survey-card-top">
                <h3>{item.name}</h3>
                <span>{item.rating}/5</span>
              </div>
              <p className="survey-email">{item.email}</p>
              <p className="survey-feedback">"{item.feedback}"</p>
            </article>
          ))
        )}
      </div>
    </section>
  )
}

export default SurveyResult
