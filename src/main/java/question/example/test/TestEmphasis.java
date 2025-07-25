package question.example.test;

public class TestEmphasis {
    public static void main(String[] args) {
        // INSURANCE DAILY 22/07/2025 to 02/08/2025 XYZ 22/07/2025
        //INSURANCE DAILY 22-07-2025 to 02-09-2025 XYZ 22/07/2025
        String input="INSURANCE DAILY 22/07/2025 to 02/08/2025 XYZ 22/07/2025";
        //inputString = "Hello Hello World World"

        //outputString = "Hello World

        convertDate(input);
    }

    private static void convertDate(String input) {
        String result=input.replace("/","-");
        result.split("to");

    }
}
