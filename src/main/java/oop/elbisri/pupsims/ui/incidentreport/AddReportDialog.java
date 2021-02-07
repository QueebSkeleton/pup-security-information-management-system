package oop.elbisri.pupsims.ui.incidentreport;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class AddReportDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField jtxtfldIncidentID;
	private JTextField jtxtfldTime;
	private JTextField jtxtfldInjuredPersonName;
	private JTextField jtxtfldInjuredPersonAge;
	private JTextField jtxtfldInjuredPersonMedicalNotes;

	/**
	 * Create the dialog.
	 */
	public AddReportDialog() {
		setTitle("New Incident");
		setBounds(100, 100, 530, 530);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JPanel jpnlIncidentDetails = new JPanel();
			jpnlIncidentDetails.setBorder(new EmptyBorder(10, 5, 0, 10));
			jpnlIncidentDetails.setMaximumSize(new Dimension(32767, 250));
			contentPanel.add(jpnlIncidentDetails);
			GridBagLayout gbl_jpnlIncidentDetails = new GridBagLayout();
			gbl_jpnlIncidentDetails.columnWidths = new int[]{0, 0, 0};
			gbl_jpnlIncidentDetails.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_jpnlIncidentDetails.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_jpnlIncidentDetails.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			jpnlIncidentDetails.setLayout(gbl_jpnlIncidentDetails);
			{
				JLabel jlblIncidentID = new JLabel("Incident ID:");
				GridBagConstraints gbc_jlblIncidentID = new GridBagConstraints();
				gbc_jlblIncidentID.anchor = GridBagConstraints.EAST;
				gbc_jlblIncidentID.insets = new Insets(0, 0, 5, 5);
				gbc_jlblIncidentID.gridx = 0;
				gbc_jlblIncidentID.gridy = 0;
				jpnlIncidentDetails.add(jlblIncidentID, gbc_jlblIncidentID);
			}
			{
				jtxtfldIncidentID = new JTextField();
				GridBagConstraints gbc_jtxtfldIncidentID = new GridBagConstraints();
				gbc_jtxtfldIncidentID.insets = new Insets(0, 0, 5, 0);
				gbc_jtxtfldIncidentID.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtxtfldIncidentID.gridx = 1;
				gbc_jtxtfldIncidentID.gridy = 0;
				jpnlIncidentDetails.add(jtxtfldIncidentID, gbc_jtxtfldIncidentID);
				jtxtfldIncidentID.setColumns(10);
			}
			{
				JLabel jlblDate = new JLabel("Date:");
				GridBagConstraints gbc_jlblDate = new GridBagConstraints();
				gbc_jlblDate.anchor = GridBagConstraints.EAST;
				gbc_jlblDate.insets = new Insets(0, 0, 5, 5);
				gbc_jlblDate.gridx = 0;
				gbc_jlblDate.gridy = 1;
				jpnlIncidentDetails.add(jlblDate, gbc_jlblDate);
			}
			
			/*
			 * TO DO: A selection Pane where user can choose date from predefined choices (Month/Day/Year) 
			 */
			{
				JLabel jlblTime = new JLabel("Time:");
				GridBagConstraints gbc_jlblTime = new GridBagConstraints();
				gbc_jlblTime.anchor = GridBagConstraints.EAST;
				gbc_jlblTime.insets = new Insets(0, 0, 5, 5);
				gbc_jlblTime.gridx = 0;
				gbc_jlblTime.gridy = 2;
				jpnlIncidentDetails.add(jlblTime, gbc_jlblTime);
			}
			{
				jtxtfldTime = new JTextField();
				GridBagConstraints gbc_jtxtfldTime = new GridBagConstraints();
				gbc_jtxtfldTime.insets = new Insets(0, 0, 5, 0);
				gbc_jtxtfldTime.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtxtfldTime.gridx = 1;
				gbc_jtxtfldTime.gridy = 2;
				jpnlIncidentDetails.add(jtxtfldTime, gbc_jtxtfldTime);
				jtxtfldTime.setColumns(10);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
				gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
				gbc_verticalStrut.gridx = 0;
				gbc_verticalStrut.gridy = 3;
				jpnlIncidentDetails.add(verticalStrut, gbc_verticalStrut);
			}
			{
				JLabel jlblInjuredPersonDetails = new JLabel("Injured Person");
				GridBagConstraints gbc_jlblInjuredPersonDetails = new GridBagConstraints();
				gbc_jlblInjuredPersonDetails.anchor = GridBagConstraints.WEST;
				gbc_jlblInjuredPersonDetails.insets = new Insets(0, 0, 5, 5);
				gbc_jlblInjuredPersonDetails.gridx = 0;
				gbc_jlblInjuredPersonDetails.gridy = 4;
				jpnlIncidentDetails.add(jlblInjuredPersonDetails, gbc_jlblInjuredPersonDetails);
			}
			{
				JLabel jlblInjuredPersonName = new JLabel("Name:");
				GridBagConstraints gbc_jlblInjuredPersonName = new GridBagConstraints();
				gbc_jlblInjuredPersonName.anchor = GridBagConstraints.EAST;
				gbc_jlblInjuredPersonName.insets = new Insets(0, 0, 5, 5);
				gbc_jlblInjuredPersonName.gridx = 0;
				gbc_jlblInjuredPersonName.gridy = 5;
				jpnlIncidentDetails.add(jlblInjuredPersonName, gbc_jlblInjuredPersonName);
			}
			{
				jtxtfldInjuredPersonName = new JTextField();
				GridBagConstraints gbc_jtxtfldInjuredPersonName = new GridBagConstraints();
				gbc_jtxtfldInjuredPersonName.insets = new Insets(0, 0, 5, 0);
				gbc_jtxtfldInjuredPersonName.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtxtfldInjuredPersonName.gridx = 1;
				gbc_jtxtfldInjuredPersonName.gridy = 5;
				jpnlIncidentDetails.add(jtxtfldInjuredPersonName, gbc_jtxtfldInjuredPersonName);
				jtxtfldInjuredPersonName.setColumns(10);
			}
			{
				JLabel jlblInjuredPersonAge = new JLabel("Age:");
				GridBagConstraints gbc_jlblInjuredPersonAge = new GridBagConstraints();
				gbc_jlblInjuredPersonAge.anchor = GridBagConstraints.EAST;
				gbc_jlblInjuredPersonAge.insets = new Insets(0, 0, 5, 5);
				gbc_jlblInjuredPersonAge.gridx = 0;
				gbc_jlblInjuredPersonAge.gridy = 6;
				jpnlIncidentDetails.add(jlblInjuredPersonAge, gbc_jlblInjuredPersonAge);
			}
			{
				jtxtfldInjuredPersonAge = new JTextField();
				GridBagConstraints gbc_jtxtfldInjuredPersonAge = new GridBagConstraints();
				gbc_jtxtfldInjuredPersonAge.insets = new Insets(0, 0, 5, 0);
				gbc_jtxtfldInjuredPersonAge.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtxtfldInjuredPersonAge.gridx = 1;
				gbc_jtxtfldInjuredPersonAge.gridy = 6;
				jpnlIncidentDetails.add(jtxtfldInjuredPersonAge, gbc_jtxtfldInjuredPersonAge);
				jtxtfldInjuredPersonAge.setColumns(10);
			}
			{
				JLabel jlblInjuredPersonMedicalNotes = new JLabel("Medical Note/s:");
				GridBagConstraints gbc_jlblInjuredPersonMedicalNotes = new GridBagConstraints();
				gbc_jlblInjuredPersonMedicalNotes.anchor = GridBagConstraints.EAST;
				gbc_jlblInjuredPersonMedicalNotes.insets = new Insets(0, 0, 5, 5);
				gbc_jlblInjuredPersonMedicalNotes.gridx = 0;
				gbc_jlblInjuredPersonMedicalNotes.gridy = 7;
				jpnlIncidentDetails.add(jlblInjuredPersonMedicalNotes, gbc_jlblInjuredPersonMedicalNotes);
			}
			{
				jtxtfldInjuredPersonMedicalNotes = new JTextField();
				GridBagConstraints gbc_jtxtfldInjuredPersonMedicalNotes = new GridBagConstraints();
				gbc_jtxtfldInjuredPersonMedicalNotes.gridheight = 2;
				gbc_jtxtfldInjuredPersonMedicalNotes.insets = new Insets(0, 0, 5, 0);
				gbc_jtxtfldInjuredPersonMedicalNotes.fill = GridBagConstraints.BOTH;
				gbc_jtxtfldInjuredPersonMedicalNotes.gridx = 1;
				gbc_jtxtfldInjuredPersonMedicalNotes.gridy = 7;
				jpnlIncidentDetails.add(jtxtfldInjuredPersonMedicalNotes, gbc_jtxtfldInjuredPersonMedicalNotes);
				jtxtfldInjuredPersonMedicalNotes.setColumns(10);
			}
			{
				Component verticalStrut = Box.createVerticalStrut(20);
				GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
				gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
				gbc_verticalStrut.gridx = 0;
				gbc_verticalStrut.gridy = 8;
				jpnlIncidentDetails.add(verticalStrut, gbc_verticalStrut);
			}
			{
				JLabel jlblDescriptiveDetails = new JLabel("Descriptive Details: ");
				GridBagConstraints gbc_jlblDescriptiveDetails = new GridBagConstraints();
				gbc_jlblDescriptiveDetails.insets = new Insets(0, 0, 0, 5);
				gbc_jlblDescriptiveDetails.gridx = 0;
				gbc_jlblDescriptiveDetails.gridy = 9;
				jpnlIncidentDetails.add(jlblDescriptiveDetails, gbc_jlblDescriptiveDetails);
			}
		}
		{
			JPanel jpnlDescriptiveDetails = new JPanel();
			jpnlDescriptiveDetails.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			jpnlDescriptiveDetails.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			jpnlDescriptiveDetails.setMaximumSize(new Dimension(32767, 500));
			contentPanel.add(jpnlDescriptiveDetails);
			jpnlDescriptiveDetails.setLayout(null);
			{
				JTextArea jtxtarDescriptiveDetails = new JTextArea();
				jtxtarDescriptiveDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
				jtxtarDescriptiveDetails.setLineWrap(true);
				jtxtarDescriptiveDetails.setWrapStyleWord(true);
				jtxtarDescriptiveDetails.setBounds(10, 11, 484, 189);
				jpnlDescriptiveDetails.add(jtxtarDescriptiveDetails);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
