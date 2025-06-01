import { createSlice, PayloadAction } from "@reduxjs/toolkit";

interface IAddress {
  inCareOfName?: string;
  streetAddress: string;
  aptNumber?: string;
  city: string;
  state: string;
  postalCode: string;
  country: string;
  addressType: string;
}

interface IEdmisAccountState {
  firstName: string;
  lastName: string;
  middleName?: string;
  email: string;
  mobilePhone: string;
  homePhone: string;
  addresses: IAddress[];
}

const initialState: IEdmisAccountState = {
  firstName: "",
  lastName: "",
  middleName: "",
  email: "",
  mobilePhone: "",
  homePhone: "",
  addresses: [],
};

const edmisAccountSlice = createSlice({
  name: "contact",
  initialState,
  reducers: {
    setEdmisAccountField: <K extends keyof IEdmisAccountState>(
      state: IEdmisAccountState,
      action: PayloadAction<{ field: K; value: IEdmisAccountState[K] }>
    ) => {
      if (
        action.payload.field === "addresses" &&
        Array.isArray(action.payload.value)
      ) {
        state.addresses = [...state.addresses, ...action.payload.value];
      } else {
        state[action.payload.field] = action.payload.value;
      }
    },
    addAddress: (state, action: PayloadAction<IAddress>) => {
      state.addresses.push(action.payload);
    },
  },
});

export const { setEdmisAccountField } = edmisAccountSlice.actions;
export default edmisAccountSlice.reducer;
