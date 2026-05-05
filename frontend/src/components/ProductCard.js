import "./ProductCard.css";

function ProductCard({ product, onAdd, onBuy }) {
  return (
    <div className="card">
      <h4>{product.name}</h4>
      <p>₹ {product.price}</p>

      <div>
        <button
          className="add-btn"
          onClick={() => onAdd(product)}
        >
          Add
        </button>

        <button
          className="buy-btn"
          onClick={() => onBuy(product.id)}
        >
          Buy
        </button>
      </div>
    </div>
  );
}

export default ProductCard;