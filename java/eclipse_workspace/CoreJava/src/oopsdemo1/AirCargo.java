package oopsdemo1;

/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :12:32:59 pm
 * Email : saisushankindroji1476@gmail.com
 */


public class AirCargo {

	// Attributes (Encapsulation - private fields)
	private String bookingId;
	private String senderName;
	private String destination;
	private double weight;
	private double costPerKg;


	public AirCargo(String bookingId, String senderName, String destination, double weight, double costPerKg) {
		super();
		this.bookingId = bookingId;
		this.senderName = senderName;
		this.destination = destination;
		this.weight = weight;
		this.costPerKg = costPerKg;
	}


	public String getBookingId() {
		return bookingId;
	}


	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}


	public String getSenderName() {
		return senderName;
	}


	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getCostPerKg() {
		return costPerKg;
	}


	public void setCostPerKg(double costPerKg) {
		this.costPerKg = costPerKg;
	}

	// Method to calculate total cost
	public double calculateCost() {
		return this.weight * this.costPerKg;
	}

	public void bookCargo() {
		System.out.println("\n✅ Cargo booked successfully with Booking ID: " + this.bookingId);
	}

	public void generateBill() {
		System.out.println("----- SITA Airlines Cargo Bill -----");
		System.out.println("Booking ID: " + this.bookingId);
		System.out.println("Sender Name: " + this.senderName);
		System.out.println("Destination: " + this.destination);
		System.out.println("Weight: " + this.weight + " kg");
		System.out.println("Rate per Kg: ₹" + this.costPerKg);
		System.out.println("Total Cost: ₹" + calculateCost());
		System.out.println("-------------------------------------");
	}
	
}