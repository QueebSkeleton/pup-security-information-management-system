package oop.elbisri.pupsims.ui.attendance;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import oop.elbisri.pupsims.domain.Attendance;
import oop.elbisri.pupsims.domain.Attendance.Status;

/**
 * Add form dialog for adding attendances.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class AddDialog extends JDialog {
	
	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Attendance Management Panel that owns this dialog box.
	 */
	protected ManagementPanel attendanceManagementPanel;

	/**
	 * Main Content Pane of this Frame
	 */
	private JPanel jpnlContentPane;
	
	// Form Components
	private JTextField jtxtfldSecurityGuard;
	private JTextField jtxtfldLogDate;
	private JComboBox<Attendance.Status> jcmbStatus;

	/**
	 * Create the dialog.
	 */
	public AddDialog() {
		setResizable(false);
		
		// For reference later
		AddDialog thisDialog = this;
		
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
		gbl_jpnlContentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_jpnlContentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		jtxtfldSecurityGuard = new JTextField();
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
		jtxtfldLogDate = new JTextField();
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
		/* END OF jtxtfldStatus */
		
		jcmbStatus = new JComboBox<>();
		jcmbStatus.setModel(new DefaultComboBoxModel<>(Status.values()));
		jcmbStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		jpnlContentPane.add(jcmbStatus, gbc_comboBox);

		/* jbtnSave - Save Button */
		JButton jbtnSave = new JButton("Save");
		jbtnSave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jbtnSave = new GridBagConstraints();
		gbc_jbtnSave.anchor = GridBagConstraints.EAST;
		gbc_jbtnSave.gridx = 1;
		gbc_jbtnSave.gridy = 3;
		
		// Attach Action Listener (Click)
		jbtnSave.addActionListener(event -> {
			// Construct an attendance domain object from the inputs
			Attendance attendance = new Attendance(
					null,
					1L,
					LocalDate.parse(jtxtfldLogDate.getText()),
					(Attendance.Status) jcmbStatus.getSelectedItem());
			
			// Save the constructed attendance object, with a SwingWorker
			new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					attendanceManagementPanel.attendanceRepository.save(attendance);
					return null;
				}
				@Override
				protected void done() {
					// Refresh the management panel table model after the attendance has been saved
					thisDialog.attendanceManagementPanel.attendanceTableModel.update();
				}
			}.execute();
			
			// Hide this add dialog
			thisDialog.setVisible(false);
		});
		
		jpnlContentPane.add(jbtnSave, gbc_jbtnSave);
		/* END OF jlblSecurityGuard */
	}
	
	/**
	 * Clears and resets the form.
	 */
	public void resetForm() {
		jtxtfldSecurityGuard.setText("");
		jtxtfldLogDate.setText(LocalDate.now().toString());
		jcmbStatus.setSelectedIndex(0);
	}

}
