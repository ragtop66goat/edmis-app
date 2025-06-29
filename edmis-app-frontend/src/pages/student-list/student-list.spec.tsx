import { render, screen } from "@testing-library/react";
import StudentList from "./student-list";

describe("Student List", () => {
  it("should render successfully", async () => {
    render(<StudentList />);

    expect(await screen.findByText("Student List")).toBeTruthy();
  });
});
