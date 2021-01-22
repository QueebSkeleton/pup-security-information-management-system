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
import javax.swing.table.DefaultTableModel;

public class AttendanceManagementPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTable jtblAttendance;

	/**
	 * Create the panel.
	 */
	public AttendanceManagementPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jpnlHeader = new JPanel();
		jpnlHeader.setBorder(new EmptyBorder(0, 0, 10, 0));
		jpnlHeader.setMinimumSize(new Dimension(10, 45));
		jpnlHeader.setMaximumSize(new Dimension(32767, 55));
		FlowLayout flowLayout = (FlowLayout) jpnlHeader.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		jpnlHeader.setBackground(Color.WHITE);
		add(jpnlHeader);
		
		JLabel jlblHeader = new JLabel("Manage Attendance");
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		jpnlHeader.add(jlblHeader);
		
		JScrollPane jscrlpnAttendanceTable = new JScrollPane();
		add(jscrlpnAttendanceTable);
		
		jtblAttendance = new JTable();
		jtblAttendance.setRowHeight(25);
		jtblAttendance.setIntercellSpacing(new Dimension(10, 10));
		jtblAttendance.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Test Guard 1", "Today", "Present"},
				{"2", "Test Guard 2", "Today", "Present"},
				{"3", "Test Guard 3", "Today", "Present"},
			},
			new String[] {
				"#", "Name", "Date", "Status"
			}
		));
		jtblAttendance.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jscrlpnAttendanceTable.setViewportView(jtblAttendance);
		
		JPanel jpnlTablePagination = new JPanel();
		jpnlTablePagination.setBorder(new EmptyBorder(10, 0, 0, 0));
		jpnlTablePagination.setBackground(Color.WHITE);
		jpnlTablePagination.setMaximumSize(new Dimension(32767, 60));
		jpnlTablePagination.setMinimumSize(new Dimension(10, 50));
		add(jpnlTablePagination);
		jpnlTablePagination.setLayout(new BoxLayout(jpnlTablePagination, BoxLayout.X_AXIS));
		
		JLabel jlblPageSize = new JLabel("Limit:");
		jlblPageSize.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlTablePagination.add(jlblPageSize);
		
		jpnlTablePagination.add(Box.createRigidArea(new Dimension(10, 0)));
		
		JComboBox<String> jcmbPageSize = new JComboBox<>();
		jcmbPageSize.setMaximumSize(new Dimension(100, 25));
		jcmbPageSize.setModel(new DefaultComboBoxModel<>(new String[] {"10", "20", "50", "100", "200"}));
		jcmbPageSize.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlTablePagination.add(jcmbPageSize);
		

	}

}
