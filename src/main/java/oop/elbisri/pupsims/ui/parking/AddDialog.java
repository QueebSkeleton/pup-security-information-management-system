package oop.elbisri.pupsims.ui.parking;

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

public class AddDialog extends JDialog {

	/**
	 * Default Serial Version UID (for serializability, not important, placed to
	 * remove warnings)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Main Content Pane of this Frame
	 */
	private JPanel jpnlContentPane;
	private JTextField jtxtfldSlotNumber;
	private JTextField jtxtfldLocation;
	private JTextArea jtxtDescription;
	private JComboBox<String> jcmbStatus;

	protected ManagementPanel parkingManagementPanel;

	/**
	 * Create the dialog.
	 */
	public AddDialog() {
		// For reference later
		AddDialog thisDialog = this;

		// Prevent user from resizing
		setResizable(false);

		// Set minimum size
		setMinimumSize(new Dimension(460, 300));

		// Set title
		setTitle("Add Parking Slot");

		// Create the main content pane of this frame
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		// Set the content pane of this frame to the custom JPanel
		// Use GridBagLayout for an eye-friendly form
		setContentPane(jpnlContentPane);
		GridBagLayout gbl_jpnlContentPane = new GridBagLayout();
		gbl_jpnlContentPane.columnWidths = new int[] { 148, 0 };
		gbl_jpnlContentPane.rowHeights = new int[] { 0, 32, 0, 0, 28, 0 };
		gbl_jpnlContentPane.columnWeights = new double[] { 0.0, 1.0 };
		gbl_jpnlContentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		jpnlContentPane.setLayout(gbl_jpnlContentPane);

		/* jlblSlotNumber Slot number */
		JLabel jlblSlotNumber = new JLabel("Slot number:");
		jlblSlotNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblSlotNumber = new GridBagConstraints();
		gbc_jlblSlotNumber.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblSlotNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jlblSlotNumber.gridx = 0;
		gbc_jlblSlotNumber.gridy = 0;
		jpnlContentPane.add(jlblSlotNumber, gbc_jlblSlotNumber);
		/* END OF jlblSlotNumber */

		/* jtxtfldSlotNumber */
		jtxtfldSlotNumber = new JTextField();
		jtxtfldSlotNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldSlotNumber = new GridBagConstraints();
		gbc_jtxtfldSlotNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldSlotNumber.anchor = GridBagConstraints.WEST;
		gbc_jtxtfldSlotNumber.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldSlotNumber.gridx = 1;
		gbc_jtxtfldSlotNumber.gridy = 0;
		jpnlContentPane.add(jtxtfldSlotNumber, gbc_jtxtfldSlotNumber);
		jtxtfldSlotNumber.setColumns(10);
		/* END OF jtxtfldSlotNumber */

		/* jlblLocation Location */
		JLabel jlblLocation = new JLabel("Location:");
		jlblLocation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblLocation = new GridBagConstraints();
		gbc_jlblLocation.anchor = GridBagConstraints.EAST;
		gbc_jlblLocation.insets = new Insets(0, 0, 5, 5);
		gbc_jlblLocation.gridx = 0;
		gbc_jlblLocation.gridy = 1;
		jpnlContentPane.add(jlblLocation, gbc_jlblLocation);
		/* END OF jlblLocation */

		/* jtxtfldLocation Location */
		jtxtfldLocation = new JTextField();
		jtxtfldLocation.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldLocation = new GridBagConstraints();
		gbc_jtxtfldLocation.fill = GridBagConstraints.BOTH;
		gbc_jtxtfldLocation.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldLocation.gridx = 1;
		gbc_jtxtfldLocation.gridy = 1;
		jpnlContentPane.add(jtxtfldLocation, gbc_jtxtfldLocation);
		jtxtfldLocation.setColumns(10);
		/* END OF jtxtfldLocation */

		/* jlblDescription Location Description */
		JLabel jlblDescription = new JLabel("Description:");
		jlblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblDescription = new GridBagConstraints();
		gbc_jlblDescription.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_jlblDescription.gridx = 0;
		gbc_jlblDescription.gridy = 2;
		jpnlContentPane.add(jlblDescription, gbc_jlblDescription);
		/* END OF jlblDescription */

		/* jtxtDescription Description */
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		jpnlContentPane.add(scrollPane, gbc_scrollPane);

		jtxtDescription = new JTextArea();
		scrollPane.setViewportView(jtxtDescription);
		jtxtDescription.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		JLabel jlblStatus = new JLabel("Status:");
		jlblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblStatus = new GridBagConstraints();
		gbc_jlblStatus.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_jlblStatus.gridx = 0;
		gbc_jlblStatus.gridy = 3;
		jpnlContentPane.add(jlblStatus, gbc_jlblStatus);
		/* END OF jtxtDescription */

		/* jcmbStatus Status selection */
		jcmbStatus = new JComboBox<>();
		jcmbStatus.setAlignmentY(0.0f);
		jcmbStatus.setAlignmentX(0.0f);
		jcmbStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jcmbStatus.setModel(new DefaultComboBoxModel<>(new String[] { "GOOD_CONDITION", "BAD_CONDITION" }));
		GridBagConstraints gbc_jcmbStatus = new GridBagConstraints();
		gbc_jcmbStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcmbStatus.insets = new Insets(0, 0, 5, 0);
		gbc_jcmbStatus.gridx = 1;
		gbc_jcmbStatus.gridy = 3;
		jpnlContentPane.add(jcmbStatus, gbc_jcmbStatus);
		/* END OF jcmbStatus */

		// create panel that will hold the CANCEL and OK button
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.gridwidth = 2;
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 4;
		jpnlContentPane.add(buttonPanel, gbc_buttonPanel);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		// add buttons to panel
		JButton jbtnOk = new JButton("Ok");
		jbtnOk.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		jbtnOk.addActionListener(event -> {
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pupsims_db", "pupsims",
						"pupsimspass_123");
				Statement statement = connection.createStatement();

				statement.execute("INSERT INTO parking_slot VALUES('" + jtxtfldSlotNumber.getText() + "', '"
						+ jtxtfldLocation.getText() + "'," + "'" + jtxtDescription.getText() + "', '" + jcmbStatus.getItemAt(jcmbStatus.getSelectedIndex())
						+ "')");

				statement.close();
				connection.close();

				JOptionPane.showMessageDialog(thisDialog, "Parking slot added successfully!");

				// Close the dialog after saving
				this.setVisible(false);
				
				// Refresh the table
				parkingManagementPanel.updateTable();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(thisDialog, "An error occured while saving... \n \n Details: " + e);
			}
		});
		buttonPanel.add(jbtnOk);

		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		jbtnCancel.addActionListener(event -> {
			// Closes the dialog
			this.setVisible(false);
		});
		buttonPanel.add(jbtnCancel);

	}

	// resets the form
	public void resetForm() {
		jtxtfldSlotNumber.setText("");
		jtxtfldLocation.setText("");
		jtxtDescription.setText("");
		jcmbStatus.setSelectedIndex(0);
	}

}
