package question.example.test;

import java.util.*;

public class ArrayOfStringIntersection {
    public static void main(String[] args) {
        String[] array1 = {"a", "b", "c", "d", "e", "f"};
        String[] array2 = {"b", "d", "e", "h", "g", "c"};
        String[] result = intersection(array1, array2);
        System.out.println(Arrays.toString(result));
    }

private static String[] intersection(String[] array1, String[] array2) {

    Set<String> set1 = new HashSet<>(Arrays.asList(array1));
    Set<String> resultSet = new LinkedHashSet<>();

    for (String s : array2) {
        if (set1.contains(s)) {
            resultSet.add(s);
        }
    }

    return resultSet.toArray(new String[0]);
}}
