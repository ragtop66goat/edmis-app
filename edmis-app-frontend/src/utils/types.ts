export type Contact = {
  firstName: String;
  lastName: String;
  middleName: String;
  email: String;
  mobilePhone: String;
  homePhone: String;
};

export type Address = {
  inCareOfName?: String;
  streetAddress: String;
  aptNumber: String;
  city: String;
  state: String;
  postalCode: String;
  country: String;
  addressType: String;
};

export type RegistrationPayload = {
  contact: Contact;
  addresses: Address[];
};
