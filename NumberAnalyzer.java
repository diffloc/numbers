package numbers;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberAnalyzer {

    private NumberAnalyzer() {
    }

    public static void singleNumberProps(long number) {
        System.out.println("Properties of " + number);
        System.out.println("\t\tbuzz: " + NumberTester.isBuzzNumber(number));
        System.out.println("\t\tduck: " + NumberTester.isDuckNumber(number));
        System.out.println(" palindromic: " + NumberTester.isPalindromic(number));
        System.out.println("\t  gapful: " + NumberTester.isGapful(number));
        System.out.println("\t\t spy: " + NumberTester.isSpy(number));
        System.out.println("\t  square: " + NumberTester.isPerfectSquare(number));
        System.out.println("\t   sunny: " + NumberTester.isSunny(number));
        System.out.println("\t jumping: " + NumberTester.isJumping(number));
        System.out.println("\t   happy: " + NumberTester.isHappy(number));
        System.out.println("\t\t sad: " + NumberTester.isSad(number));
        System.out.println("\t\teven: " + NumberTester.isEven(number));
        System.out.println("\t\t odd: " + NumberTester.isOdd(number));
    }

    public static void findNumberProps(long number, int howMany, ArrayList<Property> excludeProps, Property... properties ) {
        // System.out.println("Excluded Props: " + excludeProps);
        ArrayList<Property> mutualProps = new ArrayList<>();
        ArrayList<Property> propertyList = new ArrayList<>(Arrays.asList(properties));
        for (Property p1 : propertyList) {
            if (p1 == Property.EVEN && propertyList.contains(Property.ODD)
                    || p1 == Property.ODD && propertyList.contains(Property.EVEN)
                    || p1 == Property.DUCK && propertyList.contains(Property.SPY)
                    || p1 == Property.SPY && propertyList.contains(Property.DUCK)
                    || p1 == Property.SUNNY && propertyList.contains(Property.SQUARE)
                    || p1 == Property.SQUARE && propertyList.contains(Property.SUNNY)
                    || p1 == Property.HAPPY && propertyList.contains(Property.SAD)
                    || p1 == Property.SAD && propertyList.contains(Property.HAPPY)) {
                if (!mutualProps.contains(p1)) {
                    mutualProps.add(p1);
                }
            }
        }

        if (!mutualProps.isEmpty()) {
            System.out.println("The request contains mutually exclusive properties: " + mutualProps);
            System.out.println("There are no numbers with these properties.");
            return;
        }


        int count = 0;
        long iteration = number;
        while (count < howMany) {

            boolean conditionsValidated = true;
            boolean isExcluded = false;

            for (Property excludeProp : excludeProps) {
                if (numberValid(excludeProp, iteration)) {
                    isExcluded = true;
                    break;
                }
            }

            if (isExcluded) {
                iteration++;
                continue;
            }

            for (Property property: properties) {

                if (!numberValid(property, iteration)) {
                    conditionsValidated = false;
                    break;
                }
            }
            if (conditionsValidated) {
                rangeNumberProps(iteration, 1);
                count++;
            }
            iteration++;
        }
    }

    public static void rangeNumberProps(long number, int howMany) {

        for (int i = 0; i < howMany; i++) {
            ArrayList<String> numberTests = new ArrayList<>();
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
            if (NumberTester.isJumping(curNumber)) {
                numberTests.add("jumping");
            }
            if (NumberTester.isHappy(curNumber)) {
                numberTests.add("happy");
            }
            if (NumberTester.isSad(curNumber)) {
                numberTests.add("sad");
            }
            if (NumberTester.isEven(curNumber)) {
                numberTests.add("even");
            }
            if (NumberTester.isOdd(curNumber)) {
                numberTests.add("odd");
            }
            System.out.println("\t " + curNumber + " is " + String.join(", ", numberTests));
        }
    }

    private static boolean numberValid(Property property, long number) {
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
            case JUMPING:
                return NumberTester.isJumping(number);
            case HAPPY:
                return NumberTester.isHappy(number);
            case SAD:
                return NumberTester.isSad(number);
            case EVEN:
                return NumberTester.isEven(number);
            case ODD:
                return NumberTester.isOdd(number);
            default:
                return false;
        }
    }

}