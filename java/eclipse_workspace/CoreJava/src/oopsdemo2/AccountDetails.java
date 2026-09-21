/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :4:36:19 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo2;

//child class of Savings Bank
public class AccountDetails extends SavingsBank {

	int withdrawl, deposit, finalBalance;

	public AccountDetails(int accNo, String name, int mb, int b, int d, int w) {
		super(accNo, name, mb, b);
		this.withdrawl = w;
		this.deposit = d;
	}

	void display() 
	{
		super.display(); // Invokes savings bank display() method
		System.out.println("Deposit: " + deposit);
		System.out.println("Withdrawals: " + withdrawl);
		finalBalance = (balance + deposit) - withdrawl;
		System.out.println("Final Balance: " + finalBalance);
	}
}
