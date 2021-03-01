package oop.elbisri.pupsims.ui.violation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;

public class ViolationTableModel extends AbstractTableModel {
	
	private class ViolationRecord {
		String type;
		String name;
		String when;
		String status;
	}

	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Column names for this model.
	 */
	private static final String[] columnNames = { "#", "Type", "Name", "When", "Status" };
	
	/**
	 * Violation Management Panel that owns this dialog box.
	 */
	protected ManagementPanel violationManagementPanel;
	
	/**
	 * Internal cache of this model.<br><br>
	 * 
	 * A call to update() will update this cache, and prompts
	 * redraw of the listening JTable.
	 */
	private List<ViolationRecord> internalCache;
	
	public ViolationTableModel() {
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
		/* Since the number of columns of this table
		 * is the same as the number of elements in the columnNames array,
		 * just return its length field.
		 */
		return columnNames.length;
	}
	
	/**
	 * Returns the column name on the specified columnIndex.
	 * 
	 * @param columnIndex the index of the column
	 * @return the column name
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	/**
	 * Gets the row count of this TableModel. It depends
	 * on how many elements there are in the internal cache.
	 * 
	 * @return the row count
	 */
	@Override
	public int getRowCount() {
		return internalCache.size();
	}

	/**
	 * Gets the value at the specified row and column.
	 * Since it has a backing repository as its source of data of attendances,
	 * a cache is implemented that gets updated only for certain events.
	 * 
	 * @param rowIndex the row index of the value
	 * @param columnIndex the column index of the value
	 * @return the value
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Since each row in the Table refers to each element in the cache,
		// and apparently the indexing scheme of JTable is zero-based
		// (which is the same as the definition of the List ADT),
		// we can easily retrieve the violation at the specified rowIndex.
		ViolationRecord violationRecord = internalCache.get(rowIndex);
		
		// Depending on the column specified,
		// return the appropriate field of this attendance record.
		switch(columnIndex) {
		
		// First Column - Row Number (1-based for user-friendliness)
		case 0:
			return rowIndex + 1;
			
		// Second Column - Type
		case 1:
			return violationRecord.type;
			
		// Third Column - Violator Name
		case 2:
			return violationRecord.name;
			
		// Fourth Column - Committed on
		case 3:
			return violationRecord.when;
			
		// Fifth Column - Status of violation
		case 4:
			return violationRecord.status;
			
		default:
			return null;
		
		}
	}
	
	/**
	 * Refreshes the TableModel with new data, and prompts redraw
	 * of the listening JTable.
	 */
	public void update() {
		// Construct a SwingWorker to fetch data from the repository,
		// and execute it.
		new SwingWorker<List<ViolationRecord>, Void>() {
			@Override
			protected List<ViolationRecord> doInBackground() throws Exception {
				try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pupsims_db",
						"pupsims", "pupsimspass_123");
						Statement retrieveStatement = connection.createStatement();
						ResultSet violationsResultSet = retrieveStatement.executeQuery("SELECT * FROM violation")) {

					List<ViolationRecord> violations = new ArrayList<>();
					while (violationsResultSet.next()) {
						ViolationRecord violationRecord = new ViolationRecord();
						violationRecord.type = violationsResultSet.getString("type");
						violationRecord.name = violationsResultSet.getString("violator_name");
						violationRecord.when = violationsResultSet.getString("committed_on");
						violationRecord.status = violationsResultSet.getString("status");
						violations.add(violationRecord);
					}

					return violations;
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
							"An error occured while trying to load violations.\n\nMessage: " + e);
				}
			}
		}.execute();
	}

}
