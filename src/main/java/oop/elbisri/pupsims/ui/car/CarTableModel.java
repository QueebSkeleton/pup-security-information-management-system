package oop.elbisri.pupsims.ui.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class CarTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private class CarRecord {
		String ownerName;
		String ownerContact;
		String plateNumber;
		String modelAndColor;
		String parkingSlot;
		String timeEntered;
		String timeExited;
	}

	private List<CarRecord> internalCache;

	public CarTableModel() {
		super();
		internalCache = new ArrayList<>();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {

		case 0:
			return "Owner";

		case 1:
			return "Contact";

		case 2:
			return "Plate #";

		case 3:
			return "Model";

		case 4:
			return "Parking Slot";

		case 5:
			return "Entered";

		case 6:
			return "Exited";

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
		CarRecord carRecord = internalCache.get(rowIndex);

		switch (columnIndex) {

		case 0:
			return carRecord.ownerName;

		case 1:
			return carRecord.ownerContact;

		case 2:
			return carRecord.plateNumber;

		case 3:
			return carRecord.modelAndColor;

		case 4:
			return carRecord.parkingSlot;

		case 5:
			return carRecord.timeEntered;

		case 6:
			return carRecord.timeExited;

		default:
			return null;

		}
	}

	public void refresh() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pupsims_db", "pupsims",
				"pupsimspass_123");
				Statement retrieveStatement = connection.createStatement();
				ResultSet carsResultSet = retrieveStatement.executeQuery("SELECT * FROM car_log")) {

			internalCache.clear();
			while (carsResultSet.next()) {
				CarRecord carRecord = new CarRecord();
				carRecord.ownerName = carsResultSet.getString("first_name") + " "
						+ carsResultSet.getString("last_name");
				carRecord.ownerContact = carsResultSet.getString("contact_num");
				carRecord.plateNumber = carsResultSet.getString("plate_num");
				carRecord.modelAndColor = carsResultSet.getString("model_and_color");
				carRecord.parkingSlot = carsResultSet.getString("parking_slot");
				carRecord.timeEntered = carsResultSet.getString("time_enter");
				carRecord.timeExited = carsResultSet.getString("time_exit");
				internalCache.add(carRecord);
			}

			fireTableDataChanged();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "An error occured while trying to load cars.\n\nMessage: " + e);
		}
	}

}
