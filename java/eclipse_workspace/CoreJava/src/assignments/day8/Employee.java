/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:31:53 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day8;

public class Employee {

	private int id;
	private String name;
	private String city;

	public Employee(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
}
