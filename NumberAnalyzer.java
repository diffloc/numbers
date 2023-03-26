package numbers;

import java.util.ArrayList;

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

    public static boolean isGapful(long number) {
        String numString = Long.toString(number);
        if (numString.length() < 3) {
            return false;
        }
        String firstDigit = numString.substring(0, 1);
        String lastDigit = numString.substring(numString.length() - 1);
        int gapConcat = Integer.parseInt(firstDigit + lastDigit);
        return number % gapConcat == 0;
    }

    public static void numberProperties(long number, int param) {
        if (param == 0) {
            singleNumberProps(number);
        } else {
            rangeNumberProps(number, param);
        }
    }

    public static void singleNumberProps(long number) {
        System.out.println("\nProperties of " + number);
        System.out.println("\t\tbuzz: " + isBuzzNumber(number));
        System.out.println("\t\tduck: " + isDuckNumber(number));
        System.out.println(" palindromic: " + isPalindromic(number));
        System.out.println("\t  gapful: " + isGapful(number));
        System.out.println("\t\teven: " + isEven(number));
        System.out.println("\t\t odd: " + !isEven(number));
    }

    public static void rangeNumberProps(long number, int param) {
        ArrayList<String> numberTests;
        for (int i = 0; i < param; i++) {
            numberTests = new ArrayList<>();
            long curNumber = number + i;
            if (isBuzzNumber(curNumber)) {
                numberTests.add("buzz");
            }
            if (isDuckNumber(curNumber)) {
                numberTests.add("duck");
            }
            if (isPalindromic(curNumber)) {
                numberTests.add("palindromic");
            }
            if (isGapful(curNumber)) {
                numberTests.add("gapful");
            }
            if (isEven(curNumber)) {
                numberTests.add("even");
            }
            if (!isEven(curNumber)) {
                numberTests.add("odd");
            }
            System.out.println("\t\t\t " +curNumber + " is " + String.join(", ", numberTests));
        }
    }
}
