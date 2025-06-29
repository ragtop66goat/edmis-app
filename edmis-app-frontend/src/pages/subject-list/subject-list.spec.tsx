import { render, screen } from "@testing-library/react";
import SubjectList from "./subject-list";

describe("Subject List", () => {
  it("should render successfully", async () => {
    render(<SubjectList />);

    expect(await screen.findByText("Subject List")).toBeTruthy();
  });
});
