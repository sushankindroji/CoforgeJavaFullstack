package controlflow;

/**
 * Author :sushank2
 * Date :04-Jul-2026
 * Time :12:39:29 pm
 * Email : saisushankindroji1476@gmail.com
 */

import java.util.Scanner;

public class Greatest3 {
    public static void main(String[] args) {
    	int a, b, c;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter 3 Numbers : ");
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();

        if (a > b && a > c) {
            System.out.println(a + " Is Greatest");
        } 
        else if (b > c) {
            System.out.println(b + " Is Greatest");
        } 
        else {
            System.out.println(c + " Is Greatest");
        }
        
        scan.close();
    }
}