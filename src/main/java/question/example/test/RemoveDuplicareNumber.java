package question.example.test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class RemoveDuplicareNumber {
    public static void main(String[] args) {
        int[] a = {8, 2, 5, 3};
        int[] b = {6, 4, 8, 3};
        int[] result = removeDuplicate(a, b);
        System.out.println(Arrays.toString(result));
    }

    static int[] removeDuplicate(int[] a, int[] b) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int x : a) {
            set.add(x);
        }
        for (int x : b) {
            set.add(x);
        }

        int[] result = new int[set.size()];
        int i = 0;
        for (int x : set) {
            result[i++] = x;
        }

        return result;
    }
}

