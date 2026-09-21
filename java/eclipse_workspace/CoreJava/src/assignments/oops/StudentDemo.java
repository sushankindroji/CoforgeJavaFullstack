/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:17:10 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.oops;

import java.util.Scanner;

public class StudentDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Student students[] = new Student[3];

		for (int i = 0; i < students.length; i++) {

			System.out.println("\nEnter Details of Student " + (i + 1));

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Year Of Joining: ");
			int year = Integer.parseInt(sc.nextLine());

			System.out.print("Address: ");
			String address = sc.nextLine();

			students[i] = new Student(name, year, address);
		}

		System.out.println("\n---------------------------------------------");
		System.out.printf("%-10s %-18s %s%n",
				"Name", "Year Of Joining", "Address");
		System.out.println("---------------------------------------------");

		for (Student s : students) {
			s.displayStudent();
		}

		sc.close();
	}
}
