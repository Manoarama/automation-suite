package question.example.comparable;

import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
        Comparator<Integer> comparator=new Comparator <Integer>() {

            @Override
            public int compare(Integer i, Integer j) {
                if(i%10>j%10)
                return 1;
                else
                    return -1;
            }


        };
        List<Integer> nums=new ArrayList<>();
        nums.add(49);
        nums.add(48);
        nums.add(42);
        nums.add(41);
        Collections.sort(nums,comparator) ;
        System.out.println(nums);
    }

}
