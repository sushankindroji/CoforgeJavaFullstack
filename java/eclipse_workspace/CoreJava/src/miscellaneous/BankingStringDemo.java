/**
 * Author : sushank2
 * Date : 10-Jul-2026
 * Time : 9:52:36 am
 * Email : saisushankindroji1476@gmail.com
 */

package miscellaneous;

public class BankingStringDemo {

    public static void main(String[] args) {

        String bankName = "ABC National Bank";

        System.out.println("Welcome to " + bankName);

        BankAccount customer = new BankAccount(
                101001,
                "Rajashekar",
                "Savings",
                50000);

        StringBuffer transactionHistory = new StringBuffer();

        customer.deposit(10000, transactionHistory);
        customer.withdraw(5000, transactionHistory);
        customer.deposit(2500, transactionHistory);
        customer.withdraw(70000, transactionHistory);

        String statement =
                customer.generateStatement(transactionHistory);

        System.out.println(statement);

        // String Immutability

        String branch = "Hyderabad";

        System.out.println("Original Branch : " + branch);

        branch.concat(" Main Branch");

        System.out.println("After concat()  : " + branch);

        branch = branch.concat(" Main Branch");

        System.out.println("After Reassign  : " + branch);
    }
}