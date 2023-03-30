package numbers;

public class NumberTester {

    public static boolean isEven(long number) {
        return Property.EVEN.test(number);
    }

    public static boolean isOdd(long number) {
        return Property.ODD.test(number);
    }

    public static boolean isBuzzNumber(long number) {
        return Property.BUZZ.test(number);
    }

    public static boolean isDuckNumber(long number) {
        return Property.DUCK.test(number);
    }

    public static boolean isPalindromic(long number) {
        return Property.PALINDROMIC.test(number);
    }

    public static boolean isGapful(long number) {
        return Property.GAPFUL.test(number);
    }

    public static boolean isSpy(long number) {
        return Property.SPY.test(number);
    }

    public static boolean isPerfectSquare(long number) {
        return Property.SQUARE.test(number);
    }

    public static boolean isSunny(long number) {
        return Property.SUNNY.test(number);
    }

    public static boolean isJumping(long number) {
        return Property.JUMPING.test(number);
    }

    public static boolean isHappy(long number) {
        return Property.HAPPY.test(number);
    }

    public static boolean isSad(long number) {
        return Property.SAD.test(number);
    }


}
