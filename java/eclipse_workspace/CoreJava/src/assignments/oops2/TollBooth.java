/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:38:23 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.oops2;

/**
 * TollBooth interface.
 */
public interface TollBooth {

	// Calculates toll and updates receipts
	void calculateToll(Truck truck);

	// Displays current receipts and truck count
	void displayData();

	// Collects receipts and resets totals
	void collectReceipts();
}