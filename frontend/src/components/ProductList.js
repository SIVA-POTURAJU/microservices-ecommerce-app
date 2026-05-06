import { useEffect, useState } from "react";
import ProductCard from "./ProductCard";
import "./ProductList.css";

// ✅ ADD HERE (top of file)
const API_URL = process.env.REACT_APP_API_URL;

function ProductList({ addToCart, buyProduct }) {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    // ✅ USE HERE
    fetch(`${API_URL}/api/products`)
      .then(res => res.json())
      .then(data => {
        console.log("API Response:", data);
        setProducts(Array.isArray(data) ? data : []);
      })
      .catch(err => console.error("Fetch error:", err));
  }, []);

  return (
    <div className="container">
      {Array.isArray(products) &&
        products.map(p => (
          <ProductCard
            key={p.id}
            product={p}
            onAdd={addToCart}
            onBuy={buyProduct}
          />
        ))}
    </div>
  );
}

export default ProductList;