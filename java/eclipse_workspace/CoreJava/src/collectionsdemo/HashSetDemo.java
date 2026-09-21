/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :2:26:10 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {

		Set<String> programmingLanguages = new HashSet<>();

		programmingLanguages.add("C");
		programmingLanguages.add("C++");
		programmingLanguages.add("Java");
		programmingLanguages.add("Python");
		programmingLanguages.add("PHP");
		programmingLanguages.add("Ruby");

		// Duplicate values are ignored
		programmingLanguages.add("Java");

		// Only one null is allowed
		programmingLanguages.add(null);
		programmingLanguages.add(null);

		System.out.println("=== Iterate using Iterator ===");

		Iterator<String> programmingLanguageIterator = programmingLanguages.iterator();

		while (programmingLanguageIterator.hasNext()) {
			String programmingLanguage = programmingLanguageIterator.next();
			System.out.println(programmingLanguage);
		}

		System.out.println("\n=== Iterate using Enhanced For Loop ===");

		for (String programmingLanguage : programmingLanguages) {
			System.out.println(programmingLanguage);
		}

		HashSet<String> pl = new HashSet<>(programmingLanguages);

		System.out.println("\nOriginal HashSet:");
		System.out.println(pl);

		// Clone HashSet
		Object clonepl = pl.clone();

		System.out.println("\nCloned HashSet:");
		System.out.println(clonepl);
	}
}