import React, { useMemo, useState } from 'react'
import '../styles/JSXDemo2.css'

const numbers = [5, 12, 8, 22, 7, 31]
const words = ['React', 'JSX', 'Array', 'Demo', 'Code']

function JSXDemo2() {
  const [search, setSearch] = useState('')

  const filteredNumbers = useMemo(
    () => numbers.filter((value) => String(value).includes(search.trim())),
    [search]
  )

  const filteredWords = useMemo(
    () => words.filter((word) => word.toLowerCase().includes(search.toLowerCase())),
    [search]
  )

  const doubled = numbers.map((value) => value * 2)
  const evens = numbers.filter((value) => value % 2 === 0)
  const total = numbers.reduce((sum, value) => sum + value, 0)
  const sorted = [...numbers].sort((a, b) => a - b)
  const found = numbers.find((value) => value > 20)
  const includesSeven = numbers.includes(7)
  const someOverTwenty = numbers.some((value) => value > 20)
  const allPositive = numbers.every((value) => value > 0)

  return (
    <section className="jsx-demo-2">
      <div className="jsx-card">
        <h2>JSX Demo 2</h2>
        <p>Array operations in React using JSX and hooks.</p>

        <div className="search-block">
          <label htmlFor="search-input">Filter numbers and words</label>
          <input
            id="search-input"
            type="text"
            placeholder="Search array items..."
            value={search}
            onChange={(e) => setSearch(e.target.value)}
          />
        </div>

        <div className="section-grid">
          <div className="array-card">
            <h3>Number array</h3>
            <ul className="array-list">
              {numbers.map((value) => (
                <li key={value}>{value}</li>
              ))}
            </ul>
          </div>

          <div className="array-card">
            <h3>Word array</h3>
            <ul className="array-list">
              {words.map((word) => (
                <li key={word}>{word}</li>
              ))}
            </ul>
          </div>
        </div>

        <div className="result-grid">
          <div className="result-card">
            <h3>Array map</h3>
            <p>Doubled values: {doubled.join(', ')}</p>
          </div>

          <div className="result-card">
            <h3>Array filter</h3>
            <p>Even values: {evens.join(', ')}</p>
          </div>

          <div className="result-card">
            <h3>Array reduce</h3>
            <p>Total sum: {total}</p>
          </div>

          <div className="result-card">
            <h3>Array sort</h3>
            <p>Sorted: {sorted.join(', ')}</p>
          </div>

          <div className="result-card">
            <h3>Array find</h3>
            <p>First value over 20: {found}</p>
          </div>

          <div className="result-card">
            <h3>Array includes / some / every</h3>
            <p>Includes 7: {includesSeven ? 'Yes' : 'No'}</p>
            <p>Some &gt; 20: {someOverTwenty ? 'Yes' : 'No'}</p>
            <p>All positive: {allPositive ? 'Yes' : 'No'}</p>
          </div>
        </div>

        <div className="filter-section">
          <h3>Filtered results</h3>
          <p className="filter-note">Search output updates as you type.</p>
          <div className="filter-lists">
            <div>
              <strong>Numbers</strong>
              <ul className="array-list">
                {filteredNumbers.length > 0 ? (
                  filteredNumbers.map((value) => <li key={value}>{value}</li>)
                ) : (
                  <li>No matching numbers</li>
                )}
              </ul>
            </div>
            <div>
              <strong>Words</strong>
              <ul className="array-list">
                {filteredWords.length > 0 ? (
                  filteredWords.map((word) => <li key={word}>{word}</li>)
                ) : (
                  <li>No matching words</li>
                )}
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
  )
}

export default JSXDemo2
