package oop.elbisri.pupsims.ui.attendance;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.concurrent.ExecutionException;

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
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

/**
 * Add form dialog for adding attendances.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class AddDialog extends JDialog {

	/**
	 * Default Serial Version UID (for serializability, not important, placed to
	 * remove warnings)
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

	// Form inputs
	private JComboBox<String> jcmbSecurityGuard;
	private JTextField jtxtfldLogDate;
	private JComboBox<String> jcmbStatus;
	private JTextField jtxtfldWorkIn;
	private JTextField jtxtfldWorkOut;
	private JTextArea jtxtareaRemarks;

	/**
	 * Create the dialog.
	 */
	public AddDialog() {

		// For reference later
		AddDialog thisDialog = this;

		// Set minimum size
		setMinimumSize(new Dimension(400, 400));

		// Set title
		setTitle("Add Attendance");

		// Create the main content pane of this frame
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(null);

		// Set the content pane of this frame to the custom JPanel
		// Use GridBagLayout for an eye-friendly form
		setContentPane(jpnlContentPane);
		jpnlContentPane.setLayout(new BorderLayout(0, 0));

		/* jpnlMainForm - main form panel, uses GridBagLayout */
		JPanel jpnlMainForm = new JPanel();
		jpnlMainForm.setBorder(new EmptyBorder(10, 10, 10, 10));
		jpnlContentPane.add(jpnlMainForm, BorderLayout.CENTER);
		GridBagLayout gbl_jpnlMainForm = new GridBagLayout();
		gbl_jpnlMainForm.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpnlMainForm.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_jpnlMainForm.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpnlMainForm.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		jpnlMainForm.setLayout(gbl_jpnlMainForm);
		/* END OF jpnlMainForm */

		/* jlblSecurityGuard - label for security guard input */
		JLabel jlblSecurityGuard = new JLabel("Guard Name:");
		jlblSecurityGuard.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblSecurityGuard = new GridBagConstraints();
		gbc_jlblSecurityGuard.insets = new Insets(0, 0, 5, 5);
		gbc_jlblSecurityGuard.anchor = GridBagConstraints.EAST;
		gbc_jlblSecurityGuard.gridx = 0;
		gbc_jlblSecurityGuard.gridy = 0;
		jpnlMainForm.add(jlblSecurityGuard, gbc_jlblSecurityGuard);
		/* END OF jlblSecurityGuard */

		/* jcmbSecurityGuard - combo boxinput for security guard */
		jcmbSecurityGuard = new JComboBox<>();
		jcmbSecurityGuard.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jcmbSecurityGuard = new GridBagConstraints();
		gbc_jcmbSecurityGuard.insets = new Insets(0, 0, 5, 0);
		gbc_jcmbSecurityGuard.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcmbSecurityGuard.gridx = 1;
		gbc_jcmbSecurityGuard.gridy = 0;
		jpnlMainForm.add(jcmbSecurityGuard, gbc_jcmbSecurityGuard);
		/* END OF jtxtfldSecurityGuard */

		/* jlblLogDate - label for log date input */
		JLabel jlblLogDate = new JLabel("Log Date:");
		jlblLogDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblLogDate = new GridBagConstraints();
		gbc_jlblLogDate.insets = new Insets(0, 0, 5, 5);
		gbc_jlblLogDate.anchor = GridBagConstraints.EAST;
		gbc_jlblLogDate.gridx = 0;
		gbc_jlblLogDate.gridy = 1;
		jpnlMainForm.add(jlblLogDate, gbc_jlblLogDate);
		/* END OF jlblLogDate */

		/* jtxtfldLogDate - text field input for log date */
		jtxtfldLogDate = new JTextField();
		jtxtfldLogDate.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldLogDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldLogDate.setColumns(10);
		GridBagConstraints gbc_jtxtfldLogDate = new GridBagConstraints();
		gbc_jtxtfldLogDate.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldLogDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldLogDate.gridx = 1;
		gbc_jtxtfldLogDate.gridy = 1;
		jpnlMainForm.add(jtxtfldLogDate, gbc_jtxtfldLogDate);
		/* END OF jtxtfldLogDate */

		/* jlblStatus - label for status input */
		JLabel jlblStatus = new JLabel("Status:");
		jlblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblStatus = new GridBagConstraints();
		gbc_jlblStatus.anchor = GridBagConstraints.EAST;
		gbc_jlblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_jlblStatus.gridx = 0;
		gbc_jlblStatus.gridy = 2;
		jpnlMainForm.add(jlblStatus, gbc_jlblStatus);
		/* END OF jlblStatus */

		/* jcmbStatus - combobox input for status */
		jcmbStatus = new JComboBox<String>(
				new DefaultComboBoxModel<>(new String[] { "Present", "Absent", "On Leave" }));
		jcmbStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jcmbStatus = new GridBagConstraints();
		gbc_jcmbStatus.insets = new Insets(0, 0, 5, 0);
		gbc_jcmbStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcmbStatus.gridx = 1;
		gbc_jcmbStatus.gridy = 2;
		jpnlMainForm.add(jcmbStatus, gbc_jcmbStatus);
		/* END OF jcmbStatus */

		/* jlblWorkIn - label for work in input */
		JLabel jlblWorkIn = new JLabel("Work In:");
		jlblWorkIn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblWorkIn = new GridBagConstraints();
		gbc_jlblWorkIn.anchor = GridBagConstraints.EAST;
		gbc_jlblWorkIn.insets = new Insets(0, 0, 5, 5);
		gbc_jlblWorkIn.gridx = 0;
		gbc_jlblWorkIn.gridy = 3;
		jpnlMainForm.add(jlblWorkIn, gbc_jlblWorkIn);
		/* END OF jlblWorkIn */

		/* jtxtfldWorkIn - text field input for work in */
		jtxtfldWorkIn = new JTextField();
		jtxtfldWorkIn.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldWorkIn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldWorkIn.setColumns(10);
		GridBagConstraints gbc_jtxtfldWorkIn = new GridBagConstraints();
		gbc_jtxtfldWorkIn.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldWorkIn.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldWorkIn.gridx = 1;
		gbc_jtxtfldWorkIn.gridy = 3;
		jpnlMainForm.add(jtxtfldWorkIn, gbc_jtxtfldWorkIn);
		/* END OF jtxtfldWorkIn */

		/* jlblWorkOut - label for work out input */
		JLabel jlblWorkOut = new JLabel("Work Out:");
		jlblWorkOut.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblWorkOut = new GridBagConstraints();
		gbc_jlblWorkOut.anchor = GridBagConstraints.EAST;
		gbc_jlblWorkOut.insets = new Insets(0, 0, 5, 5);
		gbc_jlblWorkOut.gridx = 0;
		gbc_jlblWorkOut.gridy = 4;
		jpnlMainForm.add(jlblWorkOut, gbc_jlblWorkOut);
		/* END OF jlblWorkOut */

		/* jtxtfldWorkOut - text field input for work out */
		jtxtfldWorkOut = new JTextField();
		jtxtfldWorkOut.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldWorkOut.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldWorkOut.setColumns(10);
		GridBagConstraints gbc_jtxtfldWorkOut = new GridBagConstraints();
		gbc_jtxtfldWorkOut.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldWorkOut.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldWorkOut.gridx = 1;
		gbc_jtxtfldWorkOut.gridy = 4;
		jpnlMainForm.add(jtxtfldWorkOut, gbc_jtxtfldWorkOut);
		/* END OF jtxtfldWorkOut */

		/* jlblRemarks - label for remarks input */
		JLabel jlblRemarks = new JLabel("Remarks:");
		jlblRemarks.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblRemarks = new GridBagConstraints();
		gbc_jlblRemarks.insets = new Insets(0, 0, 0, 5);
		gbc_jlblRemarks.gridx = 0;
		gbc_jlblRemarks.gridy = 5;
		jpnlMainForm.add(jlblRemarks, gbc_jlblRemarks);
		/* END OF jlblRemarks */

		/* jscrlpnRemarksTextArea - scrollable container for remarks input */
		JScrollPane jscrlpnRemarksTextArea = new JScrollPane();
		GridBagConstraints gbc_jscrlpnRemarksTextArea = new GridBagConstraints();
		gbc_jscrlpnRemarksTextArea.fill = GridBagConstraints.BOTH;
		gbc_jscrlpnRemarksTextArea.gridx = 1;
		gbc_jscrlpnRemarksTextArea.gridy = 5;
		jpnlMainForm.add(jscrlpnRemarksTextArea, gbc_jscrlpnRemarksTextArea);
		/* END OF jscrlpnRemarksTextArea */

		/* jtxtareaRemarks - text area input for remarks */
		jtxtareaRemarks = new JTextArea();
		jscrlpnRemarksTextArea.setViewportView(jtxtareaRemarks);
		/* END OF jtxtareaRemarks */

		/* jpnlButtonActions - bottom button actions panel */
		JPanel jpnlButtonActions = new JPanel();
		FlowLayout fl_jpnlButtonActions = (FlowLayout) jpnlButtonActions.getLayout();
		fl_jpnlButtonActions.setAlignment(FlowLayout.RIGHT);
		jpnlContentPane.add(jpnlButtonActions, BorderLayout.SOUTH);
		/* END OF jpnlButtonActions */

		/* jbtnCancel - cancel button */
		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.addActionListener(event -> {
			thisDialog.setVisible(false);
		});
		jbtnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnCancel);
		/* END OF jbtnCancel */

		/* jbtnLog - log button (save) */
		JButton jbtnLog = new JButton("Log");
		jbtnLog.addActionListener(event -> {
			// Save the constructed attendance object, with a SwingWorker
			new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					try (Connection connection = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/pupsims_db", "pupsims", "pupsimspass_123");
							PreparedStatement insertStatement = connection.prepareStatement(
									"INSERT INTO attendance VALUES (NULL, ?, ?, ?, ?, ?, 'Viewed')")) {

						insertStatement.setLong(1, Long.parseLong(((String) jcmbSecurityGuard.getSelectedItem()).split(" ")[0]));
						insertStatement.setString(2, LocalDate.now().toString());
						insertStatement.setString(3, LocalTime.parse(jtxtfldWorkIn.getText(), DateTimeFormatter.ISO_TIME).toString());
						insertStatement.setString(4, LocalTime.parse(jtxtfldWorkOut.getText(), DateTimeFormatter.ISO_TIME).toString());
						insertStatement.setString(5, jtxtareaRemarks.getText());
						
						insertStatement.execute();
					} catch (DateTimeParseException e) {
						// If an error occured while parsing the datetime fields,
						// output a friendly message
						JOptionPane.showMessageDialog(thisDialog,
								"Please check your date and time inputs. It must follow ISO Time.\n"
										+ "Date must be yyyy-MM-dd, time fields (work-in, work-out) must be HH:mm:ss",
								"Check your inputs!", JOptionPane.WARNING_MESSAGE);
						throw new RuntimeException(e);
					} catch(SQLException e) {
						JOptionPane.showMessageDialog(thisDialog,
								"An error occured while trying to save attendance.\n\nMessage: " + e);
						throw new RuntimeException(e);
					}

					return null;
				}

				@Override
				protected void done() {
					try {
						get();
						
						// After the attendance object has been saved, show a friendly dialog box
						JOptionPane.showMessageDialog(thisDialog, "Successfully logged attendance.\n", "Success!",
								JOptionPane.INFORMATION_MESSAGE);
						// Refresh the management panel table model
						attendanceManagementPanel.updateTable();

						// Hide this add dialog
						thisDialog.setVisible(false);
					} catch (InterruptedException | ExecutionException e) {
						JOptionPane.showMessageDialog(thisDialog, "An error occured while saving.\n\nMessage:" + e);
					}
				}
			}.execute();
		});
		jbtnLog.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnLog);
		/* END OF jbtnLog */
	}

	/**
	 * Clears and resets the form.
	 */
	public void resetForm() {
		jcmbSecurityGuard.removeAllItems();

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pupsims_db", "pupsims",
				"pupsimspass_123");
				Statement retrieveStatement = connection.createStatement();
				ResultSet securityGuardsResultSet = retrieveStatement.executeQuery("SELECT * FROM security_guard")) {

			while (securityGuardsResultSet.next())
				jcmbSecurityGuard.addItem(securityGuardsResultSet.getInt("employee_id") + " " + securityGuardsResultSet.getString("first_name") + " " + securityGuardsResultSet.getString("last_name"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"An error occured while trying to load security guards into combobox.\n\nMessage: " + e);
		}

		jtxtfldLogDate.setText(LocalDate.now().toString());
		jtxtfldWorkIn.setText("");
		jtxtfldWorkOut.setText("");
		jtxtareaRemarks.setText("");
		jcmbStatus.setSelectedIndex(0);
	}

}
