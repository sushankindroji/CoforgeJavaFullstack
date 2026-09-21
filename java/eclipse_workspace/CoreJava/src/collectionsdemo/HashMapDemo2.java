/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :4:04:38 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;

public class HashMapDemo2 {

	public static void main(String[] args) {


		HashMap<Integer,String> hmap=new HashMap<>();

		//add element to map
		hmap.put(12,"Ravi");
		hmap.put(22,"Rahul");
		hmap.put(7,"Singh");
		hmap.put(49,"Annie");
		hmap.put(3,"Amit");

		Set s=hmap.entrySet(); //returns entry from Map
		Set s1=hmap.keySet(); //Returns key

		System.out.println("Entries : "+s);
		System.out.println("Keys : "+s1);

		System.out.println("*******************Key set **********");
		Iterator itr1=s1.iterator();
		while(itr1.hasNext())
		{
			Integer key=(Integer) itr1.next();
			String value=hmap.get(key);
			System.out.println(key+"---->"+value);
			System.out.println("Display based on Key :"+hmap.get(key));
		}

		// get values based on key
		String name=hmap.get(7);
		System.out.println("The Name with key 7 is :"+name);

		// remove values based on key
		hmap.remove(2);
		System.out.println(hmap);

		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Empoyee Id to be Searched: ");
		Integer eid=scan.nextInt();

		System.out.println("The Employee Id with "+eid+" is : "+hmap.get(eid));

	}

}

