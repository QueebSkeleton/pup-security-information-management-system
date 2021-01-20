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
		// Add the Sidebar to the main sole pane of the frame
		jpnlContentPane.add(sidebarPanel);
		
		// TODO: This is temporary. Create a separate class for each panel (e.g. Security Guard Panel)
		// Create the main panel for content and main functionality
		JPanel panel = new JPanel();
		// Set background to white
		panel.setBackground(Color.WHITE);
		// (By default the max size of every JPanel is 32767, 32767. This will be read by the BoxLayout
		// and accomodate the remaining space on the content pane)
		// Add this to the main content pane
		jpnlContentPane.add(panel);
	}

}
