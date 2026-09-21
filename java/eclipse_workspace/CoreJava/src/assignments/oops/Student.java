/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:16:30 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.oops;

public class Student {

	private String name;
	private int yearOfJoining;
	private String address;

	public Student(String name, int yearOfJoining, String address) {
		this.name = name;
		this.yearOfJoining = yearOfJoining;
		this.address = address;
	}

	public void displayStudent() {

		System.out.printf("%-10s %-18d %s%n",
				name, yearOfJoining, address);
	}
}
