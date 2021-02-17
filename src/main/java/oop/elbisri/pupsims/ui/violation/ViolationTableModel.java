package oop.elbisri.pupsims.ui.violation;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;

import oop.elbisri.pupsims.domain.Violation;

public class ViolationTableModel extends AbstractTableModel {

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
	private List<Violation> cache;

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
		// we can easily retrieve the violation at the specified rowIndex.
		Violation violation = cache.get(rowIndex);
		
		// Depending on the column specified,
		// return the appropriate field of this attendance record.
		switch(columnIndex) {
		
		// First Column - Row Number (1-based for user-friendliness)
		case 0:
			return rowIndex + 1;
			
		// Second Column - Type
		case 1:
			return violation.getType();
			
		// Third Column - Violator Name
		case 2:
			return violation.getViolatorName();
			
		// Fourth Column - Committed on
		case 3:
			return violation.getCommittedOn();
			
		// Fifth Column - Status of violation
		case 4:
			return violation.getStatus().toString();
			
		default:
			throw new IllegalArgumentException("Invalid column index.");
		
		}
	}
	
	/**
	 * Refreshes the TableModel with new data, and prompts redraw
	 * of the listening JTable.
	 */
	public void update() {
		// Construct a SwingWorker to fetch data from the repository,
		// and execute it.
		new SwingWorker<List<Violation>, Void>() {
			@Override
			protected List<Violation> doInBackground() throws Exception {
				// Fetch all data from the repository
				return violationManagementPanel.violationRepository.getAll();
			}
			@Override
			protected void done() {
				try {
					// Update the cache of this TableModel
					cache = get();
					// Notify JTable that data in this Model has changed
					fireTableDataChanged();
				} catch (InterruptedException e) {
					// TODO: Sophisticated handling of InterruptedException
					// maybe a message dialog.
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO: Sophisticated handling of InterruptedException
					// maybe a message dialog.
					e.printStackTrace();
				}
			}
		}.execute();
	}

}
