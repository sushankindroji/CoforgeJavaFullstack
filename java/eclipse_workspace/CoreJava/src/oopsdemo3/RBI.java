/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :2:26:32 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public final class RBI {

	public class Homeloan {
		private String customerName;
		private double loanAmount;
		private final double PROCESSING_FEE;  // final variable (unique per customer, must be initialized once)

		public Homeloan(String customerName, double loanAmount, double pROCESSING_FEE) {
			super();
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


	// Final variable (constant)
	public static final double MIN_HOME_LOAN_RATE = 6.5;  // cannot change

	// Final method (standard rule - cannot be overridden by banks)
	public final void showRBIGuidelines() {
		System.out.println("📌 RBI Guideline: Minimum Home Loan Interest Rate = " + MIN_HOME_LOAN_RATE + "%");
	}


}
