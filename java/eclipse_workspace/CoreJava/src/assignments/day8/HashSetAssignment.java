/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:30:00 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day8;

import java.util.HashSet;
import java.util.Set;

public class HashSetAssignment {

	public static void main(String[] args) {

		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		// Elements for Set1
		set1.add(0);
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);

		// Elements for Set2
		set2.add(0);
		set2.add(1);
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set2.add(7);
		set2.add(8);
		set2.add(9);

		System.out.println("Set1 : " + set1);
		System.out.println("Set2 : " + set2);

		// Union
		Set<Integer> union = new HashSet<>(set1);
		union.addAll(set2);
		System.out.println("\nUnion : " + union);

		// Intersection
		Set<Integer> intersection = new HashSet<>(set1);
		intersection.retainAll(set2);
		System.out.println("Intersection : " + intersection);

		// Difference
		Set<Integer> difference = new HashSet<>(set1);
		difference.removeAll(set2);
		System.out.println("Difference : " + difference);

		// Difference (Set2 - Set1)
		Set<Integer> difference2 = new HashSet<>(set2);
		difference2.removeAll(set1);
		System.out.println("Difference (Set2 - Set1) : " + difference2);
	}
}
