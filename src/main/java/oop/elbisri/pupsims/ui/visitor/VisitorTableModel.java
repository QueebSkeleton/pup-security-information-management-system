package oop.elbisri.pupsims.ui.visitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class VisitorTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	private class VisitorRecord {
		String name;
		String type;
		String purpose;
		String timeOfVisit;
		String timeOfLeave;
	}
	
	private List<VisitorRecord> internalCache;
	
	public VisitorTableModel() {
		super();
		internalCache = new ArrayList<>();
	}
	
	@Override
	public int getColumnCount() {
		return 6;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		
		case 0:
			return "#";
			
		case 1:
			return "Name";
			
		case 2:
			return "Type";
			
		case 3:
			return "Purpose";
			
		case 4:
			return "Time of Enter";
			
		case 5:
			return "Time of Leave";
			
		default:
			return null;
		
		}
	}
	
	@Override
	public int getRowCount() {
		return internalCache.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		VisitorRecord visitorRecord = internalCache.get(rowIndex);
		
		switch(columnIndex) {
		
		case 0:
			return rowIndex + 1;
			
		case 1:
			return visitorRecord.name;
			
		case 2:
			return visitorRecord.type;
			
		case 3:
			return visitorRecord.purpose;
			
		case 4:
			return visitorRecord.timeOfVisit;
			
		case 5:
			return visitorRecord.timeOfLeave;
			
		default:
			return null;
		
		}
	}
	
	public void refresh() {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pupsims_db", "pupsims", "pupsimspass_123");
			Statement retrieveStatement = connection.createStatement();
			ResultSet visitorsResultSet = retrieveStatement.executeQuery("SELECT * FROM visitor_log")) {
			
			internalCache.clear();
			while(visitorsResultSet.next()) {
				VisitorRecord visitorRecord = new VisitorRecord();
				visitorRecord.name = visitorsResultSet.getString("name_of_visitor");
				visitorRecord.type = visitorsResultSet.getString("visitor_type");
				visitorRecord.purpose = visitorsResultSet.getString("purpose_of_visit");
				visitorRecord.timeOfVisit = visitorsResultSet.getString("time_of_visit");
				visitorRecord.timeOfLeave = visitorsResultSet.getString("time_of_leave");
				internalCache.add(visitorRecord);
			}
			
			fireTableDataChanged();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "An error occured while trying to load visitors.\n\nMessage: " + e);
		}
		
	}

}
