package oop.elbisri.pupsims.ui.securityguard;

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
 * Security Guard Management Panel. Contains a Table
 * showing all security guard, and  ADD Dialog
 * shown by a button to create new entries.
 * 
 * An instance of this class is managed by MainFrame in itself, and is
 * shown by clicking the Attendance Button in the MainFrame's sidebar.
 * 
 * @author Elmer M. Cuenca
 *
 */

public class ManagementPanel extends JPanel {
	
	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable jtblTable;
	
	/**
	 * Add form dialog for this panel
	 */
	protected AddDialog securityGuardAddDialog; 
	
	protected SecurityGuardTableModel securityGuardTableModel;
	

	/**
	 * Create the panel.
	 */
	public ManagementPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		/*
		 * Panel made for the buttons needed for Security Guards table 
		 */
		JPanel jpnlHeader = new JPanel();
		jpnlHeader.setBackground(Color.WHITE);
		jpnlHeader.setMinimumSize(new Dimension(10, 45));
		jpnlHeader.setAlignmentY(0.0f);
		jpnlHeader.setAlignmentX(0.0f);
		jpnlHeader.setBorder(new EmptyBorder(0, 0, 10, 0));
		jpnlHeader.setMaximumSize(new Dimension(32767, 55));
		add(jpnlHeader);
		jpnlHeader.setLayout(new BoxLayout(jpnlHeader, BoxLayout.X_AXIS));
		
		JLabel jlblHeader = new JLabel("Manage Security Guards");
		jlblHeader.setAlignmentX(0.0f);
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		jpnlHeader.add(jlblHeader);
		
		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setAlignmentX(0.0f);
		jpnlButtons.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) jpnlButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		jpnlHeader.add(jpnlButtons);
		
		JButton jbtnAdd = new JButton("Add");
		jbtnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnAdd.addActionListener(event -> {
			securityGuardAddDialog.resetForm();
			securityGuardAddDialog.setVisible(true);
		});
		jpnlButtons.add(jbtnAdd);
		
		/*
		 * Panel made for the output of list of Security Guards in the database 
		 */
		JScrollPane jscrllpnTable = new JScrollPane();
		jscrllpnTable.setAlignmentY(0.0f);
		jscrllpnTable.setAlignmentX(0.0f);
		add(jscrllpnTable);
		
		jtblTable = new JTable();
		securityGuardTableModel = new SecurityGuardTableModel();
		jtblTable.setModel(securityGuardTableModel);
		jscrllpnTable.setViewportView(jtblTable);
		
		securityGuardAddDialog = new AddDialog();
		securityGuardAddDialog.securityGuardManagementPanel = this;

	}
	
	public void updateTable() {
		securityGuardTableModel.refresh();
	}

}
