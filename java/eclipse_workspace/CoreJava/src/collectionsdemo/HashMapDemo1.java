/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :3:50:50 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo1 {

	public static void main(String[] args) {

		// HashMap to store Customer Name and Bank Balance
		HashMap<String, Double> hm = new HashMap<>();

		// Adding key-value pairs
		hm.put("Ram", 4599.09);
		hm.put("Jim", 5000.45);
		hm.put("King", 5000.09);
		hm.put("Goat", 4500.09);

		// Displaying customer names and balances
		System.out.println("Customer Name\tBalance");
		System.out.println("---------------------------");

		for (String key : hm.keySet()) {
			System.out.println(key + " -------> " + hm.get(key));
		}

		// deposit 1000 to Jim's Account- Update value
		double bal=hm.get("Jim");
		hm.put("Jim",bal+1000);
		System.out.println("Jim's new Balance is :"+hm.get("Jim"));

		hm.putIfAbsent("Raj", 500.00);

		System.out.println(hm);

		Scanner s=new Scanner(System.in);
		System.out.println("Enter Customer Name for his Balance :");
		String name=s.next();
		System.out.println("The Balance of "+name+ " is :"+hm.get(name));
	}
}


