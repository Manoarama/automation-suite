package question.example.test;

public class SecondLargestFinder {
    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 1, 9, 7};
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("No second largest element found.");
        } else {
            System.out.println("Second largest element: " + second);
        }
    }
}
