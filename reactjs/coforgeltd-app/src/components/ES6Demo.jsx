import React, { useState } from 'react'
import '../styles/ES6Demo.css'

function ES6Demo() {
  const [showExample, setShowExample] = useState(true)
  const toggleExample = () => setShowExample((prev) => !prev)

  return (
    <div className="notes-container">
      <h1>ES6 Features Demo</h1>

      <section className="note-section">
        <h2>1. let & const</h2>
        <p>
          Use <code>let</code> for mutable bindings and <code>const</code> for values that shouldn't change.
        </p>
        <pre>
{`const name = 'React';
let count = 5;
count += 1;`}
        </pre>
      </section>

      <section className="note-section">
        <h2>2. Arrow Functions</h2>
        <p>
          Arrow functions are shorter and keep the lexical <code>this</code> context.
        </p>
        <pre>
{`const sum = (a, b) => a + b;
const greet = () => console.log('Hello ES6');`}
        </pre>
      </section>

      <section className="note-section">
        <h2>3. Template Literals</h2>
        <p>
          Template literals allow easy string interpolation and multi-line text.
        </p>
        <pre>
{`const title = 'ES6 Demo';
const message = \`Welcome to ${title}!\`;
console.log(message);`}
        </pre>
      </section>

      <section className="note-section">
        <h2>4. Destructuring</h2>
        <p>
          Destructuring extracts values from objects and arrays with less code.
        </p>
        <pre>
{`const user = { name: 'Ayesha', role: 'Developer' };
const { name, role } = user;
const numbers = [1, 2, 3];
const [first, second] = numbers;`}
        </pre>
      </section>

      {showExample && (
        <section className="note-section">
          <h2>5. Example Output</h2>
          <p>Toggle this section to show or hide example content.</p>
          <pre>
{`Name: Ayesha
Role: Developer
First number: 1`}
          </pre>
        </section>
      )}

      <button type="button" onClick={toggleExample}>
        {showExample ? 'Hide Example' : 'Show Example'}
      </button>
    </div>
  )
}

export default ES6Demo
