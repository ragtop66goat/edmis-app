import { screen } from "@testing-library/react";
import { act } from "react";
import userEvent from "@testing-library/user-event";
import Layout from "./layout";
import { renderWithRouter } from "../../test-utils/test-utils";

describe("Layout component tests", () => {
  beforeEach(() => {
    renderWithRouter(<Layout />);
  });

  it("should render sucessfully", async () => {
    expect((await screen.findAllByText(/edmis/i)).length).toEqual(2);
  });

  it("should call setMobielExpanded", async () => {
    const user = userEvent.setup();

    const menuButtons = screen.getAllByRole("button", { name: /menu/i });
    console.log(menuButtons.map((btn) => btn.outerHTML));
    const menuButton = menuButtons[0];

    expect(menuButton).toHaveAttribute("aria-expanded", "false");

    await act(async () => {
      await user.click(menuButton);
    });

    expect(menuButton).toHaveAttribute("aria-expanded", "true");

    await act(async () => {
      await user.click(menuButton);
    });

    expect(menuButton).toHaveAttribute("aria-expanded", "false");
  });
});
