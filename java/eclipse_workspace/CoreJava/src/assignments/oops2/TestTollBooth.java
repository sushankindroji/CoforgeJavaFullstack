/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:41:51 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.oops2;

/**
 * Main class to test Toll Booth application.
 */
public class TestTollBooth {

	public static void main(String[] args) {

		// Create toll booth object
		TollBooth booth = new AlleghenyTollBooth();

		// Create truck objects
		Truck ford = new FordTruck(5, 12500);
		Truck nissan = new NissanTruck(2, 5000);
		Truck daewoo = new DaewooTruck(6, 17000);

		// Calculate tolls
		booth.calculateToll(ford);
		booth.calculateToll(nissan);
		booth.calculateToll(daewoo);

		// Collect receipts and reset
		booth.collectReceipts();
	}
}
