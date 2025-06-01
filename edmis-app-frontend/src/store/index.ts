import { configureStore } from "@reduxjs/toolkit";
import edmisAccountReducer from "./edmisAccountSlice";

export const store = configureStore({
  reducer: {
    edmisAccount: edmisAccountReducer,
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
