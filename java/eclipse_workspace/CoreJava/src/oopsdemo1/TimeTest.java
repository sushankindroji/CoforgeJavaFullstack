/**
 * Author : Sushank2
 * Date   : 07-Jul-2026
 * Time   : 2:14:00 PM
 * Email  : saisushankindroji1476@gmail.com
 */

package oopsdemo1;

import java.util.Scanner;

public class TimeTest {

    public static void main(String[] args) {

        // Creating two Time objects
        Time t1 = new Time(12, 45, 55);
        Time t2 = new Time(10, 30, 30);

        System.out.print("Time 1 : ");
        t1.display();

        System.out.print("Time 2 : ");
        t2.display();

        // Add t2 to t1
        t1.add(t2);

        System.out.print("After Addition : ");
        t1.display();

        // ---------------- User Input ----------------
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter another time:");

        System.out.print("Enter Hours   : ");
        int h = sc.nextInt();

        System.out.print("Enter Minutes : ");
        int m = sc.nextInt();

        System.out.print("Enter Seconds : ");
        int s = sc.nextInt();

        // Create objects
        Time t3 = new Time(12, 45, 55);
        Time t4 = new Time(h, m, s);

        System.out.print("\nTime 3 : ");
        t3.display();

        System.out.print("Time 4 : ");
        t4.display();

        // Add t4 to t3
        t3.add(t4);

        System.out.print("After Addition : ");
        t3.display();

        sc.close();
    }
}