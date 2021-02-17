package oop.elbisri.pupsims.ui.violation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import oop.elbisri.pupsims.repository.ViolationJdbcRepositoryImpl;

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
	 * Violation Repository.
	 */
	protected ViolationJdbcRepositoryImpl violationRepository;
	
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
		
		/* jpnlTablePagination - Panel for Pagination Components */
		JPanel jpnlTablePagination = new JPanel();
		jpnlTablePagination.setBorder(new EmptyBorder(10, 0, 0, 0));
		jpnlTablePagination.setBackground(Color.WHITE);
		jpnlTablePagination.setMaximumSize(new Dimension(32767, 60));
		jpnlTablePagination.setMinimumSize(new Dimension(10, 50));
		add(jpnlTablePagination);
		jpnlTablePagination.setLayout(new BoxLayout(jpnlTablePagination, BoxLayout.X_AXIS));
		/* END OF jpnlTablePagination */
		
		/* jlblPageSize - Pagination Size Label */
		JLabel jlblPageSize = new JLabel("Limit:");
		jlblPageSize.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlTablePagination.add(jlblPageSize);
		/* END OF jlblPageSize */
		
		// Spacing
		jpnlTablePagination.add(Box.createRigidArea(new Dimension(10, 0)));
		
		/* jcmbPageSize - Pagination Size Choice Box */
		JComboBox<String> jcmbPageSize = new JComboBox<>();
		jcmbPageSize.setMaximumSize(new Dimension(100, 25));
		jcmbPageSize.setModel(new DefaultComboBoxModel<>(new String[] {"10", "20", "50", "100", "200"}));
		jcmbPageSize.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlTablePagination.add(jcmbPageSize);
		/* END OF jcmbPageSize */

		// Create the add form dialog
		violationAddDialog = new AddDialog();
		violationAddDialog.violationManagementPanel = this;
	}
	
	/**
	 * Sets the violation repository of the internal TableModel that this panel manages,
	 * and the add form dialog box.
	 * 
	 * @param violationRepository the repository to set for the TableModel
	 */
	public void setViolationRepository(ViolationJdbcRepositoryImpl violationRepository) {
		this.violationRepository = violationRepository;
	}
	
	/**
	 * Updates the table model and prompts for a JTable redraw.
	 */
	public void updateTable() {
		violationTableModel.update();
	}

}
