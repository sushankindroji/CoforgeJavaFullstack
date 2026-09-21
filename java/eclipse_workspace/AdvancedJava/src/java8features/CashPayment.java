package java8features;

/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :2:31:18 pm
 * Email : saisushankindroji1476@gmail.com
 */

//Functional Interface
interface Payment {

	void pay(double amount); // Abstract method

	// Default method - common across all payments
	default void generateReceipt(double amount) {
		System.out.println("Receipt generated for payment of ₹" + amount);
	}
}

//Card Payment Implementation
class CardPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using Credit/Debit Card ✅");
	}

	// Optionally override default method
	@Override
	public void generateReceipt(double amount) {
		System.out.println("Card Payment Receipt: ₹" + amount + " [Transaction Secured]");
	}
}

//Cash Payment Implementation
class CashPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " in Cash ✅");
	}
}
