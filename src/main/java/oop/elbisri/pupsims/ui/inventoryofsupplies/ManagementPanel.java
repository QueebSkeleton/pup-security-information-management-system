package oop.elbisri.pupsims.ui.inventoryofsupplies;

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
	private JTable jtblTable;

	/**
	 * Create the panel.
	 */
	public ManagementPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setBorder(new EmptyBorder(20, 0, 10, 10));
		FlowLayout flowLayout = (FlowLayout) jpnlButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		jpnlButtons.setMaximumSize(new Dimension(32767, 50));
		add(jpnlButtons);
		
		JButton jbtnView = new JButton("View ");
		jpnlButtons.add(jbtnView);
		
		JButton jbtnAdd = new JButton("Add");
		jpnlButtons.add(jbtnAdd);
		
		JScrollPane jscrllpnTable = new JScrollPane();
		add(jscrllpnTable);
		
		jtblTable = new JTable();
		jtblTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product Code", "Item Name", "Type", "Quantity", "Condition", "Price"
			}
		));
		jtblTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		jtblTable.getColumnModel().getColumn(2).setPreferredWidth(90);
		jtblTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		jscrllpnTable.setViewportView(jtblTable);

	}

}