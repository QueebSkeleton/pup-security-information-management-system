package oop.elbisri.pupsims.ui.violation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

import oop.elbisri.pupsims.domain.Violation;

/**
 * Add form dialog for logging new Violations.
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
	 * Violator Management Panel that owns this dialog box.
	 */
	protected ManagementPanel violationManagementPanel;
	
	// Form Components (Field Inputs)
	private JTextField jtxtfldCompleteName;
	private JTextField jtxtfldAddress;
	private JTextField jtxtfldContactNumber;
	private JTextField jtxtfldCompany;
	private JTextField jtxtfldViolationType;
	private JTextField jtxtfldDate;
	private JTextField jtxtfldTime;
	private JComboBox<Violation.Status> jcmbStatus;
	private JTextField jtxtfldViolatedLaw;
	private JTextArea jtxtareaDescription;
	private JTextArea jtxtareaViolatorStatement;

	/**
	 * Create the dialog.
	 */
	public AddDialog() {
		
		// For reference later
		AddDialog thisDialog = this;
		
		/* Dialog Properties */
		setMinimumSize(new Dimension(700, 600));
		setTitle("Log new Violation");
		/* END OF Dialog Properties */
		
		/* jpnlButtonActions - button actions panel */
		JPanel jpnlButtonActions = new JPanel();
		jpnlButtonActions.setBorder(new EmptyBorder(0, 0, 10, 15));
		FlowLayout flowLayout = (FlowLayout) jpnlButtonActions.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(jpnlButtonActions, BorderLayout.SOUTH);
		/* END OF jpnlButtonActions */
		
		/* jbtnCancel - cancel button to hide dialog */
		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtonActions.add(jbtnCancel);
		/* END OF jbtnCancel */
		
		/* jbtnLog - save button */
		JButton jbtnLog = new JButton("Log");
		jbtnLog.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		// Attach Action Listener (Click)
		jbtnLog.addActionListener(event -> {
			try {
				// Construct a violation domain object from the inputs
				Violation violation = new Violation(
						jtxtfldCompleteName.getText(),
						jtxtfldAddress.getText(),
						jtxtfldContactNumber.getText(),
						jtxtfldCompany.getText(),
						jtxtfldViolationType.getText(),
						LocalDateTime.parse(jtxtfldDate.getText() + "T" + jtxtfldTime.getText(),
								DateTimeFormatter.ISO_LOCAL_DATE_TIME),
						jcmbStatus.getItemAt(jcmbStatus.getSelectedIndex()),
						jtxtfldViolatedLaw.getText(),
						jtxtareaDescription.getText(),
						jtxtareaViolatorStatement.getText());
				
				// Save the constructed violation object, with a SwingWorker
				new SwingWorker<Void, Void>() {
					@Override
					protected Void doInBackground() throws Exception {
						violationManagementPanel.violationRepository.save(violation);
						return null;
					}
					@Override
					protected void done() {
						// After the violation object has been saved, show a friendly dialog box
						JOptionPane.showMessageDialog(
								thisDialog,
								"Successfully logged violation.\n",
								"Success!",
								JOptionPane.INFORMATION_MESSAGE);
						// Refresh the management panel table model
					}
				}.execute();
				
				// Hide this add dialog
				thisDialog.setVisible(false);
				
				// Reset this form
				thisDialog.resetForm();
			} catch(DateTimeParseException e) {
				// If an error occured while parsing the datetime fields,
				// output a friendly message
				JOptionPane.showMessageDialog(
						thisDialog,
						"Please check your date and time inputs. It must follow ISO Time.\n"
						+ "Date must be of format: yyyy-MM-dd,\n"
						+ "and Time must be of format: HH:mm:ss.",
						"Check your inputs!",
						JOptionPane.WARNING_MESSAGE);
			}
		});
		jpnlButtonActions.add(jbtnLog);
		/* END OF jbtnLog */

		/* jpnlForm - main form panel, uses GridBagLayout */
		JPanel jpnlForm = new JPanel();
		jpnlForm.setBorder(new EmptyBorder(20, 20, 0, 20));
		getContentPane().add(jpnlForm, BorderLayout.CENTER);
		GridBagLayout gbl_jpnlForm = new GridBagLayout();
		gbl_jpnlForm.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_jpnlForm.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_jpnlForm.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_jpnlForm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		jpnlForm.setLayout(gbl_jpnlForm);
		/* END OF jpnlForm */

		/* jlblQuickDetailsHeader - header to separate quick details section */
		JLabel jlblQuickDetailsHeader = new JLabel("Quick Details");
		jlblQuickDetailsHeader.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		GridBagConstraints gbc_jlblQuickDetailsHeader = new GridBagConstraints();
		gbc_jlblQuickDetailsHeader.anchor = GridBagConstraints.WEST;
		gbc_jlblQuickDetailsHeader.gridwidth = 4;
		gbc_jlblQuickDetailsHeader.insets = new Insets(0, 0, 15, 0);
		gbc_jlblQuickDetailsHeader.gridx = 0;
		gbc_jlblQuickDetailsHeader.gridy = 0;
		jpnlForm.add(jlblQuickDetailsHeader, gbc_jlblQuickDetailsHeader);
		/* END OF jlblQuickDetailsHeader */

		/* jlblCompleteName - label for complete name input */
		JLabel jlblCompleteName = new JLabel("Complete Name:");
		jlblCompleteName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblCompleteName = new GridBagConstraints();
		gbc_jlblCompleteName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblCompleteName.anchor = GridBagConstraints.EAST;
		gbc_jlblCompleteName.gridx = 0;
		gbc_jlblCompleteName.gridy = 1;
		jpnlForm.add(jlblCompleteName, gbc_jlblCompleteName);
		/* END OF jlblCompleteName */

		/* jtxtfldCompleteName - text field input for complete name */
		jtxtfldCompleteName = new JTextField();
		jtxtfldCompleteName.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldCompleteName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldCompleteName = new GridBagConstraints();
		gbc_jtxtfldCompleteName.insets = new Insets(0, 0, 5, 10);
		gbc_jtxtfldCompleteName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldCompleteName.gridx = 1;
		gbc_jtxtfldCompleteName.gridy = 1;
		jpnlForm.add(jtxtfldCompleteName, gbc_jtxtfldCompleteName);
		jtxtfldCompleteName.setColumns(10);
		/* END OF jtxtfldCompleteName */

		/* jlblViolationType - label for violation type input */
		JLabel jlblViolationType = new JLabel("Violation Type:");
		jlblViolationType.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblViolationType = new GridBagConstraints();
		gbc_jlblViolationType.anchor = GridBagConstraints.EAST;
		gbc_jlblViolationType.insets = new Insets(0, 0, 5, 5);
		gbc_jlblViolationType.gridx = 2;
		gbc_jlblViolationType.gridy = 1;
		jpnlForm.add(jlblViolationType, gbc_jlblViolationType);
		/* END OF jlblViolationType */

		/* jtxtfldViolationType - text field input for violation type */
		jtxtfldViolationType = new JTextField();
		jtxtfldViolationType.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldViolationType.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldViolationType.setColumns(10);
		GridBagConstraints gbc_jtxtfldViolationType = new GridBagConstraints();
		gbc_jtxtfldViolationType.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldViolationType.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldViolationType.gridx = 3;
		gbc_jtxtfldViolationType.gridy = 1;
		jpnlForm.add(jtxtfldViolationType, gbc_jtxtfldViolationType);
		/* END OF jtxtfldViolationType */

		/* jlblAddress - label for address input */
		JLabel jlblAddress = new JLabel("Address:");
		jlblAddress.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblAddress = new GridBagConstraints();
		gbc_jlblAddress.anchor = GridBagConstraints.EAST;
		gbc_jlblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_jlblAddress.gridx = 0;
		gbc_jlblAddress.gridy = 2;
		jpnlForm.add(jlblAddress, gbc_jlblAddress);
		/* END OF jlblAddress */

		/* jtxtfldAddress - text field input for addres */
		jtxtfldAddress = new JTextField();
		jtxtfldAddress.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldAddress.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldAddress.setColumns(10);
		GridBagConstraints gbc_jtxtfldAddress = new GridBagConstraints();
		gbc_jtxtfldAddress.insets = new Insets(0, 0, 5, 10);
		gbc_jtxtfldAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldAddress.gridx = 1;
		gbc_jtxtfldAddress.gridy = 2;
		jpnlForm.add(jtxtfldAddress, gbc_jtxtfldAddress);
		/* END OF jtxtfldAddress */

		/* jlblDate - label for date input */
		JLabel jlblDate = new JLabel("Date:");
		jlblDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblDate = new GridBagConstraints();
		gbc_jlblDate.anchor = GridBagConstraints.EAST;
		gbc_jlblDate.insets = new Insets(0, 0, 5, 5);
		gbc_jlblDate.gridx = 2;
		gbc_jlblDate.gridy = 2;
		jpnlForm.add(jlblDate, gbc_jlblDate);
		/* END OF jlblDate */

		/* jtxtfldDate - text field input for date */
		jtxtfldDate = new JTextField();
		jtxtfldDate.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldDate.setColumns(10);
		GridBagConstraints gbc_jtxtfldDate = new GridBagConstraints();
		gbc_jtxtfldDate.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldDate.gridx = 3;
		gbc_jtxtfldDate.gridy = 2;
		jpnlForm.add(jtxtfldDate, gbc_jtxtfldDate);
		/* END OF jtxtfldDate */

		/* jlblContactNumber - label for contact number input */
		JLabel jlblContactNumber = new JLabel("Contact #:");
		jlblContactNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblContactNumber = new GridBagConstraints();
		gbc_jlblContactNumber.anchor = GridBagConstraints.EAST;
		gbc_jlblContactNumber.insets = new Insets(0, 0, 5, 5);
		gbc_jlblContactNumber.gridx = 0;
		gbc_jlblContactNumber.gridy = 3;
		jpnlForm.add(jlblContactNumber, gbc_jlblContactNumber);
		/* END OF jlblContactNumber */

		/* jtxtfldContactNumber - text field input for contact number */
		jtxtfldContactNumber = new JTextField();
		jtxtfldContactNumber.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldContactNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldContactNumber.setColumns(10);
		GridBagConstraints gbc_jtxtfldContactNumber = new GridBagConstraints();
		gbc_jtxtfldContactNumber.insets = new Insets(0, 0, 5, 10);
		gbc_jtxtfldContactNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldContactNumber.gridx = 1;
		gbc_jtxtfldContactNumber.gridy = 3;
		jpnlForm.add(jtxtfldContactNumber, gbc_jtxtfldContactNumber);
		/* END OF jtxtfldContactNumber */

		/* jlblTime - label for time input */
		JLabel jlblTime = new JLabel("Time:");
		jlblTime.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblTime = new GridBagConstraints();
		gbc_jlblTime.anchor = GridBagConstraints.EAST;
		gbc_jlblTime.insets = new Insets(0, 0, 5, 5);
		gbc_jlblTime.gridx = 2;
		gbc_jlblTime.gridy = 3;
		jpnlForm.add(jlblTime, gbc_jlblTime);
		/* END OF jlblTime */

		/* jtxtfldTime - text field input for time */
		jtxtfldTime = new JTextField();
		jtxtfldTime.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldTime.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldTime.setColumns(10);
		GridBagConstraints gbc_jtxtfldTime = new GridBagConstraints();
		gbc_jtxtfldTime.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldTime.gridx = 3;
		gbc_jtxtfldTime.gridy = 3;
		jpnlForm.add(jtxtfldTime, gbc_jtxtfldTime);
		/* END OF jtxtfldTime */

		/* jlblCompany - label for company input */
		JLabel jlblCompany = new JLabel("Company:");
		jlblCompany.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblCompany = new GridBagConstraints();
		gbc_jlblCompany.anchor = GridBagConstraints.EAST;
		gbc_jlblCompany.insets = new Insets(0, 0, 5, 5);
		gbc_jlblCompany.gridx = 0;
		gbc_jlblCompany.gridy = 4;
		jpnlForm.add(jlblCompany, gbc_jlblCompany);
		/* END OF jlblCompany */

		/* jtxtfldCompany - text field input for company */
		jtxtfldCompany = new JTextField();
		jtxtfldCompany.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldCompany.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldCompany.setColumns(10);
		GridBagConstraints gbc_jtxtfldCompany = new GridBagConstraints();
		gbc_jtxtfldCompany.insets = new Insets(0, 0, 5, 10);
		gbc_jtxtfldCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldCompany.gridx = 1;
		gbc_jtxtfldCompany.gridy = 4;
		jpnlForm.add(jtxtfldCompany, gbc_jtxtfldCompany);
		/* END OF jtxtfldCompany */

		/* jlblStatus - label for status input */
		JLabel jlblStatus = new JLabel("Status:");
		jlblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblStatus = new GridBagConstraints();
		gbc_jlblStatus.anchor = GridBagConstraints.EAST;
		gbc_jlblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_jlblStatus.gridx = 2;
		gbc_jlblStatus.gridy = 4;
		jpnlForm.add(jlblStatus, gbc_jlblStatus);
		/* END OF jlblStatus */

		/* jcmbStatus - combo box input for status */
		jcmbStatus = new JComboBox<>();
		jcmbStatus.setModel(new DefaultComboBoxModel<>(Violation.Status.values()));
		jcmbStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jcmbStatus = new GridBagConstraints();
		gbc_jcmbStatus.insets = new Insets(0, 0, 5, 0);
		gbc_jcmbStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcmbStatus.gridx = 3;
		gbc_jcmbStatus.gridy = 4;
		jpnlForm.add(jcmbStatus, gbc_jcmbStatus);
		/* END OF jcmbStatus */

		/* jlblAboutHeader - header to separate about section */
		JLabel jlblAboutHeader = new JLabel("About the Violation");
		jlblAboutHeader.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		GridBagConstraints gbc_jlblAboutHeader = new GridBagConstraints();
		gbc_jlblAboutHeader.anchor = GridBagConstraints.WEST;
		gbc_jlblAboutHeader.gridwidth = 4;
		gbc_jlblAboutHeader.insets = new Insets(15, 0, 15, 0);
		gbc_jlblAboutHeader.gridx = 0;
		gbc_jlblAboutHeader.gridy = 5;
		jpnlForm.add(jlblAboutHeader, gbc_jlblAboutHeader);
		/* END OF jlblAboutHeader */

		/* jlblViolatedLaw - label for violated law input */
		JLabel jlblViolatedLaw = new JLabel("Violated Law:");
		jlblViolatedLaw.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblViolatedLaw = new GridBagConstraints();
		gbc_jlblViolatedLaw.anchor = GridBagConstraints.EAST;
		gbc_jlblViolatedLaw.insets = new Insets(0, 0, 5, 5);
		gbc_jlblViolatedLaw.gridx = 0;
		gbc_jlblViolatedLaw.gridy = 6;
		jpnlForm.add(jlblViolatedLaw, gbc_jlblViolatedLaw);
		/* END OF jlblViolatedLaw */

		/* jtxtfldViolatedLaw - text field input for violated law */
		jtxtfldViolatedLaw = new JTextField();
		jtxtfldViolatedLaw.setMargin(new Insets(4, 4, 4, 4));
		jtxtfldViolatedLaw.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldViolatedLaw.setColumns(10);
		GridBagConstraints gbc_jtxtfldViolatedLaw = new GridBagConstraints();
		gbc_jtxtfldViolatedLaw.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldViolatedLaw.gridwidth = 3;
		gbc_jtxtfldViolatedLaw.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldViolatedLaw.gridx = 1;
		gbc_jtxtfldViolatedLaw.gridy = 6;
		jpnlForm.add(jtxtfldViolatedLaw, gbc_jtxtfldViolatedLaw);
		/* END OF jtxtfldViolatedLaw */

		/* jlblDescription - label for description input */
		JLabel jlblDescription = new JLabel("Description:");
		jlblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblDescription = new GridBagConstraints();
		gbc_jlblDescription.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_jlblDescription.gridx = 0;
		gbc_jlblDescription.gridy = 7;
		jpnlForm.add(jlblDescription, gbc_jlblDescription);
		/* END OF jlblDescription */

		/* jscrlpnDescription - scrollable container for description input */
		JScrollPane jscrlpnDescription = new JScrollPane();
		GridBagConstraints gbc_jscrlpnDescription = new GridBagConstraints();
		gbc_jscrlpnDescription.gridwidth = 3;
		gbc_jscrlpnDescription.insets = new Insets(0, 0, 5, 0);
		gbc_jscrlpnDescription.fill = GridBagConstraints.BOTH;
		gbc_jscrlpnDescription.gridx = 1;
		gbc_jscrlpnDescription.gridy = 7;
		jpnlForm.add(jscrlpnDescription, gbc_jscrlpnDescription);
		/* END OF jscrlpnDescription */

		/* jtxtareaDescription - text area input for description */
		jtxtareaDescription = new JTextArea();
		jtxtareaDescription.setMargin(new Insets(4, 4, 4, 4));
		jscrlpnDescription.setViewportView(jtxtareaDescription);
		/* END OF jtxtareaDescription */

		/* jlblViolatorStatement - label for violator statement input */
		JLabel jlblViolatorStatement = new JLabel("<html>Violator's<br>Statement:</html>");
		jlblViolatorStatement.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblViolatorStatement = new GridBagConstraints();
		gbc_jlblViolatorStatement.anchor = GridBagConstraints.NORTHEAST;
		gbc_jlblViolatorStatement.insets = new Insets(0, 0, 0, 5);
		gbc_jlblViolatorStatement.gridx = 0;
		gbc_jlblViolatorStatement.gridy = 8;
		jpnlForm.add(jlblViolatorStatement, gbc_jlblViolatorStatement);
		/* END OF jlblViolatorStatement */

		/* jscrlpnViolatorStatement - scrollable container for statement input */
		JScrollPane jscrlpnViolatorStatement = new JScrollPane();
		GridBagConstraints gbc_jscrlpnViolatorStatement = new GridBagConstraints();
		gbc_jscrlpnViolatorStatement.gridwidth = 3;
		gbc_jscrlpnViolatorStatement.fill = GridBagConstraints.BOTH;
		gbc_jscrlpnViolatorStatement.gridx = 1;
		gbc_jscrlpnViolatorStatement.gridy = 8;
		jpnlForm.add(jscrlpnViolatorStatement, gbc_jscrlpnViolatorStatement);
		/* END OF jscrlpnViolatorStatement */

		/* jtxtareaViolatorStatement - text area input for violator statement */
		jtxtareaViolatorStatement = new JTextArea();
		jtxtareaViolatorStatement.setMargin(new Insets(4, 4, 4, 4));
		jtxtareaViolatorStatement.setAlignmentY(0.0f);
		jtxtareaViolatorStatement.setAlignmentX(0.0f);
		jscrlpnViolatorStatement.setViewportView(jtxtareaViolatorStatement);
		/* END OF jtxtareaViolatorStatement */
	}
	
	/**
	 * Clears and resets the form.
	 */
	public void resetForm() {
		jtxtfldCompleteName.setText("");
		jtxtfldAddress.setText("");
		jtxtfldContactNumber.setText("");
		jtxtfldCompany.setText("");
		jtxtfldViolationType.setText("");
		jtxtfldDate.setText("");
		jtxtfldTime.setText("");
		jcmbStatus.setSelectedIndex(0);
		jtxtfldViolatedLaw.setText("");
		jtxtareaDescription.setText("");
		jtxtareaViolatorStatement.setText("");
	}

}
