package oop.elbisri.pupsims.ui.securityguard;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddDialog extends JDialog {
	
	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField jtxtfldFirstName;
	private JTextField jtxtfldMiddleName;
	private JTextField jtxtfldLastName;
	private JTextField jtxtfldEmployeeID;
	private JTextField jtxtfldSSSID;
	private JTextField jtxtfldTINNumber;

	/**
	 * Create the dialog.
	 */
	public AddDialog() {
		setTitle("New Employee Details");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel jlblEmployeeID = new JLabel("Employee ID:");
			GridBagConstraints gbc_jlblEmployeeID = new GridBagConstraints();
			gbc_jlblEmployeeID.anchor = GridBagConstraints.EAST;
			gbc_jlblEmployeeID.insets = new Insets(0, 0, 5, 5);
			gbc_jlblEmployeeID.gridx = 0;
			gbc_jlblEmployeeID.gridy = 0;
			contentPanel.add(jlblEmployeeID, gbc_jlblEmployeeID);
		}
		{
			jtxtfldEmployeeID = new JTextField();
			GridBagConstraints gbc_jtxtfldEmployeeID = new GridBagConstraints();
			gbc_jtxtfldEmployeeID.insets = new Insets(0, 0, 5, 0);
			gbc_jtxtfldEmployeeID.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldEmployeeID.gridx = 1;
			gbc_jtxtfldEmployeeID.gridy = 0;
			contentPanel.add(jtxtfldEmployeeID, gbc_jtxtfldEmployeeID);
			jtxtfldEmployeeID.setColumns(10);
		}
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_verticalStrut.gridx = 0;
			gbc_verticalStrut.gridy = 1;
			contentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			JLabel jlblFirstName = new JLabel("First Name:");
			GridBagConstraints gbc_jlblFirstName = new GridBagConstraints();
			gbc_jlblFirstName.insets = new Insets(0, 0, 5, 5);
			gbc_jlblFirstName.anchor = GridBagConstraints.EAST;
			gbc_jlblFirstName.gridx = 0;
			gbc_jlblFirstName.gridy = 2;
			contentPanel.add(jlblFirstName, gbc_jlblFirstName);
		}
		{
			jtxtfldFirstName = new JTextField();
			GridBagConstraints gbc_jtxtfldFirstName = new GridBagConstraints();
			gbc_jtxtfldFirstName.anchor = GridBagConstraints.NORTH;
			gbc_jtxtfldFirstName.insets = new Insets(0, 0, 5, 0);
			gbc_jtxtfldFirstName.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldFirstName.gridx = 1;
			gbc_jtxtfldFirstName.gridy = 2;
			contentPanel.add(jtxtfldFirstName, gbc_jtxtfldFirstName);
			jtxtfldFirstName.setColumns(10);
		}
		{
			JLabel jlblMiddleName = new JLabel("Middle Name:");
			GridBagConstraints gbc_jlblMiddleName = new GridBagConstraints();
			gbc_jlblMiddleName.anchor = GridBagConstraints.EAST;
			gbc_jlblMiddleName.insets = new Insets(0, 0, 5, 5);
			gbc_jlblMiddleName.gridx = 0;
			gbc_jlblMiddleName.gridy = 3;
			contentPanel.add(jlblMiddleName, gbc_jlblMiddleName);
		}
		{
			jtxtfldMiddleName = new JTextField();
			GridBagConstraints gbc_jtxtfldMiddleName = new GridBagConstraints();
			gbc_jtxtfldMiddleName.insets = new Insets(0, 0, 5, 0);
			gbc_jtxtfldMiddleName.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldMiddleName.gridx = 1;
			gbc_jtxtfldMiddleName.gridy = 3;
			contentPanel.add(jtxtfldMiddleName, gbc_jtxtfldMiddleName);
			jtxtfldMiddleName.setColumns(10);
		}
		{
			JLabel jlblLastName = new JLabel("Last Name:");
			GridBagConstraints gbc_jlblLastName = new GridBagConstraints();
			gbc_jlblLastName.anchor = GridBagConstraints.EAST;
			gbc_jlblLastName.insets = new Insets(0, 0, 5, 5);
			gbc_jlblLastName.gridx = 0;
			gbc_jlblLastName.gridy = 4;
			contentPanel.add(jlblLastName, gbc_jlblLastName);
		}
		{
			jtxtfldLastName = new JTextField();
			GridBagConstraints gbc_jtxtfldLastName = new GridBagConstraints();
			gbc_jtxtfldLastName.insets = new Insets(0, 0, 5, 0);
			gbc_jtxtfldLastName.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldLastName.gridx = 1;
			gbc_jtxtfldLastName.gridy = 4;
			contentPanel.add(jtxtfldLastName, gbc_jtxtfldLastName);
			jtxtfldLastName.setColumns(10);
		}
		{
			JLabel jlblSex = new JLabel("Sex:");
			GridBagConstraints gbc_jlblSex = new GridBagConstraints();
			gbc_jlblSex.anchor = GridBagConstraints.EAST;
			gbc_jlblSex.insets = new Insets(0, 0, 5, 5);
			gbc_jlblSex.gridx = 0;
			gbc_jlblSex.gridy = 5;
			contentPanel.add(jlblSex, gbc_jlblSex);
		}
		{
			JPanel jpnlSex = new JPanel();
			GridBagConstraints gbc_jpnlSex = new GridBagConstraints();
			gbc_jpnlSex.insets = new Insets(0, 0, 5, 0);
			gbc_jpnlSex.fill = GridBagConstraints.BOTH;
			gbc_jpnlSex.gridx = 1;
			gbc_jpnlSex.gridy = 5;
			contentPanel.add(jpnlSex, gbc_jpnlSex);
			{
				JRadioButton jrdbtnFemale = new JRadioButton("Female");
				jpnlSex.add(jrdbtnFemale);
			}
			{
				JRadioButton jrdbtnMale = new JRadioButton("Male");
				jpnlSex.add(jrdbtnMale);
			}
		}
		{
			JLabel jlblSSSID = new JLabel("SSS ID:");
			GridBagConstraints gbc_jlblSSSID = new GridBagConstraints();
			gbc_jlblSSSID.anchor = GridBagConstraints.EAST;
			gbc_jlblSSSID.insets = new Insets(0, 0, 5, 5);
			gbc_jlblSSSID.gridx = 0;
			gbc_jlblSSSID.gridy = 6;
			contentPanel.add(jlblSSSID, gbc_jlblSSSID);
		}
		{
			jtxtfldSSSID = new JTextField();
			GridBagConstraints gbc_jtxtfldSSSID = new GridBagConstraints();
			gbc_jtxtfldSSSID.insets = new Insets(0, 0, 5, 0);
			gbc_jtxtfldSSSID.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldSSSID.gridx = 1;
			gbc_jtxtfldSSSID.gridy = 6;
			contentPanel.add(jtxtfldSSSID, gbc_jtxtfldSSSID);
			jtxtfldSSSID.setColumns(10);
		}
		{
			JLabel jlblTINNumber = new JLabel("TIN #:");
			GridBagConstraints gbc_jlblTINNumber = new GridBagConstraints();
			gbc_jlblTINNumber.anchor = GridBagConstraints.EAST;
			gbc_jlblTINNumber.insets = new Insets(0, 0, 0, 5);
			gbc_jlblTINNumber.gridx = 0;
			gbc_jlblTINNumber.gridy = 7;
			contentPanel.add(jlblTINNumber, gbc_jlblTINNumber);
		}
		{
			jtxtfldTINNumber = new JTextField();
			GridBagConstraints gbc_jtxtfldTINNumber = new GridBagConstraints();
			gbc_jtxtfldTINNumber.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldTINNumber.gridx = 1;
			gbc_jtxtfldTINNumber.gridy = 7;
			contentPanel.add(jtxtfldTINNumber, gbc_jtxtfldTINNumber);
			jtxtfldTINNumber.setColumns(10);
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
