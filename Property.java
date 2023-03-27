package numbers;

/*
* Revisions:
* 2303271400 - Moved number tests from NumberAnalyzer to Properties
* */

public enum Property {
    BUZZ {
        @Override
        public  boolean test(long number) {
            return number % 7 == 0 || number % 10 == 7;
        }
    },
    DUCK {
        @Override
        public  boolean test(long number) {
            return String.valueOf(number).indexOf("0") > 0;
        }
    },
    PALINDROMIC {
        @Override
        public  boolean test(long number) {
            return String.valueOf(number).equals(new StringBuilder(String.valueOf(number)).reverse().toString());
        }
    },
    GAPFUL {
        @Override
        public  boolean test(long number) {
            String numString = Long.toString(number);
            if (numString.length() < 3) {
                return false;
            }
            String firstDigit = numString.substring(0, 1);
            String lastDigit = numString.substring(numString.length() - 1);
            int gapConcat = Integer.parseInt(firstDigit + lastDigit);
            return number % gapConcat == 0;
        }
    },
    SPY {
        @Override
        public  boolean test(long number) {
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
    },
    EVEN {
        @Override
        public boolean test(long number) {
            return number % 2 == 0;
        }
    },
    ODD {
        @Override
        public boolean test(long number) {
            return number % 2 != 0;
        }
    },
    SQUARE {
        @Override
        public  boolean test(long number) {
            return number == (long) Math.sqrt(number) * Math.sqrt(number);
        }
    },
    SUNNY {
        @Override
        public  boolean test(long number) {
            return NumberTester.isPerfectSquare((number + 1));
        }
    };

    public abstract boolean test(long number);
}
