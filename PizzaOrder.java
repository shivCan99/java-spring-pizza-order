package week3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PizzaOrder extends JFrame 
{
	private static final double LARGE = 14.99;
	private static final double MEDIUM = 10.99;
	private static final double SMALL = 6.99;
	
	private static final double PEPPERONI = 5.00;
	private static final double VEGGIE = 3.00;
	
	private double price;
	private ActionListener listener;
	private JPanel radioButtonPanel;
	private JPanel checkBoxPanel;
	private JPanel pricePanel;
	
	private JPanel centralPanel;
	
	private JRadioButton smallButton;
	private JRadioButton mediumButton;
	private JRadioButton largeButton;
	
	private JCheckBox pepperoniCheckBox;
	private JCheckBox veggieCheckBox;
	
	private JTextField priceTextField;
	
	public PizzaOrder()
	{
		//set up the frame
		this.setSize(300,200);
		
		class PizzaSelectionListener implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
			{
				calculatePrice();
			}

			
		}
		listener = new PizzaSelectionListener();
		
		//radio buttons
		
		createRadioButtons();
		createCheckBox();
		calculatePriceDisplay();
		createLayout();
		}
		public void createRadioButtons() 
		{
	
		radioButtonPanel = new JPanel();
		radioButtonPanel.setLayout(new GridLayout(3,1));
		radioButtonPanel.setBorder(new TitledBorder (new EtchedBorder(), "SIZE"));
		
		smallButton = new JRadioButton("Small");
		mediumButton = new JRadioButton("Medium");
		largeButton = new JRadioButton("Large");
		
		ButtonGroup group = new ButtonGroup();
		group.add(smallButton);
		group.add(mediumButton);
		group.add(largeButton);
		
		smallButton.addActionListener(listener);
		mediumButton.addActionListener(listener);
		largeButton.addActionListener(listener);
		
		smallButton.setSelected(true);
		
		radioButtonPanel.add(smallButton);
		radioButtonPanel.add(mediumButton);
		radioButtonPanel.add(largeButton);
		
		
		}
		
		public void createCheckBox()
		{
			checkBoxPanel = new JPanel();
			checkBoxPanel.setLayout(new GridLayout(3,1));
			checkBoxPanel.setBorder(new TitledBorder (new EtchedBorder(), "Toppings"));
			
			pepperoniCheckBox = new JCheckBox("Pepperoni");
			veggieCheckBox = new JCheckBox("Veggie");
			
			pepperoniCheckBox.addActionListener(listener);
			veggieCheckBox.addActionListener(listener);
			
			checkBoxPanel.add(pepperoniCheckBox);
			checkBoxPanel.add(veggieCheckBox);
			
			
			
		}
		
		public void calculatePriceDisplay()
		{
			pricePanel = new JPanel();
			JLabel priceLabel = new JLabel("Your Price");
			priceTextField = new JTextField(10);
			
			pricePanel.add(priceLabel);
			pricePanel.add(priceTextField);
			
			
		}
		
		public void createLayout()
		{
			centralPanel = new JPanel();
			
			centralPanel.add(radioButtonPanel);
			centralPanel.add(checkBoxPanel);
			
			add(centralPanel, BorderLayout.CENTER);
			add(pricePanel, BorderLayout.SOUTH);
			
			
		}
		public void calculatePrice()
		{
			price=0;
			
			if(smallButton.isSelected())
				price= SMALL;
			else if(mediumButton.isSelected())
				price= MEDIUM;
			else if(largeButton.isSelected())
				price= LARGE;
			
			if(pepperoniCheckBox.isSelected())
				price = price + PEPPERONI;

			else if(veggieCheckBox.isSelected())
				price = price + VEGGIE;
			
			
			priceTextField.setText("$" + String.format("%2f", price));
			
		}
		public static void main(String[] args)
		{
			JFrame frame = new PizzaOrder();
			frame.setDefaultCloseOperation(3);
			frame.setTitle("Happy Monday");
			frame.setVisible(true);
		}
		}

