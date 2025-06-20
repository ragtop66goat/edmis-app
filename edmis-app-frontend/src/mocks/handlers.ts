import { rest } from "msw";

export const handlers = [
  rest.get("/todos", (req, res, ctx) => {
    return res(
      ctx.status(200),
      ctx.json([
        {
          userId: 1,
          title: "Wave hello",
          completed: false,
          id: 1,
        },
      ])
    );
  }),
];
