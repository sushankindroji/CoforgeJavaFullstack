/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :11:04:40 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo4;

public class BankAccount extends Customer implements AccountOperations, BankingServices {

	private long accountNumber;
	private long mobileNumber;
	private String accountType;
	private double balance;

	public BankAccount(int customerId, String customerName, long mobileNumber,
			long accountNumber, String accountType, double balance) {

		super(customerId, customerName);

		this.mobileNumber = mobileNumber;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}

	@Override
	public void deposit(double amount) {

		if (amount > 0) {
			balance += amount;
			System.out.println("₹" + amount + " deposited successfully.");
			System.out.println("Updated Balance : ₹" + balance);
		} else {
			System.out.println("Invalid Deposit Amount.");
		}
	}

	@Override
	public void withdraw(double amount) {

		if (amount <= balance) {
			balance -= amount;
			System.out.println("₹" + amount + " withdrawn successfully.");
			System.out.println("Remaining Balance : ₹" + balance);
		} else {
			System.out.println("Insufficient Balance.");
		}
	}

	@Override
	public void checkBalance() {
		System.out.println("Current Balance : ₹" + balance);
	}

	@Override
	public void transferMoney(double amount, String beneficiary) {

		if (amount <= balance) {
			balance -= amount;
			System.out.println("₹" + amount + " transferred to " + beneficiary);
			System.out.println("Remaining Balance : ₹" + balance);
		} else {
			System.out.println("Transfer Failed. Insufficient Balance.");
		}
	}

	public void displayAccount() {

		System.out.println("\n==================================");
		super.displayCustomerDetails();
		System.out.println("Mobile Number : " + mobileNumber);
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Type  : " + accountType);
		System.out.println("Balance       : ₹" + balance);
		System.out.println("==================================");
	}
}