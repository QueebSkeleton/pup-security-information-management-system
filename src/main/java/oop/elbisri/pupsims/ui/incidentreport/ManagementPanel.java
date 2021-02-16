package oop.elbisri.pupsims.ui.incidentreport;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setBorder(new EmptyBorder(20, 0, 0, 10));
		FlowLayout flowLayout = (FlowLayout) jpnlButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		jpnlButtons.setMaximumSize(new Dimension(32767, 150));
		add(jpnlButtons);
		
		JButton jbtnAdd = new JButton("New Report");
		jbtnAdd.addActionListener(event -> {
			incidentAddDialog.setVisible(true);
		});
		jpnlButtons.add(jbtnAdd);
		
		
		JButton jbtnDelete = new JButton("Delete");
		jpnlButtons.add(jbtnDelete);
		
		JScrollPane jscrllpnReportTable = new JScrollPane();
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
