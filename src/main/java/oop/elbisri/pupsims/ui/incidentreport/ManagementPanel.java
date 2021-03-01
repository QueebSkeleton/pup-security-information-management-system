package oop.elbisri.pupsims.ui.incidentreport;

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
 * Incident port java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPll incident reports logged in the system, and a Dialog form
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
	
	protected IncidentTableModel incidentTableModel;
	

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
			incidentAddDialog.resetForm();
			incidentAddDialog.setVisible(true);
		});
		
		JScrollPane jscrllpnReportTable = new JScrollPane();
		jscrllpnReportTable.setAlignmentY(0.0f);
		jscrllpnReportTable.setAlignmentX(0.0f);
		add(jscrllpnReportTable);
		
		jtblReportTable = new JTable();
		incidentTableModel = new IncidentTableModel();
		jtblReportTable.setModel(incidentTableModel);
		jscrllpnReportTable.setViewportView(jtblReportTable);
		
		//Create the add form dialog
		incidentAddDialog = new AddReportDialog();
		incidentAddDialog.incidentManagementPanel = this; 

	}
	
	public void updateTable() {
		incidentTableModel.refresh();
	}

}
