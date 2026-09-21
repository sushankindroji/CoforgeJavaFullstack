import React, { useState, useEffect, useReducer, useRef, useMemo, useCallback } from 'react'
import '../styles/HooksDemo.css'

// small localStorage hook
function useLocalStorage(key, initial) {
  const [state, setState] = useState(() => {
    try {
      const raw = localStorage.getItem(key)
      return raw ? JSON.parse(raw) : initial
    } catch (e) {
      return initial
    }
  })

  useEffect(() => {
    try {
      localStorage.setItem(key, JSON.stringify(state))
    } catch (e) {}
  }, [key, state])

  return [state, setState]
}

function todosReducer(state, action) {
  switch (action.type) {
    case 'ADD':
      return [...state, { id: Date.now(), text: action.text, done: false }]
    case 'TOGGLE':
      return state.map(t => (t.id === action.id ? { ...t, done: !t.done } : t))
    case 'REMOVE':
      return state.filter(t => t.id !== action.id)
    case 'SET':
      return action.todos
    default:
      return state
  }
}

function HooksDemo() {
  // useState counter
  const [count, setCount] = useState(0)

  // useReducer todos persisted with useLocalStorage
  const [saved, setSaved] = useLocalStorage('hooks_todos', [])
  const [todos, dispatch] = useReducer(todosReducer, saved)

  useEffect(() => {
    setSaved(todos)
  }, [todos, setSaved])

  // useRef to focus input and count renders
  const inputRef = useRef(null)
  const renders = useRef(0)
  renders.current += 1

  // useEffect timer example
  const [running, setRunning] = useState(false)
  const [seconds, setSeconds] = useState(0)

  useEffect(() => {
    if (!running) return undefined
    const t = setInterval(() => setSeconds(s => s + 1), 1000)
    return () => clearInterval(t)
  }, [running])

  // useMemo expensive calculation (factorial)
  const [n, setN] = useState(6)
  const factorial = useMemo(() => {
    function fact(x) {
      return x <= 1 ? 1 : x * fact(x - 1)
    }
    // simulate work
    for (let i = 0; i < 15000000; i++) {}
    return fact(n)
  }, [n])

  // useCallback add todo
  const addTodo = useCallback((text) => dispatch({ type: 'ADD', text }), [])

  // fetch demo (on demand)
  const [posts, setPosts] = useState([])
  const [loadingPosts, setLoadingPosts] = useState(false)

  const loadPosts = async () => {
    setLoadingPosts(true)
    try {
      const res = await fetch('https://jsonplaceholder.typicode.com/posts?_limit=4')
      const data = await res.json()
      setPosts(data)
    } catch (e) {
      console.error(e)
    } finally {
      setLoadingPosts(false)
    }
  }

  return (
    <section className="hooks-demo">
      <div className="hooks-heading">
        <h2>Hooks Demo — Interactive</h2>
        <p>Examples: useState, useEffect, useReducer, useRef, useMemo, useCallback and a small custom hook.</p>
      </div>

      <div className="hooks-card">
        <div className="section">
          <h3>useState — Counter</h3>
          <div className="counter-row">
            <button onClick={() => setCount(c => c - 1)}>-</button>
            <strong>{count}</strong>
            <button onClick={() => setCount(0)}>Reset</button>
            <button onClick={() => setCount(c => c + 1)}>+</button>
          </div>
        </div>

        <div className="section">
          <h3>useReducer + useLocalStorage — Todos</h3>
          <div className="todo-controls">
            <input ref={inputRef} placeholder="New todo" id="todo-input" />
            <button onClick={() => { const v = document.getElementById('todo-input').value.trim(); if (v) { addTodo(v); document.getElementById('todo-input').value=''; inputRef.current.focus() } }}>Add</button>
            <button onClick={() => dispatch({ type: 'SET', todos: [] })}>Clear</button>
          </div>
          <ul className="todo-list">
            {todos.length === 0 && <li className="empty">No todos yet.</li>}
            {todos.map(t => (
              <li key={t.id} className={`todo-item ${t.done ? 'done' : ''}`}>
                <label>
                  <input type="checkbox" checked={t.done} onChange={() => dispatch({ type: 'TOGGLE', id: t.id })} />
                  <span>{t.text}</span>
                </label>
                <button className="small" onClick={() => dispatch({ type: 'REMOVE', id: t.id })}>Remove</button>
              </li>
            ))}
          </ul>
        </div>

        <div className="section">
          <h3>useEffect — Timer</h3>
          <div className="timer">
            <div>Running: <strong>{running ? 'Yes' : 'No'}</strong></div>
            <div>Seconds: <strong>{seconds}</strong></div>
            <div className="controls">
              <button onClick={() => setRunning(r => !r)}>{running ? 'Stop' : 'Start'}</button>
              <button onClick={() => { setSeconds(0); setRunning(false) }}>Reset</button>
            </div>
          </div>
        </div>

        <div className="section">
          <h3>useRef — Focus & renders</h3>
          <div>Renders: <strong>{renders.current}</strong></div>
          <div className="controls">
            <button onClick={() => inputRef.current && inputRef.current.focus()}>Focus Todo Input</button>
          </div>
        </div>

        <div className="section">
          <h3>useMemo — Expensive Calc (factorial)</h3>
          <div className="memo">
            <input type="number" value={n} onChange={(e) => setN(Number(e.target.value || 0))} min="0" />
            <div>Factorial: <strong>{factorial}</strong></div>
          </div>
        </div>

        <div className="section">
          <h3>useCallback + fetch demo</h3>
          <div className="controls">
            <button onClick={loadPosts} disabled={loadingPosts}>{loadingPosts ? 'Loading...' : 'Load Posts'}</button>
          </div>
          <ul className="posts">
            {posts.map(p => (
              <li key={p.id}><strong>{p.title}</strong><p>{p.body}</p></li>
            ))}
          </ul>
        </div>

      </div>
    </section>
  )
}

export default HooksDemo
