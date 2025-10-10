package question.example.leetCode;
//Write a Java program to find the first non-repeating character in a string: String s= "jjavavbvc"; //b
import java.util.HashMap;

public class InfoBean {
    public static void main(String[] args) {
        String s = "jjavavbvc";
        char result = getFirstNonRepeating(s);
        if (result != '\0') {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }

    private static char getFirstNonRepeating(String s) {
        HashMap<Character,Integer> charCountMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            charCountMap.put(s.charAt(i),charCountMap.getOrDefault(s.charAt(i),0)+1);
        }
        //for(charCountMap.get())
        for(int i=0;i<s.length();i++){
           if(charCountMap.get(s.charAt(i))==1){
            return s.charAt(i);
        }}
        return 0;
    }




}
