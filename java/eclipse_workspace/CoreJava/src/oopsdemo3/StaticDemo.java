/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :1:05:37 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class StaticDemo {

	public static void main(String[] args) {


		Student s1=new Student(101,"Mike");
		Student s2=new Student(102,"John");
		Student s3=new Student(103,"Mary");

		s1.display();
		s2.display();
		s3.display();

		// invoke static method even before creating object
		Student.collegeChange();  



		s1.display();
		s2.display();
		s3.display();

	}

}
