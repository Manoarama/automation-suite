package question.recurssion;

public class PrintNumberDecendingOrder {
    public static void main(String[] args) {
        int n = 5;
        printNumber(n);
    }

    public static void printNumber(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNumber(n - 1);


    }
}
