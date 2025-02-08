import { createSlice, PayloadAction } from "@reduxjs/toolkit";

interface IContactState {
    firstName: string;
    lastName: string;
    email: string;
    mobilePhone: string;
    homePhone: string;
};

const initialState: IContactState = {
    firstName: "",
    lastName: "",
    email: "",
    mobilePhone: "",
    homePhone: ""
};

const contactSlice = createSlice({
    name: "contact",
    initialState,
    reducers: {
        setContactField: <K extends keyof IContactState>(
            state: IContactState,
            action: PayloadAction<{field: K, value: IContactState[K]}>
        ) => {
            state[action.payload.field] = action.payload.value;
        }
    }
});

export const { setContactField } = contactSlice.actions;
export default contactSlice.reducer;