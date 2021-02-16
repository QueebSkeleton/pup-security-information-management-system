package oop.elbisri.pupsims.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Main sidebar panel of the whole application. The user
 * interacts with this panel to navigate through the functionalities
 * of this data-entry system.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class SidebarPanel extends JPanel {
	
	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
  
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	public SidebarPanel() {
		
		// Set the applicable sizes (utilized by the layout manager which will use this panel)
		setMinimumSize(new Dimension(250, 500));
		setMaximumSize(new Dimension(250, 32767));
		setPreferredSize(new Dimension(250, 489));
		
		// Set background color of this panel
		setBackground(new Color(153, 0, 0));
		
		/* Set the layout manager of this sidebar panel to BoxLayout.
		 * Why?
		 * 1. All components are aligned on one direction, just like a browser app sidebar.
		 * 2. The components' requested min, max, and preferred sizes are respected.
		 */
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// TODO: Add PUP Logo
		
		// PUP Header Label
		JLabel jlblPupHeader = new JLabel("<html>Polytechnic University<br>\r\nof the Philippines</html>");
		jlblPupHeader.setBorder(new EmptyBorder(15, 15, 5, 15));
		jlblPupHeader.setFont(new Font("Montserrat", Font.PLAIN, 10));
		jlblPupHeader.setForeground(Color.WHITE);
		add(jlblPupHeader);
		
		// PUP-SIMS Header Label
		JLabel jlblSimsHeader = new JLabel("<html>Security Information<br>Management System</html>");
		jlblSimsHeader.setBorder(new EmptyBorder(0, 15, 0, 15));
		jlblSimsHeader.setForeground(Color.WHITE);
		jlblSimsHeader.setFont(new Font("Montserrat Black", Font.PLAIN, 14));
		add(jlblSimsHeader);
		
		// Add empty space for the succeeding buttons
		add(Box.createRigidArea(new Dimension(0, 20)));
		
		// Dashboard Button
		JButton jbtnDashboardPanel = new JButton("Dashboard");
		jbtnDashboardPanel.setBorderPainted(false);
		jbtnDashboardPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnDashboardPanel.setFocusPainted(false);
		jbtnDashboardPanel.setForeground(Color.WHITE);
		jbtnDashboardPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnDashboardPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
		jbtnDashboardPanel.setBackground(new Color(153, 0, 0));
		jbtnDashboardPanel.setMaximumSize(new Dimension(32767, 40));
		add(jbtnDashboardPanel);
		
		// Security Guard Panel Button
		JButton jbtnSecurityGuardPanel = new JButton("Security Guards");
		jbtnSecurityGuardPanel.addActionListener(event -> {
			mainFrame.showSecurityGuardManagementPanel();
		});
		jbtnSecurityGuardPanel.setBorderPainted(false);
		jbtnSecurityGuardPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnSecurityGuardPanel.setMaximumSize(new Dimension(32767, 40));
		jbtnSecurityGuardPanel.setForeground(Color.WHITE);
		jbtnSecurityGuardPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnSecurityGuardPanel.setFocusPainted(false);
		jbtnSecurityGuardPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
		jbtnSecurityGuardPanel.setBackground(new Color(153, 0, 0));
		add(jbtnSecurityGuardPanel);
		
		// Attendance Panel Button
		JButton jbtnAttendancePanel = new JButton("Attendance");
		jbtnAttendancePanel.addActionListener(event -> {
			mainFrame.showAttendanceManagementPanel();
			mainFrame.attendanceManagementPanel.updateTable();
		});
		jbtnAttendancePanel.setBorderPainted(false);
		jbtnAttendancePanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnAttendancePanel.setMaximumSize(new Dimension(32767, 40));
		jbtnAttendancePanel.setForeground(Color.WHITE);
		jbtnAttendancePanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnAttendancePanel.setFocusPainted(false);
		jbtnAttendancePanel.setBorder(new EmptyBorder(0, 15, 0, 0));
		jbtnAttendancePanel.setBackground(new Color(153, 0, 0));
		add(jbtnAttendancePanel);
		
		// Visitors Panel Button
		JButton jbtnVisitorLogPanel = new JButton("Visitor Log");
		jbtnVisitorLogPanel.addActionListener(event -> {
			mainFrame.showVisitorLogManagementPanel();
		});
		jbtnVisitorLogPanel.setBorderPainted(false);
		jbtnVisitorLogPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnVisitorLogPanel.setMaximumSize(new Dimension(32767, 40));
		jbtnVisitorLogPanel.setForeground(Color.WHITE);
		jbtnVisitorLogPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnVisitorLogPanel.setFocusPainted(false);
		jbtnVisitorLogPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
		jbtnVisitorLogPanel.setBackground(new Color(153, 0, 0));
		add(jbtnVisitorLogPanel);
		
		// Parking Slots Panel Button
		JButton jbtnParkingSlotsPanel = new JButton("Parking Slots");
		jbtnParkingSlotsPanel.addActionListener(event -> {
			mainFrame.showParkingSlotManagementPanel();
			//mainFrame.parkingManagementPanel.updateTable();
		});
		jbtnParkingSlotsPanel.setBorderPainted(false);
		jbtnParkingSlotsPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnParkingSlotsPanel.setMaximumSize(new Dimension(32767, 40));
		jbtnParkingSlotsPanel.setForeground(Color.WHITE);
		jbtnParkingSlotsPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnParkingSlotsPanel.setFocusPainted(false);
		jbtnParkingSlotsPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
		jbtnParkingSlotsPanel.setBackground(new Color(153, 0, 0));
		add(jbtnParkingSlotsPanel);
		
		// Car History Panel Button
		JButton jbtnCarLogPanel = new JButton("Car Log");
		jbtnCarLogPanel.addActionListener(evemt -> {
			mainFrame.showCarManagementPanel();
		});
		jbtnCarLogPanel.setBorderPainted(false);
		jbtnCarLogPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnCarLogPanel.setMaximumSize(new Dimension(32767, 40));
		jbtnCarLogPanel.setForeground(Color.WHITE);
		jbtnCarLogPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnCarLogPanel.setFocusPainted(false);
		jbtnCarLogPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
		jbtnCarLogPanel.setBackground(new Color(153, 0, 0));
		add(jbtnCarLogPanel);
		
		// Incident Reporting Panel Button
		JButton jbtnIncidentsReportPanel = new JButton("Incidents Report");
		jbtnIncidentsReportPanel.addActionListener (event -> {
			mainFrame.showIncidentManagementPanel();
		});
		jbtnIncidentsReportPanel.setBorderPainted(false);
		jbtnIncidentsReportPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnIncidentsReportPanel.setMaximumSize(new Dimension(32767, 40));
		jbtnIncidentsReportPanel.setForeground(Color.WHITE);
		jbtnIncidentsReportPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnIncidentsReportPanel.setFocusPainted(false);
		jbtnIncidentsReportPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
		jbtnIncidentsReportPanel.setBackground(new Color(153, 0, 0));
		add(jbtnIncidentsReportPanel);
		
		// Violator Logging Panel Button
		JButton jbtnViolatorsReportPanel = new JButton("Violators Report");
		jbtnViolatorsReportPanel.addActionListener(event -> {
			mainFrame.showViolationManagementPanel();
		});
		jbtnViolatorsReportPanel.setBorderPainted(false);
		jbtnViolatorsReportPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnViolatorsReportPanel.setMaximumSize(new Dimension(32767, 40));
		jbtnViolatorsReportPanel.setForeground(Color.WHITE);
		jbtnViolatorsReportPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnViolatorsReportPanel.setFocusPainted(false);
		jbtnViolatorsReportPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
		jbtnViolatorsReportPanel.setBackground(new Color(153, 0, 0));
		add(jbtnViolatorsReportPanel);
		
		// Inspection Log Panel Button
		JButton jbtnInspectionLogPanel = new JButton("Inspection Log");
		jbtnInspectionLogPanel.addActionListener(event -> {
			mainFrame.showInspectionManagementPanel();
		});
		jbtnInspectionLogPanel.setBorderPainted(false);
		jbtnInspectionLogPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnInspectionLogPanel.setMaximumSize(new Dimension(32767, 40));
		jbtnInspectionLogPanel.setForeground(Color.WHITE);
		jbtnInspectionLogPanel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnInspectionLogPanel.setFocusPainted(false);
		jbtnInspectionLogPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
		jbtnInspectionLogPanel.setBackground(new Color(153, 0, 0));
		add(jbtnInspectionLogPanel);
		
		JButton jbtnInventory = new JButton("Inventory");
		jbtnInventory.addActionListener(event -> {
			mainFrame.showInventoryManagementPanel();
		});
		jbtnInventory.setMaximumSize(new Dimension(32767, 40));
		jbtnInventory.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnInventory.setForeground(Color.WHITE);
		jbtnInventory.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnInventory.setFocusPainted(false);
		jbtnInventory.setBorderPainted(false);
		jbtnInventory.setBorder(new EmptyBorder(0, 15, 0, 0));
		jbtnInventory.setBackground(new Color(153, 0, 0));
		add(jbtnInventory);

	}
	
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

}
