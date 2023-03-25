package numbers;

public class NumberAnalyzer {

    private static boolean isEven(int number) { return number % 2 ==0; }

    private static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 ==7;
    }

    private static boolean isDuckNumber(String userInput) {
        char[] chars = userInput.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {
                return true;
            }
        }
        return false;
    }

    public static void numberProperties(int userNumber, String userNumberString) {
        System.out.println("Properties of " + userNumber);
        System.out.println("\t\teven: " + isEven(userNumber));
        System.out.println("\t\t odd: " + !isEven(userNumber));
        System.out.println("\t\tbuzz: " + isBuzzNumber(userNumber));
        System.out.println("\t\tduck: " + isDuckNumber(userNumberString));
    }

}
