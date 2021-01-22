package oop.elbisri.pupsims.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import oop.elbisri.pupsims.domain.Attendance;

/**
 * Repository for mapping each record in the `attendance` table
 * to an Attendance object.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class AttendanceJdbcRepositoryImpl {
	
	/* All queries and other DML statements are defined here. 
	 * One per method defined in this repository.
	 */
	private static final String GET_ALL_QUERY = "SELECT * FROM attendance";
	
	/**
	 * The main datasource that this repository retrieves and manipulates data.
	 */
	private DataSource dataSource;
	
	/**
	 * Constructs a repository with the given datasource as its source of data
	 * for operations.
	 * 
	 * @param dataSource the source of data to execute queries against
	 */
	public AttendanceJdbcRepositoryImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * Retrieves all Attendances. <br><br>
	 * 
	 * This method executes a select all for the attendance table in the specified datasource,
	 * and maps each record in the result to an Attendance object.
	 * 
	 * @return
	 */
	public List<Attendance> getAll() {
		// Final list of all retrieved attendances
		List<Attendance> attendanceList = new LinkedList<>();
		
		try(
			// Make a connection	
			Connection connection = dataSource.getConnection();
			// Create the statement to be executed later
			Statement statement = connection.createStatement();
			// Execute a SELECT all statement (GET_ALL_QUERY) and grab the result set
			ResultSet attendanceResultSet = statement.executeQuery(GET_ALL_QUERY)) {
			
			// Loop through each record
			// map it to an attendance object,
			// and add it to the final list
			while(attendanceResultSet.next())
				attendanceList.add(
						new Attendance(
							attendanceResultSet.getLong("id"),
							attendanceResultSet.getLong("security_guard_id"),
							LocalDate.parse(attendanceResultSet.getString("log_date")),
							Attendance.Status.valueOf(attendanceResultSet.getString("log_status"))));
			
		} catch(SQLException e) {
			// TODO: Handle exceptions in a sophisticated manner.
			e.printStackTrace();
		}
		
		// Return the list.
		return attendanceList;
	}
	
	public void save(Attendance attendance) {
		throw new UnsupportedOperationException("Save not yet supported.");
	}

}
