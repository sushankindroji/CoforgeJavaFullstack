/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :3:15:54 pm
 * Email : saisushankindroji1476@gmail.com
 */


package oopsdemo2;

public class Employee {

	private int empId;
	private String name;


	//Generate constructor using fields
	public Employee(int empId, String name) {
		this.empId = empId;
		this.name = name;
	}


	void display()
	{
		System.out.println("********** Employee Details ***************");
		System.out.println("Employee Id :"+empId);
		System.out.println("Employee Name: "+name);
	}

}

