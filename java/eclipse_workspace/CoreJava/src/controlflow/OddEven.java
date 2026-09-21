/**
	 * Author :sushank2
	 * Date :04-Jul-2026
	 * Time :12:43:53 pm
	 * Email : saisushankindroji1476@gmail.com
	 */
package controlflow;

/**
 * 
 */

import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        
        int num;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a Number : ");
        num = scanner.nextInt();
        
        if (num % 2 == 0) {
            System.out.println(num + " is a Even Number");
        }
        else {
            System.out.println(num + " is a Odd Number");
        }
        
        scanner.close();
    }
}
