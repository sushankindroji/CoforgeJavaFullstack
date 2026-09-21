/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :12:32:53 pm
 * Email : saisushankindroji1476@gmail.com
 * forEach() Method In Iterable Interface
		Java 8 has introduced a forEach method in the interface java.lang.Iterable that can 
		iterate over the elements in the collection.
		forEach is a default method defined in the Iterable interface. 
		It is used by the Collection classes that extend the Iterable 
		interface to iterate elements.

		The forEach method takes the Functional Interface as a single parameter i.e. 
		you can pass Lambda Expression as an argument.



		List<String> languages=new ArrayList<>(); // declare ArrayList
 */

package java8features;

import java.util.ArrayList;
import java.util.List;

public class ForEachDemo {

	public static void main(String[] args) {

		// Declare ArrayList
		List<String> languages = new ArrayList<>();

		// Add elements to List
		languages.add("Java");
		languages.add("Python");
		languages.add("C#");
		languages.add("Scala");
		languages.add("Ruby");
		languages.add("C++");

		System.out.println("********** Programming Languages *************");

		// Using Lambda Expression
		languages.forEach(i -> System.out.println(i));

		System.out.println("\n********** Print Elements using Method Reference *************");

		// Using Method Reference
		languages.forEach(System.out::println);
	}
}
