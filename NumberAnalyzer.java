package numbers;

public class NumberAnalyzer {

    private NumberAnalyzer() {

    }

    private static boolean isEven(long number) {
        return number % 2 ==0; }

    private static boolean isBuzzNumber(long number) {
        return number % 7 == 0 || number % 10 ==7;
    }

    private static boolean isDuckNumber(long number) {
        return String.valueOf(number).indexOf("0") > 0;
    }

    private static boolean isPalindromic(long number) {
        return String.valueOf(number).equals(new StringBuilder(String.valueOf(number)).reverse().toString());
    }

    public static void numberProperties(long number) {
        System.out.println("\nProperties of " + number);
        System.out.println("\t\teven: " + isEven(number));
        System.out.println("\t\t odd: " + !isEven(number));
        System.out.println("\t\tbuzz: " + isBuzzNumber(number));
        System.out.println("\t\tduck: " + isDuckNumber(number));
        System.out.println(" palindromic: " + isPalindromic(number));
    }

}
