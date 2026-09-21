/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :4:31:39 pm
 * Email : saisushankindroji1476@gmail.com
 */


package oopsdemo2;

//Multilevel Inheritance
//base class for SavingsBank
public class Account {

	private int accNo;
	private String name;

	public Account(int accNo, String name) {
		this.accNo = accNo;
		this.name = name;
	}

	void display() {
		System.out.println("**** Account Details ****");
		System.out.println("Account Number: " + accNo);
		System.out.println("Customer Name: " + name);
	}
}
