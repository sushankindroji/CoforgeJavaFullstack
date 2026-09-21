/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :12:24:27 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.ArrayList;
import java.util.List;

public class ArraylistDemo2 {

	public static void main(String[] args) {

		// Create list of Books
		List<Book> bList = new ArrayList<>();

		// Creating Book objects
		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);

		// Add objects to ArrayList
		bList.add(b1);
		bList.add(b2);
		bList.add(b3);

		// Display books
		for (Book b : bList) {
			System.out.println(b);
		}
	}
}
