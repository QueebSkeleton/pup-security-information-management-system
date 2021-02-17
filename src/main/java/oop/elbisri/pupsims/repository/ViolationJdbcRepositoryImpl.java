package oop.elbisri.pupsims.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import oop.elbisri.pupsims.domain.Violation;

/**
 * Repository of all violation entities in the system.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class ViolationJdbcRepositoryImpl {
	
	/* All queries and other DML statements are defined here. 
	 * One per method defined in this repository.
	 */
	private static final String GET_ALL_QUERY = "SELECT * FROM violation";
	private static final String SAVE_STATEMENT = "INSERT INTO violation VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
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
	public ViolationJdbcRepositoryImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * Retrieves all Violations. <br><br>
	 * 
	 * This method executes a select all for the attendance table in the specified datasource,
	 * and maps each record in the result to an Attendance object.
	 * 
	 * @return
	 */
	public List<Violation> getAll() {
		// Final list of all retrieved violations
		List<Violation> violationList = new LinkedList<>();
		
		try(
			// Make a connection	
			Connection connection = dataSource.getConnection();
			// Create the statement to be executed later
			Statement statement = connection.createStatement();
			// Execute a SELECT all statement (GET_ALL_QUERY) and grab the result set
			ResultSet violationResultSet = statement.executeQuery(GET_ALL_QUERY)) {
			
			// Loop through each record
			// map it to a violation object,
			// and add it to the final list
			while(violationResultSet.next())
				violationList.add(
						new Violation(
								violationResultSet.getLong(1),
								violationResultSet.getString(2),
								violationResultSet.getString(3),
								violationResultSet.getString(4),
								violationResultSet.getString(5),
								violationResultSet.getString(6),
								LocalDateTime.parse(violationResultSet.getString(7),
										DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
								Violation.Status.valueOf(violationResultSet.getString(8)),
								violationResultSet.getString(9),
								violationResultSet.getString(10),
								violationResultSet.getString(11)));
			
		} catch(SQLException e) {
			// TODO: Handle exceptions in a sophisticated manner.
			e.printStackTrace();
		}
		
		// Return the list.
		return violationList;
	}
	
	/**
	 * Saves the specified violation object to the datasource.
	 * @param violation the violation to be saved
	 */
	public void save(Violation violation) {
		try(
			// Make a connection	
			Connection connection = dataSource.getConnection();
			// Create the statement to be executed later
			PreparedStatement insertViolationStatement =
					connection.prepareStatement(SAVE_STATEMENT)) {
			
			// Bind the violation fields to the prepared statement
			insertViolationStatement.setString(1, violation.getViolatorName());
			insertViolationStatement.setString(2, violation.getViolatorAddress());
			insertViolationStatement.setString(3, violation.getViolatorContactNumber());
			insertViolationStatement.setString(4, violation.getViolatorCompany());
			insertViolationStatement.setString(5, violation.getType());
			insertViolationStatement.setString(6, violation.getCommittedOn().toString());
			insertViolationStatement.setString(7, violation.getStatus().toString());
			insertViolationStatement.setString(8, violation.getViolatedLaw());
			insertViolationStatement.setString(9, violation.getDescription());
			insertViolationStatement.setString(10, violation.getViolatorStatement());
			
			// Execute the insert statement
			insertViolationStatement.execute();
		} catch(SQLException e) {
			// TODO: Handle exceptions in a sophisticated manner.
			e.printStackTrace();
		}
	}

}
