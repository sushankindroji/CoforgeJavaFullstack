package controlflow;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :10:44:42 am
 * Email : saisushankindroji1476@gmail.com
 */

import java.util.Scanner;

public class SumSeries {
    public static void main(String[] args) {

        int num, i = 1, sum = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a limit :");
        num = scan.nextInt();
        scan.close();

        while (i <= num) {
            sum = sum + i;
            i = i + 1;
            // System.out.println("The Sum of Series is : " + sum);
        }
        System.out.println("The Sum of Series is : " + sum);
    }
}
