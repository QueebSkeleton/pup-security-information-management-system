package oop.elbisri.pupsims.ui.attendance;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import oop.elbisri.pupsims.domain.Attendance;

public class PaginatingTableModel extends AbstractTableModel {

	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Column names for this model.
	 */
	private static final String[] columnNames = { "#", "Name", "Date", "Status" };
	
	/**
	 * Attendance Management Panel that owns this dialog box.
	 */
	protected ManagementPanel attendanceManagementPanel;
	
	/**
	 * Internal cache of this model.<br><br>
	 * 
	 * A call to update() will update this cache, and prompts
	 * redraw of the listening JTable.
	 */
	private List<Attendance> cache;

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
		if(cache == null)
			return 0;
		
		return cache.size();
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
		// we can easily retrieve the attendance at the specified rowIndex.
		Attendance attendance = cache.get(rowIndex);
		
		// Depending on the column specified,
		// return the appropriate field of this attendance record.
		switch(columnIndex) {
		
		// First Column - Row Number (1-based for user-friendliness)
		case 0:
			return rowIndex + 1;
			
		// Second Column - Security Guard Name
		// TODO: Update this to output the name
		case 1:
			return attendance.getSecurityGuardId();
			
		// Third Column - Date of this attendance log
		case 2:
			return attendance.getLogDate();
			
		// Fourth Column - Status of this attendance log
		case 3:
			return attendance.getStatus();
			
		default:
			throw new IllegalArgumentException("Invalid column index.");
		
		}
	}
	
	/**
	 * Refreshes the TableModel with new data, and prompts redraw
	 * of the listening JTable.
	 */
	public void update() {
		repopulateCache();
		fireTableDataChanged();
	}
	
	/**
	 * Convenience method for updating the cache.
	 */
	private void repopulateCache() {
		cache = attendanceManagementPanel.attendanceRepository.getAll();
	}

}
