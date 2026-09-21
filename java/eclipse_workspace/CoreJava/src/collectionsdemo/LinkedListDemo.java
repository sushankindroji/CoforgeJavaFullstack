/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :12:33:24 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {

		LinkedList<String> friends = new LinkedList<>();

		// Adding elements
		friends.add("Rajeev");
		friends.add("John");
		friends.add("David");
		friends.add("Chris");
		friends.add("John");

		System.out.println("Initial LinkedList : " + friends);

		// Add at specific index
		friends.add(3, "Lisa");
		System.out.println("After add(3, \"Lisa\") : " + friends);

		// Add at beginning
		friends.addFirst("Steve");
		System.out.println("After addFirst(\"Steve\") : " + friends);

		// Add at end
		friends.addLast("Jennifer");
		System.out.println("After addLast(\"Jennifer\") : " + friends);

		// Another collection
		List<String> familyFriends = new ArrayList<>();
		familyFriends.add("Jesse");
		familyFriends.add("Walt");

		friends.addAll(familyFriends);

		System.out.println("After addAll(familyFriends) : " + friends);

		System.out.println("*********** Retrieve Elements *************");

		System.out.println("First Friend : " + friends.getFirst());
		System.out.println("Last Friend : " + friends.getLast());
		System.out.println("Friend at Index 3 : " + friends.get(3));
		System.out.println("Delete Walt : " + friends.remove("Walt"));
		System.out.println("Index of John : " + friends.indexOf("John"));

		System.out.println("\nLinked List Contents:");

		for (String s : friends) {
			System.out.println(s);
		}
	}
}