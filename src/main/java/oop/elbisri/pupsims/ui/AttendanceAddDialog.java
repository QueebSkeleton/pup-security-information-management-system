package oop.elbisri.pupsims.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import oop.elbisri.pupsims.domain.Attendance;

/**
 * Add form dialog for adding attendances.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class AttendanceAddDialog extends JDialog {
	
	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Attendance Management Panel that owns this dialog box.
	 */
	protected AttendanceManagementPanel attendanceManagementPanel;

	/**
	 * Main Content Pane of this Frame
	 */
	private JPanel jpnlContentPane;

	/**
	 * Create the dialog.
	 */
	public AttendanceAddDialog() {
		
		// For reference later
		AttendanceAddDialog thisDialog = this;
		
		// Set minimum size
		setMinimumSize(new Dimension(300, 190));
		
		// Set title
		setTitle("Add Attendance");
		
		// Create the main content pane of this frame
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// Set the content pane of this frame to the custom JPanel
		// Use GridBagLayout for an eye-friendly form
		setContentPane(jpnlContentPane);
		GridBagLayout gbl_jpnlContentPane = new GridBagLayout();
		gbl_jpnlContentPane.columnWidths = new int[]{0, 0, 0};
		gbl_jpnlContentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_jpnlContentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_jpnlContentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlContentPane.setLayout(gbl_jpnlContentPane);
		
		/* jlblSecurityGuard - Security Guard Label */
		JLabel jlblSecurityGuard = new JLabel("Guard Name:");
		jlblSecurityGuard.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblSecurityGuard = new GridBagConstraints();
		gbc_jlblSecurityGuard.insets = new Insets(0, 0, 5, 5);
		gbc_jlblSecurityGuard.anchor = GridBagConstraints.EAST;
		gbc_jlblSecurityGuard.gridx = 0;
		gbc_jlblSecurityGuard.gridy = 0;
		jpnlContentPane.add(jlblSecurityGuard, gbc_jlblSecurityGuard);
		/* END OF jlblSecurityGuard */
		
		/* jtxtfldSecurityGuard - Security Guard Text Field Input */
		JTextField jtxtfldSecurityGuard = new JTextField();
		jtxtfldSecurityGuard.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldSecurityGuard.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldSecurityGuard = new GridBagConstraints();
		gbc_jtxtfldSecurityGuard.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldSecurityGuard.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldSecurityGuard.gridx = 1;
		gbc_jtxtfldSecurityGuard.gridy = 0;
		jpnlContentPane.add(jtxtfldSecurityGuard, gbc_jtxtfldSecurityGuard);
		jtxtfldSecurityGuard.setColumns(10);
		/* END OF jtxtfldSecurityGuard */

		/* jlblLogDate - Log Date Label */
		JLabel jlblLogDate = new JLabel("Log Date:");
		jlblLogDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblLogDate = new GridBagConstraints();
		gbc_jlblLogDate.anchor = GridBagConstraints.EAST;
		gbc_jlblLogDate.insets = new Insets(0, 0, 5, 5);
		gbc_jlblLogDate.gridx = 0;
		gbc_jlblLogDate.gridy = 1;
		jpnlContentPane.add(jlblLogDate, gbc_jlblLogDate);
		/* END OF jlblLogDate */

		/* jtxtfldLogDate - Log Date Text Field Input */
		JTextField jtxtfldLogDate = new JTextField();
		jtxtfldLogDate.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldLogDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldLogDate.setColumns(10);
		GridBagConstraints gbc_jtxtfldLogDate = new GridBagConstraints();
		gbc_jtxtfldLogDate.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldLogDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldLogDate.gridx = 1;
		gbc_jtxtfldLogDate.gridy = 1;
		jpnlContentPane.add(jtxtfldLogDate, gbc_jtxtfldLogDate);
		/* END OF jtxtfldLogDate */

		/* jlblStatus - Status Label */
		JLabel jlblStatus = new JLabel("Status:");
		jlblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblStatus = new GridBagConstraints();
		gbc_jlblStatus.anchor = GridBagConstraints.EAST;
		gbc_jlblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_jlblStatus.gridx = 0;
		gbc_jlblStatus.gridy = 2;
		jpnlContentPane.add(jlblStatus, gbc_jlblStatus);
		/* END OF jlblStatus */

		/* jtxtfldStatus - Status Text Field Input */
		JTextField jtxtfldStatus = new JTextField();
		jtxtfldStatus.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldStatus.setColumns(10);
		GridBagConstraints gbc_jtxtfldStatus = new GridBagConstraints();
		gbc_jtxtfldStatus.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldStatus.gridx = 1;
		gbc_jtxtfldStatus.gridy = 2;
		jpnlContentPane.add(jtxtfldStatus, gbc_jtxtfldStatus);
		/* END OF jtxtfldStatus */

		/* jbtnSave - Save Button */
		JButton jbtnSave = new JButton("Save");
		jbtnSave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jbtnSave = new GridBagConstraints();
		gbc_jbtnSave.gridx = 1;
		gbc_jbtnSave.gridy = 3;
		
		// Attach Action Listener (Click)
		jbtnSave.addActionListener(event -> {
			// Construct an attendance domain object from the inputs
			Attendance attendance = new Attendance(
					null,
					1L,
					LocalDate.parse(jtxtfldLogDate.getText()),
					Attendance.Status.valueOf(jtxtfldStatus.getText()));
			
			// Clear the input fields
			jtxtfldSecurityGuard.setText("");
			jtxtfldLogDate.setText("");
			jtxtfldStatus.setText("");
			
			// Save the constructed attendance object
			attendanceManagementPanel.attendanceRepository.save(attendance);
			// Refresh the management panel table model
			thisDialog.attendanceManagementPanel.attendanceTableModel.update();
			// Hide this add dialog
			thisDialog.setVisible(false);
		});
		
		jpnlContentPane.add(jbtnSave, gbc_jbtnSave);
		/* END OF jlblSecurityGuard */
	}

}
