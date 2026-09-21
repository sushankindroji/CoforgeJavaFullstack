/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :2:50:10 pm
 * Email : saisushankindroji1476@gmail.com
 */

package jdbcdemo;

public class Candidate {
	private String firstName;
	private String lastName;
	private String dob;
	private String phone;
	private String email;

	public Candidate() {
		super();
	}

	public Candidate(String firstName, String lastName, String dob, String phone, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
