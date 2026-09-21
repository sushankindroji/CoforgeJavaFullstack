/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:17:43 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.oops;

public class BankAccount {

	private int accountNumber;
	private String accountHolder;
	private double balance;

	public BankAccount(int accountNumber, String accountHolder, double balance) {

		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public void deposit(double amount) {

		if (amount > 0) {
			balance += amount;
			System.out.println("Deposited Successfully.");
		} else {
			System.out.println("Invalid Deposit Amount.");
		}
	}

	public void withdraw(double amount) {

		if (amount <= balance) {
			balance -= amount;
			System.out.println("Withdraw Successful.");
		} else {
			System.out.println("Insufficient Balance.");
		}
	}

	public void displayAccount() {

		System.out.println("\n----------- Account Details -----------");
		System.out.println("Account Number : " + accountNumber);
		System.out.println("Account Holder : " + accountHolder);
		System.out.println("Balance        : ₹" + balance);
	}
}
