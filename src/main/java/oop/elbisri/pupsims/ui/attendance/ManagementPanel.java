package oop.elbisri.pupsims.ui.attendance;

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
 * Attendance Management Panel of this Application. Contains a Table
 * showing all logged attendances of each security guard, and a Dialog
 * shown by a button to create new entries.
 * 
 * An instance of this class is managed by MainFrame in itself, and is
 * shown by clicking the Attendance Button in the MainFrame's sidebar.
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
	private JTable jtblAttendance;
	
	/**
	 * TableModel of the main table.
	 */
	protected AttendanceTableModel attendanceTableModel;
	
	/**
	 * Add Form Dialog of this panel.
	 */
	protected AddDialog attendanceAddDialog;

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
		JLabel jlblHeader = new JLabel("Manage Attendance");
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		jpnlHeader.add(jlblHeader);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.setBackground(Color.WHITE);
		jpnlHeader.add(panel);
		
		JButton jbtnShowAddForm = new JButton("Add");
		jbtnShowAddForm.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnShowAddForm.addActionListener(event -> {
			attendanceAddDialog.resetForm();
			attendanceAddDialog.setVisible(true);
		});
		panel.add(jbtnShowAddForm);
		/* END OF jlblHeader */
		
		/* jscrlpnAttendanceTable - Scrollable Table Panel */
		JScrollPane jscrlpnAttendanceTable = new JScrollPane();
		add(jscrlpnAttendanceTable);
		/* END OF jscrlpnAttendanceTable */
		
		/* jtblAttendance - Main Panel Table */
		jtblAttendance = new JTable();
		jtblAttendance.setRowHeight(25);
		jtblAttendance.setIntercellSpacing(new Dimension(10, 10));
		jtblAttendance.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		// Table Model
		attendanceTableModel = new AttendanceTableModel();
		attendanceTableModel.attendanceManagementPanel = this;
		jtblAttendance.setModel(attendanceTableModel);
		
		jscrlpnAttendanceTable.setViewportView(jtblAttendance);
		/* END OF jtblAttendance */

		// Create the add form dialog
		attendanceAddDialog = new AddDialog();
		attendanceAddDialog.attendanceManagementPanel = this;
	}
	
	/**
	 * Updates the table model and prompts for a JTable redraw.
	 */
	public void updateTable() {
		attendanceTableModel.update();
	}

}
