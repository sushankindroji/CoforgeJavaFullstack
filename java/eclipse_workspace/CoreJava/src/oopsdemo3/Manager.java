/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :3:01:02 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class Manager extends Employee {

	private String department;

	//Generate Constructor
	public Manager(String name, double basic, String address, String department) {
		super(name, basic, address);
		this.department = department;
	}

	@Override
	double totalPay() {
		double totalAmount = 0;
		double houseRentAllowance = (basic * 0.08);
		double dearnessAllowance = (basic * 0.3);
		double medicalAllowance = 1500;
		totalAmount = basic + houseRentAllowance
				+ dearnessAllowance + medicalAllowance;
		return totalAmount;

	}
	void show() {
		super.show();
		System.out.println("Department: \t\t" + department);
	}

}
