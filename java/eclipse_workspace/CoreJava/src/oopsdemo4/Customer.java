/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :11:03:58 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo4;

public class Customer {

	protected int customerId;
	protected String customerName;

	public Customer(int customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public void displayCustomerDetails() {
		System.out.println("******** Customer Details ********");
		System.out.println("Customer ID   : " + customerId);
		System.out.println("Customer Name : " + customerName);
	}
}
