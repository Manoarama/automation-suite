package question.example.test;

public class SecondLargestNumberInArrayFinder_publicisSapient {

    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 1, 9, 7};
        try {
            int secondLargest = findSecondLargest(arr);
            System.out.println("Second largest element: " + secondLargest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        boolean foundSecond = false;

        for (int num : arr) {
            if (num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest && num != firstLargest) {
                secondLargest = num;
                foundSecond = true;
            }
        }

        if (!foundSecond) {
            throw new IllegalArgumentException("No second largest element found (all elements may be equal).");
        }

        return secondLargest;
    }
}
