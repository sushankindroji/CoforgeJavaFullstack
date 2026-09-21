import React, { useEffect, useState } from 'react'
import '../styles/Addition.css'

function Addition() {
  const [first, setFirst] = useState(5)
  const [second, setSecond] = useState(7)
  const [result, setResult] = useState(0)
  const [message, setMessage] = useState('')

  useEffect(() => {
    const a = Number(first)
    const b = Number(second)
    setResult(a + b)
    setMessage(`Updated ${a} + ${b} = ${a + b}`)
    document.title = `Addition: ${a + b}`
  }, [first, second])

  return (
    <section className="addition-page">
      <h2>Addition Demo</h2>
      <p>Try entering two numbers to see the result instantly.</p>

      <div className="addition-form">
        <label>
          First number
          <input type="number" value={first} onChange={(e) => setFirst(e.target.value)} />
        </label>
        <label>
          Second number
          <input type="number" value={second} onChange={(e) => setSecond(e.target.value)} />
        </label>
      </div>

      <div className="addition-result">
        <span>{first} + {second}</span>
        <strong>= {result}</strong>
      </div>
      <p className="addition-note">{message}</p>
    </section>
  )
}

export default Addition
