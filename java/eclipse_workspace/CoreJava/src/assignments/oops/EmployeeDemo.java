/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:15:15 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.oops;

import java.util.Scanner;

public class EmployeeDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Employee emp = new Employee();

		System.out.print("Enter Salary: ");
		double salary = sc.nextDouble();

		System.out.print("Enter Working Hours Per Day: ");
		int hours = sc.nextInt();

		emp.getInfo(salary, hours);

		emp.addSal();
		emp.addWork();

		emp.displaySalary();

		sc.close();
	}
}
