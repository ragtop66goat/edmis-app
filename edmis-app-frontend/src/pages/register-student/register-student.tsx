import ContactSection from "../../components/form-components/contact-section";
import StandardButtonConfig from "../../components/form-components/standard-button-config";

export const RegisterStudent = () => {
  return (
    <>
      <div className="margin-y-1">
        <h1>Register Student</h1>
      </div>
      <ContactSection />
      <div className="margin-y-1">
        <StandardButtonConfig />
      </div>
    </>
  );
};
