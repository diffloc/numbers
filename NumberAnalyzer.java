package numbers;

import java.util.ArrayList;

public class NumberAnalyzer {

    private NumberAnalyzer() {
    }

    private static boolean isEven(long number) {
        return number % 2 == 0;
    }

    private static boolean isBuzzNumber(long number) {
        return number % 7 == 0 || number % 10 == 7;
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

    public static boolean isSpy(long number) {
        int sum = 0;
        int product = 1;
        while (number > 0) {
            int digit = (int) (number % 10);
            sum += digit;
            product *= digit;
            number /= 10;
        }
        return sum == product;
    }

    public static boolean isPerfectSquare(long number) {
        return number == (long) Math.sqrt(number) * Math.sqrt(number);
    }

    public static boolean isSunny(long number) {
        return isPerfectSquare(number +1);
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
        System.out.println("\t\tbuzz: " + isBuzzNumber(number));
        System.out.println("\t\tduck: " + isDuckNumber(number));
        System.out.println(" palindromic: " + isPalindromic(number));
        System.out.println("\t  gapful: " + isGapful(number));
        System.out.println("\t\t spy: " + isSpy(number));
        System.out.println("\t  square: " + isPerfectSquare(number));
        System.out.println("\t   sunny: " + isSunny(number));
        System.out.println("\t\teven: " + isEven(number));
        System.out.println("\t\t odd: " + !isEven(number));
    }

    // public static void findNumberProps(long number, int howMany, Property property) {
    //     int count = 0;
    //     long iteration = number;
    //     while (count < howMany) {
    //         switch (property) {
    //             case BUZZ:
    //                 if (isBuzzNumber(iteration)) {
    //                     rangeNumberProps(iteration, 1);
    //                     count++;
    //                 }
    //                 iteration++;
    //                 break;
    //             case DUCK:
    //                 if (isDuckNumber(iteration)) {
    //                     rangeNumberProps(iteration, 1);
    //                     count++;
    //                 }
    //                 iteration++;
    //                 break;
    //             case PALINDROMIC:
    //                 if (isPalindromic(iteration)) {
    //                     rangeNumberProps(iteration, 1);
    //                     count++;
    //                 }
    //                 iteration++;
    //                 break;
    //             case GAPFUL:
    //                 if (isGapful(iteration)) {
    //                     rangeNumberProps(iteration, 1);
    //                     count++;
    //                 }
    //                 iteration++;
    //                 break;
    //             case SPY:
    //                 if (isSpy(iteration)) {
    //                     rangeNumberProps(iteration, 1);
    //                     count++;
    //                 }
    //                 iteration++;
    //                 break;
    //             case SQUARE:
    //                 if (isPerfectSquare(iteration)) {
    //                     rangeNumberProps(iteration, 1);
    //                     count++;
    //                 }
    //                 iteration++;
    //                 break;
    //             case SUNNY:
    //                 if (isSunny(iteration)) {
    //                     rangeNumberProps(iteration, 1);
    //                     count++;
    //                 }
    //                 iteration++;
    //                 break;
    //             case EVEN:
    //                 if (isEven(iteration)) {
    //                     rangeNumberProps(iteration, 1);
    //                     count++;
    //                 }
    //                 iteration++;
    //                 break;
    //             case ODD:
    //                 if (!isEven(iteration)) {
    //                     rangeNumberProps(iteration, 1);
    //                     count++;
    //                 }
    //                 iteration++;
    //                 break;
    //             default:
    //                 break;
    //         }
    //     }
    // }

    public static void findNumberProps(long number, int howMany, Property propertyOne, Property propertyTwo ) {
        int count = 0;
        long iteration = number;
        while (count < howMany) {
            boolean propertyOneSatisfied = false;
            boolean propertyTwoSatisfied = false;
            if (propertyOne != null) {
                switch (propertyOne) {
                    case BUZZ:
                        if (isBuzzNumber(iteration)) {
                            propertyOneSatisfied = true;
                        }
                        break;
                    case DUCK:
                        if (isDuckNumber(iteration)) {
                            propertyOneSatisfied = true;
                        }
                        break;
                    case PALINDROMIC:
                        if (isPalindromic(iteration)) {
                            propertyOneSatisfied = true;
                        }
                        break;
                    case GAPFUL:
                        if (isGapful(iteration)) {
                            propertyOneSatisfied = true;
                        }
                        break;
                    case SPY:
                        if (isSpy(iteration)) {
                            propertyOneSatisfied = true;
                        }
                        break;
                    case SQUARE:
                        if (isPerfectSquare(iteration)) {
                            propertyOneSatisfied = true;
                        }
                        break;
                    case SUNNY:
                        if (isSunny(iteration)) {
                            propertyOneSatisfied = true;
                        }
                        break;
                    case EVEN:
                        if (isEven(iteration)) {
                            propertyOneSatisfied = true;
                        }
                        break;
                    case ODD:
                        if (!isEven(iteration)) {
                            propertyOneSatisfied = true;
                        }
                        break;
                    default:
                        break;
                }
            }

            if (propertyTwo != null) {
                switch (propertyTwo) {
                    case BUZZ:
                        if (isBuzzNumber(iteration)) {
                            propertyTwoSatisfied = true;
                        }
                        break;
                    case DUCK:
                        if (isDuckNumber(iteration)) {
                            propertyTwoSatisfied = true;
                        }
                        break;
                    case PALINDROMIC:
                        if (isPalindromic(iteration)) {
                            propertyTwoSatisfied = true;
                        }
                        break;
                    case GAPFUL:
                        if (isGapful(iteration)) {
                            propertyTwoSatisfied = true;
                        }
                        break;
                    case SPY:
                        if (isSpy(iteration)) {
                            propertyTwoSatisfied = true;
                        }
                        break;
                    case SQUARE:
                        if (isPerfectSquare(iteration)) {
                            propertyTwoSatisfied = true;
                        }
                        break;
                    case SUNNY:
                        if (isSunny(iteration)) {
                            propertyTwoSatisfied = true;
                        }
                        break;
                    case EVEN:
                        if (isEven(iteration)) {
                            propertyTwoSatisfied = true;
                        }

                        break;
                    case ODD:
                        if (!isEven(iteration)) {
                            propertyTwoSatisfied = true;
                        }

                        break;
                    default:
                        break;
                }
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

    public static void rangeNumberProps(long number, int howMany) {
        ArrayList<String> numberTests;
        for (int i = 0; i < howMany; i++) {
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
            if (isSpy(curNumber)) {
                numberTests.add("spy");
            }
            if (isPerfectSquare(curNumber)) {
                numberTests.add("square");
            }
            if (isSunny(curNumber)) {
                numberTests.add("sunny");
            }
            if (isEven(curNumber)) {
                numberTests.add("even");
            }
            if (!isEven(curNumber)) {
                numberTests.add("odd");
            }
            System.out.println("\t\t\t " + curNumber + " is " + String.join(", ", numberTests));
        }
    }
}