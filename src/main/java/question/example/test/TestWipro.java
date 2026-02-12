package question.example.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestWipro {
    public static void main(String[] args) {
        String str="Manorama Singh" ;

       /* String words[]=str.split(" ");
        char[] chars=words[0].toCharArray();
        String result="";
        for (int i=chars.length-1;i>=0;i--){
            result=result+chars[i];
        }
        result=result+" "+words[1];
        System.out.println(result);*/

        Map<Character,Integer> map=new HashMap<>();
        char[] chars=str.toLowerCase().toCharArray();
        for(char c: chars){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else
                map.put(c,0);
        }
        System.out.println(map);
        for(Map.Entry<Character,Integer> entry :map.entrySet()) {
            if (entry.getKey()>1){
                System.out.println("Key and values greater than1 are"+entry.getKey()+": "+entry.getValue());
            }
        }

    }


}
