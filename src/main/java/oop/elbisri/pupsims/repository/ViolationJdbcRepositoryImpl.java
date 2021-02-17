package oop.elbisri.pupsims.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
