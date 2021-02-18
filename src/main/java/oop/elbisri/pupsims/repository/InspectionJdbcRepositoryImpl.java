package oop.elbisri.pupsims.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import oop.elbisri.pupsims.domain.Inspection;

/**
 * Repository of all inspection entities in the system.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class InspectionJdbcRepositoryImpl {
	
	/* All queries and other DML statements are defined here. 
	 * One per method defined in this repository.
	 */
	private static final String GET_ALL_QUERY = "SELECT inspection.*, inspection_issue.* FROM inspection LEFT JOIN inspection_issue ON inspection_issue.inspection_id = inspection.id";
	private static final String SAVE_INSPECTION_STATEMENT = "INSERT INTO inspection VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SAVE_ISSUES_BATCH_STATEMENT = "INSERT INTO inspection_issue VALUES (?, ?)";
	
	/**
	 * The main datasource that this repository retrieves and manipulates data.
	 */
	private final DataSource dataSource;
	
	/**
	 * Constructs a repository with the given datasource as its source of data
	 * for operations.
	 * 
	 * @param dataSource the source of data to execute queries against
	 */
	public InspectionJdbcRepositoryImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * Retrieves all inspections. <br><br>
	 * 
	 * @return
	 */
	public List<Inspection> getAll() {
		// Final list of all retrieved inspections
		List<Inspection> inspectionList = new ArrayList<>();
		
		try(
			// Make a connection	
			Connection connection = dataSource.getConnection();
			// Create the statement to be executed later
			Statement statement = connection.createStatement();
			// Execute a SELECT all statement (GET_ALL_QUERY) and grab the result set
			ResultSet inspectionResultSet = statement.executeQuery(GET_ALL_QUERY)) {
			
			Map<Long, List<String>> issueMap = new HashMap<>();
			
			while(inspectionResultSet.next()) {
				
				// If issue map already contains the id of this inspection row,
				// then simply grab the issue to the right
				if(issueMap.containsKey(inspectionResultSet.getLong(1)) && inspectionResultSet.getString(13) != null)
					issueMap.get(inspectionResultSet.getLong(1)).add(inspectionResultSet.getString(13));
				
				// Else, create an inspection object then grab the issue to the right
				else {
					// Create list of issues for this inspection
					List<String> inspectionIssuesList = new ArrayList<>();
					
					// If the column for an issue is not null in this row, retrieve it
					if(inspectionResultSet.getString(13) != null)
						inspectionIssuesList.add(inspectionResultSet.getString(13));
					
					// Put this constructed list into the map, mapping it to the id of the inspection
					issueMap.put(inspectionResultSet.getLong(1), inspectionIssuesList);
					
					// Construct an inspection object out of the row
					Inspection inspection = new Inspection(
							inspectionResultSet.getLong(1),
							Inspection.Building.valueOf(inspectionResultSet.getString(2)),
							inspectionResultSet.getInt(3),
							inspectionResultSet.getString(4),
							Inspection.GeneralCondition.valueOf(inspectionResultSet.getString(5)),
							inspectionResultSet.getLong(6),
							LocalDate.parse(inspectionResultSet.getString(7)),
							LocalTime.parse(inspectionResultSet.getString(8)),
							LocalTime.parse(inspectionResultSet.getString(9)),
							inspectionResultSet.getString(10),
							inspectionResultSet.getString(11),
							inspectionIssuesList);
					// Add the inspection to the final list
					inspectionList.add(inspection);
				}
			}
			
		} catch(SQLException e) {
			// TODO: Handle exceptions in a sophisticated manner.
			e.printStackTrace();
		}
		
		// Return the list.
		return inspectionList;
	}
	
	/**
	 * Saves the specified inspection object to the datasource.
	 * @param inspection the inspection to be saved
	 */
	public void save(Inspection inspection) {
		try(
			// Make a connection	
			Connection connection = dataSource.getConnection();
			// Create the insert inspection statement to be executed later
			PreparedStatement insertInspectionStatement =
					connection.prepareStatement(
							SAVE_INSPECTION_STATEMENT,
							Statement.RETURN_GENERATED_KEYS);
			// Create the insert issues statement to be executed later
			PreparedStatement insertIssuesStatement =
					connection.prepareStatement(SAVE_ISSUES_BATCH_STATEMENT)) {
			
			// Bind the violation fields to the prepared statement
			insertInspectionStatement.setString(1, inspection.getBuilding().toString());
			insertInspectionStatement.setInt(2, inspection.getFloorNumber());
			insertInspectionStatement.setString(3, inspection.getRoomNumbers());
			insertInspectionStatement.setString(4, inspection.getGeneralCondition().toString());
			insertInspectionStatement.setLong(5, inspection.getSecurityGuardId());
			insertInspectionStatement.setString(6, inspection.getDate().toString());
			insertInspectionStatement.setString(7, inspection.getTimeStarted().toString());
			insertInspectionStatement.setString(8, inspection.getTimeFinished().toString());
			insertInspectionStatement.setString(9, inspection.getDescription());
			insertInspectionStatement.setString(10, inspection.getOtherNotes());
			
			// Execute the insert inspection statement
			insertInspectionStatement.execute();
			
			// If there are issues to save, proceed
			if(inspection.getIssues().size() > 0) {
				// Get the generated id
				int generatedId = 0;
				try(ResultSet generatedIdResultSet = insertInspectionStatement.getGeneratedKeys()) {
					generatedIdResultSet.next();
					generatedId = generatedIdResultSet.getInt(1);
				}
				
				// Bind the issues of this inspection as a batch
				for(String issue : inspection.getIssues()) {
					insertIssuesStatement.setInt(1, generatedId);
					insertIssuesStatement.setString(2, issue);
					insertIssuesStatement.addBatch();
				}
				
				// Execute the batch insert issues statement
				insertIssuesStatement.executeBatch();
			}
		} catch(SQLException e) {
			// TODO: Handle exceptions in a sophisticated manner.
			e.printStackTrace();
		}
	}

}
