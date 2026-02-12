package question.example.leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class SortThePeople_2418 {

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // sort by height descending
       // Arrays.sort(indices, (a, b) -> Integer.compare(heights[b], heights[a]));
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(heights[b], heights[a]);
            }
        };
        Arrays.sort(indices, comparator);

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = names[indices[i]];
        }

        return result;
    }
    public static void main(String[] args) {

        SortThePeople_2418 sol = new SortThePeople_2418();

        // ✅ Test Case 1 (Given example)
        String[] names1 = {"Mary","John","Emma"};
        int[] heights1 = {180,165,170};
        System.out.println("Test1: " + Arrays.toString(sol.sortPeople(names1, heights1)));

        // ✅ Test Case 2 (Already sorted descending)
        String[] names2 = {"A","B","C"};
        int[] heights2 = {190,180,170};
        System.out.println("Test2: " + Arrays.toString(sol.sortPeople(names2, heights2)));

        // ✅ Test Case 3 (Ascending heights)
        String[] names3 = {"X","Y","Z"};
        int[] heights3 = {150,160,170};
        System.out.println("Test3: " + Arrays.toString(sol.sortPeople(names3, heights3)));

        // ✅ Test Case 4 (Single element)
        String[] names4 = {"Solo"};
        int[] heights4 = {155};
        System.out.println("Test4: " + Arrays.toString(sol.sortPeople(names4, heights4)));

        // ✅ Test Case 5 (Random order)
        String[] names5 = {"Rahul","Aman","Neha","Priya"};
        int[] heights5 = {172,181,165,176};
        System.out.println("Test5: " + Arrays.toString(sol.sortPeople(names5, heights5)));
    }
}
