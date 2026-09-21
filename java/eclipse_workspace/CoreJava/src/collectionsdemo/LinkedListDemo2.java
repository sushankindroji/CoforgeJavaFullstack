/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :12:46:35 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.LinkedList;

public class LinkedListDemo2 {

	public static void main(String[] args) {

		LinkedList<String> linkedlist = new LinkedList<>();

		linkedlist.add("Item1");
		linkedlist.add("Item5");
		linkedlist.add("Item3");
		linkedlist.add("Item6");
		linkedlist.add("Item2");

		System.out.println("Linked List Content: " + linkedlist);

		// Add at tail
		linkedlist.offer("Item100");
		System.out.println("After offer(): " + linkedlist);

		// Add first & last
		linkedlist.addFirst("First Item");
		linkedlist.addLast("Last Item");

		System.out.println("After addFirst() & addLast(): " + linkedlist);

		// Get element
		String first = linkedlist.get(0);
		System.out.println("First Element: " + first);

		// Update element
		linkedlist.set(0, "Changed First Item");

		System.out.println("After set(): " + linkedlist);

		String s = linkedlist.get(0);
		System.out.println("Updated First Element: " + s);

		// Remove first & last
		linkedlist.removeFirst();
		linkedlist.removeLast();

		System.out.println("After removeFirst() & removeLast(): " + linkedlist);

		// Add & Remove by index
		linkedlist.add(0, "Newly Added Item");
		linkedlist.remove(2);

		System.out.println("Final Content: " + linkedlist);
	}
}