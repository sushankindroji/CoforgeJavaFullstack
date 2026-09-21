/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :3:02:02 pm
 * Email : saisushankindroji1476@gmail.com
 */

package exceptionsdemo;

public class InsufficientfundsException extends Exception{

	private static final long serialVersionUID=1L;
	private double amount;

	public InsufficientfundsException(double amount) {
		this.amount=amount;

	}
	public double getAmount() {
		return amount;
	}
}
