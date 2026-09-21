/**
	 * Author :sushank2
	 * Date :04-Jul-2026
	 * Time :12:43:26 pm
	 * Email : saisushankindroji1476@gmail.com
	 */

package controlflow;

import java.util.Scanner;

/*
 * Java Program to Check whether a Number is Single Digit or Not
 */
public class SingleDigit {

    public static void main(String[] args) {

        int num;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a Number : ");
        num=scan.nextInt();
        
        if (num>=-9 && num<=9) {
        	System.out.println("is a single digit");
        }
        else {
        	System.out.println("is not a single digit");
        }
        
    }
}
