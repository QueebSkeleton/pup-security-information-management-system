package oop.elbisri.pupsims.ui.visitor;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
	private static String visitorType[] = {"Alumnus", "Parent"};
	private JComboBox<String> comboBox;
	private JLabel jlblPurposeOfVisit;
	private JLabel lblTimeOfVisit;
	private JScrollPane scrollPane;
	private JTextArea txtPurposeOfVisit;
	private JLabel lblTimeOfLeave;
	private JTextField jtxtfldTimeOfVisit;
	private JTextField jtxtfldTimeOfLeave;
	private JPanel panel;
	private JButton jbtnOk;
	private JButton jbtnCancel;
	
	public AddDialog() {
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
		gridBagLayout.columnWeights = new double[]{0.15, 0.85, Double.MIN_VALUE};
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
		comboBox = new JComboBox<>(visitorType);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		comboBox.setVisible(rootPaneCheckingEnabled);
		jpnlContentPane.add(comboBox, gbc_comboBox);
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
		panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 40));
		panel.setPreferredSize(new Dimension(10, 40));
		panel.setMinimumSize(new Dimension(10, 40));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		jpnlContentPane.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		//create and add buttons to the panel
		jbtnCancel = new JButton("Cancel");
		panel.add(jbtnCancel);
		
		jbtnOk = new JButton("Ok");
		panel.add(jbtnOk);
		
		
		
	}// AddDialog();
}// class AddDialog
