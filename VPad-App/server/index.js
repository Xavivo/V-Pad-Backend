import express from 'express';
import cors from 'cors';

const app = express();
const PORT = 3000;

// Middlewares
app.use(cors()); // Allows react app to communicate with this server
app.use(express.json()); // Allows to parse JSON bodies

// Endpoints

// Message to verify server is running
app.get('/api/status', (req, res) => {
  res.json({ message: '¡Server is running!', time: new Date() });
});

// This is just an example for now
app.get('/api/products', async (req, res) => {
  try {
    // const products = await prisma.product.findMany(); 
    // res.json(products);
    res.json([{ id: 1, name: "Pedido de prueba", price: 5.50 }]); // Fake data for now
  } catch (error) {
    console.error('Error fetching products:', error);
    res.status(500).json({ error: 'Error al obtener productos' });
  }
});

// Server running
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});