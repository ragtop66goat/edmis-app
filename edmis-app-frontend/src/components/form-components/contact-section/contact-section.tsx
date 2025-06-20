export const ContactSection = () => {
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
      />
      <label className="usa-label" htmlFor="middleName">
        Middle Name
      </label>
      <input
        className="usa-input"
        id="middleName"
        name="middleName"
        type="text"
      />
      <label className="usa-label" htmlFor="lastName">
        Last Name
      </label>
      <input className="usa-input" id="lastName" name="lastName" type="text" />
      <label className="usa-label" htmlFor="email">
        Email
      </label>
      <input className="usa-input" id="email" name="email" type="email" />
      <label className="usa-label" htmlFor="mobilePhone">
        Mobile Phone
      </label>
      <input
        className="usa-input"
        id="mobilePhone"
        name="mobilePhone"
        type="text"
      />
      <label className="usa-label" htmlFor="homePhone">
        Home Phone
      </label>
      <input
        className="usa-input"
        id="homePhone"
        name="homePhone"
        type="text"
      />
    </>
  );
};

export default ContactSection;
