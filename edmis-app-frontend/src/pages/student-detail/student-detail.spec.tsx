import { render, screen } from "@testing-library/react";
import StudentDetail from "./student-detail";

describe("Student Detail", () => {
  it("should render succesfully", async () => {
    render(<StudentDetail />);

    expect(await screen.findByText("Student Detail")).toBeTruthy();
  });
});
