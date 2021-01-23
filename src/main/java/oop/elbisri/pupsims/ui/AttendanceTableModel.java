package oop.elbisri.pupsims.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import oop.elbisri.pupsims.domain.Attendance;

public class AttendanceTableModel extends AbstractTableModel {

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
	protected AttendanceManagementPanel attendanceManagementPanel;
	
	/**
	 * 
	 */
	private List<Attendance> cache;

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public int getRowCount() {
		if(cache == null)
			return 0;
		
		return cache.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Attendance attendance = cache.get(rowIndex);
		
		switch(columnIndex) {
		
		case 0:
			return rowIndex + 1;
			
		case 1:
			return attendance.getSecurityGuardId();
			
		case 2:
			return attendance.getLogDate();
			
		case 3:
			return attendance.getStatus();
			
		default:
			throw new IllegalArgumentException("Invalid column index.");
		
		}
	}
	
	public void update() {
		repopulateCache();
		fireTableDataChanged();
	}
	
	private void repopulateCache() {
		cache = attendanceManagementPanel.attendanceRepository.getAll();
	}

}
