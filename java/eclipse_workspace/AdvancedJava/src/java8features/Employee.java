/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :2:34:44 pm
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

public class Employee {

	private int id;
	private String name;
	private String department;
	private double salary;
	private double rating;

	public Employee(int id, String name, String department, double salary, double rating) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}

	public double getRating() {
		return rating;
	}
}
