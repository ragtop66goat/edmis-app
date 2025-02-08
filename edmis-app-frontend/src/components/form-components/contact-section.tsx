import { useDispatch, useSelector } from "react-redux";
import type { RootState, AppDispatch } from "../../store";
import { setContactField } from "../../store/contactSlice";

export const ContactSection = () => {
  const dispatch = useDispatch<AppDispatch>();
  const contact = useSelector((state: RootState) => state.contact);

  const handleChange =
    (field: keyof typeof contact) =>
    (e: React.ChangeEvent<HTMLInputElement>) => {
      dispatch(setContactField({ field, value: e.target.value }));
    };

  return (
    <>
      <label className="usa-label" htmlFor="firstName">
        First Name
      </label>
      <input
        className="usa-input"
        id="firstName"
        name="firstName"
        type="text"
        value={contact.firstName}
        onChange={handleChange("firstName")}
      />
      <label className="usa-label" htmlFor="lastName">
        Last Name
      </label>
      <input
        className="usa-input"
        id="lastName"
        name="lastName"
        type="text"
        value={contact.lastName}
        onChange={handleChange("lastName")}
      />
      <label className="usa-label" htmlFor="email">
        Email
      </label>
      <input
        className="usa-input"
        id="email"
        name="email"
        type="email"
        value={contact.email}
        onChange={handleChange("email")}
      />
      <label className="usa-label" htmlFor="mobilePhone">
        Mobile Phone
      </label>
      <input
        className="usa-input"
        id="mobilePhone"
        name="mobilePhone"
        type="text"
        value={contact.mobilePhone}
        onChange={handleChange("mobilePhone")}
      />
      <label className="usa-label" htmlFor="homePhone">
        Home Phone
      </label>
      <input
        className="usa-input"
        id="homePhone"
        name="homePhone"
        type="text"
        value={contact.homePhone}
        onChange={handleChange("homePhone")}
      />
    </>
  );
};

export default ContactSection;
