const StandardButtonConfig = () => {
  return (
    <div className="button-group">
      <button
        className="usa-button usa-button--outline"
        type="button"
        id="student-form-clear"
      >
        Clear
      </button>
      <button
        className="usa-button usa-button--secondary"
        type="button"
        id="student-form-cancel"
      >
        Cancel
      </button>
      <button 
        className="usa-button" 
        type="button" 
        id="student-form-submit"
    >
        Submit
      </button>
    </div>
  );
};

export default StandardButtonConfig;
