import { render, screen } from "@testing-library/react";
import { RegisterStudent } from "./register-student";

describe("Register Student", () => {
  it("should render successfully", async () => {
    render(<RegisterStudent />);

    expect(await screen.findByText("Student Registration")).toBeTruthy();
  });
});
