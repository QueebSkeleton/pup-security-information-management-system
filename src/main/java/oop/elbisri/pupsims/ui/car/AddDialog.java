package oop.elbisri.pupsims.ui.car;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;

/**
 * Add form dialog for adding car information for parking.
 * 
 * @author Bismillah C. Constantino
 *
 */

public class AddDialog extends JDialog{
	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Main Content Pane of this Frame
	 */
	private JPanel jpnlContentPane;
	
	/**
	 * Attendance Management Panel that owns this dialog box.
	 */
	protected ManagementPanel carManagementPanel;

	
	//Form Components
	private JTextField jtxtfldOwnerFirstName;
	private JTextField jtxtfldOwnerLastName;
	private JLabel jlblContactNumber;
	private JTextField jtxtfldContactNumber;
	private JLabel jlblCarPlateNumber;
	private JTextField jtxtfldCarPlateNumber;
	private JLabel jlblCarModelAndColor;
	private JTextField jtxtfldCarModelAndColor;
	private JLabel jlblTimeEntered;
	private JTextField jtxtfldTimeEntered;
	private JLabel jlblTimeExited;
	private JTextField jtxtfldTimeExited;
	private JLabel jlblParkingSlot;
	private JTextField jtxtfldParkingSlot;
	private JPanel panel;
	private JButton jbtnCancel;
	private JButton jbtnOk;
	
	
	
	public AddDialog() {
		//prevent user from resizing the dialog
		setResizable(false);
				
		//set window size
		setMinimumSize(new Dimension(600, 260));
				
		//set title
		setTitle("Add Car Information");
				
		// Create the main content pane of this frame
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
				
		// Create the main content pane of this frame
		setContentPane(jpnlContentPane);
				
		// Use GridBagLayout for an eye-friendly form
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 154, 0, 0};
		gridBagLayout.rowHeights = new int[] {30, 30, 39, 30, 30, 28, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlContentPane.setLayout(gridBagLayout);
		
		/*  jlblOwnerFirstName  Name of Visitor Label      */
		JLabel jlblOwnerFirstName = new JLabel("Owner first name:");
		jlblOwnerFirstName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblOwnerFirstName = new GridBagConstraints();
		gbc_jlblOwnerFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblOwnerFirstName.gridx = 0;
		gbc_jlblOwnerFirstName.gridy = 0;
		jpnlContentPane.add(jlblOwnerFirstName, gbc_jlblOwnerFirstName);
		/*  END OF jlblOwnerFirstName          */
		
		/* jtxtfldOwnerFirstName*/
		jtxtfldOwnerFirstName = new JTextField();
		jtxtfldOwnerFirstName.setColumns(10);
		jtxtfldOwnerFirstName.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldOwnerFirstName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldOwnerFirstName = new GridBagConstraints();
		gbc_jtxtfldOwnerFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldOwnerFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_jtxtfldOwnerFirstName.gridx = 1;
		gbc_jtxtfldOwnerFirstName.gridy = 0;
		jpnlContentPane.add(jtxtfldOwnerFirstName, gbc_jtxtfldOwnerFirstName);
		/* END OF jtxtfldOwnerFirstName*/
		
		/* jlblOwnerLastName Owner Last Name */
		JLabel jlblOwnerLastName = new JLabel("Owner last name:");
		jlblOwnerLastName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblOwnerLastName = new GridBagConstraints();
		gbc_jlblOwnerLastName.anchor = GridBagConstraints.EAST;
		gbc_jlblOwnerLastName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblOwnerLastName.gridx = 2;
		gbc_jlblOwnerLastName.gridy = 0;
		jpnlContentPane.add(jlblOwnerLastName, gbc_jlblOwnerLastName);
		/* END OF jlblOwnerLastName*/
		
		/*jtxtfldOwnerLastName  */
		jtxtfldOwnerLastName = new JTextField();
		jtxtfldOwnerLastName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldOwnerLastName = new GridBagConstraints();
		gbc_jtxtfldOwnerLastName.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldOwnerLastName.fill = GridBagConstraints.BOTH;
		gbc_jtxtfldOwnerLastName.gridx = 3;
		gbc_jtxtfldOwnerLastName.gridy = 0;
		jpnlContentPane.add(jtxtfldOwnerLastName, gbc_jtxtfldOwnerLastName);
		jtxtfldOwnerLastName.setColumns(10);
		/* END OF jtxtfldOwnerLastName*/
		
		/*jlblContactNumber Contact Number */
		jlblContactNumber = new JLabel("Contact number:");
		jlblContactNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblContactNumber = new GridBagConstraints();
		gbc_jlblContactNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jlblContactNumber.gridx = 0;
		gbc_jlblContactNumber.gridy = 1;
		jpnlContentPane.add(jlblContactNumber, gbc_jlblContactNumber);
		/* END OF jlblContactNumber*/
		
		/*jtxtfldContactNumber*/
		jtxtfldContactNumber = new JTextField();
		jtxtfldContactNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldContactNumber = new GridBagConstraints();
		gbc_jtxtfldContactNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jtxtfldContactNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldContactNumber.gridx = 1;
		gbc_jtxtfldContactNumber.gridy = 1;
		jpnlContentPane.add(jtxtfldContactNumber, gbc_jtxtfldContactNumber);
		jtxtfldContactNumber.setColumns(10);
		/*END OF jtxtfldContactNumber*/
		
		/*jlblCarPlateNumber Car Plate Number*/
		jlblCarPlateNumber = new JLabel("Car plate number:");
		jlblCarPlateNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblCarPlateNumber = new GridBagConstraints();
		gbc_jlblCarPlateNumber.anchor = GridBagConstraints.EAST;
		gbc_jlblCarPlateNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jlblCarPlateNumber.gridx = 2;
		gbc_jlblCarPlateNumber.gridy = 1;
		jpnlContentPane.add(jlblCarPlateNumber, gbc_jlblCarPlateNumber);
		/*END OF jlblCarPlateNumber*/
		
		/*jtxtfldCarPlateNumber */
		jtxtfldCarPlateNumber = new JTextField();
		jtxtfldCarPlateNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldCarPlateNumber = new GridBagConstraints();
		gbc_jtxtfldCarPlateNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldCarPlateNumber.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldCarPlateNumber.gridx = 3;
		gbc_jtxtfldCarPlateNumber.gridy = 1;
		jpnlContentPane.add(jtxtfldCarPlateNumber, gbc_jtxtfldCarPlateNumber);
		jtxtfldCarPlateNumber.setColumns(10);
		/*END OF jtxtfldCarPlateNumber*/
		
		/* jlblCarModelAndColor Car Model and Color*/
		jlblCarModelAndColor = new JLabel("Car Model and Color:");
		jlblCarModelAndColor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblCarModelAndColor = new GridBagConstraints();
		gbc_jlblCarModelAndColor.insets = new Insets(0, 0, 5, 5);
		gbc_jlblCarModelAndColor.gridx = 0;
		gbc_jlblCarModelAndColor.gridy = 2;
		jpnlContentPane.add(jlblCarModelAndColor, gbc_jlblCarModelAndColor);
		/*END OF jlblCarModelAndColor*/
		
		/*jtxtfldCarModelAndColor*/
		jtxtfldCarModelAndColor = new JTextField();
		jtxtfldCarModelAndColor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldCarModelAndColor = new GridBagConstraints();
		gbc_jtxtfldCarModelAndColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldCarModelAndColor.gridwidth = 3;
		gbc_jtxtfldCarModelAndColor.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldCarModelAndColor.gridx = 1;
		gbc_jtxtfldCarModelAndColor.gridy = 2;
		jpnlContentPane.add(jtxtfldCarModelAndColor, gbc_jtxtfldCarModelAndColor);
		jtxtfldCarModelAndColor.setColumns(10);
		/*END OF jtxtfldCarModelAndColor*/
		
		/*jlblTimeEntered Time Entered*/
		jlblTimeEntered = new JLabel("Time entered:");
		jlblTimeEntered.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblTimeEntered = new GridBagConstraints();
		gbc_jlblTimeEntered.insets = new Insets(0, 0, 5, 5);
		gbc_jlblTimeEntered.gridx = 0;
		gbc_jlblTimeEntered.gridy = 3;
		jpnlContentPane.add(jlblTimeEntered, gbc_jlblTimeEntered);
		/*END OF jlblTimeEntered*/
		
		/*jtxtfldTimeEntered*/
		jtxtfldTimeEntered = new JTextField();
		jtxtfldTimeEntered.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldTimeEntered = new GridBagConstraints();
		gbc_jtxtfldTimeEntered.insets = new Insets(0, 0, 5, 5);
		gbc_jtxtfldTimeEntered.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldTimeEntered.gridx = 1;
		gbc_jtxtfldTimeEntered.gridy = 3;
		jpnlContentPane.add(jtxtfldTimeEntered, gbc_jtxtfldTimeEntered);
		jtxtfldTimeEntered.setColumns(10);
		/*END OF jtxtfldTimeEntered*/
		
		/*jlblTimeExited Time exited*/
		jlblTimeExited = new JLabel("Time exited:");
		jlblTimeExited.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblTimeExited = new GridBagConstraints();
		gbc_jlblTimeExited.insets = new Insets(0, 0, 5, 5);
		gbc_jlblTimeExited.gridx = 2;
		gbc_jlblTimeExited.gridy = 3;
		jpnlContentPane.add(jlblTimeExited, gbc_jlblTimeExited);
		/*END OF jlblTimeExited*/
		
		/*jtxtfldTimeExited*/
		jtxtfldTimeExited = new JTextField();
		jtxtfldTimeExited.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldTimeExited = new GridBagConstraints();
		gbc_jtxtfldTimeExited.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldTimeExited.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldTimeExited.gridx = 3;
		gbc_jtxtfldTimeExited.gridy = 3;
		jpnlContentPane.add(jtxtfldTimeExited, gbc_jtxtfldTimeExited);
		jtxtfldTimeExited.setColumns(10);
		/*END OF jtxtfldTimeExited*/
		
		/*jlblParkingSlot Parking Slot*/
		jlblParkingSlot = new JLabel("Parking slot:");
		jlblParkingSlot.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblParkingSlot = new GridBagConstraints();
		gbc_jlblParkingSlot.insets = new Insets(0, 0, 5, 5);
		gbc_jlblParkingSlot.gridx = 0;
		gbc_jlblParkingSlot.gridy = 4;
		jpnlContentPane.add(jlblParkingSlot, gbc_jlblParkingSlot);
		/*END OF jlblParkingSlot*/
		
		/*jtxtfldParkingSlot*/
		jtxtfldParkingSlot = new JTextField();
		jtxtfldParkingSlot.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldParkingSlot = new GridBagConstraints();
		gbc_jtxtfldParkingSlot.insets = new Insets(0, 0, 5, 5);
		gbc_jtxtfldParkingSlot.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldParkingSlot.gridx = 1;
		gbc_jtxtfldParkingSlot.gridy = 4;
		jpnlContentPane.add(jtxtfldParkingSlot, gbc_jtxtfldParkingSlot);
		jtxtfldParkingSlot.setColumns(10);
		/*END OF jtxtfldParkingSlot*/
		
		//Create a panel that will hold CANCEL and OK button
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		jpnlContentPane.add(panel, gbc_panel);
		panel.setFocusable(false);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		jbtnCancel = new JButton("Cancel");
		jbtnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		jbtnCancel.setFocusable(false);
		panel.add(jbtnCancel);
		
		jbtnOk = new JButton("Ok");
		jbtnOk.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		jbtnOk.setFocusable(false);
		panel.add(jbtnOk);
		
	}// public AddDialog();
	
}// public class AddDialog
