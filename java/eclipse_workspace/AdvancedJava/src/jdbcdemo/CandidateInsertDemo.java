/**
 * Author :sushank2
 * Date :13-Jul-2026
 * Time :3:10:24 pm
 * Email : saisushankindroji1476@gmail.com
 * JDBC OOP program that inserts candidate records into a candidates table using PreparedStatement 
 * and Scanner for user input.
 * 
 * Advantages of this OOP Design
 * Candidate Class → Encapsulates candidate data (POJO/Bean).
 * CandidateDAO Class → Handles all database operations (DAO Pattern).
 * Main Class → Only manages user interaction and program flow.
 * Loose Coupling → Database logic is separated from business logic.
 * Reusability → CandidateDAO can be reused for Update, Delete, Search, and Display operations.
 * Scalability → Easy to extend into a complete CRUD application following OOP princ
 */

package jdbcdemo;

import java.util.Scanner;

public class CandidateInsertDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CandidateDAO dao = new CandidateDAO();

		System.out.println("==================================");
		System.out.println(" Candidate Registration System");
		System.out.println("==================================");

		System.out.print("How many candidate records do you want to insert? ");

		int count = sc.nextInt();
		sc.nextLine(); // consume newline

		for (int i = 1; i <= count; i++) {

			System.out.println("\nEnter Candidate " + i + " Details");

			Candidate candidate = new Candidate();

			System.out.print("First Name : ");
			candidate.setFirstName(sc.nextLine());

			System.out.print("Last Name  : ");
			candidate.setLastName(sc.nextLine());

			System.out.print("DOB (yyyy-mm-dd) : ");
			candidate.setDob(sc.nextLine());

			System.out.print("Phone Number : ");
			candidate.setPhone(sc.nextLine());

			System.out.print("Email : ");
			candidate.setEmail(sc.nextLine());

			boolean status = dao.insertCandidate(candidate);

			if (status) {
				System.out.println("✅ Candidate " + i + " inserted successfully.");
			} else {
				System.out.println("❌ Failed to insert Candidate " + i);
			}
		}

		System.out.println("\n==================================");
		System.out.println("All records processed.");
		System.out.println("==================================");

		sc.close();
	}

}
