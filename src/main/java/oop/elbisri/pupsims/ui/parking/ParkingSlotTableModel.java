package oop.elbisri.pupsims.ui.parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ParkingSlotTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private class ParkingSlotRecord {
		String slotNumber;
		String location;
		String description;
		String condition;
	}

	private List<ParkingSlotRecord> internalCache;

	public ParkingSlotTableModel() {
		super();
		internalCache = new ArrayList<>();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {

		case 0:
			return "Slot Number";

		case 1:
			return "Location";

		case 2:
			return "Description";

		case 3:
			return "Condition";

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
		ParkingSlotRecord parkingSlotRecord = internalCache.get(rowIndex);

		switch (columnIndex) {

		case 0:
			return parkingSlotRecord.slotNumber;

		case 1:
			return parkingSlotRecord.location;

		case 2:
			return parkingSlotRecord.description;

		case 3:
			return parkingSlotRecord.condition;

		default:
			return null;

		}
	}

	public void refresh() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pupsims_db", "pupsims",
				"pupsimspass_123");
				Statement retrieveStatement = connection.createStatement();
				ResultSet parkingSlotsResultSet = retrieveStatement.executeQuery("SELECT * FROM parking_slot")) {

			internalCache.clear();
			while (parkingSlotsResultSet.next()) {
				ParkingSlotRecord parkingSlotRecord = new ParkingSlotRecord();
				parkingSlotRecord.slotNumber = parkingSlotsResultSet.getString("slot_number");
				parkingSlotRecord.location = parkingSlotsResultSet.getString("location");
				parkingSlotRecord.description = parkingSlotsResultSet.getString("description");
				parkingSlotRecord.condition = parkingSlotsResultSet.getString("status");
				internalCache.add(parkingSlotRecord);
			}

			fireTableDataChanged();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"An error occured while trying to load parking slots.\n\nMessage: " + e);
		}

	}

}
