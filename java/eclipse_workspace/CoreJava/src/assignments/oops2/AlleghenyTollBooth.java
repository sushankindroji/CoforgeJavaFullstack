/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:41:02 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.oops2;

/**
 * Allegheny Toll Booth implementation.
 */
public class AlleghenyTollBooth implements TollBooth {

	// Stores total money collected
	private int totalReceipts;

	// Stores total trucks passed
	private int totalTrucks;

	// Default constructor
	public AlleghenyTollBooth() {
		totalReceipts = 0;
		totalTrucks = 0;
	}

	/**
	 * Calculates toll using formula:
	 * Toll = ($5 × axles) + ($10 × weight/500)
	 */
	@Override
	public void calculateToll(Truck truck) {

		int toll = (truck.getAxles() * 5) + ((truck.getWeight() / 500) * 10);

		// Update totals
		totalReceipts += toll;
		totalTrucks++;

		// Display truck details
		System.out.println("Arrival of " + truck.getMake() + " Truck");
		System.out.println("Truck arrival - Axles: "
				+ truck.getAxles()
				+ " Total weight: "
				+ truck.getWeight()
				+ " Toll due: $"
				+ toll);
		System.out.println();
	}

	/**
	 * Displays total receipts and truck count.
	 */
	@Override
	public void displayData() {

		System.out.println("Totals since the last collection - Receipts: $"
				+ totalReceipts
				+ " Trucks: "
				+ totalTrucks);
	}

	/**
	 * Collect receipts and reset counters.
	 */
	@Override
	public void collectReceipts() {

		System.out.println("*** Collecting receipts ***");

		displayData();

		// Reset totals
		totalReceipts = 0;
		totalTrucks = 0;

		System.out.println("***** Reset Receipts **********");
		displayData();
	}
}
