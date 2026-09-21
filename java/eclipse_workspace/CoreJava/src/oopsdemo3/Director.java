/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :3:08:48 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class Director extends Employee {

	double transportAllowance;


	public Director(String name, double basic, String address, double transportAllowance) {
		super(name, basic, address);
		this.transportAllowance = transportAllowance;
	}

	@Override
	double totalPay() {
		double totalAmount = 0;
		double houseRentAllowance = (basic * 0.20);
		double dearnessAllowance = (basic * 0.5);
		double medicalAllowance = 4500;
		double entertainmentAllowance = 5000;
		totalAmount = basic + houseRentAllowance + dearnessAllowance
				+ medicalAllowance + entertainmentAllowance + transportAllowance;
		return totalAmount;


	}    
	void show() {
		super.show();
		System.out.println("Transport Allowance: \t" + transportAllowance);
	}

}
