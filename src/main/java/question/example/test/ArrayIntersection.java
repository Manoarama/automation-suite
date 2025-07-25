package question.example.test;

import java.util.*;

public class ArrayIntersection {
    public static void main(String[] args) {
        String[] array1 = {"a", "b", "c", "d", "e", "f"};
        String[] array2 = {"b", "d", "e", "h", "g", "c"};

        // Convert Array2 to a Set for O(1) lookup
        Set<String> set2 = new HashSet<>(Arrays.asList(array2));

        // Use TreeSet to get sorted + unique intersection result
        Set<String> intersection = new TreeSet<>();

        for (String val : array1) {
            if (set2.contains(val)) {
                intersection.add(val);
            }
        }

        // Print result
        System.out.println("Output: " + intersection);
    }
}
