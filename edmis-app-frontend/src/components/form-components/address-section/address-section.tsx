import {
  Fieldset,
  RequiredMarker,
  Label,
  TextInput,
} from "@trussworks/react-uswds";
import StateSelector from "../state-selector/state-selector";

const AddressSection = () => {
  return (
    <>
      <Fieldset legend="Mailing Address" legendStyle="large">
        <p>
          Required fields are marked with an asterisk (<RequiredMarker />
          ).
        </p>
        <Label htmlFor="inCareOfName">Mailing in Care of Name</Label>
        <TextInput id="inCareOfName" name="inCareOfName" type="text" />
        <Label htmlFor="mailingStreetAddress">Street address</Label>
        <TextInput
          id="mailingStreetAddress"
          name="mailingStreetAddress"
          type="text"
        />

        <Label htmlFor="mailingAppartmentNumber">Appartment Number</Label>
        <TextInput
          id="mailingAppartmentNumber"
          name="mailingAppartmentNumber"
          type="text"
        />

        <Label htmlFor="mailingCity" requiredMarker>
          City
        </Label>
        <TextInput id="mailingCity" name="mailingCity" type="text" required />

        <Label htmlFor="mailingState" requiredMarker>
          State, territory, or military post
        </Label>
        <StateSelector id="mailngState" name="mailingState" />
        <Label htmlFor="mailingZipCode">ZIP Code</Label>
        <TextInput
          id="mailingZipCode"
          name="mailingZipCode"
          type="text"
          inputSize="medium"
          pattern="[\d]{5}(-[\d]{4})?"
        />
      </Fieldset>
      <Fieldset legend="Physical Address" legendStyle="large">
        <p>
          Required fields are marked with an asterisk (<RequiredMarker />
          ).
        </p>
        <Label htmlFor="physicalStreetAddress">Street address</Label>
        <TextInput
          id="physicalStreetAddress"
          name="physicalStreetAddress"
          type="text"
        />

        <Label htmlFor="physicalAppartmentNumber">Appartment Number</Label>
        <TextInput
          id="physicalAppartmentNumber"
          name="physicalAppartmentNumber"
          type="text"
        />

        <Label htmlFor="physicalCity" requiredMarker>
          City
        </Label>
        <TextInput id="physicalCity" name="physicalCity" type="text" required />

        <Label htmlFor="physicalState" requiredMarker>
          State, territory, or military post
        </Label>
        <StateSelector id="physicalState" name="physicalState" />
        <Label htmlFor="physicalZipCode">ZIP Code</Label>
        <TextInput
          id="physicalZipCode"
          name="physicalZipCode"
          type="text"
          inputSize="medium"
          pattern="[\d]{5}(-[\d]{4})?"
        />
      </Fieldset>
    </>
  );
};

export default AddressSection;
