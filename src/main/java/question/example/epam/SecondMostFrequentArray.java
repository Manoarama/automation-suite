package question.example.epam;
public class SecondMostFrequentArray {
    // Method to find the second largest element in an array
    public static int findSecondLargest(int[] arr) {
        // Check if the array has at least 2 elements
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > firstLargest) {
                secondLargest = firstLargest;  // update second largest
                firstLargest = num;            // update first largest
            } else if (num > secondLargest && num != firstLargest) {
                secondLargest = num;
            }
        }

        // If secondLargest is still Integer.MIN_VALUE, it means there's no second largest element
        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("There is no second largest element");
        }

        return secondLargest;
    }

    // Main method to test the program
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};  // Example array

        try {
            int secondLargest = findSecondLargest(arr);
            System.out.println("The second largest element is: " + secondLargest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
