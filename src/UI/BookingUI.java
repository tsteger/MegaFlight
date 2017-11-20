package UI;



import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import booking.Booking;
import booking.TravelTickets;


import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;

public class BookingUI {

	public JFrame frame;
    private JComboBox<String> comboBox_flight;
    private JComboBox<String> comboBox_passangerClass;
    JTextArea textArea_booking;
    JTextPane textPane_TotalIncome;
    JTextPane textPane_Profit;
    private Booking booking = new Booking();
	private List<TravelTickets> flights = new ArrayList<>(booking.flights);
    
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
		
	    loadData();
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("MegaFlight Booking System v.1.2");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_flight = new JPanel();
		panel_flight.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_food = new JPanel();
		panel_food.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_report = new JPanel();
		panel_report.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_booking.setText("New Customer\n");
				booking.resetCustomerPrice();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnNewButton = new JButton("Company profit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double total=booking.getTotalFlightCost();
				textPane_TotalIncome.setText(Double.toString(total)+ " SEK");
				textPane_Profit.setText(Double.toString(total*0.3)+" SEK");
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(135)
											.addComponent(btnNewButton)))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 645, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(panel_flight, 0, 0, Short.MAX_VALUE)
										.addComponent(panel_food, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
									.addGap(18)
									.addComponent(panel_report, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(btnNewCustomer)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewCustomer)
								.addComponent(btnNewButton)))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_report, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_flight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_food, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)))
					.addGap(65))
		);
		
		JLabel lblNewLabel_7 = new JLabel("Company total income :");
		
		textPane_TotalIncome = new JTextPane();
		
		JLabel lblNewLabel_8 = new JLabel("Profit :");
		
		textPane_Profit = new JTextPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_7))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textPane_Profit)
						.addComponent(textPane_TotalIncome, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
					.addContainerGap(348, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane_TotalIncome, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_8)
						.addComponent(textPane_Profit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		textArea_booking = new JTextArea();
		
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
		
		JComboBox<String> comboBox_food_meny = new JComboBox<>();
		
		JSpinner spinner_foodQuantity = new JSpinner();
		
		JButton btnAdd_Food = new JButton("Add");
		btnAdd_Food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String food_meny = booking.bookFoodMeny();
			}
		});
		
		JButton btnRemove_Food = new JButton("Remove");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("First Class Meny");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Second Class Meny");
		GroupLayout gl_panel_food = new GroupLayout(panel_food);
		gl_panel_food.setHorizontalGroup(
			gl_panel_food.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_food.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_food.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addGroup(Alignment.TRAILING, gl_panel_food.createSequentialGroup()
							.addGroup(gl_panel_food.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4, Alignment.LEADING)
								.addComponent(comboBox_food_meny, 0, 212, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner_foodQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd_Food)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemove_Food)
							.addGap(31))
						.addGroup(gl_panel_food.createSequentialGroup()
							.addComponent(rdbtnNewRadioButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnNewRadioButton_1)
							.addContainerGap())))
		);
		gl_panel_food.setVerticalGroup(
			gl_panel_food.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_food.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addGroup(gl_panel_food.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnNewRadioButton_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_food.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_food_meny, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_foodQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd_Food)
						.addComponent(btnRemove_Food))
					.addGap(158))
		);
		panel_food.setLayout(gl_panel_food);
		
		JLabel lblNewLabel_1 = new JLabel("Select Flight ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Flight Nr:");
		
		comboBox_flight = new JComboBox<>();
		
		JLabel lblPassangerClass = new JLabel("Passanger Class:");
		
		comboBox_passangerClass = new JComboBox<>();
		
		JLabel lblTickets = new JLabel("Tickets:");
		
		JSpinner spinner_ticketsQuantity = new JSpinner();
		spinner_ticketsQuantity.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		
		JButton btnButton_BookFlight = new JButton("Reserv This Flight");
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
