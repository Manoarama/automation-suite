package question.example.test;

public class DayfinderJan2026NorthernTrustBank {
    public static void main(String[] args) {
        String input="19/01/2026";
        int date = Integer.parseInt(input.split("/")[0]);
        String day=getDayOfJanuary2026(date);
        System.out.println("Input Date: " + input);
        System.out.println("Day of the week: " + day);
    }

    private static String getDayOfJanuary2026(int date) {
        String [] days={"Thursday", "Friday", "Saturday",
                "Sunday", "Monday", "Tuesday", "Wednesday"};
        int dayIndex=(date-1)%7;
        return days[dayIndex];
    }
}
