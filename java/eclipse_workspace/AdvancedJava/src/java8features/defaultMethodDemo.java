/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :2:21:53 pm
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

public class defaultMethodDemo {

	public static void main(String[] args) {

		Vehicle car = new Car("BMW");

		// Invoke overridden methods
		System.out.println("Brand : " + car.getBrand());
		System.out.println(car.speedUp());
		System.out.println(car.slowDown());

		// Invoke default methods
		System.out.println(car.turnAlarmOn());
		System.out.println(car.turnAlarmOff());

		// Invoke static method
		System.out.println("Horse Power : " +
				Vehicle.getHorsePower(2500, 400));
	}
}

