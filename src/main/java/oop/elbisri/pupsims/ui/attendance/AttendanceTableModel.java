package oop.elbisri.pupsims.ui.attendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;

public class AttendanceTableModel extends AbstractTableModel {

	private class AttendanceRecord {
		String securityGuardName;
		String date;
		String status;
		String workIn;
		String workOut;
	}

	/**
	 * Default Serial Version UID (for serializability, not important, placed to
	 * remove warnings)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Attendance Management Panel that owns this dialog box.
	 */
	protected ManagementPanel attendanceManagementPanel;

	/**
	 * Internal cache of this model.<br>
	 * <br>
	 * 
	 * A call to update() will update this cache, and prompts redraw of the
	 * listening JTable.
	 */
	private List<AttendanceRecord> internalCache;

	public AttendanceTableModel() {
		super();
		internalCache = new ArrayList<>();
	}

	/**
	 * Returns the column count of this Model.
	 * 
	 * @return the column count
	 */
	@Override
	public int getColumnCount() {
		/*
		 * Since the number of columns of this table is the same as the number of
		 * elements in the columnNames array, just return its length field.
		 */
		return 6;
	}

	/**
	 * Returns the column name on the specified columnIndex.
	 * 
	 * @param columnIndex the index of the column
	 * @return the column name
	 */
	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {

		case 0:
			return "#";

		case 1:
			return "Name";

		case 2:
			return "Date";

		case 3:
			return "Status";

		case 4:
			return "Work In";

		case 5:
			return "Work Out";

		default:
			return null;

		}
	}

	/**
	 * Gets the row count of this TableModel. It depends on how many elements there
	 * are in the internal cache.
	 * 
	 * @return the row count
	 */
	@Override
	public int getRowCount() {
		return internalCache.size();
	}

	/**
	 * Gets the value at the specified row and column. Since it has a backing
	 * repository as its source of data of attendances, a cache is implemented that
	 * gets updated only for certain events.
	 * 
	 * @param rowIndex    the row index of the value
	 * @param columnIndex the column index of the value
	 * @return the value
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Since each row in the Table refers to each element in the cache,
		// and apparently the indexing scheme of JTable is zero-based
		// (which is the same as the definition of the List ADT),
		// we can easily retrieve the attendance at the specified rowIndex.
		AttendanceRecord attendanceRecord = internalCache.get(rowIndex);

		// Depending on the column specified,
		// return the appropriate field of this attendance record.
		switch (columnIndex) {

		// First Column - Row Number (1-based for user-friendliness)
		case 0:
			return rowIndex + 1;

		// Second Column - Security Guard Name
		// TODO: Update this to output the name
		case 1:
			return attendanceRecord.securityGuardName;

		// Third Column - Date of this attendance log
		case 2:
			return attendanceRecord.date;

		// Fourth Column - Status of this attendance log
		case 3:
			return attendanceRecord.status;

		// Fifth Column - Work in of this attendance log
		case 4:
			return attendanceRecord.workIn;

		// Sixth Column - Work out of this attendance log
		case 5:
			return attendanceRecord.workOut;

		default:
			throw new IllegalArgumentException("Invalid column index.");

		}
	}

	/**
	 * Refreshes the TableModel with new data, and prompts redraw of the listening
	 * JTable.
	 */
	public void update() {
		// Construct a SwingWorker to fetch data from the repository,
		// and execute it.
		new SwingWorker<List<AttendanceRecord>, Void>() {
			@Override
			protected List<AttendanceRecord> doInBackground() throws Exception {
				try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pupsims_db",
						"pupsims", "pupsimspass_123");
						Statement retrieveStatement = connection.createStatement();
						ResultSet attendancesResultSet = retrieveStatement.executeQuery("SELECT * FROM attendance LEFT JOIN security_guard ON security_guard.employee_id = attendance.security_guard_id")) {

					List<AttendanceRecord> attendances = new ArrayList<>();
					while (attendancesResultSet.next()) {
						AttendanceRecord attendanceRecord = new AttendanceRecord();
						attendanceRecord.securityGuardName = attendancesResultSet.getString("first_name") + " " + attendancesResultSet.getString("last_name");
						attendanceRecord.date = attendancesResultSet.getString("log_date");
						attendanceRecord.status = attendancesResultSet.getString("log_status");
						attendanceRecord.workIn = attendancesResultSet.getString("work_in");
						attendanceRecord.workOut = attendancesResultSet.getString("work_out");
						attendances.add(attendanceRecord);
					}

					return attendances;
				}
			}

			@Override
			protected void done() {
				try {
					// Update the cache of this TableModel
					internalCache = get();
					// Notify JTable that data in this Model has changed
					fireTableDataChanged();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"An error occured while trying to load attendances.\n\nMessage: " + e);
				}
			}
		}.execute();
	}

}
