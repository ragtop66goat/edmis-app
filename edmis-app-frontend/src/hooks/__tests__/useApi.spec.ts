import { renderHook, act } from "@testing-library/react";
import { useApi } from "../useApi";
import { server } from "../../mocks/server";
import { rest } from "msw";

describe("useApi hook", () => {
  it("should return the correct todo item", async () => {
    server.use(
      rest.get("/todos", (req, res, ctx) => {
        return res(
          ctx.status(200),
          ctx.json({
            userId: 1,
            title: "Wave hello",
            completed: false,
            id: 1,
          })
        );
      })
    );

    const { result } = renderHook(() =>
      useApi({
        url: "/todos",
      })
    );

    await act(async () => {
      await result.current.makeRequest();
    });

    expect(result.current.response).toEqual({
      userId: 1,
      title: "Wave hello",
      completed: false,
      id: 1,
    });
  });
});
