/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :1:07:00 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class Student {

	private int rollNo;
	private String name;
	private static String college="CBIT"; // static field";

	//generate Constructor
	public Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}


	static void collegeChange() //static method
	{
		college="RVCE";
		//rollNo=101; // static methods can use only static fields i.e  we can change static variables  ony
	}

	void display()
	{
		System.out.println(rollNo+" "+name+" "+college);
	}

}

