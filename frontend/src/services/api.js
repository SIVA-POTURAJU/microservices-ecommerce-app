const BASE_URL = "http://localhost:8080";

// GET Products
export const getProducts = async () => {
  const res = await fetch(`${BASE_URL}/api/products`);
  return res.json();
};

// PLACE ORDER
export const placeOrder = async (productId) => {
  const res = await fetch(`${BASE_URL}/api/orders`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      productId: productId,
      quantity: 1,
      userId: 1
    })
  });

  return res.text();
};