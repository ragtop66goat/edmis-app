import { render } from "@testing-library/react";
import App from "./App";

describe("App test", () => {
  it("should render sucessfully", () => {
    const { baseElement } = render(<App />);

    expect(baseElement).toBeTruthy();
  });
});
