package oop.elbisri.pupsims.domain;

import java.time.LocalDateTime;

/**
 * Domain class for a Violation.
 * This represents an individual violation report
 * including all necessary information about what
 * happened.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class Violation {

	/**
	 * Status that determines what was done with this violation so far.
	 * 
	 * @author Rian Carlo Reyes
	 *
	 */
	public static enum Status {
		PENDING, VIEWED, DISCARDED;
	}

	// Database id
	private Long id;
	
	// Violator Personal Information
	private String violatorName;
	private String violatorAddress;
	private String violatorContactNumber;
	private String violatorCompany;

	// Type of violation committed
	private String type;

	// When this violation was committed
	private LocalDateTime committedOn;

	// Status of this violation so far
	private Status status;

	// Information regarding the law or code
	private String violatedLaw;

	// Main descriptive information of this violation
	private String description;

	// Statement of the violator
	private String violatorStatement;

	/**
	 * Constructs a fresh violation with all the specified fields.
	 * 
	 * @param violatorName
	 * @param violatorAddress
	 * @param violatorContactNumber
	 * @param violatorCompany
	 * @param type
	 * @param committedOn
	 * @param status
	 * @param violatedLaw
	 * @param description
	 * @param violatorStatement
	 */
	public Violation(String violatorName, String violatorAddress, String violatorContactNumber, String violatorCompany,
			String type, LocalDateTime committedOn, Status status, String violatedLaw, String description,
			String violatorStatement) {
		super();
		this.violatorName = violatorName;
		this.violatorAddress = violatorAddress;
		this.violatorContactNumber = violatorContactNumber;
		this.violatorCompany = violatorCompany;
		this.type = type;
		this.committedOn = committedOn;
		this.status = status;
		this.violatedLaw = violatedLaw;
		this.description = description;
		this.violatorStatement = violatorStatement;
	}

	/**
	 * Constructs a Violation object with pre-initialized data.<br><br>
	 * 
	 * Only used by JDBC code when fetching violations from the database.
	 * 
	 * @param id the database id
	 * @param violatorName
	 * @param violatorAddress
	 * @param violatorContactNumber
	 * @param violatorCompany
	 * @param type
	 * @param committedOn
	 * @param status
	 * @param violatedLaw
	 * @param description
	 * @param violatorStatement
	 */
	public Violation(Long id, String violatorName, String violatorAddress, String violatorContactNumber,
			String violatorCompany, String type, LocalDateTime committedOn, Status status, String violatedLaw,
			String description, String violatorStatement) {
		super();
		this.id = id;
		this.violatorName = violatorName;
		this.violatorAddress = violatorAddress;
		this.violatorContactNumber = violatorContactNumber;
		this.violatorCompany = violatorCompany;
		this.type = type;
		this.committedOn = committedOn;
		this.status = status;
		this.violatedLaw = violatedLaw;
		this.description = description;
		this.violatorStatement = violatorStatement;
	}

	public String getViolatorName() {
		return violatorName;
	}

	public void setViolatorName(String violatorName) {
		this.violatorName = violatorName;
	}

	public String getViolatorAddress() {
		return violatorAddress;
	}

	public void setViolatorAddress(String violatorAddress) {
		this.violatorAddress = violatorAddress;
	}

	public String getViolatorContactNumber() {
		return violatorContactNumber;
	}

	public void setViolatorContactNumber(String violatorContactNumber) {
		this.violatorContactNumber = violatorContactNumber;
	}

	public String getViolatorCompany() {
		return violatorCompany;
	}

	public void setViolatorCompany(String violatorCompany) {
		this.violatorCompany = violatorCompany;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getCommittedOn() {
		return committedOn;
	}

	public void setCommittedOn(LocalDateTime committedOn) {
		this.committedOn = committedOn;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getViolatedLaw() {
		return violatedLaw;
	}

	public void setViolatedLaw(String violatedLaw) {
		this.violatedLaw = violatedLaw;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getViolatorStatement() {
		return violatorStatement;
	}

	public void setViolatorStatement(String violatorStatement) {
		this.violatorStatement = violatorStatement;
	}

	public Long getId() {
		return id;
	}

}
