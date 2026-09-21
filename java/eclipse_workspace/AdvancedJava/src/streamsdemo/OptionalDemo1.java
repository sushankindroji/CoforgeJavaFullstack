/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :4:37:55 pm
 * Email : saisushankindroji1476@gmail.com
 */

package streamsdemo;

public class OptionalDemo1 {

	public static void main(String[] args) {
		Customer1 customer1 = new Customer1("Ramesh", "ramesh@gmail.com");
		Customer1 customer2 = new Customer1("Suresh", null);

		System.out.println("Customer 1 Email:");
		System.out.println(customer1.getEmail().orElse("Email not Available"));


		System.out.println("\nCustomer 2 Email:");
		System.out.println(customer2.getEmail().orElse("Email not Available"));

	}

}
