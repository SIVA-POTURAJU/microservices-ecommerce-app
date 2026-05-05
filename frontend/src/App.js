import { useState } from "react";
import ProductList from "./components/ProductList";
import Cart from "./components/Cart";

function App() {
  const [cart, setCart] = useState([]);

  // Add to cart (avoid duplicates optional)
  function addToCart(product) {
    setCart(prev => [...prev, product]);
  }

  // Buy directly
  async function buyProduct(id) {
    try {
      const response = await fetch("http://localhost:8080/api/orders", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          productId: id,
          quantity: 1,
          userId: 1
        })
      });

      if (!response.ok) {
        throw new Error("Failed request");
      }

      const data = await response.text();
      alert("Order placed: " + data);

    } catch (error) {
      console.error(error);
      alert("Order failed!");
    }
  }

  return (
    <div>
      <h2 style={{ textAlign: "center" }}>Products</h2>

      <ProductList
        addToCart={addToCart}
        buyProduct={buyProduct}
      />

      <Cart
        cart={cart}
        setCart={setCart}
      />
    </div>
  );
}

export default App;