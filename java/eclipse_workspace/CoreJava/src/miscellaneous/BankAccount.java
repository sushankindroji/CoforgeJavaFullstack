/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:49:46 am
 * Email : saisushankindroji1476@gmail.com
 * 
 * 
 * 
 * 
 * String → Stores immutable customer details (Name, Account Number, Account Type).
StringBuffer → Generates a thread-safe transaction history.
StringBuilder → Generates the account statement efficiently.

 *Class			Banking Usage		Example***
String			Customer Name, 		Account Number (as text), Branch Name, Account Type	Immutable data that rarely changes
StringBuffer	Transaction History	Multiple transactions appended safely (thread-safe)
StringBuilder	Account Statement, 	Mini Statement, Loan Summary	Faster string construction for reports (non-thread-safe)

 */

package miscellaneous;

public class BankAccount {

    private final int accountNumber;
    private final String customerName;
    private final String accountType;
    private double balance;

    public BankAccount(int accountNumber, String customerName,
                       String accountType, double balance) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Deposit
    public void deposit(double amount, StringBuffer transactionHistory) {

        balance += amount;

        transactionHistory
                .append("Deposited ₹")
                .append(amount)
                .append(" | Balance : ₹")
                .append(balance)
                .append("\n");
    }

    // Withdraw
    public void withdraw(double amount, StringBuffer transactionHistory) {

        if (amount <= balance) {

            balance -= amount;

            transactionHistory
                    .append("Withdrawn ₹")
                    .append(amount)
                    .append(" | Balance : ₹")
                    .append(balance)
                    .append("\n");

        } else {

            transactionHistory
                    .append("Withdrawal Failed (Insufficient Balance)\n");
        }
    }

    public String generateStatement(StringBuffer transactionHistory) {

        StringBuilder statement = new StringBuilder();

        statement.append("\n=====================================\n");
        statement.append("        BANK ACCOUNT STATEMENT\n");
        statement.append("=====================================\n");
        statement.append("Account Number : ").append(accountNumber).append("\n");
        statement.append("Customer Name  : ").append(customerName).append("\n");
        statement.append("Account Type   : ").append(accountType).append("\n");
        statement.append("Current Balance: ₹").append(balance).append("\n");
        statement.append("-------------------------------------\n");
        statement.append("Transaction History\n");
        statement.append("-------------------------------------\n");
        statement.append(transactionHistory);
        statement.append("=====================================\n");

        return statement.toString();
    }
}