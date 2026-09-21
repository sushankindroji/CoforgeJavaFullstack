/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :3:18:38 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public abstract class HospitalStaff {

	private String name;
	private String id;
	private String department;

	public HospitalStaff(String name, String id, String department) {
		this.name = name;
		this.id = id;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getDepartment() {
		return department;
	}

	// Abstract method
	public abstract void performDuties();

	// Common method
	public void attendMeeting() {
		System.out.println(name + " is attending a hospital meeting.");
	}
}

