package oop.elbisri.pupsims.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main Frame of the Application. Every interaction possible for
 * this data-entry system is made in here.
 * 
 * Has a side navigator which dictates what current panel to
 * view, and a content panel.
 * 
 * @author Rian Reyes
 *
 */
public class MainFrame extends JFrame {
	
	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Main Content Pane of this Frame
	 */
	private JPanel jpnlContentPane;
	
	/**
	 * Current shown panel.
	 */
	private JPanel jpnlCurrentShownPanel;
	
	/**
	 * Attendance management panel.
	 */
	private AttendanceManagementPanel attendanceManagementPanel;

	/**
	 * Construct the frame.
	 */
	public MainFrame() {
		
		// Set the applicable sizes
		setMinimumSize(new Dimension(800, 550));
		setPreferredSize(new Dimension(800, 550));
		
		// Set main background to white
		setBackground(Color.WHITE);
		
		// Set title
		setTitle("PUP-SIMS");
		
		// When this frame is closed, the JFrame gets dumped
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set location to middle of screen
		setLocationRelativeTo(null);
		
		// Create the main content pane of this frame
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBackground(Color.WHITE);
		jpnlContentPane.setBorder(null);
		
		// Set the content pane of this frame to the custom JPanel
		setContentPane(jpnlContentPane);
		
		// Use BoxLayout to:
		// 1. Layout the Sidebar and Main Panel (JPanel) on one direction (Line-Axis)
		// 2. So that the Sidebar and Main Panel's sizes are respected by this layout manager
		jpnlContentPane.setLayout(new BoxLayout(jpnlContentPane, BoxLayout.LINE_AXIS));
		
		// Create the Sidebar Panel
		SidebarPanel sidebarPanel = new SidebarPanel();
		// Set the Sidebar Panel hook to this MainFrame
		sidebarPanel.setMainFrame(this);
		// Add the Sidebar to the main sole pane of the frame
		jpnlContentPane.add(sidebarPanel);
		
		// Create the Attendance Management Panel
		attendanceManagementPanel = new AttendanceManagementPanel();
	}
	
	public void showAttendanceManagementPanel() {
		if(jpnlCurrentShownPanel != null)
			jpnlContentPane.remove(jpnlCurrentShownPanel);
		
		else if(jpnlCurrentShownPanel == attendanceManagementPanel)
			return;
		
		jpnlCurrentShownPanel = attendanceManagementPanel;
		jpnlContentPane.add(attendanceManagementPanel);
		revalidate();
		repaint();
	}

}
