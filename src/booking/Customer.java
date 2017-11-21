package booking;

public class Customer {
	private int id;
	
	private String firstName;
	private String lastName;
	
	public Customer(int id,String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id=id;
		
		
	
	}
	
	public synchronized void setId(int id) {
		this.id = id;
	}

	public synchronized int getId() {
		return id;
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
