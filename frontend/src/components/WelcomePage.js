import "./WelcomePage.css";

function WelcomePage() {

  // Scroll function
  function scrollToProducts() {

    const section = document.getElementById("products");

    section.scrollIntoView({
      behavior: "smooth"
    });

  }

  return (

    <div className="welcome-container">

      {/* Navbar */}
      <nav className="navbar">

        <h2 className="logo">
          LUXE MART
        </h2>

        <div className="nav-links">
          <span>Home</span>
          <span>Products</span>
          <span>Collections</span>
          <span>Contact</span>
        </div>

      </nav>

      {/* Hero Section */}
      <div className="hero-section">

        <div className="hero-content">

          <h1>
            LUXURY <br />
            E-COMMERCE
          </h1>

          <p>
            Modern shopping experience with premium products,
            smooth UI and powerful microservices backend.
          </p>

          <button onClick={scrollToProducts}>
            Explore Products
          </button>

        </div>

      </div>

    </div>

  );
}

export default WelcomePage;