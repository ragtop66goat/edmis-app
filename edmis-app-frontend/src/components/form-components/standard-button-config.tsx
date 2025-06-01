interface IStandardButtonConfigProps {
  handleClear: () => void;
  handleCancel: () => void;
}

const StandardButtonConfig = (props: IStandardButtonConfigProps) => {
  const { handleClear, handleCancel } = props;
  return (
    <div className="button-group">
      <button
        className="usa-button usa-button--outline"
        type="button"
        id="student-form-clear"
        onClick={handleClear}
      >
        Clear
      </button>
      <button
        className="usa-button usa-button--secondary"
        type="button"
        id="student-form-cancel"
        onClick={handleCancel}
      >
        Cancel
      </button>
      <button className="usa-button" type="submit" id="student-form-submit">
        Submit
      </button>
    </div>
  );
};

export default StandardButtonConfig;
