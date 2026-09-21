import React, { useEffect, useState } from 'react'
import '../styles/Shopping.css'

const initialProducts = [
  { id: 1, name: 'Energy Boost', price: 25 },
  { id: 2, name: 'React Toolkit', price: 49 },
  { id: 3, name: 'Vite Pro', price: 79 },
  { id: 4, name: 'UI Kit', price: 19 },
  { id: 5, name: 'API Helper', price: 9 },
]

function Shopping() {
  const [products, setProducts] = useState([])
  const [loading, setLoading] = useState(true)
  const [query, setQuery] = useState('')

  // cart persisted to localStorage
  const [cart, setCart] = useState(() => {
    try {
      const raw = localStorage.getItem('cart')
      return raw ? JSON.parse(raw) : []
    } catch (e) {
      return []
    }
  })

  useEffect(() => {
    // simulate fetching products
    setLoading(true)
    const t = setTimeout(() => {
      setProducts(initialProducts)
      setLoading(false)
    }, 600)
    return () => clearTimeout(t)
  }, [])

  useEffect(() => {
    try {
      localStorage.setItem('cart', JSON.stringify(cart))
    } catch (e) {}
  }, [cart])

  const filtered = products.filter(p => p.name.toLowerCase().includes(query.trim().toLowerCase()))

  function addToCart(product) {
    setCart(prev => {
      const found = prev.find(i => i.id === product.id)
      if (found) return prev.map(i => i.id === product.id ? { ...i, qty: i.qty + 1 } : i)
      return [...prev, { ...product, qty: 1 }]
    })
  }

  function removeFromCart(id) {
    setCart(prev => prev.filter(i => i.id !== id))
  }

  function clearCart() {
    setCart([])
  }

  const total = cart.reduce((s, i) => s + i.price * i.qty, 0)

  return (
    <section className="shopping-page">
      <div className="shopping-heading">
        <h2>Shopping</h2>
        <p>Explore products curated for modern React development.</p>
      </div>

      <div className="shopping-inner">
        <div className="product-area">
          <div className="product-controls">
            <input placeholder="Search products..." value={query} onChange={(e) => setQuery(e.target.value)} />
            <button onClick={() => setQuery('')}>Clear</button>
          </div>

          {loading ? (
            <div className="loading">Loading products…</div>
          ) : (
            <div className="product-grid">
              {filtered.map((product) => (
                <article key={product.id} className="product-card">
                  <h3>{product.name}</h3>
                  <p>${product.price.toFixed(2)}</p>
                  <div className="product-actions">
                    <button onClick={() => addToCart(product)}>Add to cart</button>
                  </div>
                </article>
              ))}
              {filtered.length === 0 && <div className="empty">No products match your search.</div>}
            </div>
          )}
        </div>

        <aside className="cart-panel">
          <h3>Cart</h3>
          {cart.length === 0 ? (
            <div className="empty">Your cart is empty.</div>
          ) : (
            <ul className="cart-list">
              {cart.map(item => (
                <li key={item.id} className="cart-item">
                  <div>
                    <strong>{item.name}</strong>
                    <div className="muted">{item.qty} × ${item.price.toFixed(2)}</div>
                  </div>
                  <div className="cart-actions">
                    <button onClick={() => setCart(prev => prev.map(i => i.id === item.id ? { ...i, qty: Math.max(1, i.qty - 1) } : i))}>-</button>
                    <button onClick={() => setCart(prev => prev.map(i => i.id === item.id ? { ...i, qty: i.qty + 1 } : i))}>+</button>
                    <button className="remove" onClick={() => removeFromCart(item.id)}>Remove</button>
                  </div>
                </li>
              ))}
            </ul>
          )}

          <div className="cart-summary">
            <div>Total: <strong>${total.toFixed(2)}</strong></div>
            <div style={{ display: 'flex', gap: 8, marginTop: 8 }}>
              <button onClick={() => alert('Checkout demo — integrate real payments')}>Checkout</button>
              <button className="remove" onClick={clearCart}>Clear</button>
            </div>
          </div>
        </aside>
      </div>
    </section>
  )
}

export default Shopping
