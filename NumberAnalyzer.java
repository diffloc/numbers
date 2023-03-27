package numbers;

/*
 * Revisions:
 * 2303271400 - Moved number tests from NumberAnalyzer to Properties
 * 2303271412 - decomposed findNumberProps, moved switch to isPropertySatisfied
 * */

import java.util.ArrayList;

public class NumberAnalyzer {

    private NumberAnalyzer() {
    }

    public static void numberProperties(long number, int howMany, Property propertyOne, Property propertyTwo) {
        if (howMany == 0) {
            singleNumberProps(number);
        } else if (propertyOne != null) {
            findNumberProps(number, howMany, propertyOne, propertyTwo);
        } else {
            rangeNumberProps(number, howMany);
        }
    }

    public static void singleNumberProps(long number) {
        System.out.println("\nProperties of " + number);
        System.out.println("\t\tbuzz: " + NumberTester.isBuzzNumber(number));
        System.out.println("\t\tduck: " + NumberTester.isDuckNumber(number));
        System.out.println(" palindromic: " + NumberTester.isPalindromic(number));
        System.out.println("\t  gapful: " + NumberTester.isGapful(number));
        System.out.println("\t\t spy: " + NumberTester.isSpy(number));
        System.out.println("\t  square: " + NumberTester.isPerfectSquare(number));
        System.out.println("\t   sunny: " + NumberTester.isSunny(number));
        System.out.println("\t\teven: " + NumberTester.isEven(number));
        System.out.println("\t\t odd: " + NumberTester.isOdd(number));
    }

    public static void findNumberProps(long number, int howMany, Property propertyOne, Property propertyTwo ) {
        int count = 0;
        long iteration = number;
        while (count < howMany) {
            boolean propertyOneSatisfied = false;
            boolean propertyTwoSatisfied = false;
            if (propertyOne != null) {
                propertyOneSatisfied = isPropertySatisfied(propertyOne, iteration);
            }
            if (propertyTwo != null) {
                propertyTwoSatisfied = isPropertySatisfied(propertyTwo, iteration);
            }
            if (propertyTwo == null && propertyOneSatisfied) {
                rangeNumberProps(iteration, 1);
                count++;
            } else if (propertyOneSatisfied && propertyTwoSatisfied) {
                rangeNumberProps(iteration, 1);
                count++;
            }
            iteration++;
        }
    }

    private static boolean isPropertySatisfied(Property property, long number) {
        switch (property) {
            case BUZZ:
                return NumberTester.isBuzzNumber(number);
            case DUCK:
                return NumberTester.isDuckNumber(number);
            case PALINDROMIC:
                return NumberTester.isPalindromic(number);
            case GAPFUL:
                return NumberTester.isGapful(number);
            case SPY:
                return NumberTester.isSpy(number);
            case SQUARE:
                return NumberTester.isPerfectSquare(number);
            case SUNNY:
                return NumberTester.isSunny(number);
            case EVEN:
                return NumberTester.isEven(number);
            case ODD:
                return NumberTester.isOdd(number);
            default:
                return false;
        }
    }

    public static void rangeNumberProps(long number, int howMany) {
        ArrayList<String> numberTests;
        for (int i = 0; i < howMany; i++) {
            numberTests = new ArrayList<>();
            long curNumber = number + i;
            if (NumberTester.isBuzzNumber(curNumber)) {
                numberTests.add("buzz");
            }
            if (NumberTester.isDuckNumber(curNumber)) {
                numberTests.add("duck");
            }
            if (NumberTester.isPalindromic(curNumber)) {
                numberTests.add("palindromic");
            }
            if (NumberTester.isGapful(curNumber)) {
                numberTests.add("gapful");
            }
            if (NumberTester.isSpy(curNumber)) {
                numberTests.add("spy");
            }
            if (NumberTester.isPerfectSquare(curNumber)) {
                numberTests.add("square");
            }
            if (NumberTester.isSunny(curNumber)) {
                numberTests.add("sunny");
            }
            if (NumberTester.isEven(curNumber)) {
                numberTests.add("even");
            }
            if (NumberTester.isOdd(curNumber)) {
                numberTests.add("odd");
            }
            System.out.println("\t\t\t " + curNumber + " is " + String.join(", ", numberTests));
        }
    }
}