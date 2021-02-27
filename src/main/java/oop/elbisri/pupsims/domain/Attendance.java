package oop.elbisri.pupsims.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Domain class for a Security Guard Attendance Log.
 * This represents the attendance of a Guard depending on
 * the specified date. The status field defines if the guard
 * has worked or not.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class Attendance {
	
	/**
	 * Determines if a Guard has worked or not.
	 * 
	 * @author Rian Carlo Reyes
	 *
	 */
	public static enum Status {
		PRESENT,
		ABSENT,
		ON_LEAVE;
	}
	
	/**
	 * Database ID.
	 */
	private Long id;
	
	// TODO: Replace with actual Security Guard object
	private Long securityGuardId;
	
	/**
	 * Date of this attendance record.
	 */
	private LocalDate logDate;
	
	/**
	 * Work in.
	 */
	private LocalDateTime workIn;
	
	/**
	 * Work out.
	 */
	private LocalDateTime workOut;
	
	/**
	 * Additional remarks.
	 */
	private String remarks;
	
	/**
	 * Whether the guard has worked or not for the specified logDate.
	 */
	private Status status;
	
	/**
	 * Creates a pre-initialized Attendance object.<br><br>
	 * 
	 * Typically used by JDBC code, when attendances are already saved and existing.
	 * Do not use this for creating attendances that must go with proper business logic.
	 * 
	 * @param id
	 * @param securityGuardId
	 * @param logDate
	 * @param workIn
	 * @param workOut
	 * @param remarks
	 * @param status
	 */
	public Attendance(Long id, Long securityGuardId, LocalDate logDate, LocalDateTime workIn, LocalDateTime workOut,
			String remarks, Status status) {
		super();
		this.id = id;
		this.securityGuardId = securityGuardId;
		this.logDate = logDate;
		this.workIn = workIn;
		this.workOut = workOut;
		this.remarks = remarks;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public Long getSecurityGuardId() {
		return securityGuardId;
	}

	public void setSecurityGuardId(Long securityGuardId) {
		this.securityGuardId = securityGuardId;
	}

	public LocalDate getLogDate() {
		return logDate;
	}

	public void setLogDate(LocalDate logDate) {
		this.logDate = logDate;
	}

	public LocalDateTime getWorkIn() {
		return workIn;
	}

	public void setWorkIn(LocalDateTime workIn) {
		this.workIn = workIn;
	}

	public LocalDateTime getWorkOut() {
		return workOut;
	}

	public void setWorkOut(LocalDateTime workOut) {
		this.workOut = workOut;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
