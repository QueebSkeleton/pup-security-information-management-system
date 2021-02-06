package oop.elbisri.pupsims.ui.inventoryofsupplies;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddSuppliesDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField jtxtfldProductCode;
	private JTextField jtxtfldItemName;
	private JTextField jtxtfldQuantity;
	private JTextField jtxtfldPrice;

	/**
	 * Create the dialog.
	 */
	public AddSuppliesDialog() {
		setTitle("New Supplies");
		setBounds(100, 100, 429, 321);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel jlblProductCode = new JLabel("Product Code:");
			GridBagConstraints gbc_jlblProductCode = new GridBagConstraints();
			gbc_jlblProductCode.insets = new Insets(0, 0, 5, 5);
			gbc_jlblProductCode.anchor = GridBagConstraints.EAST;
			gbc_jlblProductCode.gridx = 0;
			gbc_jlblProductCode.gridy = 0;
			contentPanel.add(jlblProductCode, gbc_jlblProductCode);
		}
		{
			jtxtfldProductCode = new JTextField();
			GridBagConstraints gbc_jtxtfldProductCode = new GridBagConstraints();
			gbc_jtxtfldProductCode.insets = new Insets(0, 0, 5, 0);
			gbc_jtxtfldProductCode.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldProductCode.gridx = 1;
			gbc_jtxtfldProductCode.gridy = 0;
			contentPanel.add(jtxtfldProductCode, gbc_jtxtfldProductCode);
			jtxtfldProductCode.setColumns(10);
		}
		{
			JLabel jlblItemName = new JLabel("Item Name:");
			GridBagConstraints gbc_jlblItemName = new GridBagConstraints();
			gbc_jlblItemName.anchor = GridBagConstraints.EAST;
			gbc_jlblItemName.insets = new Insets(0, 0, 5, 5);
			gbc_jlblItemName.gridx = 0;
			gbc_jlblItemName.gridy = 1;
			contentPanel.add(jlblItemName, gbc_jlblItemName);
		}
		{
			jtxtfldItemName = new JTextField();
			GridBagConstraints gbc_jtxtfldItemName = new GridBagConstraints();
			gbc_jtxtfldItemName.insets = new Insets(0, 0, 5, 0);
			gbc_jtxtfldItemName.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldItemName.gridx = 1;
			gbc_jtxtfldItemName.gridy = 1;
			contentPanel.add(jtxtfldItemName, gbc_jtxtfldItemName);
			jtxtfldItemName.setColumns(10);
		}
		{
			JLabel jlblItemType = new JLabel("Item Type:");
			GridBagConstraints gbc_jlblItemType = new GridBagConstraints();
			gbc_jlblItemType.anchor = GridBagConstraints.EAST;
			gbc_jlblItemType.insets = new Insets(0, 0, 5, 5);
			gbc_jlblItemType.gridx = 0;
			gbc_jlblItemType.gridy = 2;
			contentPanel.add(jlblItemType, gbc_jlblItemType);
		}
		{
			JList jlstItemType = new JList();
			jlstItemType.setModel(new AbstractListModel() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				String[] values = new String[] {"Stationery", "Consumables ", "Others"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			GridBagConstraints gbc_jlstItemType = new GridBagConstraints();
			gbc_jlstItemType.insets = new Insets(0, 0, 5, 0);
			gbc_jlstItemType.fill = GridBagConstraints.HORIZONTAL;
			gbc_jlstItemType.gridx = 1;
			gbc_jlstItemType.gridy = 2;
			contentPanel.add(jlstItemType, gbc_jlstItemType);
		}
		{
			JLabel jlblQuantity = new JLabel("Quantity:");
			GridBagConstraints gbc_jlblQuantity = new GridBagConstraints();
			gbc_jlblQuantity.anchor = GridBagConstraints.EAST;
			gbc_jlblQuantity.insets = new Insets(0, 0, 5, 5);
			gbc_jlblQuantity.gridx = 0;
			gbc_jlblQuantity.gridy = 3;
			contentPanel.add(jlblQuantity, gbc_jlblQuantity);
		}
		{
			jtxtfldQuantity = new JTextField();
			GridBagConstraints gbc_jtxtfldQuantity = new GridBagConstraints();
			gbc_jtxtfldQuantity.insets = new Insets(0, 0, 5, 0);
			gbc_jtxtfldQuantity.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldQuantity.gridx = 1;
			gbc_jtxtfldQuantity.gridy = 3;
			contentPanel.add(jtxtfldQuantity, gbc_jtxtfldQuantity);
			jtxtfldQuantity.setColumns(10);
		}
		{
			JLabel jlblCondition = new JLabel("Item Condition:");
			GridBagConstraints gbc_jlblCondition = new GridBagConstraints();
			gbc_jlblCondition.insets = new Insets(0, 0, 5, 5);
			gbc_jlblCondition.gridx = 0;
			gbc_jlblCondition.gridy = 4;
			contentPanel.add(jlblCondition, gbc_jlblCondition);
		}
		{
			JList jlstCondition = new JList();
			jlstCondition.setModel(new AbstractListModel() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				String[] values = new String[] {"Good Condition", "Bad Condition", "Needs Attention", "OUT OF STOCK"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			GridBagConstraints gbc_jlstCondition = new GridBagConstraints();
			gbc_jlstCondition.insets = new Insets(0, 0, 5, 0);
			gbc_jlstCondition.fill = GridBagConstraints.HORIZONTAL;
			gbc_jlstCondition.gridx = 1;
			gbc_jlstCondition.gridy = 4;
			contentPanel.add(jlstCondition, gbc_jlstCondition);
		}
		{
			JLabel jlblPrice = new JLabel("Price:");
			GridBagConstraints gbc_jlblPrice = new GridBagConstraints();
			gbc_jlblPrice.anchor = GridBagConstraints.EAST;
			gbc_jlblPrice.insets = new Insets(0, 0, 0, 5);
			gbc_jlblPrice.gridx = 0;
			gbc_jlblPrice.gridy = 5;
			contentPanel.add(jlblPrice, gbc_jlblPrice);
		}
		{
			jtxtfldPrice = new JTextField();
			GridBagConstraints gbc_jtxtfldPrice = new GridBagConstraints();
			gbc_jtxtfldPrice.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtxtfldPrice.gridx = 1;
			gbc_jtxtfldPrice.gridy = 5;
			contentPanel.add(jtxtfldPrice, gbc_jtxtfldPrice);
			jtxtfldPrice.setColumns(10);
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
