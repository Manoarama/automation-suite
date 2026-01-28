package question.example.test;

public class WiproTesco {
    public static void main(String[] args) {
        String input = "abc";
        permutation(input.toCharArray(), 0);
    }

    private static void permutation(char[] charArray, int index) {
        if (index == charArray.length) {
            System.out.println(new String(charArray));
            return;
        }
        for (int i = index; i < charArray.length - 1; i++) {
            swapmethod(charArray, i, index);
            permutation(charArray, index + 1);
            swapmethod(charArray, i, index);

        }

    }

    private static void swapmethod(char[] charArray, int i, int index) {
        char temp = charArray[i];
        charArray[i] = charArray[index];
        charArray[index] = temp;
    }


}
