package numbers;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberAnalyzer {

    private NumberAnalyzer() {
    }

    public static void numberProperties(long number, int howMany, Property... properties) {

        if (howMany == 0) {
            singleNumberProps(number);
        } else if (properties.length > 0) {
            findNumberProps(number, howMany, properties);
        } else {
            rangeNumberProps(number, howMany);
        }
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
        System.out.println("\t\teven: " + NumberTester.isEven(number));
        System.out.println("\t\t odd: " + NumberTester.isOdd(number));
    }

    public static void findNumberProps(long number, int howMany, Property... properties ) {

        ArrayList<Property> excludeProp = new ArrayList<>();
        ArrayList<Property> propertyList = new ArrayList<>(Arrays.asList(properties));
        for (Property p1 : propertyList) {
            if (p1 == Property.EVEN && propertyList.contains(Property.ODD)
                    || p1 == Property.ODD && propertyList.contains(Property.EVEN)
                    || p1 == Property.DUCK && propertyList.contains(Property.SPY)
                    || p1 == Property.SPY && propertyList.contains(Property.DUCK)
                    || p1 == Property.SUNNY && propertyList.contains(Property.SQUARE)
                    || p1 == Property.SQUARE && propertyList.contains(Property.SUNNY)) {
                if (!excludeProp.contains(p1)) {
                    excludeProp.add(p1);
                }
            }
        }

        if (!excludeProp.isEmpty()) {
            System.out.println("The request contains mutually exclusive properties: " + excludeProp);
            System.out.println("There are no numbers with these properties.");
            return;
        }

        ArrayList<String> errorParts = new ArrayList<>();
        for (Property property: properties) {
            try {
                Property.valueOf(property.name());
            } catch (IllegalArgumentException e) {
                errorParts.add(property.name());
            }
        }

        if (!errorParts.isEmpty()) {
            if (errorParts.size() == 1) {
                System.out.println(errorParts);
                System.out.println("The property [" + errorParts.get(0) + "] is wrong");
            } else {
                System.out.println(errorParts);
                System.out.println("The properties... [" + String.join(", ", errorParts) + "] are wrong");
            }
            System.out.println("Available properties: " + UserInterface.getAvailableProperties());
            return;
        }


        int count = 0;
        long iteration = number;
        while (count < howMany) {
            boolean satisfiesAllProperties = true;
            for (Property property: properties) {
                if (!isPropertySatisfied(property, iteration)) {
                    satisfiesAllProperties = false;
                    break;
                }
            }
            if (satisfiesAllProperties) {
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
            case JUMPING:
                return NumberTester.isJumping(number);
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
            if (NumberTester.isJumping(curNumber)) {
                numberTests.add("jumping");
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
}