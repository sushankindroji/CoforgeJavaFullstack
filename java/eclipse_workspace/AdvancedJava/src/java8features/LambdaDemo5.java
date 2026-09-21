/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :11:37:31 am
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaDemo5 {

	public static void main(String[] args) {

		List<Trainee> empList = new ArrayList<>();

		empList.add(new Trainee(101, "Raj", 45000));
		empList.add(new Trainee(102, "Anjali", 65000));
		empList.add(new Trainee(103, "Kiran", 38000));
		empList.add(new Trainee(104, "Priya", 72000));

		// Sort by salary (ascending)
		Collections.sort(empList,
				(e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

		System.out.println("Employees sorted by salary:");

		for (Trainee emp : empList) {
			System.out.println(emp);
		}
	}
}
