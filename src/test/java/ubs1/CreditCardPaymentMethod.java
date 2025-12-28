package ubs1;

public class CreditCardPaymentMethod implements PaymentMethod {
    public CreditCardPaymentMethod(String cardNumber,String cvv,
            String expiryDate,String cardHolderName) {
        // values are not required for logic
    }

    @Override
    public void pay(double amount) {

        double reward = Math.min(amount * 0.10, 10.0);
        double remaining = amount - reward;

        System.out.println("Paying $" + Utils.roundDouble(amount) +
                        " via Credit Card using Reward Points Redemption Feature.");

        System.out.println("Redeemed $" + Utils.roundDouble(reward) +
                        " using reward points.");

        System.out.println("Paying remaining amount of $" + Utils.roundDouble(remaining) +
                        " via credit card.");
    }
}


