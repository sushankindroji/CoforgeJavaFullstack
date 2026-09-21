import React, { useEffect, useState } from 'react'
import '../styles/JSXDemo.css'

function JSXDemo() {
  const [firstValue, setFirstValue] = useState(12)
  const [secondValue, setSecondValue] = useState(8)
  const [inputText, setInputText] = useState('React is powerful!')
  const [currentTime, setCurrentTime] = useState(new Date())

  useEffect(() => {
    const interval = setInterval(() => setCurrentTime(new Date()), 1000)
    return () => clearInterval(interval)
  }, [])

  const a = Number(firstValue) || 0
  const b = Number(secondValue) || 0
  const addition = a + b
  const subtraction = a - b
  const multiplication = a * b

  const lowerCase = inputText.toLowerCase()
  const upperCase = inputText.toUpperCase()

  const regions = [
    { label: 'United States', locale: 'en-US' },
    { label: 'United Kingdom', locale: 'en-GB' },
    { label: 'Japan', locale: 'ja-JP' },
    { label: 'India', locale: 'en-IN' },
    { label: 'Germany', locale: 'de-DE' },
  ]

  return (
    <section className="jsx-demo">
      <div className="jsx-card">
        <h2>JSX Demo: Operations & Formatting</h2>
        <p>Explore arithmetic, string case, and localized date/time formatting in a React component.</p>

        <div className="operation-grid">
          <div className="operation-block">
            <h3>Arithmetic</h3>
            <label>
              First value
              <input type="number" value={firstValue} onChange={(e) => setFirstValue(e.target.value)} />
            </label>
            <label>
              Second value
              <input type="number" value={secondValue} onChange={(e) => setSecondValue(e.target.value)} />
            </label>
            <div className="result-row">
              <span>{a} + {b}</span>
              <strong>= {addition}</strong>
            </div>
            <div className="result-row">
              <span>{a} - {b}</span>
              <strong>= {subtraction}</strong>
            </div>
            <div className="result-row">
              <span>{a} × {b}</span>
              <strong>= {multiplication}</strong>
            </div>
          </div>

          <div className="operation-block">
            <h3>Text Case</h3>
            <label>
              Input text
              <input type="text" value={inputText} onChange={(e) => setInputText(e.target.value)} />
            </label>
            <div className="case-output">
              <div>
                <span>Lowercase</span>
                <p>{lowerCase}</p>
              </div>
              <div>
                <span>Uppercase</span>
                <p>{upperCase}</p>
              </div>
            </div>
          </div>
        </div>

        <div className="time-block">
          <h3>Regional Date / Time</h3>
          <div className="region-list">
            {regions.map(({ label, locale }) => (
              <div key={locale} className="region-card">
                <strong>{label}</strong>
                <span>{new Intl.DateTimeFormat(locale, {
                  dateStyle: 'full',
                  timeStyle: 'long',
                }).format(currentTime)}</span>
              </div>
            ))}
          </div>
        </div>

        <pre>{`const element = <h1>Hello, JSX!</h1>;`}</pre>
      </div>
    </section>
  )
}

export default JSXDemo
