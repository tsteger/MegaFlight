package booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookingTest {
	private Booking booking = new Booking();

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testBookOnSeatOnSecondClass() {
	
		
		String sRetInfo=booking.bookFlightAndSeats(0,0,1);
		assertEquals("BOOKED", sRetInfo.substring(0,6));
	}
	@Test
	void testBookFiveSeatOnSecondClass() {
	
		
		String sRetInfo=booking.bookFlightAndSeats(0,0,5);
		assertEquals("BOOKED", sRetInfo.substring(0,6));
	}
	@Test
	void testBookSixSeatOnSecondClass() {
	
		
		String sRetInfo=booking.bookFlightAndSeats(0,0,6);
		assertEquals("There are only", sRetInfo.substring(0,14));
	}
	@Test
	void testBookSixSeparateSeatOnSecondClass() {
	
		
		String sRetInfo=booking.bookFlightAndSeats(0,0,2);
		sRetInfo=booking.bookFlightAndSeats(0,0,2);
		sRetInfo=booking.bookFlightAndSeats(0,0,2);
		assertEquals("There are only", sRetInfo.substring(0,14));
	}
	@Test
	void testBookOnSeatOnFirstClass() {
	
		
		String sRetInfo=booking.bookFlightAndSeats(0,1,1);
		assertEquals("BOOKED", sRetInfo.substring(0,6));
	}
	@Test
	void testBookFiveSeatOnFirstClass() {
	
		
		String sRetInfo=booking.bookFlightAndSeats(0,1,5);
		assertEquals("BOOKED", sRetInfo.substring(0,6));
	}
	@Test
	void testBookSixSeatOnFirstClass() {
	
		
		String sRetInfo=booking.bookFlightAndSeats(0,1,6);
		assertEquals("There are only", sRetInfo.substring(0,14));
	}
	@Test
	void testBookSixSeparateSeatOnFirstClass() {
	
		
		String sRetInfo=booking.bookFlightAndSeats(0,1,2);
		sRetInfo=booking.bookFlightAndSeats(0,1,2);
		sRetInfo=booking.bookFlightAndSeats(0,1,2);
		assertEquals("There are only", sRetInfo.substring(0,14));
	}

}
