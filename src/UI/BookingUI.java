package UI;



import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import booking.Booking;
import booking.Customer;
import booking.FlightMenu;
import booking.FlightMenyBooking;
import booking.FoodClass;
import booking.TravelTickets;


import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;

public class BookingUI {

	public JFrame frame;
    private JComboBox<String> comboBox_flight;
    private JComboBox<String> comboBox_passangerClass;
    private JComboBox<String> comboBox_food_meny;
    private JSpinner spinner_ticketsQuantity;
    private JTextArea textArea_booking;
    private JSpinner spinner_foodQuantity;
    private JButton btnAdd_Food;
    private JButton btnRemove_Food;
    private JTextPane textPane_TotalIncome;
    private JTextPane textPane_Profit;
    private JButton btnButton_BookFlight;
    private Booking booking = new Booking();
    private FlightMenyBooking meny = new FlightMenyBooking();
    private Customer newCustomer;// = new Customer();
	private List<TravelTickets> flights = new ArrayList<>(booking.flights);
	private JTextField textField_Customer_Id;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private int customerID=0;
    
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookingUI window = new BookingUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public BookingUI() {
		
		initialize();
		setupFoodMenu(0); // init setup of food menu .. maybe not here ... later
	    loadData();
	   
	    
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		;
		JLabel lblNewLabel = new JLabel("MegaFlight Booking System v.1.2");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_flight = new JPanel();
		panel_flight.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_food = new JPanel();
		panel_food.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_report = new JPanel();
		panel_report.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_flight, 0, 0, Short.MAX_VALUE)
								.addComponent(panel_food, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(panel_report, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_flight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_food, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_report, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE))
					.addGap(65))
		);
		
		JButton btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_FirstName.getText().equals("")) {
					textArea_booking.append("Please set name of the booking person\n");
					return;
				}
					
				customerID++;
				newCustomer  = new Customer(customerID,textField_FirstName.toString(),textField_LastName.toString());
				textField_Customer_Id.setText(Integer.toString(newCustomer.getId()));
				textArea_booking.setText("New Customer:"+textField_FirstName.getText()+" "+textField_LastName.getText()+"\n\n");
				booking.resetCustomerPrice();
				
				comboBox_flight.setEnabled(true);
				comboBox_passangerClass.setEnabled(true);
				spinner_ticketsQuantity.setEnabled(true);
				btnButton_BookFlight.setEnabled(true);
				comboBox_food_meny.setEnabled(true);
				spinner_foodQuantity.setEnabled(true);
				btnAdd_Food.setEnabled(true);
				btnRemove_Food.setEnabled(true);
				String food_meny = meny.newCustomer(10,"Jocke","Svensson");
			}
		});
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_5 = new JLabel("IdNr:");
		
		textField_Customer_Id = new JTextField();
		textField_Customer_Id.setEditable(false);
		textField_Customer_Id.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Firstname:");
		
		textField_FirstName = new JTextField();
		textField_FirstName.setColumns(10);
		
		textField_LastName = new JTextField();
		textField_LastName.setColumns(10);
		
		JLabel lblLastname = new JLabel("Lastname:");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCustomer)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_Customer_Id, 0, 0, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addGap(63))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(textField_FirstName, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_LastName, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(btnNewCustomer))
								.addComponent(lblLastname))))
					.addGap(22))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCustomer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_6)
						.addComponent(lblLastname))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewCustomer)
						.addComponent(textField_Customer_Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_FirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_LastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_7 = new JLabel("Company total income :");
		
		textPane_TotalIncome = new JTextPane();
		
		JLabel lblNewLabel_8 = new JLabel("Profit :");
		
		textPane_Profit = new JTextPane();
		
		JButton button = new JButton("Company profit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double totalcost =booking.getTotalFlightCost();
				textPane_TotalIncome.setText(Double.toString(totalcost)+" SEK");
				textPane_Profit.setText(Double.toString(totalcost*0.3)+" SEK");
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_7))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textPane_TotalIncome)
						.addComponent(textPane_Profit, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
					.addGap(63)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(button)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(textPane_TotalIncome, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_7)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_8)
						.addComponent(textPane_Profit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		textArea_booking = new JTextArea();
		textArea_booking.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblFlightsTicetsBookd = new JLabel("Customer bookings and cost");
		lblFlightsTicetsBookd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel_report = new GroupLayout(panel_report);
		gl_panel_report.setHorizontalGroup(
			gl_panel_report.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_report.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_report.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_booking, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFlightsTicetsBookd))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_panel_report.setVerticalGroup(
			gl_panel_report.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_report.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFlightsTicetsBookd)
					.addGap(27)
					.addComponent(textArea_booking, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_report.setLayout(gl_panel_report);
		
		JLabel lblNewLabel_2 = new JLabel("Select Food");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_4 = new JLabel("Food meny:");
		
		comboBox_food_meny = new JComboBox<>();  
		comboBox_food_meny.setEnabled(false);
		
		spinner_foodQuantity = new JSpinner();
		spinner_foodQuantity.setEnabled(false);
		
		btnAdd_Food = new JButton("Add");
		btnAdd_Food.setEnabled(false);
		btnAdd_Food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String food_meny = meny.foodMenuOrderItems(customerID,comboBox_food_meny.getSelectedItem().toString(),(int)spinner_foodQuantity.getValue(),comboBox_passangerClass.getSelectedIndex());
				textArea_booking.append(food_meny);
			}
		});
		
		btnRemove_Food = new JButton("Remove");
		btnRemove_Food.setEnabled(false);
		btnRemove_Food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String food_meny = meny.foodMenuOrderItems(customerID,comboBox_food_meny.getSelectedItem().toString(),(int)spinner_foodQuantity.getValue(),comboBox_passangerClass.getSelectedIndex());
				textArea_booking.append(food_meny);
			}
		});
		GroupLayout gl_panel_food = new GroupLayout(panel_food);
		gl_panel_food.setHorizontalGroup(
			gl_panel_food.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_food.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_food.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_food.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addContainerGap(331, Short.MAX_VALUE))
						.addGroup(gl_panel_food.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addContainerGap(355, Short.MAX_VALUE))
						.addGroup(gl_panel_food.createSequentialGroup()
							.addComponent(comboBox_food_meny, 0, 212, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner_foodQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd_Food)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemove_Food)
							.addGap(31))))
		);
		gl_panel_food.setVerticalGroup(
			gl_panel_food.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_food.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_food.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_food_meny, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_foodQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd_Food)
						.addComponent(btnRemove_Food))
					.addGap(193))
		);
		panel_food.setLayout(gl_panel_food);
		
		JLabel lblNewLabel_1 = new JLabel("Select Flight ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Flight Nr:");
		
		comboBox_flight = new JComboBox<>();
		comboBox_flight.setEnabled(false);
		
		JLabel lblPassangerClass = new JLabel("Passanger Class:");
		
		comboBox_passangerClass = new JComboBox<>();
		comboBox_passangerClass.setEnabled(false);
		comboBox_passangerClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox_passangerClass.getSelectedIndex();
				setupFoodMenu(index);
		

			}
		});
		
		JLabel lblTickets = new JLabel("Tickets:");
		
		spinner_ticketsQuantity = new JSpinner(); 
		spinner_ticketsQuantity.setEnabled(false);
		spinner_ticketsQuantity.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		
		btnButton_BookFlight = new JButton("Reserv This Flight"); 
		btnButton_BookFlight.setEnabled(false);
		btnButton_BookFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sRetInfo=booking.bookFlightAndSets(comboBox_flight.getSelectedIndex(),comboBox_passangerClass.getSelectedIndex(),
						(Integer) spinner_ticketsQuantity.getValue());
				textArea_booking.append(sRetInfo+"\n");


			}
		});
		GroupLayout gl_panel_flight = new GroupLayout(panel_flight);
		gl_panel_flight.setHorizontalGroup(
			gl_panel_flight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_flight.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_flight.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_3)
						.addComponent(comboBox_flight, 0, 213, Short.MAX_VALUE)
						.addComponent(lblPassangerClass)
						.addComponent(comboBox_passangerClass, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTickets)
						.addGroup(gl_panel_flight.createSequentialGroup()
							.addComponent(spinner_ticketsQuantity, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnButton_BookFlight)))
					.addContainerGap(218, Short.MAX_VALUE))
		);
		gl_panel_flight.setVerticalGroup(
			gl_panel_flight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_flight.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_flight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPassangerClass)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_passangerClass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTickets)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_flight.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner_ticketsQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnButton_BookFlight))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel_flight.setLayout(gl_panel_flight);
		frame.getContentPane().setLayout(groupLayout);
	}
	protected void setupFoodMenu(int index) {
		// TODO Auto-generated method stub
		FlightMenu foodMenu;	
		if(index==0) {
			foodMenu = new FlightMenu(FoodClass.FIRST);
			Iterator<String> it = foodMenu.getMenu().keySet().iterator();
			comboBox_food_meny.removeAllItems();
			while(it.hasNext())
			{
				String tmp = (String) it.next();
			    comboBox_food_meny.addItem((tmp));
			}	
		}
		else
		{	
			foodMenu = new FlightMenu(FoodClass.SECOND);
			Iterator<String> it = foodMenu.getMenu().keySet().iterator();
			comboBox_food_meny.removeAllItems();
			while(it.hasNext())
			{
				String tmp = (String) it.next();
			    comboBox_food_meny.addItem((tmp));
			}		
		}
	}
	public void loadData() {
		

		if(!flights.isEmpty()) {
			for (TravelTickets nextFlight : flights) {
			comboBox_flight.addItem(nextFlight.getFlightType());
			}
		}
		else {
			
			System.out.println("list Empty");
		}
		String[] passangerClassList = {"Second Class", "First Class"};
		comboBox_passangerClass.addItem(passangerClassList[0]);
		comboBox_passangerClass.addItem(passangerClassList[1]);
						
	}
}
