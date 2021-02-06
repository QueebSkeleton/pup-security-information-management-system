package oop.elbisri.pupsims.ui.securityguard;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Dimension;

public class ViewDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ViewDialog() {
		setResizable(false);
		setTitle("Employee Details");
		setBounds(100, 100, 519, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 15, 5, 15));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			/*
			 * A header panel that contains the employee full name and employee ID number
			 * made for aesthetic purposes and easy readability for users
			 */
			JPanel jpnlNameHeader = new JPanel();
			jpnlNameHeader.setMaximumSize(new Dimension(32767, 100));
			contentPanel.add(jpnlNameHeader);
			jpnlNameHeader.setLayout(null);
			
			JLabel jlblFullName = new JLabel("Elmer M. Cuenca");
			jlblFullName.setFont(new Font("Tahoma", Font.BOLD, 25));
			jlblFullName.setBounds(0, 32, 250, 31);
			jpnlNameHeader.add(jlblFullName);
			
			JLabel jlblEmployeeID = new JLabel("Employee ID: ");
			jlblEmployeeID.setBounds(0, 61, 67, 14);
			jpnlNameHeader.add(jlblEmployeeID);
			{
				JLabel jlblEmployeeID_Output = new JLabel("2021-1234567890");
				jlblEmployeeID_Output.setBounds(70, 61, 134, 14);
				jpnlNameHeader.add(jlblEmployeeID_Output);
			}
		}
		{
			/*
			 * A panel dedicated to other details from one employee selected by user
			 */
			JPanel jpnlOtherDetails = new JPanel();
			jpnlOtherDetails.setBorder(new EmptyBorder(6, 0, 0, 0));
			jpnlOtherDetails.setMaximumSize(new Dimension(32767, 150));
			contentPanel.add(jpnlOtherDetails);
			GridBagLayout gbl_jpnlOtherDetails = new GridBagLayout();
			gbl_jpnlOtherDetails.columnWidths = new int[]{0, 0, 0};
			gbl_jpnlOtherDetails.rowHeights = new int[]{30, 0, 0, 0, 0, 0};
			gbl_jpnlOtherDetails.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_jpnlOtherDetails.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			jpnlOtherDetails.setLayout(gbl_jpnlOtherDetails);
			{
				JLabel jlblAddress = new JLabel("Address: ");
				jlblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
				GridBagConstraints gbc_jlblAddress = new GridBagConstraints();
				gbc_jlblAddress.anchor = GridBagConstraints.EAST;
				gbc_jlblAddress.insets = new Insets(0, 0, 5, 5);
				gbc_jlblAddress.gridx = 0;
				gbc_jlblAddress.gridy = 0;
				jpnlOtherDetails.add(jlblAddress, gbc_jlblAddress);
			}
			{
				JLabel jlblAddress_Output = new JLabel("157-S 19th Avenue (West Side), East Rembo, 1216  Makati City ");
				GridBagConstraints gbc_jlblAddress_Output = new GridBagConstraints();
				gbc_jlblAddress_Output.anchor = GridBagConstraints.WEST;
				gbc_jlblAddress_Output.fill = GridBagConstraints.VERTICAL;
				gbc_jlblAddress_Output.insets = new Insets(0, 0, 5, 0);
				gbc_jlblAddress_Output.gridx = 1;
				gbc_jlblAddress_Output.gridy = 0;
				jpnlOtherDetails.add(jlblAddress_Output, gbc_jlblAddress_Output);
			}
			{
				JLabel jlblSex = new JLabel("Sex:");
				jlblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
				GridBagConstraints gbc_jlblSex = new GridBagConstraints();
				gbc_jlblSex.insets = new Insets(0, 0, 5, 5);
				gbc_jlblSex.anchor = GridBagConstraints.EAST;
				gbc_jlblSex.gridx = 0;
				gbc_jlblSex.gridy = 1;
				jpnlOtherDetails.add(jlblSex, gbc_jlblSex);
			}
			{
				JLabel jlblSex_Output = new JLabel("Male\r\n");
				GridBagConstraints gbc_jlblSex_Output = new GridBagConstraints();
				gbc_jlblSex_Output.anchor = GridBagConstraints.WEST;
				gbc_jlblSex_Output.insets = new Insets(0, 0, 5, 0);
				gbc_jlblSex_Output.gridx = 1;
				gbc_jlblSex_Output.gridy = 1;
				jpnlOtherDetails.add(jlblSex_Output, gbc_jlblSex_Output);
			}
			{
				JLabel jlblContactNumber = new JLabel("Contact Number:");
				jlblContactNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
				jlblContactNumber.setHorizontalAlignment(SwingConstants.TRAILING);
				GridBagConstraints gbc_jlblContactNumber = new GridBagConstraints();
				gbc_jlblContactNumber.anchor = GridBagConstraints.EAST;
				gbc_jlblContactNumber.insets = new Insets(0, 0, 5, 5);
				gbc_jlblContactNumber.gridx = 0;
				gbc_jlblContactNumber.gridy = 2;
				jpnlOtherDetails.add(jlblContactNumber, gbc_jlblContactNumber);
			}
			{
				JLabel jlblContactNumber_Output = new JLabel("092123640457");
				GridBagConstraints gbc_jlblContactNumber_Output = new GridBagConstraints();
				gbc_jlblContactNumber_Output.anchor = GridBagConstraints.WEST;
				gbc_jlblContactNumber_Output.insets = new Insets(0, 0, 5, 0);
				gbc_jlblContactNumber_Output.gridx = 1;
				gbc_jlblContactNumber_Output.gridy = 2;
				jpnlOtherDetails.add(jlblContactNumber_Output, gbc_jlblContactNumber_Output);
			}
			{
				JLabel jlblSSSID = new JLabel("SSS ID:");
				jlblSSSID.setFont(new Font("Tahoma", Font.BOLD, 11));
				GridBagConstraints gbc_jlblSSSID = new GridBagConstraints();
				gbc_jlblSSSID.anchor = GridBagConstraints.EAST;
				gbc_jlblSSSID.insets = new Insets(0, 0, 5, 5);
				gbc_jlblSSSID.gridx = 0;
				gbc_jlblSSSID.gridy = 3;
				jpnlOtherDetails.add(jlblSSSID, gbc_jlblSSSID);
			}
			{
				JLabel jlblSSSID_Output = new JLabel("222-555-77711");
				GridBagConstraints gbc_jlblSSSID_Output = new GridBagConstraints();
				gbc_jlblSSSID_Output.anchor = GridBagConstraints.WEST;
				gbc_jlblSSSID_Output.insets = new Insets(0, 0, 5, 0);
				gbc_jlblSSSID_Output.gridx = 1;
				gbc_jlblSSSID_Output.gridy = 3;
				jpnlOtherDetails.add(jlblSSSID_Output, gbc_jlblSSSID_Output);
			}
			{
				JLabel jlblTINNumber = new JLabel("TIN #: ");
				jlblTINNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
				GridBagConstraints gbc_jlblTINNumber = new GridBagConstraints();
				gbc_jlblTINNumber.anchor = GridBagConstraints.EAST;
				gbc_jlblTINNumber.insets = new Insets(0, 0, 0, 5);
				gbc_jlblTINNumber.gridx = 0;
				gbc_jlblTINNumber.gridy = 4;
				jpnlOtherDetails.add(jlblTINNumber, gbc_jlblTINNumber);
			}
			{
				JLabel jlblTINNumber_Output = new JLabel("2222-1112333-2");
				GridBagConstraints gbc_jlblTINNumber_Output = new GridBagConstraints();
				gbc_jlblTINNumber_Output.anchor = GridBagConstraints.WEST;
				gbc_jlblTINNumber_Output.gridx = 1;
				gbc_jlblTINNumber_Output.gridy = 4;
				jpnlOtherDetails.add(jlblTINNumber_Output, gbc_jlblTINNumber_Output);
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
		}
	}
}
