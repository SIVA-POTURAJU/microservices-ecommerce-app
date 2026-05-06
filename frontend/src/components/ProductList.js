import { useEffect, useState } from "react";
import ProductCard from "./ProductCard";
import "./ProductList.css";

function ProductList({ addToCart, buyProduct }) {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/products")
      .then(res => res.json())
      .then(data => {
        console.log("API Response:", data);
        setProducts(data);
      });
  }, []);

  return (
    <div className="container">
      {products.map(p => (
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