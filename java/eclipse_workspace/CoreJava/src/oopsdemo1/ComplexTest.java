/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :12:44:17 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo1;

import java.util.Scanner;

public class ComplexTest {

	public static void main(String[] args)
	{
		Complex c1=new Complex(10.3,67.4); // invokes constructor
		Complex c2=new Complex(0.7,3.6); // invokes constructor
		Complex c3=new Complex(1.0,1.0); //

		c1.add(c2); // calls method add() by passing object c2 //c1+c2
		System.out.println("The Addition of 2 Complex number is:");
		c1.display();

		c1.add(c3); //c1+c3
		System.out.println("The Addition of 2 Complex number is:");
		c1.display();

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter real and imaginary part of complex number:");
		double r=sc.nextDouble();
		double i=sc.nextDouble();

		Complex c4=new Complex(r,i);

		c2.add(c4); //c2+c4
		System.out.println("The Addition of 2 Complex number is:");
		c2.display();

		sc.close();
	}
}
