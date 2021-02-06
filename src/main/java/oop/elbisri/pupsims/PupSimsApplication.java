package oop.elbisri.pupsims;

import javax.swing.SwingUtilities;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import oop.elbisri.pupsims.repository.AttendanceJdbcRepositoryImpl;
import oop.elbisri.pupsims.ui.MainFrame;

/**
 * PUP-SIMS Application Entry Point.<br><br>
 * 
 * Creates all main application objects here and wires them together.
 * 
 * @author Rian Reyes
 *
 */
public class PupSimsApplication {
	
	public static void main(String[] args) {
		
		// Create MySQL DataSource
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/pupsims_db");
		dataSource.setUser("pupsims");
		dataSource.setPassword("pupsimspass_123");
		
		// Create Attendance Repository
		AttendanceJdbcRepositoryImpl attendanceRepository = new AttendanceJdbcRepositoryImpl(dataSource);
		
		SwingUtilities.invokeLater(() -> {
			MainFrame mainFrame = new MainFrame();
			mainFrame.setAttendanceRepository(attendanceRepository);
			mainFrame.setVisible(true);
		});
		
	}

}
