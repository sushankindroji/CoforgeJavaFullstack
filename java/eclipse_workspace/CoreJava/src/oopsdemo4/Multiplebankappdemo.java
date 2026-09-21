/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :10:59:56 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo4;

import java.util.Scanner;

public class Multiplebankappdemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Customers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("\n========== Customer " + i + " ==========");

            System.out.print("Enter Customer ID: ");
            int customerId = sc.nextInt();

            System.out.print("Enter Account Number: ");
            long accountNumber = sc.nextLong();
            sc.nextLine();

            System.out.print("Enter Customer Name: ");
            String customerName = sc.nextLine();

            System.out.print("Enter Mobile Number: ");
            long mobileNumber = sc.nextLong();
            sc.nextLine();

            System.out.print("Enter Account Type (Savings/Current): ");
            String accountType = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            BankAccount account = new BankAccount(
                    customerId,
                    customerName,
                    mobileNumber,
                    accountNumber,
                    accountType,
                    balance);

            account.displayAccount();

            System.out.print("\nEnter Deposit Amount: ");
            double deposit = sc.nextDouble();
            account.deposit(deposit);

            System.out.print("Enter Withdraw Amount: ");
            double withdraw = sc.nextDouble();
            account.withdraw(withdraw);

            sc.nextLine();

            System.out.print("Enter Beneficiary Name: ");
            String beneficiary = sc.nextLine();

            System.out.print("Enter Transfer Amount: ");
            double transfer = sc.nextDouble();

            account.transferMoney(transfer, beneficiary);

            account.checkBalance();

            System.out.println("\n========================================");
        }

        System.out.println("\nAll Customer Transactions Completed Successfully.");

        sc.close();
    }
}