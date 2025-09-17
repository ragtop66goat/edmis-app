import reducer, { setEdmisAccountField } from "./edmisAccountSlice";

describe("edmisAccountSlice test", () => {
  const initialState = {
    firstName: "",
    lastName: "",
    middleName: "",
    email: "",
    mobilePhone: "",
    homePhone: "",
    addresses: [],
  };

  it("should initiate with correct state", () => {
    const result = reducer(undefined, { type: "" });

    expect(result).toEqual(initialState);
  });

  it("should update a non-address field", () => {
    const action = setEdmisAccountField({ field: "firstName", value: "Saske" });
    const result = reducer(initialState, action);

    expect(result.firstName).toEqual("Saske");
  });

  it("should update an adress field", () => {
    const addresses = [
      {
        streetAddress: "hokage",
        city: "Hidden Leaf",
        state: "CA",
        postalCode: "12345",
        country: "USA",
        addressType: "mailing",
      },
    ];

    const action = setEdmisAccountField({
      field: "addresses",
      value: addresses,
    });
    const result = reducer(initialState, action);

    expect(result.addresses).toEqual(addresses);
  });
});
