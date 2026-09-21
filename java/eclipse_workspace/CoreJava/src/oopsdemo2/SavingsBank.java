/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :4:34:04 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo2;

//Child class of Account
public class SavingsBank extends Account
{
	private int min_bal; // can access only within the class
	protected int balance; // can access within the class & in the sub class

	public SavingsBank(int accno, String name, int mb, int b) {
		super(accno, name);
		this.min_bal = mb;
		this.balance = b;
	}

	void display()
	{
		super.display(); // Invoke super class method
		System.out.println("Minimum Balance: " + min_bal);
		System.out.println("Saving Balance: " + balance);
	}
}
