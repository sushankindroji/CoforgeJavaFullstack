import React from 'react'
import '../styles/DisplayCustomers.css'

const customers = [
  { id: 1, name: 'Alice Johnson', email: 'alice@example.com' },
  { id: 2, name: 'Marcus Lee', email: 'marcus@example.com' },
  { id: 3, name: 'Sophia Patel', email: 'sophia@example.com' },
]

function DisplayCustomers() {
  return (
    <section className="display-customers">
      <div className="display-heading">
        <h2>Customer List</h2>
        <p>Customer records are displayed below with a clean table view.</p>
      </div>

      <div className="customers-table">
        <div className="table-row table-header">
          <span>ID</span>
          <span>Name</span>
          <span>Email</span>
        </div>
        {customers.map((customer) => (
          <div className="table-row" key={customer.id}>
            <span>{customer.id}</span>
            <span>{customer.name}</span>
            <span>{customer.email}</span>
          </div>
        ))}
      </div>
    </section>
  )
}

export default DisplayCustomers
