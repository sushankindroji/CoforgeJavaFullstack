/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :2:38:28 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.Objects;

public class Customer {

	private long id;
	private String name;
	private String city;

	public Customer(long id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, city);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Customer other = (Customer) obj;

		return id == other.id
				&& Objects.equals(name, other.name)
				&& Objects.equals(city, other.city);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}
}

