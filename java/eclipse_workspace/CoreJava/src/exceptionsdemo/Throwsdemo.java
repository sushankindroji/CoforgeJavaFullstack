/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :2:40:05 pm
 * Email : saisushankindroji1476@gmail.com
 */

package exceptionsdemo;

public class Throwsdemo {

	void Division() throws ArithmeticException,NumberFormatException
	{
		int a=45,b=0,rs;

		rs = a / b;
		System.out.print("\n\tThe result is : " + rs); 
	}

	public static void main(String[] args) {

		Throwsdemo T = new Throwsdemo();
		try
		{
			T.Division();
		}
		catch(NumberFormatException Ex) {
			System.out.println("\n\\tError : "+Ex.getMessage());

		}
		catch(ArithmeticException Ex) {
			System.out.println("\n\tError : "+Ex.getMessage());
		}
		System.out.println("\n\tEnd of Program");

	}
}

