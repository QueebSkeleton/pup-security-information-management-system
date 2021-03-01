package oop.elbisri.pupsims.ui.securityguard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class SecurityGuardTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	private class SecurityGuardRecord {
		int employeeId;
		String firstName;
		String middleName;
		String lastName;
		String sex;
		int sssNumber;
		int tin;
	}
	
	private List<SecurityGuardRecord> internalCache;
	
	public SecurityGuardTableModel() {
		super();
		internalCache = new ArrayList<>();
	}
	
	@Override
	public int getColumnCount() {
		return 7;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		
		case 0:
			return "ID";
			
		case 1:
			return "First Name";
			
		case 2:
			return "Middle Name";
			
		case 3:
			return "Last Name";
			
		case 4:
			return "Sex";
			
		case 5:
			return "SSS Number";
			
		case 6:
			return "TIN";
			
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
		SecurityGuardRecord securityGuardRecord = internalCache.get(rowIndex);
		
		switch(columnIndex) {
		
		case 0:
			return securityGuardRecord.employeeId;
			
		case 1:
			return securityGuardRecord.firstName;
			
		case 2:
			return securityGuardRecord.middleName;
			
		case 3:
			return securityGuardRecord.lastName;
			
		case 4:
			return securityGuardRecord.sex;
			
		case 5:
			return securityGuardRecord.sssNumber;
			
		case 6:
			return securityGuardRecord.tin;
			
		default:
			return null;
		
		}
	}
	
	public void refresh() {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pupsims_db", "pupsims", "pupsimspass_123");
			Statement retrieveStatement = connection.createStatement();
			ResultSet securityGuardsResultSet = retrieveStatement.executeQuery("SELECT * FROM security_guard")) {
			
			internalCache.clear();
			while(securityGuardsResultSet.next()) {
				SecurityGuardRecord securityGuardRecord = new SecurityGuardRecord();
				securityGuardRecord.employeeId = securityGuardsResultSet.getInt("employee_id");
				securityGuardRecord.firstName = securityGuardsResultSet.getString("first_name");
				securityGuardRecord.middleName = securityGuardsResultSet.getString("middle_name");
				securityGuardRecord.lastName = securityGuardsResultSet.getString("last_name");
				securityGuardRecord.sex = securityGuardsResultSet.getString("sex");
				securityGuardRecord.sssNumber = securityGuardsResultSet.getInt("sss_id");
				securityGuardRecord.tin = securityGuardsResultSet.getInt("tin_number");
				internalCache.add(securityGuardRecord);
			}
			
			fireTableDataChanged();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "An error occured while trying to load security guards.\n\nMessage: " + e);
		}
		
	}

}
