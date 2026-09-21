/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :9:46:15 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo2;

public class AggregationDemo {

	public static void main(String[] args) {
		
		Address ad1= new Address("Hyderabad","Telangana","India",500028);
		
		Student s1 = new Student(34,"Ram",ad1);
		s1.display();
	}

}
