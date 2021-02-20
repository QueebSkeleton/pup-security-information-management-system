package oop.elbisri.pupsims.ui.incidentreport;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.Color;

/**
 * Incident Report Management of this Application. Contains a Table
 * showing all incident reports logged in the system, and a Dialog form
 * shown by a button to log new entries.
 * 
 * An instance of this class is managed by MainFrame in itself, and is
 * shown by clicking the Incidents Button in the MainFrame's sidebar.
 * 
 * @author Elmer M. Cuenca
 *
 */

public class ManagementPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable jtblReportTable;
	
	/**
	 * Add Form dialog of this panel
	 */
	protected AddReportDialog incidentAddDialog; 
	

	/**
	 * Create the panel.
	 */
	public ManagementPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jpnlHeader = new JPanel();
		jpnlHeader.setBackground(Color.WHITE);
		jpnlHeader.setAlignmentY(0.0f);
		jpnlHeader.setAlignmentX(0.0f);
		jpnlHeader.setBorder(new EmptyBorder(0, 0, 10, 0));
		jpnlHeader.setMaximumSize(new Dimension(32767, 150));
		add(jpnlHeader);
		jpnlHeader.setLayout(new BoxLayout(jpnlHeader, BoxLayout.X_AXIS));
		
		/* jlblHeader - Header label */
		JLabel jlblHeader = new JLabel("Manage Incidents");
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		jpnlHeader.add(jlblHeader);
		/* END OF jlblHeader */
		
		JPanel jpnlButtonActions = new JPanel();
		jpnlButtonActions.setBackground(Color.WHITE);
		jpnlButtonActions.setAlignmentX(0.0f);
		FlowLayout flowLayout = (FlowLayout) jpnlButtonActions.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		jpnlHeader.add(jpnlButtonActions);
		
		JButton jbtnAdd = new JButton("New Report");
		jbtnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnAdd.setAlignmentY(0.0f);
		jpnlButtonActions.add(jbtnAdd);
		jbtnAdd.addActionListener(event -> {
			incidentAddDialog.setVisible(true);
		});
		
		JScrollPane jscrllpnReportTable = new JScrollPane();
		jscrllpnReportTable.setAlignmentY(0.0f);
		jscrllpnReportTable.setAlignmentX(0.0f);
		add(jscrllpnReportTable);
		
		jtblReportTable = new JTable();
		jtblReportTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Report ID", "Date", "Time", "Location", "Detailed Description"
			}
		));
		jtblReportTable.getColumnModel().getColumn(0).setPreferredWidth(84);
		jtblReportTable.getColumnModel().getColumn(1).setPreferredWidth(80);
		jtblReportTable.getColumnModel().getColumn(4).setPreferredWidth(300);
		jscrllpnReportTable.setViewportView(jtblReportTable);
		
		//Create the add form dialog
		incidentAddDialog = new AddReportDialog();
		incidentAddDialog.incidentManagementPanel = this; 

	}

}
