import "./App.css";
import "@uswds/uswds/css/uswds.css";
import ContactSection from "./components/form-components/contact-section";
import StandardButtonConfig from "./components/form-components/standard-button-config";
import { RegisterStudent } from "./pages/register-student/register-student";

function App() {
  return (
    <>
      <RegisterStudent />
    </>
  );
}

export default App;
