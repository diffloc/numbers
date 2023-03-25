package numbers;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;

    public UserInterface() {

        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Enter a natural number:");
        int userInput = scanner.nextInt();

        if (userInput < 1) {
            System.out.println("This number is not natural!");
            return;
        }

        System.out.printf("This number is %s\n", evenOrOdd((userInput)));

        if (isBuzzNumber((userInput))) {
            System.out.println("This is a Buzz number!");
        } else {
            System.out.println("This is not a Buzz number!");
        }
        explanation(userInput);

    }

    private static String evenOrOdd(int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }

    private static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 ==7;
    }

    private static boolean divideBySeven(int number) {
        return number % 7 == 0;
    }

    private static boolean endsWithSeven(int number) {
        return number % 10 ==7;
    }

    public static void explanation(int number) {
        System.out.println("Explanation:");
        if (!divideBySeven(number) && !endsWithSeven(number)) {
            System.out.println(number + " is neither divisible by 7 nor does it end with 7.");
        } else if (divideBySeven(number) && endsWithSeven(number)) {
            System.out.println(number + " is divisible by 7 and ends with 7.");
        } else if (divideBySeven(number)) {
            System.out.println(number + " is divisible by 7.");
        } else {
            System.out.println(number + " ends with 7.");
        }

    }
}
