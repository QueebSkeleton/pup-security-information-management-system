package oop.elbisri.pupsims.ui.parking;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
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

	protected ManagementPanel parkingManagementPanel;

	/**
	 * Create the dialog.
	 */
	public AddDialog() {
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
		gbl_jpnlContentPane.rowHeights = new int[] { 0, 0, 0, 28, 0 };
		gbl_jpnlContentPane.columnWeights = new double[] { 0.0, 0.85 };
		gbl_jpnlContentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
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

		/* jlblLocationDescription Location Description */
		JLabel jlblLocationDescription = new JLabel("Text Description of Location:");
		jlblLocationDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblLocationDescription = new GridBagConstraints();
		gbc_jlblLocationDescription.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblLocationDescription.insets = new Insets(0, 0, 5, 5);
		gbc_jlblLocationDescription.gridx = 0;
		gbc_jlblLocationDescription.gridy = 1;
		jpnlContentPane.add(jlblLocationDescription, gbc_jlblLocationDescription);
		/* END OF jtxtareaLocationDescription */

		/* jlblStatus Status */

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		jpnlContentPane.add(scrollPane, gbc_scrollPane);

		JTextArea jtxtareaLocationDescription = new JTextArea();
		scrollPane.setViewportView(jtxtareaLocationDescription);
		jtxtareaLocationDescription.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		JLabel jlblStatus = new JLabel("Status:");
		jlblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblStatus = new GridBagConstraints();
		gbc_jlblStatus.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_jlblStatus.gridx = 0;
		gbc_jlblStatus.gridy = 2;
		jpnlContentPane.add(jlblStatus, gbc_jlblStatus);
		/* END OF jlblStatus */

		/* jcmbStatus Status selection */
		JComboBox<String> jcmbStatus = new JComboBox<>();
		jcmbStatus.setAlignmentY(0.0f);
		jcmbStatus.setAlignmentX(0.0f);
		jcmbStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jcmbStatus.setModel(new DefaultComboBoxModel<>(new String[] { "GOOD_CONDITION", "BAD_CONDITION" }));
		GridBagConstraints gbc_jcmbStatus = new GridBagConstraints();
		gbc_jcmbStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcmbStatus.insets = new Insets(0, 0, 5, 0);
		gbc_jcmbStatus.gridx = 1;
		gbc_jcmbStatus.gridy = 2;
		jpnlContentPane.add(jcmbStatus, gbc_jcmbStatus);
		/* END OF jcmbStatus */

		// create panel that will hold the CANCEL and OK button
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		jpnlContentPane.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		// add buttons to panel
		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		panel.add(jbtnCancel);

		JButton jbtnOk = new JButton("Ok");
		jbtnOk.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		panel.add(jbtnOk);

	}

}
