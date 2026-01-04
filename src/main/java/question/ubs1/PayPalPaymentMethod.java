package question.ubs1;

public class PayPalPaymentMethod implements PaymentMethod {

    public PayPalPaymentMethod(String email, String password) {
        // required constructor
    }
    @Override
    public void pay(double amount) {

        double first = amount / 2;
        double second = first * 1.05;

        System.out.println("Paying $" + Utils.roundDouble(amount) +
                        " via PayPal using Installment Payment Plan.");

        System.out.println("Paid $" + Utils.roundDouble(first) +
                " in first installment.");

        System.out.println("Paid $" + Utils.roundDouble(second) +
                        " in second installment with 5% interest.");
    }
}


