/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :2:27:29 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class FinalDemo {

	public static void main(String[] args) {

		RBI rbi = new RBI();
		rbi.showRBIGuidelines();

		System.out.println();

		HomeLoan loan1 =
				new HomeLoan("Alice", 3000000, 10000);

		HomeLoan loan2 =
				new HomeLoan("Bob", 5000000, 15000);

		loan1.showLoanDetails();

		System.out.println("------------------------");

		loan2.showLoanDetails();

		// These are NOT allowed because they are final.
		// RBI.MIN_HOME_LOAN_RATE = 7.0;
		// loan1.PROCESSING_FEE = 20000;
	}
}
