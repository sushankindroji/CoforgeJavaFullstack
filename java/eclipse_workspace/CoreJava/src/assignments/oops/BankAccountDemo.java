/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:18:16 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.oops;

import java.util.Scanner;

public class BankAccountDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Account Number: ");
		int accountNumber = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Account Holder Name: ");
		String accountHolder = sc.nextLine();

		System.out.print("Enter Initial Balance: ");
		double balance = sc.nextDouble();

		BankAccount account = new BankAccount(accountNumber, accountHolder, balance);

		account.displayAccount();

		System.out.print("\nEnter Deposit Amount: ");
		double deposit = sc.nextDouble();
		account.deposit(deposit);

		System.out.print("Enter Withdraw Amount: ");
		double withdraw = sc.nextDouble();
		account.withdraw(withdraw);

		account.displayAccount();

		sc.close();
	}
}
