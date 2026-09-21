package controlflow;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :12:03:39 pm
 * Email : saisushankindroji1476@gmail.com
 */

import java.util.Scanner;

public class ShoppingBill{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();

        double totalBill = 0;

        // loop for each item
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter price of item " + i + ": ");
            double price = scanner.nextDouble();

            System.out.print("Enter quantity of item " + i + ": ");
            int qty = scanner.nextInt();

            double itemTotal = price * qty;
            totalBill += itemTotal;

            System.out.println("Item " + i + " cost = " + itemTotal + "\n");
        }

        System.out.println("===============================");
        // Completing the missing part:
        System.out.println("Total Bill: " + totalBill);
        System.out.println("Thanks for shopping with us!");
        
        scanner.close();
    }
}
