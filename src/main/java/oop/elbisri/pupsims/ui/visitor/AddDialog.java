package oop.elbisri.pupsims.ui.visitor;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Add form dialog for adding visitors.
 * 
 * @author Bismillah C. Constantino
 *
 */
public class AddDialog extends JDialog {

	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Main Content Pane of this Frame
	 */
	private JPanel jpnlContentPane;
	
	//Form components
	private JTextField jtxtfldNameOfVisitor;
	private JLabel jlblPurposeOfVisit;
	private JLabel lblTimeOfVisit;
	private JScrollPane scrollPane;
	private JTextArea txtPurposeOfVisit;
	private JLabel lblTimeOfLeave;
	private JTextField jtxtfldTimeOfVisit;
	private JTextField jtxtfldTimeOfLeave;
	private JPanel buttonPane;
	private JButton jbtnOk;
	private JButton jbtnCancel;
	private JComboBox<String> jcmbVisitorType;

	protected ManagementPanel visitorManagementPanel;
	
	public AddDialog() {
		//For reference later
		AddDialog thisDialog = this;
		
		//prevent user to resize the dialog
		setResizable(false);
		
		//set window size
		setMinimumSize(new Dimension(600, 400));
		
		//set title
		setTitle("Add Visitor");
		
		// Create the main content pane of this frame
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// Create the main content pane of this frame
		setContentPane(jpnlContentPane);
		
		// Use GridBagLayout for an eye-friendly form
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[] {30, 30, 60, 30, 30, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.15, 0.85};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		jpnlContentPane.setLayout(gridBagLayout);
		
		/*  jlblNameOfVisitor  Name of Visitor Label      */
		JLabel jlblNameOfVisitor = new JLabel("Name of Visitor:");
		jlblNameOfVisitor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblNameOfVisitor = new GridBagConstraints();
		gbc_jlblNameOfVisitor.insets = new Insets(0, 0, 5, 5);
		gbc_jlblNameOfVisitor.gridx = 0;
		gbc_jlblNameOfVisitor.gridy = 0;
		jpnlContentPane.add(jlblNameOfVisitor, gbc_jlblNameOfVisitor);
		/*  END OF jlblNameOfVisitor          */
		
		/* jtxtfldNameOfVisitor */
		jtxtfldNameOfVisitor = new JTextField();
		jtxtfldNameOfVisitor.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldNameOfVisitor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldNameOfVisitor = new GridBagConstraints();
		gbc_jtxtfldNameOfVisitor.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldNameOfVisitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldNameOfVisitor.gridx = 1;
		gbc_jtxtfldNameOfVisitor.gridy = 0;
		jpnlContentPane.add(jtxtfldNameOfVisitor, gbc_jtxtfldNameOfVisitor);
		jtxtfldNameOfVisitor.setColumns(10);
		/* END OF jtxtfldNameOfVisitor  */
		
		/* jlbljlstTypeOfVisitor - Type of visitor */
		JLabel jlbljlstTypeOfVisitor = new JLabel("Type of visitor:");
		jlbljlstTypeOfVisitor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlbljlstTypeOfVisitor = new GridBagConstraints();
		gbc_jlbljlstTypeOfVisitor.insets = new Insets(0, 0, 5, 5);
		gbc_jlbljlstTypeOfVisitor.gridx = 0;
		gbc_jlbljlstTypeOfVisitor.gridy = 1;
		jpnlContentPane.add(jlbljlstTypeOfVisitor, gbc_jlbljlstTypeOfVisitor);
		/* END OF jlbljlstTypeOfVisitor*/
		
		//Create combo box for visitor type
		//The use of combo box makes it appealing to the eyes of use
		jcmbVisitorType = new JComboBox<>();
		jcmbVisitorType.setModel(new DefaultComboBoxModel<>(new String[] {"Alumnus", "Parent"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		jpnlContentPane.add(jcmbVisitorType, gbc_comboBox);
		String visitorType = jcmbVisitorType.getItemAt(jcmbVisitorType.getSelectedIndex());
		/* END OF comboBox */
		
		/* jlblPurposeOfVisit Purpose of Visit */
		jlblPurposeOfVisit = new JLabel("Purpose of visit:");
		jlblPurposeOfVisit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblPurposeOfVisit = new GridBagConstraints();
		gbc_jlblPurposeOfVisit.insets = new Insets(0, 0, 5, 5);
		gbc_jlblPurposeOfVisit.gridx = 0;
		gbc_jlblPurposeOfVisit.gridy = 2;
		jpnlContentPane.add(jlblPurposeOfVisit, gbc_jlblPurposeOfVisit);
		/* END OF jlblPurposeOfVisit*/
		
		//Added scrollpane for purpose of visit
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		jpnlContentPane.add(scrollPane, gbc_scrollPane);
		
		/* txtPurposeOfVisit Purpose of visit   */
		txtPurposeOfVisit = new JTextArea();
		txtPurposeOfVisit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane.setViewportView(txtPurposeOfVisit);
		/*END OF txtPurposeOfVisit*/
		
		/* lblTimeOfVisit Time of visit*/
		lblTimeOfVisit = new JLabel("Time of visit:");
		lblTimeOfVisit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTimeOfVisit = new GridBagConstraints();
		gbc_lblTimeOfVisit.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimeOfVisit.gridx = 0;
		gbc_lblTimeOfVisit.gridy = 3;
		jpnlContentPane.add(lblTimeOfVisit, gbc_lblTimeOfVisit);
		/* END OF lblTimeOfVisit*/
		
		/* jtxtfldTimeOfVisit Time of Visit*/
		jtxtfldTimeOfVisit = new JTextField();
		jtxtfldTimeOfVisit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldTimeOfVisit = new GridBagConstraints();
		gbc_jtxtfldTimeOfVisit.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldTimeOfVisit.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldTimeOfVisit.gridx = 1;
		gbc_jtxtfldTimeOfVisit.gridy = 3;
		jpnlContentPane.add(jtxtfldTimeOfVisit, gbc_jtxtfldTimeOfVisit);
		jtxtfldTimeOfVisit.setColumns(10);
		/* END OF jtxtfldTimeOfVisit */
		
		/* lblTimeOfLeave Time of leave*/
		lblTimeOfLeave = new JLabel("Time of leave:");
		lblTimeOfLeave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTimeOfLeave = new GridBagConstraints();
		gbc_lblTimeOfLeave.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimeOfLeave.gridx = 0;
		gbc_lblTimeOfLeave.gridy = 4;
		jpnlContentPane.add(lblTimeOfLeave, gbc_lblTimeOfLeave);
		/* END OF lblTimeOfLeave*/
		
		/* jtxtfldTimeOfLeave Time of leave */
		jtxtfldTimeOfLeave = new JTextField();
		jtxtfldTimeOfLeave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldTimeOfLeave = new GridBagConstraints();
		gbc_jtxtfldTimeOfLeave.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldTimeOfLeave.anchor = GridBagConstraints.NORTH;
		gbc_jtxtfldTimeOfLeave.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldTimeOfLeave.gridx = 1;
		gbc_jtxtfldTimeOfLeave.gridy = 4;
		jpnlContentPane.add(jtxtfldTimeOfLeave, gbc_jtxtfldTimeOfLeave);
		jtxtfldTimeOfLeave.setColumns(10);
		/* END OF jtxtfldTimeOfLeave*/
		
		//create panel that will hold the CANCEL and OK button
		buttonPane = new JPanel();
		buttonPane.setMaximumSize(new Dimension(32767, 40));
		buttonPane.setPreferredSize(new Dimension(10, 40));
		buttonPane.setMinimumSize(new Dimension(10, 40));
		GridBagConstraints gbc_buttonPane = new GridBagConstraints();
		gbc_buttonPane.gridwidth = 2;
		gbc_buttonPane.insets = new Insets(0, 0, 0, 5);
		gbc_buttonPane.fill = GridBagConstraints.BOTH;
		gbc_buttonPane.gridx = 0;
		gbc_buttonPane.gridy = 5;
		buttonPane.setFocusable(false);
		jpnlContentPane.add(buttonPane, gbc_buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		//create and add buttons to the panel
		jbtnOk = new JButton("Ok");
		jbtnOk.setFocusable(false);
		jbtnOk.addActionListener(event ->{
			try {
				 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pupsims_db", "pupsims", "pupsimspass_123"); 
				 Statement statement = connection.createStatement();
				 
				statement.execute("INSERT INTO visitor_log VALUES (NULL, '"+ jtxtfldNameOfVisitor.getText() +"','"+ visitorType +"', '"+ txtPurposeOfVisit.getText() +"', '"
						+ jtxtfldTimeOfVisit.getText() + "', '"+ jtxtfldTimeOfLeave.getText() +"')");
				JOptionPane.showMessageDialog(thisDialog, "Visitor added!");
				// Refresh the table
				visitorManagementPanel.updateTable();
				
				//Close the dialog after saving
				this.setVisible(false);
				
				statement.close();
				connection.close();
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(thisDialog,"An error occured while saving... \n \n Details: "+e );
			}
			
		});
		buttonPane.add(jbtnOk);
		
		
		jbtnCancel = new JButton("Cancel");
		jbtnCancel.setFocusable(false);
		jbtnCancel.addActionListener(event ->{
			this.setVisible(false);
		});
		buttonPane.add(jbtnCancel);
		
	}
	
	public void resetForm() {
		jtxtfldNameOfVisitor.setText("");
		jcmbVisitorType.setSelectedIndex(0);
		txtPurposeOfVisit.setText("");
		jtxtfldTimeOfVisit.setText("");
		jtxtfldTimeOfLeave.setText("");
	}
}
