/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:40:31 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.oops2;

/**
 * Daewoo Truck implementation.
 */
public class DaewooTruck implements Truck {

	private final int axles;
	private final int weight;

	public DaewooTruck(int axles, int weight) {
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
		return "Daewoo";
	}
}