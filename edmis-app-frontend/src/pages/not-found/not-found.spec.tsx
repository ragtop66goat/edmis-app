import { render, screen } from "@testing-library/react";
import NotFound from "./not-found";

describe("Not Found", () => {
  it("should render successfully", async () => {
    render(<NotFound />);

    expect(await screen.findByText("Not Found")).toBeTruthy();
  });
});
