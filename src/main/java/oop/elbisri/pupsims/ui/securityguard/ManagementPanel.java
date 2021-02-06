package oop.elbisri.pupsims.ui.securityguard;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManagementPanel extends JPanel {
	private JTable jtblTable;

	/**
	 * Create the panel.
	 */
	public ManagementPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		/*
		 * Panel made for the buttons needed for Security Guards table 
		 */
		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setBorder(new EmptyBorder(20, 0, 20, 10));
		FlowLayout flowLayout = (FlowLayout) jpnlButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		jpnlButtons.setMaximumSize(new Dimension(32767, 100));
		add(jpnlButtons);
		
		JButton jbtnView = new JButton("View");
		jpnlButtons.add(jbtnView);
		
		JButton jbtnNew = new JButton("New");
		jpnlButtons.add(jbtnNew);
		
		/*
		 * Panel made for the output of list of Security Guards in the database 
		 */
		JScrollPane jscrllpnTable = new JScrollPane();
		jscrllpnTable.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(jscrllpnTable);
		
		jtblTable = new JTable();
		jtblTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name", "Middle Name", "Last Name", "Age", "Contact Number", "SSS ID"
			}
		));
		jtblTable.getColumnModel().getColumn(4).setPreferredWidth(44);
		jtblTable.getColumnModel().getColumn(5).setPreferredWidth(111);
		jtblTable.getColumnModel().getColumn(6).setPreferredWidth(111);
		jscrllpnTable.setViewportView(jtblTable);

	}

}
