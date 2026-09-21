/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :11:59:17 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class SavingsAccount extends Account {

	private double interestRate;

	public SavingsAccount(String name, double balance, double interestRate) {
		super(name, balance);
		this.interestRate = interestRate;
	}


}

class CheckingAccount extends Account {

    private double overDraft;

    public CheckingAccount(String name, double balance, double overDraft) {
        super(name, balance);
        this.overDraft = overDraft;
    }

    @Override
    void withdraw(double amt) {
        System.out.println("Overdraft Amount: " + overDraft);

        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawing: " + amt);
        } else if (amt > balance + overDraft) {
            System.out.println("Sorry! You cannot withdraw");
        } else {
            double result = amt - balance;
            overDraft -= result;
            balance = 0;

            System.out.println("Withdrawing: " + amt);
            System.out.println("Current Overdraft Amount: " + overDraft);
        }
    }
}