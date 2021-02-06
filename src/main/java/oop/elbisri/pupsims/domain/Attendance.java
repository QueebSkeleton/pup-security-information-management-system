package oop.elbisri.pupsims.domain;

import java.time.LocalDate;

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
	 * @param status
	 */
	public Attendance(Long id, Long securityGuardId, LocalDate logDate, Status status) {
		super();
		this.id = id;
		this.securityGuardId = securityGuardId;
		this.logDate = logDate;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
