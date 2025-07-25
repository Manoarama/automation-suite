package question.example.test;

import java.sql.Array;
import java.util.HashMap;
import java.util.*;

public class Test2 {/*
    I/p = MANORAMA
    o/p = M-1, A-3, N-1..
    I=[1,0,2,0,5,8,7,6,0,4,0,1,0,2]
    o/p= 1,2,4,5,6,7,8,0,0,0,0,0

     Array1 = [“a”, “b”, “c”, “d”, “e”, “f”],
           Array2 = [“b”, “d”, “e”, “h”, “g”, “c”]
Output: [b, c, d, e]
        7
      6 7
     5 6 7
    4 5 6 7
   3 4 5 6 7
  2 3 4 5 6 7
1 2 3 4 5 6 7

3
23
123
    */

    public static void main(String[] args) {

        String [] arrays1={"a","b", "c", "d",  "e", "f"};
        String [] arrays2={"b",  "d",  "e", "h",  "g", "c"};

        for(int i=3;i<=1 ;i--){
            for(int j=i-1;j<=4;j++){//
                System.out.println(j);
            }

        }

        }

}

