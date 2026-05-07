import "./ProductCard.css";

function ProductCard({ product, onAdd, onBuy }) {
  return (
    <div className="card">

      <div className="product-image">

        <div className="scroll-text">
          {product.name} • {product.name} • {product.name}
        </div>

      </div>

      <h4>{product.name}</h4>

      <p>₹ {product.price}</p>

      <div className="btn-group">

        <button
          className="add-btn"
          onClick={() => onAdd(product)}
        >
          Add Cart
        </button>

        <button
          className="buy-btn"
          onClick={() => onBuy(product.id)}
        >
          Buy Now
        </button>

      </div>
    </div>
  );
}

export default ProductCard;