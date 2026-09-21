package controlflow;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :11:33:04 am
 * Email : saisushankindroji1476@gmail.com
 */

import java.util.Scanner;

/*
 * Program to enter a Positive Number & display it
 */
public class DoWhileDemo {

    public static void main(String[] args) {

        int number;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter a Number : ");
            number = scanner.nextInt();
            System.out.println(number);
        } while (number > 0);

        System.out.println("The Entered Number is : " + number);

        scanner.close();
    }
}
