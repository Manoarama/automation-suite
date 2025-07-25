package question.example.test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TestBCE {

        private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        public static String getRandomCharString(int numChars, int numDigits) {
            StringBuilder result = new StringBuilder();
            Random random = new Random();

            // Add random letters
            for (int i = 0; i < numChars; i++) {
                int index = random.nextInt(CHARS.length());
                result.append(CHARS.charAt(index));
            }

            // Add random digits (as characters)
            for (int i = 0; i < numDigits; i++) {
                result.append(random.nextInt(10)); // 0 to 9
            }

            return result.toString();
        }

        public static void main(String[] args) {
            String randomValue = getRandomCharString(5, 10);
            String randomValue1 = getRandomCharString(0, 10);
            String randomValue2 = getRandomCharString(9, 0);
            System.out.println("Random Output: " + randomValue);
            System.out.println("Random Output: " + randomValue1);
            System.out.println("Random Output: " + randomValue2);
        }
    }

   /* private static void getRamdomNumber( int chars, int digit) {
        File file=new File("");
               // one column,count matches,valuematches,duplicate
*/








