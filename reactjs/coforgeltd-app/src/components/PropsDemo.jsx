import React from 'react'
import '../styles/PropsDemo.css'

function Card({ title, description }) {
  return (
    <article className="props-card">
      <h3>{title}</h3>
      <p>{description}</p>
    </article>
  )
}

function PropsDemo() {
  return (
    <section className="props-demo">
      <div className="props-heading">
        <h2>Props Demo</h2>
        <p>Props let you pass data into reusable components.</p>
      </div>
      <div className="props-grid">
        <Card title="Reusable" description="Components can be reused with different prop values." />
        <Card title="Flexible" description="Props make components highly flexible and composable." />
        <Card title="Structured" description="Data flows down from parent to child components." />
      </div>
    </section>

  )
}

export default PropsDemo
