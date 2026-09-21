/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :11:40:56 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

class Bank{
	private String name;

	//Generate constructor
	public Bank(String name) {
		this.name = name;
	}

	int getRateOfInterest()
	{
		return 0;
	}
	void display()
	{
		System.out.println("Welcome to "+name+" Bank");
	}

}


class SBI extends Bank{

	public SBI(String name) {
		super(name);
	}

	@Override
	int getRateOfInterest() {

		return 5;
	}



}

class ICICI extends Bank{

	public ICICI(String name) {
		super(name);
	}

	@Override
	int getRateOfInterest() {
		// TODO Auto-generated method stub
		return 7;
	}

}

class Axis extends Bank{

	public Axis(String name) {
		super(name);
	}

	@Override
	int getRateOfInterest() {
		// TODO Auto-generated method stub
		return super.getRateOfInterest();
	}
}

public class OverrideDemo {

	public static void main(String[] args) {

		SBI sbibank= new SBI("SBI");
		ICICI icicibank = new ICICI("ICICI");
		Axis axisbank = new Axis("Axis");

		sbibank.display();
		System.out.println("The Interest of SBI is:"+sbibank.getRateOfInterest()); //invoke overridden

		icicibank.display();
		System.out.println("The Interest of ICICI is:"+icicibank.getRateOfInterest());

		axisbank.display();
		System.out.println("The Interest  Rate of Axis is:"+axisbank.getRateOfInterest());

	}

}