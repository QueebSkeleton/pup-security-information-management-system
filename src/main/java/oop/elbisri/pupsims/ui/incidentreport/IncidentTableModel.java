package oop.elbisri.pupsims.ui.incidentreport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class IncidentTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	private class IncidentRecord {
		String incidentHappenedOn;
		String injuredName;
		short injuredAge;
		String descriptiveDetails;
	}
	
	private List<IncidentRecord> internalCache;
	
	public IncidentTableModel() {
		super();
		internalCache = new ArrayList<>();
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		
		case 0:
			return "Happened On";
			
		case 1:
			return "Injured Name";
			
		case 2:
			return "Age";
			
		case 3:
			return "Details";
			
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
		IncidentRecord incidentRecord = internalCache.get(rowIndex);
		
		switch(columnIndex) {

		case 0:
			return incidentRecord.incidentHappenedOn;
			
		case 1:
			return incidentRecord.injuredName;
			
		case 2:
			return incidentRecord.injuredAge;
			
		case 3:
			return incidentRecord.descriptiveDetails;
			
		default:
			return null;
		
		}
	}
	
	public void refresh() {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pupsims_db", "pupsims", "pupsimspass_123");
			Statement retrieveStatement = connection.createStatement();
			ResultSet incidentsResultSet = retrieveStatement.executeQuery("SELECT * FROM incident_report")) {
			
			internalCache.clear();
			while(incidentsResultSet.next()) {
				IncidentRecord incidentRecord = new IncidentRecord();
				incidentRecord.incidentHappenedOn = incidentsResultSet.getString("incident_date") + " " + incidentsResultSet.getString("incident_time");
				incidentRecord.injuredName = incidentsResultSet.getString("injured_name");
				incidentRecord.injuredAge = incidentsResultSet.getShort("age");
				incidentRecord.descriptiveDetails = incidentsResultSet.getString("descriptive_details");
				internalCache.add(incidentRecord);
			}
			
			fireTableDataChanged();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "An error occured while trying to load incidents.\n\nMessage: " + e);
		}
	}

}
