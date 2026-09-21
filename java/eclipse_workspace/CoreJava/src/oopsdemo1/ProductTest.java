package oopsdemo1;

import java.util.Scanner;

/**
 * Author :sushank2
 * Date :07-Jul-2026
 * Time :10:06:09 am
 * Email : saisushankindroji1476@gmail.com
 */

public class ProductTest {

	public static void main(  String[] args) {

		Scanner sc = new Scanner(System.in);

		Product p = new Product();

		System.out.print("Enter Product Id: ");
		p.setProductId(sc.nextInt());
		sc.nextLine(); // Consume newline

		// Product name can contain multiple words
		System.out.print("Enter Product Name: ");
		p.setProductName(sc.nextLine());

		System.out.print("Enter Product Price: ");
		p.setPrice(sc.nextFloat());

		System.out.print("Enter Quantity: ");
		p.setQty(sc.nextInt());

		p.display();

		System.out.println("\nUsing toString()");
		System.out.println(p);
		
		
		

		Product p2 = new Product();

		System.out.println("******** Product Details ********");

		p2.setProductId(111);
		p2.setProductName("iPhone XS Max");
		p2.setPrice(23444.0f);
		p2.setQty(3);

		p2.display();

		System.out.println("\nUsing toString()");
		System.out.println(p2);

		sc.close();
		
	}
}