package oop.elbisri.pupsims.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Domain class for an inspection.<br><br>
 * 
 * Contains necessary information for an inspection
 * done by a security guard, for a specific building and floor.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class Inspection {

	/**
	 * Buildings to be inspected in the PUP Main Branch.
	 * 
	 * @author Rian Carlo Reyes
	 *
	 */
	public static enum Building {
		MAIN_NORTH_WING, MAIN_EAST_WING, MAIN_SOUTH_WING, MAIN_WEST_WING, MAIN_CHK, MAIN_ALUMNUS_BUILDING,
		MAIN_OVAL_TAHANAN_NG_ALUMNI, MAIN_OVAL_STAGE, COLLEGE_OF_COMMUNICATION, COLLEGE_OF_ENGINEERING_AND_ARCHITECTURE,
		INSTITUTE_OF_TECHNOLOGY, CONDOTEL, HASMIN;
	}

	/**
	 * General Condition that describes an inspection.
	 * 
	 * @author Rian Carlo Reyes
	 *
	 */
	public static enum GeneralCondition {
		GOOD, MEDIOCRE, BAD;
	}

	// Database id
	private Long id;
	
	// Information about the building that was inspected
	private Building building;
	private int floorNumber;
	private String roomNumbers;
	
	// General information about the inspection
	private GeneralCondition generalCondition;
	
	// Who performed the inspection
	private Long securityGuardId;
	
	// When this inspection was conducted
	private LocalDate date;
	private LocalTime timeStarted;
	private LocalTime timeFinished;
	
	// Descriptive information about this information
	private String description;
	private String otherNotes;
	
	// Necessary issues tracked here
	private List<String> issues;

	/**
	 * Constructs a fresh inspection with the specified fields.
	 * 
	 * @param building
	 * @param floorNumber
	 * @param roomNumbers
	 * @param generalCondition
	 * @param securityGuardId
	 * @param date
	 * @param timeStarted
	 * @param timeFinished
	 * @param description
	 * @param otherNotes
	 * @param issues
	 */
	public Inspection(Building building, int floorNumber, String roomNumbers, GeneralCondition generalCondition,
			Long securityGuardId, LocalDate date, LocalTime timeStarted, LocalTime timeFinished, String description,
			String otherNotes, List<String> issues) {
		super();
		this.building = building;
		this.floorNumber = floorNumber;
		this.roomNumbers = roomNumbers;
		this.generalCondition = generalCondition;
		this.securityGuardId = securityGuardId;
		this.date = date;
		this.timeStarted = timeStarted;
		this.timeFinished = timeFinished;
		this.description = description;
		this.otherNotes = otherNotes;
		this.issues = issues;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getRoomNumbers() {
		return roomNumbers;
	}

	public void setRoomNumbers(String roomNumbers) {
		this.roomNumbers = roomNumbers;
	}

	public GeneralCondition getGeneralCondition() {
		return generalCondition;
	}

	public void setGeneralCondition(GeneralCondition generalCondition) {
		this.generalCondition = generalCondition;
	}

	public Long getSecurityGuardId() {
		return securityGuardId;
	}

	public void setSecurityGuardId(Long securityGuardId) {
		this.securityGuardId = securityGuardId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTimeStarted() {
		return timeStarted;
	}

	public void setTimeStarted(LocalTime timeStarted) {
		this.timeStarted = timeStarted;
	}

	public LocalTime getTimeFinished() {
		return timeFinished;
	}

	public void setTimeFinished(LocalTime timeFinished) {
		this.timeFinished = timeFinished;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOtherNotes() {
		return otherNotes;
	}

	public void setOtherNotes(String otherNotes) {
		this.otherNotes = otherNotes;
	}

	public List<String> getIssues() {
		return issues;
	}

	public void setIssues(List<String> issues) {
		this.issues = issues;
	}

	public Long getId() {
		return id;
	}

}
