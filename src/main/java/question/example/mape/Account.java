package question.example.mape;
 /*   Create a class called Account, which maintains the balance,and allows you to deposit and withdraw money.
        Whenever the balance of the account goes below zero,and will raise an exception.  */
 class InsufficientFundsException extends Exception {
     public InsufficientFundsException(String message) {
         super(message);
     }
 }

public class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        balance -= amount;

        if (balance < 0) {
            throw new InsufficientFundsException("Withdrawal failed. Balance cannot go below zero.");
        }

        System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}
 class AccountTest {
    public static void main(String[] args) {
        Account myAccount = new Account(100.0);  // Starting with 100

        myAccount.deposit(50.0);  // Should be fine

        try {
            myAccount.withdraw(120.0);  // Should be fine, balance = 30
            myAccount.withdraw(50.0);   // Will cause exception
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
 }