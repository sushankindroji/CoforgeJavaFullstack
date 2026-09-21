/**
 * Author : Sushank
 * Date   : 07-Jul-2026
 * Time   : 12:12:50 PM
 * Email  : saisushankindroji1476@gmail.com
 */

package oopsdemo1;

public class ConstructorDemo {
	private int id;
	private String name;
	private float salary;
	
	
	public ConstructorDemo() {
		System.out.println("iam an impilicit const");
		this.id=101;
		this.name="Alice";
		this.salary=7000.00f;
	}


	public ConstructorDemo(int id, String name, float salary) {
		System.out.println("iam a parametrized constructor");
		this.id = id;
		this.name = name;
		this.salary = salary;
	}	
	
	void display() {
		System.out.println(this.id+ " "+this.name+" "+this.salary);
	}
	
	public static void main(String[] args) {
		ConstructorDemo cd1=new ConstructorDemo(); // invokes implicit Constructor
		ConstructorDemo cd2=new ConstructorDemo(102,"John",6000.00f); // invoke parameterized constructor
		ConstructorDemo cd3=new ConstructorDemo(103,"Gavin",5000.00f); // invoke parameterized constructor
		
		ConstructorDemo cd4=new ConstructorDemo();
		ConstructorDemo cd5=new ConstructorDemo();
		
		cd1.display();
		cd2.display();
		cd3.display();
	
		ConstructorDemo cd6=new ConstructorDemo();
	}
}
