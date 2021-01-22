package oop.elbisri.pupsims.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import oop.elbisri.pupsims.repository.AttendanceJdbcRepositoryImpl;

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
public class AttendanceManagementPanel extends JPanel {
	
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
	 * Construct the panel.
	 */
	public AttendanceManagementPanel() {
		
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
		FlowLayout flowLayout = (FlowLayout) jpnlHeader.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		jpnlHeader.setBackground(Color.WHITE);
		add(jpnlHeader);
		/* END OF jpnlHeader */
		
		/* jlblHeader - Main Header Label */
		JLabel jlblHeader = new JLabel("Manage Attendance");
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		jpnlHeader.add(jlblHeader);
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
		jtblAttendance.setModel(attendanceTableModel);
		
		jscrlpnAttendanceTable.setViewportView(jtblAttendance);
		/* END OF jtblAttendance */
		
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

	}
	
	/**
	 * Sets the attendance repository of the internal TableModel that this panel manages.
	 * 
	 * @param attendanceRepository the repository to set for the TableModel
	 */
	public void setAttendanceRepository(AttendanceJdbcRepositoryImpl attendanceRepository) {
		attendanceTableModel.setAttendanceRepository(attendanceRepository);
	}

}
