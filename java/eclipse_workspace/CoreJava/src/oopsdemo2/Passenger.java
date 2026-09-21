/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :3:53:57 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo2;

public class Passenger {

	private String name;
	private int age;
	private String passportNumber;
	
	//Constructor with parameters
	public Passenger(String name, int age, String passportNumber) {
		this.name = name;
		this.age = age;
		this.passportNumber = passportNumber;
	}
	
	 public void displayPassengerInfo() {
			System.out.println("Passenger Name: " + name);
			System.out.println("Passenger Age: " + age);
			System.out.println("Passport Number: " + passportNumber);
		}

}
