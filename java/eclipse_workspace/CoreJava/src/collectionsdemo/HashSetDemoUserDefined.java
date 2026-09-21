/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :2:43:13 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemoUserDefined {

	public static void main(String[] args) {

		HashSet<Customer> customers = new HashSet<>();

		Customer c1 = new Customer(101, "Rahul", "Hyderabad");
		Customer c2 = new Customer(102, "Ravi", "Chennai");
		Customer c3 = new Customer(103, "Anil", "Bangalore");

		// Duplicate object
		Customer c4 = new Customer(101, "Rahul", "Hyderabad");

		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4); // Will not be added

		System.out.println("HashSet Contents:");

		for (Customer c : customers) {
			System.out.println(c);
		}

		System.out.println("\nTotal Customers = " + customers.size());

		System.out.println("\nUsing Iterator:");

		Iterator<Customer> iterator = customers.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}