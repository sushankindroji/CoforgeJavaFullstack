/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :2:27:03 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class HomeLoan {  // RBI final class cannot be extended


	private String customerName;
	private double loanAmount;
	private final double PROCESSING_FEE;  // final variable (unique per customer, must be initialized once)



	public HomeLoan(String customerName, double loanAmount, double pROCESSING_FEE) {
		this.customerName = customerName;
		this.loanAmount = loanAmount;
		PROCESSING_FEE = pROCESSING_FEE;
	}



	public void showLoanDetails() {
		System.out.println("Customer: " + customerName);
		System.out.println("Loan Amount: " + loanAmount);
		System.out.println("Processing Fee: " + PROCESSING_FEE);
	}

}
