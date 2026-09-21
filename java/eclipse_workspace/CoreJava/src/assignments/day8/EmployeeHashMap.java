/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:32:39 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeHashMap {

	public static void main(String[] args) {

		Map<Integer, Employee> employeesMap = new HashMap<>();

		// Add 5 Employees
		employeesMap.put(101, new Employee(101, "Rahul", "Hyderabad"));
		employeesMap.put(102, new Employee(102, "Sneha", "Chennai"));
		employeesMap.put(103, new Employee(103, "Kiran", "Bangalore"));
		employeesMap.put(104, new Employee(104, "Anjali", "Mumbai"));
		employeesMap.put(105, new Employee(105, "Ramesh", "Delhi"));

		// Display all Employees
		System.out.println("Employee Details:");

		for (Map.Entry<Integer, Employee> entry : employeesMap.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " -> " + entry.getValue());
		}

		// Search Employee by ID
		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter Employee ID to search: ");
		int id = sc.nextInt();

		Employee emp = employeesMap.get(id);

		if (emp != null) {
			System.out.println("Employee Found:");
			System.out.println(emp);
		} else {
			System.out.println("Employee ID not found.");
		}

		sc.close();
	}
}
