import { render, screen } from "@testing-library/react";
import HomePage from "./home-page";

describe("Home Page", () => {
  it("should render successfully", async () => {
    render(<HomePage />);

    expect(await screen.findByText("Home Page")).toBeTruthy();
  });
});
