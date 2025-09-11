import { Form } from "@trussworks/react-uswds";
import AddressSection from "../../components/form-components/address-section/address-section";
import ContactSection from "../../components/form-components/contact-section/contact-section";
import StandardButtonConfig from "../../components/form-components/button-configs/standard-button-config";
import { Address, Contact, RegistrationPayload } from "../../utils/types";
import { useApi } from "../../hooks/useApi";

export const RegisterStudent = () => {
  const { response, error, loading, makeRequest } = useApi({
    url: "http://localhost:8080/students",
    method: "POST",
    headers: { "Content-Type": "application/json" },
  });
  const mockSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const formData = new FormData(event.currentTarget);
    const rawData = Object.fromEntries(formData.entries());

    const contact: Contact = {
      firstName: rawData.firstName as String,
      middleName: rawData.middleName as String,
      lastName: rawData.lastName as String,
      email: rawData.email as String,
      mobilePhone: rawData.mobilePhone as String,
      homePhone: rawData.homePhone as String,
    };

    const addresses: Address[] = [
      {
        inCareOfName: rawData.inCareOfName as String,
        streetAddress: rawData.mailingStreetAddress as String,
        aptNumber: rawData.mailingAppartmentNumber as String,
        city: rawData.mailingCity as String,
        state: rawData.mailingState as String,
        postalCode: rawData.mailingZipCode as String,
        country: "US",
        addressType: "Mailing",
      },
      {
        streetAddress: rawData.physicalStreetAddress as String,
        aptNumber: rawData.physicalAppartmentNumber as String,
        city: rawData.physicalCity as String,
        state: rawData.physicalState as String,
        postalCode: rawData.physicalZipCode as String,
        country: "US",
        addressType: "Physical",
      },
    ];

    const payload: RegistrationPayload = {
      contact,
      addresses,
    };
    console.log(payload);
    await makeRequest(payload);
  };

  const handleClear = () => {};
  const handleCancel = () => {};

  return (
    <>
      <div className="margin-y-1">
        <h1>Student Registration</h1>
      </div>
      {loading && <p>Rpegistering your student.....</p>}
      {error && <p className="text-red">Error: {error}</p>}
      {response && <p className="test-green">Student registered sucessfully</p>}
      <Form onSubmit={mockSubmit} large>
        <ContactSection />
        <AddressSection />
        <StandardButtonConfig
          handleCancel={handleCancel}
          handleClear={handleClear}
        />
      </Form>
    </>
  );
};
