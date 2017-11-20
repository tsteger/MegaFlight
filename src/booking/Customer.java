package booking;

public class Customer {
	private String firstName;
	private String lastName;
	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public synchronized String getFirstName() {
		return firstName;
	}
	public synchronized void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public synchronized String getLastName() {
		return lastName;
	}
	public synchronized void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
