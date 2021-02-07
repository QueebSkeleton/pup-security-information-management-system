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

public class ManagementPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable jtblReportTable;

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
		
		JButton jbtnView = new JButton("View Report");
		jpnlButtons.add(jbtnView);
		
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

	}

}
