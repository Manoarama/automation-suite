package question.example.test;

public class AlternateCharacterLTIMCBS {

    public static void main(String[] args) {
    String input="Manorama Singh";
        String result=alternateCharacter(input);
        System.out.println(result);
    }
    public static String alternateCharacter(String input){
        String [] word=input.split(" ");
        StringBuilder sb=new StringBuilder();
        int max=Math.max(word[0].length(),word[1].length());
        for(int i=0;i<max;i++){
         if(i<word[0].length()){
            sb.append(Character.toLowerCase(word[0].charAt(i)));
         }
         if(i<word[1].length()){
             sb.append(Character.toLowerCase(word[1].charAt(i)));
         }
        }

        return sb.toString();
    }
}
