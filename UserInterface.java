package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private final Scanner uiScan;
    static final String BEGIN_MSG = ("Welcome to Amazing Numbers!\n\n"
            + "Supported requests:\n"
            + "- enter a natural number to know its properties;\n"
            + "- enter 0 to exit.");
    static final String END_MSG = ("\nGoodbye!");

    static final String PROMPT = ("\nEnter a request: ");
    static final String INVALID_INPUT = ("The first parameter should be a natural number or zero.");

    public UserInterface() {
        this.uiScan = new Scanner(System.in);
    }

    public void run() {
        System.out.println(BEGIN_MSG);

        while (true) {
            System.out.print(PROMPT);
            long userInput;
            try {
                userInput = uiScan.nextLong();
                if (userInput == 0) {
                    System.out.println(END_MSG);
                    break;
                }
                if (userInput < 0) {
                    System.out.println(INVALID_INPUT);
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch Exception: " + uiScan.next() + " is not a natural number!");
                continue;
            }
            NumberAnalyzer.numberProperties(userInput);
        }

    }
}
