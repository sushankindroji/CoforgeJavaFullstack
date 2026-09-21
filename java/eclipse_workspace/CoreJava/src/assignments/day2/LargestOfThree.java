/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:08:51 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day2;

import java.util.Scanner;

public class LargestOfThree {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int a = sc.nextInt();

        System.out.print("Enter Second Number: ");
        int b = sc.nextInt();

        System.out.print("Enter Third Number: ");
        int c = sc.nextInt();

        if (a >= b && a >= c)
            System.out.println("Largest Number is " + a);
        else if (b >= a && b >= c)
            System.out.println("Largest Number is " + b);
        else
            System.out.println("Largest Number is " + c);

        sc.close();
    }
}
