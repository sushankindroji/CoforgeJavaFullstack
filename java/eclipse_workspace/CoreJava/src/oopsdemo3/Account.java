/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :11:55:50 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class Account {
	private String name;
	protected double balance;

	public Account(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}


	// final methods cannot be overridden
	final void deposit(double amt) {
		balance += amt;
		System.out.println("Depositing: " + amt);
	}

	void withdraw(double amt) {
		balance -= amt;
		System.out.println("WithDrawing: " + amt);

	}


}
