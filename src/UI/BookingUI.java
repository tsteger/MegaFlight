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


import booking.AirCompany;
import booking.BookingDesk;
import booking.Flight;
import booking.Customer;
import booking.FlightMenu;
import booking.FlightMenuBooking;
import booking.MockAirCompany;
import booking.SeatClass;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class BookingUI {

	public JFrame frame;
    private JComboBox<String> comboBox_flight;
    private JComboBox<String> comboBox_passangerClass;
    private JComboBox<String> comboBox_food_menu;
    private JSpinner spinner_ticketsQuantity;
    private JSpinner spinner_foodQuantity;
    private JButton btnAdd_Food;
    private JButton btnRemove_Food;
    private JTextPane textPane_TotalIncome;
    private JTextPane textPane_Profit;
    private JTextPane textPane_TotalSum;
    private JTextPane textPane_TotalMenuPrice;
    private JTextPane textPane_TotalFlightPrice;
    private JButton btnButton_BookFlight;
    private JCheckBox chckbxNewCheckBox_OnOff;
    private JCheckBox chckbxNewCheckBox_AutoLogger;
    public static boolean autologgerOnOff=true;
    public static  JTextArea textArea_FlightSimulator ;
    private JTextArea textArea_Booking_Food_And_Flight;
    private AirCompany airCompany = new MockAirCompany().Get();
    private BookingDesk bookingDesk = airCompany.getBookingDesk(); 
    private List<Flight> flights = new ArrayList<>(bookingDesk.getFlights());
    
    private FlightMenuBooking menu = new FlightMenuBooking();

    private Customer newCustomer;
   
	private JTextField textField_Customer_Id;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private int customerID=0;
	//private int totalFoadCostForAllCustomers;
    

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
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1095, 796);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(panel_flight, 0, 0, Short.MAX_VALUE)
									.addComponent(panel_food, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_report, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, 0, 0, Short.MAX_VALUE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_report, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_flight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_food, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)))
					.addGap(65))
		);
		
		JLabel lblNewLabel_12 = new JLabel("Flightsimulator");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autologgerOnOff=false;
				chckbxNewCheckBox_AutoLogger.setSelected(false);
				//textArea_FlightTicker.append(airCompany.getLogReport());
				textArea_FlightSimulator.setText(airCompany.getLogReport());
				
			}
		});
		
		chckbxNewCheckBox_OnOff = new JCheckBox("On/Off");
		chckbxNewCheckBox_OnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MockAirCompany.flightSimulatorOnOff(chckbxNewCheckBox_OnOff.isSelected());
			}
		});
		
		JScrollPane scrollPane_Simulator = new JScrollPane();
		
		chckbxNewCheckBox_AutoLogger = new JCheckBox("Autologger");
		chckbxNewCheckBox_AutoLogger.setSelected(true);
		chckbxNewCheckBox_AutoLogger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(autologgerOnOff)
					autologgerOnOff=false;
				else
					autologgerOnOff=true;
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_Simulator, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_12)
							.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
							.addComponent(btnNewButton))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(chckbxNewCheckBox_OnOff)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxNewCheckBox_AutoLogger)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_12)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxNewCheckBox_OnOff)
						.addComponent(chckbxNewCheckBox_AutoLogger))
					.addGap(18)
					.addComponent(scrollPane_Simulator, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
					.addGap(12))
		);
		
		textArea_FlightSimulator = new JTextArea();
		scrollPane_Simulator.setViewportView(textArea_FlightSimulator);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_FirstName.getText().equals("")) {
					
					textArea_Booking_Food_And_Flight.append("Please set name of the booking person\n");
					return;
				}
					
				customerID++;
				newCustomer  = new Customer(customerID,textField_FirstName.toString(),textField_LastName.toString());
				textField_Customer_Id.setText(Integer.toString(newCustomer.getId()));
				
				textArea_Booking_Food_And_Flight.setText("Customer: "+textField_FirstName.getText()+" "+textField_LastName.getText()+"\n\n");
				bookingDesk.resetTotalCustomerCost();
				textPane_TotalSum.setText("0");
				textPane_TotalMenuPrice.setText("0");
				textPane_TotalFlightPrice.setText("0");
				comboBox_flight.setEnabled(true);
				comboBox_passangerClass.setEnabled(true);
				spinner_ticketsQuantity.setEnabled(true);
				btnButton_BookFlight.setEnabled(true);
				comboBox_food_menu.setEnabled(true);
				spinner_foodQuantity.setEnabled(true);
				btnAdd_Food.setEnabled(true);
				btnRemove_Food.setEnabled(true);
				textField_FirstName.setText("");
				textField_LastName.setText("");
				menu.newCustomer();
			}
		});
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_5 = new JLabel("IdNr:");
		
		textField_Customer_Id = new JTextField();
		textField_Customer_Id.setEditable(false);
		textField_Customer_Id.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Surname:");
		
		textField_FirstName = new JTextField();
		textField_FirstName.setColumns(10);
		
		textField_LastName = new JTextField();
		textField_LastName.setColumns(10);
		
		JLabel lblLastname = new JLabel("Name:");
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
		textPane_TotalIncome.setEditable(false);
		
		JLabel lblNewLabel_8 = new JLabel("Profit :");
		
		textPane_Profit = new JTextPane();
		textPane_Profit.setEditable(false);
		
		JButton button = new JButton("Company profit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double totalMenuCost = menu.getTotalCompanyEarnedAmount();
				double totalcost =bookingDesk.getTotalFlightCost();
				textPane_TotalIncome.setText(Double.toString(totalcost+totalMenuCost)+" SEK");
				textPane_Profit.setText(Double.toString((totalcost+totalMenuCost)*0.3)+" SEK");

				
			}
		});
		
		JLabel lblNewLabel_11 = new JLabel("Company Information");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_11)
							.addContainerGap(234, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_7)
							.addContainerGap(167, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane_TotalIncome, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(141, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_8)
							.addContainerGap(247, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane_Profit)
							.addGap(142))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(142, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_11)
					.addGap(18)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_TotalIncome, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_8)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_Profit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button)
					.addContainerGap(470, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblFlightsTicetsBookd = new JLabel("Customer bookings and cost");
		lblFlightsTicetsBookd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_9 = new JLabel("Total Flight Cost:");
		
		textPane_TotalFlightPrice = new JTextPane();
		textPane_TotalFlightPrice.setEditable(false);
		
		JLabel lblTotalFoodCost = new JLabel("Total Food Cost:");
		
		textPane_TotalMenuPrice = new JTextPane();
		textPane_TotalMenuPrice.setEditable(false);
		
		JLabel lblNewLabel_10 = new JLabel("Total sum :");
		
		textPane_TotalSum = new JTextPane(); 
		textPane_TotalSum.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_report = new GroupLayout(panel_report);
		gl_panel_report.setHorizontalGroup(
			gl_panel_report.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_report.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_report.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_report.createSequentialGroup()
							.addGroup(gl_panel_report.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_report.createSequentialGroup()
									.addComponent(lblNewLabel_9)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblTotalFoodCost))
								.addGroup(gl_panel_report.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblFlightsTicetsBookd)
									.addGroup(Alignment.TRAILING, gl_panel_report.createSequentialGroup()
										.addComponent(textPane_TotalFlightPrice)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textPane_TotalMenuPrice, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_report.createParallelGroup(Alignment.LEADING)
								.addComponent(textPane_TotalSum, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(lblNewLabel_10))))
					.addContainerGap())
		);
		gl_panel_report.setVerticalGroup(
			gl_panel_report.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_report.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFlightsTicetsBookd)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panel_report.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(lblTotalFoodCost)
						.addComponent(lblNewLabel_10))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_report.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_report.createParallelGroup(Alignment.LEADING)
							.addComponent(textPane_TotalMenuPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textPane_TotalFlightPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textPane_TotalSum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		textArea_Booking_Food_And_Flight = new JTextArea();
		textArea_Booking_Food_And_Flight.setEditable(false);
		textArea_Booking_Food_And_Flight.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea_Booking_Food_And_Flight.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea_Booking_Food_And_Flight);
		panel_report.setLayout(gl_panel_report);
		
		JLabel lblNewLabel_2 = new JLabel("Select Food");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_4 = new JLabel("Menu:");
		
		comboBox_food_menu = new JComboBox<>();  
		comboBox_food_menu.setEnabled(false);
		
		spinner_foodQuantity = new JSpinner();
		spinner_foodQuantity.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_foodQuantity.setEnabled(false);
		
		btnAdd_Food = new JButton("Add");
		btnAdd_Food.setEnabled(false);
		btnAdd_Food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String food_menu = menu.foodMenuOrderItems(customerID,comboBox_food_menu.getSelectedItem().toString(),(int)spinner_foodQuantity.getValue(),comboBox_passangerClass.getSelectedIndex());
				
				
				textArea_Booking_Food_And_Flight.append(food_menu+"\n");
				textPane_TotalFlightPrice.setText(Integer.toString(bookingDesk.getTotalCustomerCost()));
				textPane_TotalMenuPrice.setText(Integer.toString(menu.GettotalCustomerPrice()));
				textPane_TotalSum.setText(Integer.toString(bookingDesk.getTotalCustomerCost()+menu.GettotalCustomerPrice()));
			}
		});
		
		btnRemove_Food = new JButton("Remove");
		btnRemove_Food.setEnabled(false);
		btnRemove_Food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String food_menu = menu.foodMenuUnOrderItems(customerID,comboBox_food_menu.getSelectedItem().toString(),(int)spinner_foodQuantity.getValue(),comboBox_passangerClass.getSelectedIndex());
				
				textArea_Booking_Food_And_Flight.append(food_menu+"\n");
				textPane_TotalFlightPrice.setText(Integer.toString(bookingDesk.getTotalCustomerCost()));
				textPane_TotalMenuPrice.setText(Integer.toString(menu.GettotalCustomerPrice()));
				textPane_TotalSum.setText(Integer.toString(bookingDesk.getTotalCustomerCost()+menu.GettotalCustomerPrice()));
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
							.addComponent(comboBox_food_menu, 0, 212, Short.MAX_VALUE)
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
						.addComponent(comboBox_food_menu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
		
		JLabel lblPassangerClass = new JLabel("Class:");
		
		comboBox_passangerClass = new JComboBox<>();
		comboBox_passangerClass.setEnabled(false);
		comboBox_passangerClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox_passangerClass.getSelectedIndex();
				setupFoodMenu(index);
		

			}
		});
		
		JLabel lblTickets = new JLabel("Number Of Seats:");
		
		spinner_ticketsQuantity = new JSpinner(); 
		spinner_ticketsQuantity.setEnabled(false);
		spinner_ticketsQuantity.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		
		btnButton_BookFlight = new JButton("Book"); 
		btnButton_BookFlight.setEnabled(false);
		btnButton_BookFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sRetInfo=bookingDesk.bookFlightAndSeats(comboBox_flight.getSelectedIndex(),comboBox_passangerClass.getSelectedIndex(),
						(Integer) spinner_ticketsQuantity.getValue());
			
				textArea_Booking_Food_And_Flight.append(sRetInfo+"\n");
				textPane_TotalFlightPrice.setText(Integer.toString(bookingDesk.getTotalCustomerCost())); 
				textPane_TotalMenuPrice.setText(Integer.toString(menu.GettotalCustomerPrice()));
				textPane_TotalSum.setText(Integer.toString(bookingDesk.getTotalCustomerCost()+menu.GettotalCustomerPrice()));
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
							.addComponent(btnButton_BookFlight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(192, Short.MAX_VALUE))
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
		FlightMenu foodMenu;	
		if(index==0) {
			foodMenu = new FlightMenu(SeatClass.ECONOMY);
			Iterator<String> it = foodMenu.getMenu().keySet().iterator();
			comboBox_food_menu.removeAllItems();
			while(it.hasNext())
			{
				String tmp = (String) it.next();
			    comboBox_food_menu.addItem((tmp));
			}	
		}
		else
		{	
			foodMenu = new FlightMenu(SeatClass.FIRST);
			Iterator<String> it = foodMenu.getMenu().keySet().iterator();
			comboBox_food_menu.removeAllItems();
			while(it.hasNext())
			{
				String tmp = (String) it.next();
			    comboBox_food_menu.addItem((tmp));
			}		
		}
	}
	public void loadData() {
		
		if(!flights.isEmpty()) {
			for (Flight nextFlight : flights) {
			comboBox_flight.addItem(nextFlight.getName());
			}
		}
		else {
			
			System.out.println("list Empty");
		}
		SeatClass[] passangerClassList = SeatClass.values(); // { SeatClass.ECONOMY, SeatClass.FIRST};	
		comboBox_passangerClass.addItem(passangerClassList[0].toString());
		comboBox_passangerClass.addItem(passangerClassList[1].toString());
						
	}
}
