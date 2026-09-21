/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:37:45 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.oops2;

/**
 * Truck interface.
 * Every truck should provide its axle count, weight and make.
 */
public interface Truck {

	// Returns number of axles
	int getAxles();

	// Returns total weight of truck
	int getWeight();

	// Returns truck make
	String getMake();
}
