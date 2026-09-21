/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :3:00:37 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.LinkedHashSet;

public class LinkedHashset {

	public static void main(String[] args) {


		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

		linkedHashSet.add("Apple");
		linkedHashSet.add("Banana");
		linkedHashSet.add("Cherry");
		linkedHashSet.add("Date");
		linkedHashSet.add("Elderberry");

		System.out.println("LinkedHashSet: " + linkedHashSet);

		// Adding duplicate element
		boolean isAdded = linkedHashSet.add("Apple");
		System.out.println("Attempt to add duplicate 'Apple': " + isAdded);

		// Manipulating elements
		linkedHashSet.remove("Date");
		System.out.println("After removing 'Date': " + linkedHashSet);

		// Checking if an element exists
		boolean containsCherry = linkedHashSet.contains("Cherry");
		System.out.println("Contains 'Cherry': " + containsCherry);

		// Iterating through the LinkedHashSet
		System.out.println("Iterating through LinkedHashSet:");
		for (String fruit : linkedHashSet) {
			System.out.println(fruit);
		}

		// Size of the LinkedHashSet
		int size = linkedHashSet.size();
		System.out.println("Size of LinkedHashSet: " + size);

		//Create LinkedHashSet of Integers
		LinkedHashSet<Integer> linkedHashSetInt = new LinkedHashSet<>();
		linkedHashSetInt.add(10);
		linkedHashSetInt.add(20);
		linkedHashSetInt.add(30);
		System.out.println("LinkedHashSet of Integers: " + linkedHashSetInt);
	}

}

