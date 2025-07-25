package question.example.test;

import java.util.regex.*;
import java.util.*;
public class Tokenizer {
    public static void main(String[] args) {
        String input = "abc  xyz \"ejhgfd lnmkg\" pqr \"hlkpjhg ghioyt\"";
        String[] tokens = extractTokens(input);
        for (String token : tokens) {
            System.out.println(token);
        }
    }

    public static String[] extractTokens(String input) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = Pattern.compile("\"[^\"]*\"|\\S+").matcher(input);
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens.toArray(new String[0]);
    }
}

