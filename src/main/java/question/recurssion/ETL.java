package question.recurssion;

import java.util.ArrayList;

public class ETL {

/*    Write a program to print the Reverse of Pyramid
        * * * * * *
        * * * * *
        * * * *
        * * *
        * *
        *
    Int array1={8,3,0,4,2,6}
    Int array2={7,6,3,8,5,1,4,0,9}
    Wap to print Matched Elements between 2 Arrays and Unmatched elements.. ..
    Matched Elements: {0,3,4,6}
    UnMatched Elements: {1,5,8,9}}
print the output of these programes*/

    //Check the given String - LEVEL..check string is Palindrome string or not

    public static void main(String[] args) {
      //  printStar();
        getCommonArayElement();
    }

    private static void getCommonArayElement() {
        int []array1={8,3,0,4,2,6};
        int []array2={7,6,3,8,5,1,4,0,9};
        ArrayList matched=new ArrayList<>();
        ArrayList unMatched=new ArrayList<>();
        for(int i=0;i<array1.length-1;i++){
            for(int j=0;j<array2.length-1;j++){
                if(array1[i]==array2[j]){
                    matched.add(i);
                }
                else
                unMatched.add(j);
            }

        }
        System.out.println("matched"+matched);
        System.out.println("unMatched"+unMatched);


    }

    private static void printStar() {

        for (int i=0;i<7;i++){
            for (int j=6 ;j>1;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
