package question.example.leetCode;

public class Pattern {
    public static void main(String[] args) {
        int n =3;
        for (int i = 1; i <= n; i++) {
            // 1. Inner loop for spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("q");
            }

            // 2. Inner loop for stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Move to next line (missing in image, but assumed)
            System.out.println();
        }
    }


}
