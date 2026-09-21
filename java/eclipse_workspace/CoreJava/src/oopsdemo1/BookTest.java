package oopsdemo1;

import java.util.Scanner;

/**
 * Author : sushank2
 * Date : 07-Jul-2026
 * Time : 9:41:04 am
 * Email : saisushankindroji1476@gmail.com
 */

public class BookTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Book b1 = new Book();

		System.out.print("Enter Book Id: ");
		b1.setBookId(sc.nextInt());
		sc.nextLine(); // Consume newline

		System.out.print("Enter Book Name: ");
		b1.setBookName(sc.nextLine());

		System.out.print("Enter Book Price: ");
		b1.setPrice(sc.nextFloat());
		sc.nextLine(); // Consume newline

		System.out.print("Enter Publisher: ");
		b1.setPublisher(sc.nextLine());

		System.out.println("\n******** Book Details ********");
		b1.display();

		System.out.println("Discounted Price : " + b1.discountPrice());

		// Calls toString()
		System.out.println(b1);

		Book b2=new Book();
		Scanner s=new Scanner(System.in);

		System.out.println();
		System.out.println("Enter Book Id, Name, Price & Publisher :");
		b2.setBookId(s.nextInt());
		s.nextLine();
		b2.setBookName(s.nextLine());
		b2.setPrice(s.nextFloat());
		s.nextLine();
		b2.setPublisher(s.nextLine());
		s.close();

		b2.display();
		System.out.println("************** Book Details *********************");
		System.out.println("Book Id                  :"+b2.getBookId());
		System.out.println("Book Name                :"+b2.getBookName());
		System.out.println("Book Price               :"+b2.getPrice());
		System.out.println("Book Publisher           :"+b2.getPublisher());
		System.out.println("Discounted Price of Book :"+b2.discountPrice());
		System.out.println("-------------------------------------------------");

		System.out.println(b2);// invokes toString() method of the instance class

		sc.close();
	}
}