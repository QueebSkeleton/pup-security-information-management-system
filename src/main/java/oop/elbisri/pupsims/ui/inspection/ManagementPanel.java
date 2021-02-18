package oop.elbisri.pupsims.ui.inspection;

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
import javax.swing.table.DefaultTableModel;

import oop.elbisri.pupsims.repository.InspectionJdbcRepositoryImpl;

/**
 * Building Inspection Management Panel of this Application. Contains a Table
 * showing all logged building inspection each night, and a Dialog
 * shown by a button to create new entries.
 * 
 * An instance of this class is managed by MainFrame in itself, and is
 * shown by clicking the Inspection Button in the MainFrame's sidebar.
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
	private JTable jtblInspection;
	
	/**
	 * Inspection Repository.
	 */
	protected InspectionJdbcRepositoryImpl inspectionRepository;
	
	/**
	 * Add Form Dialog of this panel.
	 */
	protected AddDialog inspectionAddDialog;

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
		JLabel jlblHeader = new JLabel("Manage Inspection Log");
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
			inspectionAddDialog.setVisible(true);
		});
		jpnlButtonActions.add(jbtnShowAddForm);
		/* END OF jbtnShowAddForm */
		
		/* jscrlpnInspectionTable - Scrollable Table Panel */
		JScrollPane jscrlpnInspectionTable = new JScrollPane();
		add(jscrlpnInspectionTable);
		/* END OF jscrlpnInspectionTable */
		
		/* jtblInspection - Main Panel Table */
		jtblInspection = new JTable();
		jtblInspection.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date", "Building-Floor", "Rooms", "# of Issues", "Condition"
			}
		));
		jtblInspection.getColumnModel().getColumn(0).setPreferredWidth(52);
		jtblInspection.getColumnModel().getColumn(1).setPreferredWidth(112);
		jtblInspection.getColumnModel().getColumn(2).setPreferredWidth(60);
		jtblInspection.getColumnModel().getColumn(3).setPreferredWidth(65);
		jtblInspection.setRowHeight(25);
		jtblInspection.setIntercellSpacing(new Dimension(10, 10));
		jtblInspection.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jscrlpnInspectionTable.setViewportView(jtblInspection);
		/* END OF jtblInspection */
		
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
		inspectionAddDialog = new AddDialog();
		inspectionAddDialog.inspectionManagementPanel = this;
	}
	
	/**
	 * Sets the inspection repository of the internal TableModel that this panel manages,
	 * and the add form dialog box.
	 * 
	 * @param inspectionRepository the repository to set
	 */
	public void setInspectionRepository(InspectionJdbcRepositoryImpl inspectionRepository) {
		this.inspectionRepository = inspectionRepository;
	}

}
