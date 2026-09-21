import React, { useState } from 'react'
import '../styles/StudentManager.css'

const initialStudents = [
  { id: 1, name: 'Ayesha Khan', grade: 'A' },
  { id: 2, name: 'Rohan Das', grade: 'B+' },
  { id: 3, name: 'Priya Singh', grade: 'A-' },
]

function StudentManager() {
  const [students, setStudents] = useState(initialStudents)

  return (
    <section className="student-manager">
      <div className="student-heading">
        <h2>Student Manager</h2>
        <p>Manage student records with a simple list view.</p>
      </div>

      <div className="student-list">
        {students.map((student) => (
          <div className="student-card" key={student.id}>
            <span>{student.name}</span>
            <strong>{student.grade}</strong>
          </div>
        ))}
      </div>
    </section>
  )
}

export default StudentManager
