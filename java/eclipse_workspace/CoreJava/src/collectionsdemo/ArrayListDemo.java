/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :11:21:01 am
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

/**
 * ==********************************************************
 * List data structure maintains order of elemnts and stores duplicates
 * ******************************************************************
 */


import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {

	public static void main(String[] args) {


		ArrayList<String> a1=new ArrayList<>();

		a1.add("Java");
		a1.add("c++");
		a1.add("perl");
		a1.add("python");
		a1.add("java");
		a1.add("perl");

		System.out.println(a1);

		ArrayList<Integer> a2= new ArrayList<>();

		a2.add(100);
		a2.add(300);
		a2.add(200);
		System.out.println(a2);

		System.out.println("Element at index 1 is"+a1.get(1));

		System.out.println("does list contains elemnt java ?"+a1.contains("java"));

		System.out.println("**************");

		a1.add(2,"oracle");
		System.out.println(a1);
		System.out.println("*****************");
		System.out.println("Is Arraylist Empty ? :"+a1.isEmpty());
		System.out.println("Index of perl :"+a1.indexOf("Perl"));
		System.out.println("size of arraylist :"+a1.size());

		Collections.sort(a1);
		System.out.println("array list after sorting"+a1);

		//a1.add(100);


	}

}
