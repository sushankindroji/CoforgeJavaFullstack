/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :11:32:29 am
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

public class Trainee {

	private int id;
	private String name;
	private double salary;

	// Constructor
	public Trainee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + id +
				", name=" + name +
				", salary=" + salary + "]";
	}
}
