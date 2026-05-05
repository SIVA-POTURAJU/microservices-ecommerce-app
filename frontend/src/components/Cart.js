import "./Cart.css";

function Cart({ cart, setCart }) {

  // Remove item
  function removeItem(index) {
    setCart(prev => prev.filter((_, i) => i !== index));
  }

  // Place Order → DB
  async function placeOrder() {
    try {
      for (let item of cart) {
        const response = await fetch("http://localhost:8080/api/orders", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            productId: item.id,
            quantity: 1,
            userId: 1
          })
        });

        if (!response.ok) {
          throw new Error("Failed request");
        }

        const data = await response.text();
        console.log("Saved:", data);
      }

      alert("Order placed successfully!");
      setCart([]); // clear cart

    } catch (error) {
      console.error("Order Error:", error);
      alert("Order failed! Check backend.");
    }
  }

  // Total calculation
  const total = cart.reduce((sum, item) => sum + item.price, 0);

  return (
    <div style={{
      margin: "20px",
      padding: "15px",
      border: "1px solid #ccc",
      borderRadius: "8px",
      background: "#f9f9f9"
    }}>
      <h3>🛒 Cart</h3>

      {cart.length === 0 && <p>No items in cart</p>}

      {cart.map((item, index) => (
        <div key={index} style={{
          display: "flex",
          justifyContent: "space-between",
          marginBottom: "10px"
        }}>
          <span>{item.name} - ₹{item.price}</span>

          <button
            onClick={() => removeItem(index)}
            style={{
              background: "red",
              color: "white",
              border: "none",
              padding: "4px 8px",
              cursor: "pointer"
            }}
          >
            Remove
          </button>
        </div>
      ))}

      <h4>Total: ₹{total}</h4>

      {cart.length > 0 && (
        <button
          onClick={placeOrder}
          style={{
            marginTop: "10px",
            padding: "8px",
            background: "green",
            color: "white",
            border: "none",
            width: "100%",
            cursor: "pointer"
          }}
        >
          Place Order
        </button>
      )}
    </div>
  );
}

export default Cart;