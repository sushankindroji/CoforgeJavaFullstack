/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :2:30:20 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HashSetDemo2 {

	public static void main(String[] args) {

		Set<String> fruits = new HashSet<>();

		// add()
		fruits.add("Apple");
		fruits.add("Banana");

		// isEmpty()
		System.out.println("fruits set is empty = " + fruits.isEmpty());

		// contains()
		System.out.println("fruits contains Apple = " + fruits.contains("Apple"));
		System.out.println("fruits contains Mango = " + fruits.contains("Mango"));

		// remove()
		System.out.println("Apple removed = " + fruits.remove("Apple"));
		System.out.println("Mango removed = " + fruits.remove("Mango"));

		// size()
		System.out.println("fruits size = " + fruits.size());

		// addAll()
		List<String> list = new ArrayList<>();

		list.add("Apple");
		list.add("Apple");
		list.add("Banana");
		list.add("Mango");

		System.out.println("\nfruits before addAll = " + fruits);
		System.out.println("List = " + list);

		fruits.addAll(list);

		System.out.println("fruits after addAll = " + fruits);

		// Iterator
		Iterator<String> iterator = fruits.iterator();

		while (iterator.hasNext()) {
			System.out.println("Consuming Fruit : " + iterator.next());
		}

		System.out.println("\nHashSet Contents : " + fruits);

		// Convert HashSet to TreeSet
		TreeSet<String> treeSet = new TreeSet<>(fruits);

		System.out.println("Converted to TreeSet : " + treeSet);

		// removeAll()
		fruits.add("Orange");

		System.out.println("\nfruits before removeAll = " + fruits);

		fruits.removeAll(list);

		System.out.println("fruits after removeAll = " + fruits);

		// clear()
		fruits.clear();

		System.out.println("After clear(), isEmpty = " + fruits.isEmpty());
	}
}