/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:39:06 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.oops2;

/**
 * Ford Truck implementation.
 */
public class FordTruck implements Truck {

	// Number of axles
	private final int axles;

	// Total truck weight
	private final int weight;

	// Constructor
	public FordTruck(int axles, int weight) {
		this.axles = axles;
		this.weight = weight;
	}

	@Override
	public int getAxles() {
		return axles;
	}

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public String getMake() {
		return "Ford";
	}
}
