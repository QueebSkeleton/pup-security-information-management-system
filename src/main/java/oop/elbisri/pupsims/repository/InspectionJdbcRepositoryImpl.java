package oop.elbisri.pupsims.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
