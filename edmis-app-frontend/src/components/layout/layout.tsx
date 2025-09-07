import { Header, PrimaryNav, Title, Footer } from "@trussworks/react-uswds";
import { Outlet, Link, NavLink } from "react-router-dom";
import { useState } from "react";
import { navLinks } from "./nav-links";
import edmisLogo from "../../assets/edmisLogo.png";

const Layout = () => {
  const [mobileExpanded, setMobileExpanded] = useState(false);
  const navItems = navLinks.map(({ to, label }) => (
    <NavLink
      key={to}
      to={to}
      onClick={() => setMobileExpanded(false)}
      className={({ isActive }) =>
        isActive ? "usa-nav__link usa-current" : "usa-nav__link"
      }
    >
      {label}
    </NavLink>
  ));

  return (
    <>
      {/* Skip Nav Link */}
      <a href="#main-content" className="usa-skipnav">
        Skip to main content
      </a>
      <Header extended>
        <div className="usa-navbar">
          <Title>
            <Link to="/" className="usa-nav__link primary-text-color">
              <img
                src={edmisLogo}
                alt="EDMIS Home"
                style={{ height: "50px", width: "auto", marginRight: "0.5rem" }}
              />
              <span className="primary-text-color">EDMIS</span>
            </Link>
          </Title>
          {/* Menu button MUST be here and use aria-controls */}
          <button
            type="button"
            className="usa-menu-btn"
            aria-controls="extended-nav"
            aria-expanded={mobileExpanded}
            onClick={() => setMobileExpanded((prev) => !prev)}
          >
            Menu
          </button>
        </div>

        {/* This div MUST be a sibling of .usa-navbar and get the right ID/class */}
        <PrimaryNav
          items={navItems}
          mobileExpanded={mobileExpanded}
          onToggleMobileNav={() => setMobileExpanded((prev) => !prev)}
          className="usa-nav"
          id="extended-nav"
        />
      </Header>

      <main id="main-content" className="padding-top-1">
        <Outlet />
      </main>

      <Footer
        primary={<></>}
        secondary={
          <div className="usa-footer__secondary-content">
            <div className="display-flex flex-row flex-justify">
              <p className="padding-1">© {new Date().getFullYear()} EDMIS</p>
              <p className="padding-1">
                Section 508 Compliant · Built with React + Spring Boot
              </p>
            </div>
          </div>
        }
      />
    </>
  );
};

export default Layout;
