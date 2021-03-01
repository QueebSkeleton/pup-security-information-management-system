package oop.elbisri.pupsims.ui.inventoryofsupplies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class InventoryTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private class SupplyRecord {
		long productCode;
		String productName;
		String type;
		int quantity;
		String condition;
		double price;
	}

	private List<SupplyRecord> internalCache;

	public InventoryTableModel() {
		super();
		internalCache = new ArrayList<>();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {

		case 0:
			return "Product Code";

		case 1:
			return "Name";

		case 2:
			return "Type";

		case 3:
			return "Quantity";

		case 4:
			return "Condition";

		case 5:
			return "Price";

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
		SupplyRecord supplyRecord = internalCache.get(rowIndex);

		switch (columnIndex) {

		case 0:
			return supplyRecord.productCode;

		case 1:
			return supplyRecord.productName;

		case 2:
			return supplyRecord.type;

		case 3:
			return supplyRecord.quantity;

		case 4:
			return supplyRecord.condition;

		case 5:
			return supplyRecord.price;

		default:
			return null;

		}
	}

	public void refresh() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pupsims_db", "pupsims",
				"pupsimspass_123");
				Statement retrieveStatement = connection.createStatement();
				ResultSet inventoryResultSet = retrieveStatement.executeQuery("SELECT * FROM inventory_of_supplies")) {

			internalCache.clear();
			while (inventoryResultSet.next()) {
				SupplyRecord supplyRecord = new SupplyRecord();
				supplyRecord.productCode = inventoryResultSet.getLong("product_code");
				supplyRecord.productName = inventoryResultSet.getString("item_name");
				supplyRecord.type = inventoryResultSet.getString("item_type");
				supplyRecord.quantity = inventoryResultSet.getInt("quantity");
				supplyRecord.condition = inventoryResultSet.getString("item_condition");
				supplyRecord.price = inventoryResultSet.getDouble("price");
				internalCache.add(supplyRecord);
			}

			fireTableDataChanged();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"An error occured while trying to load inventory details.\n\nMessage: " + e);
		}
	}

}
