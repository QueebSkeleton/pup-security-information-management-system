package oop.elbisri.pupsims.ui.inventoryofsupplies;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Add new form dialog for entering new supplies
 * @author Elmer M. Cuenca
 *
 */
public class AddSuppliesDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Inventory of Supplies Management Panel that owns this dialog box
	 */
	protected ManagementPanel inventoryManagementPanel; 
	
	private final JPanel contentPanel = new JPanel();
	private JTextField jtxtfldProductCode;
	private JTextField jtxtfldItemName;
	private JTextField jtxtfldQuantity;
	private JTextField jtxtfldPrice;
	private JTextField jtxtfldOthers;
	private JRadioButton jrdbtnStationery; 
	private JRadioButton jrdbtnConsumables;
	private JRadioButton jrdbtnOthers;
	private JRadioButton jrdbtnGoodCondition;
	private JRadioButton jrdbtnBadCondition;
	private JRadioButton jrdbtnNeedsAttention;
	private JRadioButton jrdbtnOutOfStock;
	
	

	/**
	 * Create the dialog.
	 */
	public AddSuppliesDialog() {
		
		// For referencing later 
		AddSuppliesDialog thisDialog = this;
		
		setTitle("New Supplies");
		setBounds(100, 100, 492, 321);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 67, 0, 0};
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
			JPanel jpnlItemType = new JPanel();
			GridBagConstraints gbc_jpnlItemType = new GridBagConstraints();
			gbc_jpnlItemType.insets = new Insets(0, 0, 5, 0);
			gbc_jpnlItemType.fill = GridBagConstraints.BOTH;
			gbc_jpnlItemType.gridx = 1;
			gbc_jpnlItemType.gridy = 2;
			contentPanel.add(jpnlItemType, gbc_jpnlItemType);
			jpnlItemType.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			ButtonGroup btngrpItemType = new ButtonGroup();
			{
				jrdbtnStationery = new JRadioButton("Stationery");
				jpnlItemType.add(jrdbtnStationery);
				btngrpItemType.add(jrdbtnStationery);
			}
			{
				jrdbtnConsumables = new JRadioButton("Consumables");
				jpnlItemType.add(jrdbtnConsumables);
				btngrpItemType.add(jrdbtnConsumables);
			}
			{
				Component horizontalStrut = Box.createHorizontalStrut(20);
				jpnlItemType.add(horizontalStrut);
			}
			{
				jrdbtnOthers = new JRadioButton("Others");
				jpnlItemType.add(jrdbtnOthers);
				btngrpItemType.add(jrdbtnOthers);
			}
			{
				jtxtfldOthers = new JTextField();
				jtxtfldOthers.setEnabled(true);
				jpnlItemType.add(jtxtfldOthers);
				jtxtfldOthers.setColumns(10);
			}
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
			JPanel jpnlItemCondition = new JPanel();
			GridBagConstraints gbc_jpnlItemCondition = new GridBagConstraints();
			gbc_jpnlItemCondition.insets = new Insets(0, 0, 5, 0);
			gbc_jpnlItemCondition.fill = GridBagConstraints.VERTICAL;
			gbc_jpnlItemCondition.gridx = 1;
			gbc_jpnlItemCondition.gridy = 4;
			contentPanel.add(jpnlItemCondition, gbc_jpnlItemCondition);
			GridBagLayout gbl_jpnlItemCondition = new GridBagLayout();
			gbl_jpnlItemCondition.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_jpnlItemCondition.rowHeights = new int[]{0, 0, 0};
			gbl_jpnlItemCondition.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_jpnlItemCondition.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			
			ButtonGroup btngrpItemCondition = new ButtonGroup();
			jpnlItemCondition.setLayout(gbl_jpnlItemCondition);
			{
				jrdbtnGoodCondition = new JRadioButton("Good Condition");
				GridBagConstraints gbc_jrdbtnGoodCondition = new GridBagConstraints();
				gbc_jrdbtnGoodCondition.insets = new Insets(0, 0, 5, 5);
				gbc_jrdbtnGoodCondition.gridx = 0;
				gbc_jrdbtnGoodCondition.gridy = 0;
				jpnlItemCondition.add(jrdbtnGoodCondition, gbc_jrdbtnGoodCondition);
				btngrpItemCondition.add(jrdbtnGoodCondition);
			}
			{
				jrdbtnBadCondition = new JRadioButton("Bad Condition");
				GridBagConstraints gbc_jrdbtnBadCondition = new GridBagConstraints();
				gbc_jrdbtnBadCondition.insets = new Insets(0, 0, 5, 5);
				gbc_jrdbtnBadCondition.gridx = 1;
				gbc_jrdbtnBadCondition.gridy = 0;
				jpnlItemCondition.add(jrdbtnBadCondition, gbc_jrdbtnBadCondition);
				btngrpItemCondition.add(jrdbtnBadCondition);
			}
			{
				jrdbtnNeedsAttention = new JRadioButton("Needs Attention");
				GridBagConstraints gbc_jrdbtnNeedsAttention = new GridBagConstraints();
				gbc_jrdbtnNeedsAttention.insets = new Insets(0, 0, 0, 5);
				gbc_jrdbtnNeedsAttention.gridx = 0;
				gbc_jrdbtnNeedsAttention.gridy = 1;
				jpnlItemCondition.add(jrdbtnNeedsAttention, gbc_jrdbtnNeedsAttention);
				btngrpItemCondition.add(jrdbtnNeedsAttention);
			}
			{
				jrdbtnOutOfStock = new JRadioButton("OUT OF STOCK");
				GridBagConstraints gbc_jrdbtnOutOfStock = new GridBagConstraints();
				gbc_jrdbtnOutOfStock.insets = new Insets(0, 0, 0, 5);
				gbc_jrdbtnOutOfStock.gridx = 1;
				gbc_jrdbtnOutOfStock.gridy = 1;
				jpnlItemCondition.add(jrdbtnOutOfStock, gbc_jrdbtnOutOfStock);
				btngrpItemCondition.add(jrdbtnOutOfStock);
			}
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
				JButton jbtnSaveButton = new JButton("SAVE");
				jbtnSaveButton.addActionListener(event -> {
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pupsims_db", "pupsims", "pupsimspass_123");
						Statement statement = connection.createStatement();
						
						/*Condition set for item type button group*/
						
						//String holder for user input in item type
						String strItemTypeInput = " "; 
						
						if (jrdbtnStationery.isSelected())
							strItemTypeInput = "Stationery";
						else if (jrdbtnConsumables.isSelected())
							strItemTypeInput = "Consumables";
						else if (jrdbtnOthers.isSelected())
							strItemTypeInput = jtxtfldOthers.getText();
						else 
							strItemTypeInput = "no status selected";
						
						/*Condition set for item condition button group*/
						
					
						//String holder for user input in item condition
						String strItemConditionInput = " ";
						
						if (jrdbtnGoodCondition.isSelected())
							strItemConditionInput = "Good Condition";
						else if (jrdbtnBadCondition.isSelected())
							strItemConditionInput = "Bad Condition";
						else if (jrdbtnNeedsAttention.isSelected())
							strItemConditionInput = "Needs Attention";
						else if(jrdbtnOutOfStock.isSelected())
							strItemConditionInput = "Out Of Stock";
						else 
							strItemConditionInput = "no status selected";
							
						statement.execute("INSERT INTO inventory_of_supplies VALUES ('" + jtxtfldProductCode.getText() + "','" + jtxtfldItemName.getText() +
																						"','" + strItemTypeInput + "','" + jtxtfldQuantity.getText() + 
																						"','" + strItemConditionInput + "','" + jtxtfldPrice.getText() + "')");
						
						JOptionPane.showMessageDialog(null, "Supply item successfully saved!");
					} catch(SQLException e) {
					  JOptionPane.showMessageDialog(null, "An error occured while saving.\n\n Details:" + e);
					}

					// Closes this dialog right after creation
					this.setVisible(false);
					
					// Refresh the table
					inventoryManagementPanel.updateTable();
				});
				buttonPane.add(jbtnSaveButton);
				}
				
				
			{
				JButton jbtnCancelButton = new JButton("CANCEL");
				jbtnCancelButton.addActionListener(event -> {
					thisDialog.setVisible(false);
				});
				buttonPane.add(jbtnCancelButton);
			}
		}
	}

}
