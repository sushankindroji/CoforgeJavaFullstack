/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :2:10:13 pm
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

public interface Vehicle {

	// Abstract methods
	String getBrand();

	String speedUp();

	String slowDown();

	// Default methods
	default String turnAlarmOn() {
		return "Turning the vehicle alarm on";
	}

	default String turnAlarmOff() {
		return "Turning the vehicle alarm off";
	}

	// Static method
	static int getHorsePower(int rpm, int torque) {
		return (rpm * torque) / 5252;
	}
}
