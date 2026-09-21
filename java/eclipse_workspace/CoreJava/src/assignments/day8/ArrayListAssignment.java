/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:29:03 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListAssignment {
	public static void main(String[] args) {

		// Create ArrayList and add colors
		ArrayList<String> colors = new ArrayList<>();

		colors.add("Red");
		colors.add("Blue");
		colors.add("Green");
		colors.add("Yellow");
		colors.add("Black");

		System.out.println("Original ArrayList:");
		System.out.println(colors);

		// Iterate through all elements
		System.out.println("\nIterating through ArrayList:");
		for (String color : colors) {
			System.out.println(color);
		}

		// Insert an element at first position
		colors.add(0, "White");
		System.out.println("\nAfter inserting White at first position:");
		System.out.println(colors);

		// Retrieve element at specified index
		System.out.println("\nElement at index 2: " + colors.get(2));

		// Update specific element
		colors.set(3, "Pink");
		System.out.println("\nAfter updating index 3:");
		System.out.println(colors);

		// Remove third element
		colors.remove(2);
		System.out.println("\nAfter removing third element:");
		System.out.println(colors);

		// Search an element
		String search = "Green";
		if (colors.contains(search))
			System.out.println("\nGreen is found.");
		else
			System.out.println("\nGreen is not found.");

		// Sort ArrayList
		Collections.sort(colors);
		System.out.println("\nSorted ArrayList:");
		System.out.println(colors);

		// Copy one ArrayList into another
		ArrayList<String> copyList = new ArrayList<>(colors);
		System.out.println("\nCopied ArrayList:");
		System.out.println(copyList);

		// Shuffle elements
		Collections.shuffle(colors);
		System.out.println("\nShuffled ArrayList:");
		System.out.println(colors);

		// Reverse elements
		Collections.reverse(colors);
		System.out.println("\nReversed ArrayList:");
		System.out.println(colors);

		// Extract a portion
		List<String> subList = colors.subList(1, 4);
		System.out.println("\nExtracted Portion:");
		System.out.println(subList);

		// Replace second element
		colors.set(1, "Orange");
		System.out.println("\nAfter replacing second element:");
		System.out.println(colors);
	}
}