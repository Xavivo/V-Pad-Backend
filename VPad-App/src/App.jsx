import { useEffect, useState } from 'react'

function App() {
  const [mensaje, setMensaje] = useState("Cargando conexión...")

  useEffect(() => {
    // Connect to backend server
    fetch('http://localhost:3000/api/status')
      .then(res => res.json())
      .then(data => setMensaje(data.message))
      .catch(err => {
        console.error('Error connecting to server:', err);
        setMensaje("Error connecting to server");
      });

  }, [])

  return (
    <div style={{ padding: '40px', textAlign: 'center', fontFamily: 'sans-serif' }}>
      <h1>V-Pad Terminal</h1>
      <div style={{ background: '#f0f0f0', padding: '20px', borderRadius: '10px' }}>
        <p>Estado del Backend:</p>
        <strong>{mensaje}</strong>
      </div>
    </div>
  )
}

export default App