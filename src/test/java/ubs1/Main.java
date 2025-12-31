package ubs1;

public class Main {
    public static void main(String[] args) {

        PaymentMethod pm;

        pm = new CreditCardPaymentMethod("1234-5678-9101-1121", "123", "12/23", "JohnDoe");
        pm.pay(119.858);

        pm = new PayPalPaymentMethod("amy.white@example.com", "password987");
        pm.pay(124.468);
    }
}


