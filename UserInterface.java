package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private final Scanner uiScan;
    static final String BEGIN_MSG = ("Welcome to Amazing Numbers!");
    static final String INSTRUCTIONS = ("\nSupported requests:\n"
            + "- enter a natural number to know its properties;\n"
            + "- enter two natural numbers to obtain the properties of the list:\n"
            + "  * the first parameter represents a starting number;\n"
            + "  * the second parameter shows how many consecutive numbers are to be processed;\n"
            + "- separate the parameters with one space;\n"
            + "- enter 0 to exit.");
    static final String END_MSG = ("\nGoodbye!");

    static final String PROMPT = ("\nEnter a request: ");
    static final String INVALID_FIRST = ("\nThe first parameter should be a natural number or zero.");
    static final String INVALID_SECOND = ("\nThe second parameter should be a natural number.");

    public UserInterface() {

        this.uiScan = new Scanner(System.in);
    }

    public void run() {
        System.out.println(BEGIN_MSG);
        System.out.println(INSTRUCTIONS);

        while (true) {
            System.out.print(PROMPT);
            String userInput = uiScan.nextLine();
            if (userInput.isEmpty()) {
                System.out.println(INSTRUCTIONS);
                continue;
            }

            String[] parts = userInput.split(" ");
            long userNumber;
            int userParam = 0;

            try {
                userNumber = Long.parseLong(parts[0]);
                if (userNumber == 0) {
                    System.out.println(END_MSG);
                    break;
                }
                if (userNumber < 0) {
                    System.out.println(INVALID_FIRST);
                    continue;
                }

                try {
                    if (parts.length > 1) {
                        userParam = Integer.parseInt(parts[1]);
                    }
                    if (userParam < 0) {
                        System.out.println(INVALID_SECOND);
                        continue;
                    }

                } catch (NumberFormatException e) {
                    System.out.println(INVALID_SECOND);
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println(INVALID_FIRST);
                continue;
            }
            NumberAnalyzer.numberProperties(userNumber, userParam);
        }

    }
}
