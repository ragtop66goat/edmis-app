import { render, screen } from "@testing-library/react";
import HomePage from "./home-page";

describe("Home Page", () => {
  it("should render successfully", () => {
    render(<HomePage />);

    expect(screen.getByText(/welcome to edmis/i)).toBeTruthy();
  });
});
