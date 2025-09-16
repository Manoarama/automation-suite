package Question;

import java.util.Arrays;
import java.util.List;

public class Testeproductivity {
    public static void main(String[] args) {
/*        String input = "azonam";

        char[] chars = input.toCharArray();
        Arrays.sort(chars);

        String output = new String(chars);
        System.out.println(output); // amazon*/
        List<String> input =Arrays.asList("Alice","Rob","Andrew","Adam","Charlee");
        List<String> result= getListinAccendingOrder(input);
    }

    private static List<String> getListinAccendingOrder(List<String> input) {
        List<String> result = List.of();

        for(String s:input){
            char [] c=s.toCharArray();
            for(int i=0;i<c.length;i++){
              if(c[i]=='a'){


              }

            }


        }

        return result;
    }
}
