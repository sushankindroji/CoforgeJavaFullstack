/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :4:08:29 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {


		TreeMap<String,String> fileExtensions=new TreeMap<>();

		// Adding new key-value pairs to a TreeMap
		fileExtensions.put("python", ".py");
		fileExtensions.put("c++", ".cpp");
		fileExtensions.put("kotlin", ".kt");
		fileExtensions.put("golang", ".go");
		fileExtensions.put("java", ".java");
		fileExtensions.put("java", ".java"); //duplicate key, value will be updated
		//  fileExtensions.put(null, ".java"); //null key not allowed in TreeMap

		//Tree map will be sorted based on keys
		System.out.println(fileExtensions);

		TreeMap<String,String> fileExtensions1=new TreeMap<String,String>(Comparator.reverseOrder());

		// Adding new key-value pairs to a TreeMap
		fileExtensions1.put("python", ".py");
		fileExtensions1.put("c++", ".cpp");
		fileExtensions1.put("kotlin", ".kt");
		fileExtensions1.put("golang", ".go");
		fileExtensions1.put("java", ".java");

		//Tree map will be sorted based on keys in descending order
		System.out.println(fileExtensions1);

	}

}
