package numbers;

import java.util.Scanner;

public class UserInterface {

    private final Scanner uiScan;
    static final String BEGIN_MSG = ("Welcome to Amazing Numbers!");
    static final String INSTRUCTIONS = ("\nSupported requests:\n"
            + "- enter a natural number to know its properties;\n"
            + "- enter two natural numbers to obtain the properties of the list:\n"
            + "  * the first parameter represents a starting number;\n"
            + "  * the second parameter shows how many consecutive numbers are to be processed;\n"
            + "- two natural numbers and a property to search for;\n"
            + "- separate the parameters with one space;\n"
            + "- enter 0 to exit.");
    static final String END_MSG = ("\nGoodbye!");

    static final String PROMPT = ("\nEnter a request: ");
    static final String INVALID_FIRST = ("\nThe first parameter should be a natural number or zero.");
    static final String INVALID_SECOND = ("\nThe second parameter should be a natural number.");

    static final String INVALID_PROP = ("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]");

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
            int howMany = 0;
            Property property = null;

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

                if (parts.length > 2) {
                    try {
                        property = Property.valueOf(parts[2].toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("The property [" + parts[2].toUpperCase() + "] is wrong.");
                        System.out.println(INVALID_PROP);
                        continue;
                    }
                }

                if (parts.length > 1) {
                    try {
                        howMany = Integer.parseInt(parts[1]);
                        if (howMany < 0) {
                            System.out.println(INVALID_SECOND);
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(INVALID_SECOND);
                        continue;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println(INVALID_FIRST);
                continue;
            }
            NumberAnalyzer.numberProperties(userNumber, howMany, property);
        }

    }
}
