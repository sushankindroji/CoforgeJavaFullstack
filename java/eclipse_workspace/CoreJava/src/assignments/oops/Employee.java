/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:14:43 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.oops;

public class Employee {

	private double salary;
	private int hoursPerDay;

	public void getInfo(double salary, int hoursPerDay) {
		this.salary = salary;
		this.hoursPerDay = hoursPerDay;
	}

	public void addSal() {
		if (salary < 500) {
			salary += 10;
		}
	}

	public void addWork() {
		if (hoursPerDay > 6) {
			salary += 5;
		}
	}

	public void displaySalary() {
		System.out.println("Final Salary = $" + salary);
	}
}
