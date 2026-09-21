/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :2:18:32 pm
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

public class Car implements Vehicle {

	private String brand;

	public Car(String brand) {
		this.brand = brand;
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public String speedUp() {
		return "Car is Speeding Up!!!";
	}

	@Override
	public String slowDown() {
		return "Car is Slowing Down!!!";
	}
}

