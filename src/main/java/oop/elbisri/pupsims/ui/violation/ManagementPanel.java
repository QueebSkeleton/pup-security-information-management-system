package oop.elbisri.pupsims.ui.violation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

/**
 * Violation Management Panel of this Application. Contains a Table
 * showing all violations logged in the system, and a Dialog form
 * shown by a button to log new entries.
 * 
 * An instance of this class is managed by MainFrame in itself, and is
 * shown by clicking the Violators Button in the MainFrame's sidebar.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class ManagementPanel extends JPanel {
	
	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The main table of this panel.
	 */
	private JTable jtblViolation;
	
	/**
	 * TableModel of the main table.
	 */
	protected ViolationTableModel violationTableModel;
	
	/**
	 * Add Form Dialog of this panel.
	 */
	protected AddDialog violationAddDialog;

	/**
	 * Construct the panel.
	 */
	public ManagementPanel() {
		
		// Set background to white
		setBackground(Color.WHITE);
		// Set border to EmptyBorder for spacing
		setBorder(new EmptyBorder(10, 10, 10, 10));
		// Use BoxLayout to lay the internal 3 panels: Header, Table, Pagination Actions
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		/* jpnlHeader - Header Panel */
		JPanel jpnlHeader = new JPanel();
		jpnlHeader.setBorder(new EmptyBorder(0, 0, 10, 0));
		jpnlHeader.setMinimumSize(new Dimension(10, 45));
		jpnlHeader.setMaximumSize(new Dimension(32767, 55));
		jpnlHeader.setBackground(Color.WHITE);
		add(jpnlHeader);
		/* END OF jpnlHeader */
		
		/* jlblHeader - Main Header Label */
		jpnlHeader.setLayout(new BoxLayout(jpnlHeader, BoxLayout.X_AXIS));
		JLabel jlblHeader = new JLabel("Manage Violations");
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		jpnlHeader.add(jlblHeader);
		/* END OF jlblHeader */
		
		/* jpnlButtonActions - Header Panel Buttons */
		JPanel jpnlButtonActions = new JPanel();
		FlowLayout fl_jpnlButtonActions = (FlowLayout) jpnlButtonActions.getLayout();
		fl_jpnlButtonActions.setAlignment(FlowLayout.RIGHT);
		jpnlButtonActions.setBackground(Color.WHITE);
		jpnlHeader.add(jpnlButtonActions);
		/* END OF jpnlButtonActions */
		
		/* jbtnShowAddForm - button for showing the add form dialog */
		JButton jbtnShowAddForm = new JButton("Add");
		jbtnShowAddForm.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnShowAddForm.addActionListener(event -> {
			violationAddDialog.resetForm();
			violationAddDialog.setVisible(true);
		});
		jpnlButtonActions.add(jbtnShowAddForm);
		/* END OF jbtnShowAddForm */
		
		/* jscrlpnAttendanceTable - Scrollable Table Panel */
		JScrollPane jscrlpnViolationTable = new JScrollPane();
		add(jscrlpnViolationTable);
		/* END OF jscrlpnAttendanceTable */
		
		/* jtblViolation - Main Panel Table */
		jtblViolation = new JTable();
		jtblViolation.setRowHeight(25);
		jtblViolation.setIntercellSpacing(new Dimension(10, 10));
		jtblViolation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		// Table Model
		violationTableModel = new ViolationTableModel();
		violationTableModel.violationManagementPanel = this;
		jtblViolation.setModel(violationTableModel);
		
		jscrlpnViolationTable.setViewportView(jtblViolation);
		/* END OF jtblViolation */

		// Create the add form dialog
		violationAddDialog = new AddDialog();
		violationAddDialog.violationManagementPanel = this;
	}
	
	/**
	 * Updates the table model and prompts for a JTable redraw.
	 */
	public void updateTable() {
		violationTableModel.update();
	}

}
