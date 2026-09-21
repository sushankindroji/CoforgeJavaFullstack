package oopsdemo1;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :4:51:21 pm
 * Email : saisushankindroji1476@gmail.com
 */

public class CoforgeEmployeeTest {

	public static void main(String[] args) {
		// create objects e1, e2, e3 of Employee Class
		Employee developer = new Employee(); // invoke default constructor
		Employee tester = new Employee();
		Employee sales = new Employee();

		System.out.println("*** Coforge Technologies ***");

		// Invoke Methods (Method call)
		developer.inputEmployeeDetails(); 
		developer.calculateNetSalary();
		developer.displayEmployeeDetails();

		tester.inputEmployeeDetails();
		tester.calculateNetSalary();
		tester.displayEmployeeDetails();

		sales.inputEmployeeDetails();
		// (Note: The remaining lines for 'sales' are cut off at the bottom)
	}
}

