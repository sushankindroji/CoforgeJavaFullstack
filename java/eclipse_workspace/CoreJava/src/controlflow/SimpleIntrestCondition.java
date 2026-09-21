package controlflow;

/**
 * Author : sushank2
 * Date : 04-Jul-2026
 * Program to Calculate Simple Interest for a Loan Amount
 */

import java.util.Scanner;

public class SimpleIntrestCondition {

    public static void main(String[] args) {

        String customerName;
        double principal;
        double si;
        int term, rate;

        // Create Scanner object
        Scanner scan = new Scanner(System.in);

        // Input
        System.out.println("*********** Soft Bank - Simple Interest Calculation *********");

        System.out.print("Enter Customer Name : ");
        customerName = scan.nextLine();

        System.out.print("Enter Loan Amount : ");
        principal = scan.nextDouble();

        System.out.print("Enter Loan Term (Years) : ");
        term = scan.nextInt();

        System.out.print("Enter Rate of Interest : ");
        rate = scan.nextInt();

        // Condition
        if (principal > 100000) {

            si = (principal * rate * term) / 100;

            System.out.println("\n*********** Simple Interest Calculation ***********");
            System.out.println("Customer Name        : " + customerName);
            System.out.println("Loan Amount          : " + principal);
            System.out.println("Loan Term            : " + term + " Years");
            System.out.println("Rate of Interest     : " + rate + "%");
            System.out.println("---------------------------------------------------");
            System.out.println("Simple Interest      : " + si);
            System.out.println("***************************************************");

        } else {

            System.out.println("\nNot Eligible for Loan. Please avail above Rs. 1,00,000.");
        }

        scan.close();
    }
}