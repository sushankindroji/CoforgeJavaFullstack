import React from 'react'
import '../styles/JSXDemo1.css'

function JSXDemo1() {
  return (
    <section className="jsx-demo-1">
      <div className="jsx-card">
        <h2>JSX Demo 1</h2>
        <p>This example shows how JSX becomes JavaScript behind the scenes.</p>
        <pre>{`function Greeting() {
  return <div>Hello World</div>
}`}</pre>
      </div>
    </section>
  )
}

export default JSXDemo1
