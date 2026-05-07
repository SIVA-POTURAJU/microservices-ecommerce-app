import "./Header.css";

function Header() {
  return (
    <div className="header">
      <h2>ShopEasy</h2>

      <div className="nav-links">
        <span>Home</span>
        <span>Products</span>
        <span>Cart</span>
      </div>
    </div>
  );
}

export default Header;