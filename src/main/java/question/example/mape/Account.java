package question.example.mape;
 /*   Create a class called Account, which maintains the balance,and allows you to deposit and withdraw money.
        Whenever the balance of the account goes below zero,and will raise an exception.  */
 class InsufficientBalanceException extends Exception {
     public InsufficientBalanceException(String message) {
         super(message);
     }
 }

public class Account {
    private double balance;
    public Account(double InitialBalance) {
        this.balance = InitialBalance;
    }

public void deposit(double amount){
     if(amount>0){
         balance=balance+amount;
         System.out.println("Deposited: " + amount + ", New Balance: " + balance);
     }
     else
         System.out.println("Invalid deposit amount.");

}

    private void withdraw(double amount)throws InsufficientBalanceException {
        if(balance<=0){
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        balance=balance-amount;
        if(balance<0){
            throw new InsufficientBalanceException("Balance cannot go beyond zero");
        }
    }
    public static void main(String[] args) {
        Account myccount=new Account(100);
        myccount.deposit(100);
        try {
            myccount.withdraw(100);
        } catch (InsufficientBalanceException e) {
            throw new RuntimeException(e);
        }

    }
}
