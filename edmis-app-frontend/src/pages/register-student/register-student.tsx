import { Form } from "@trussworks/react-uswds";
import AddressSection from "../../components/form-components/address-section/address-section";
import ContactSection from "../../components/form-components/contact-section/contact-section";
import StandardButtonConfig from "../../components/form-components/button-configs/standard-button-config";
import { Address, Contact, RegistrationPayload } from "../../utils/types";
import { useApi } from "../../hooks/useApi";
import { useRef } from "react";

export const RegisterStudent = () => {
  // Wrapper ref to access the DOM form later
  const wrapperRef = useRef<HTMLDivElement | null>(null);

  const { response, error, loading, makeRequest } = useApi({
    url: "http://localhost:8080/students",
    method: "POST",
    headers: { "Content-Type": "application/json" },
  });

  const getFormElement = () => {
    return wrapperRef.current?.querySelector("form") as HTMLFormElement | null;
  };

  const submit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    const formEl = getFormElement();
    if (!formEl) return;

    const formData = new FormData(formEl);
    const rawData = Object.fromEntries(formData.entries());

    const contact: Contact = {
      firstName: rawData.firstName as string,
      middleName: rawData.middleName as string,
      lastName: rawData.lastName as string,
      email: rawData.email as string,
      mobilePhone: rawData.mobilePhone as string,
      homePhone: rawData.homePhone as string,
    };

    const addresses: Address[] = [
      {
        inCareOfName: rawData.inCareOfName as string,
        streetAddress: rawData.mailingStreetAddress as string,
        aptNumber: rawData.mailingAppartmentNumber as string,
        city: rawData.mailingCity as string,
        state: rawData.mailingState as string,
        postalCode: rawData.mailingZipCode as string,
        country: "US",
        addressType: "Mailing",
      },
      {
        streetAddress: rawData.physicalStreetAddress as string,
        aptNumber: rawData.physicalAppartmentNumber as string,
        city: rawData.physicalCity as string,
        state: rawData.physicalState as string,
        postalCode: rawData.physicalZipCode as string,
        country: "US",
        addressType: "Physical",
      },
    ];

    const payload: RegistrationPayload = { contact, addresses };
    await makeRequest(payload);

    formEl.reset();
  };

  const handleClear = () => {
    const formEl = getFormElement();
    if (window.confirm("Are you sure you want to clear the form?")) {
      formEl?.reset();
    }
  };

  return (
    <>
      <div className="margin-y-1">
        <h1>Student Registration</h1>
      </div>

      {loading && <p>Registering your student.....</p>}
      {error && <p className="text-red">Error: {error}</p>}
      {response && (
        <p className="text-green">Student registered successfully</p>
      )}

      <div ref={wrapperRef}>
        <Form onSubmit={submit} large>
          <ContactSection />
          <AddressSection />
          <StandardButtonConfig handleClear={handleClear} />
        </Form>
      </div>
    </>
  );
};
