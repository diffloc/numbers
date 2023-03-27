package numbers;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private final Scanner uiScan;
    static final String BEGIN_MSG = ("Welcome to Amazing Numbers!");
    static final String INSTRUCTIONS = ("\nSupported requests:\n"
            + "- enter a natural number to know its properties;\n"
            + "- enter two natural numbers to obtain the properties of the list:\n"
            + "  * the first parameter represents a starting number;\n"
            + "  * the second parameters show how many consecutive numbers are to be processed;\n"
            + "- two natural numbers and two properties to search for;\n"
            + "- separate the parameters with one space;\n"
            + "- enter 0 to exit.");
    static final String END_MSG = ("\nGoodbye!");

    static final String PROMPT = ("\nEnter a request: ");
    static final String INVALID_FIRST = ("\nThe first parameter should be a natural number or zero.");
    static final String INVALID_SECOND = ("\nThe second parameter should be a natural number.");

    static final String AVAILABLE_PROPS = ("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SQUARE, SUNNY]");

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
            Property propertyOne = null;
            Property propertyTwo = null;

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

                ArrayList<String> errorParts = new ArrayList<>();
                boolean propertyTwoError = false;
                boolean propertyOneError = false;
                if (parts.length > 3) {

                    try {
                        propertyTwo = Property.valueOf(parts[3].toUpperCase());
                    } catch (IllegalArgumentException e) {
                        propertyTwoError = true;
                        errorParts.add(parts[3].toUpperCase());
                    }
                }

                if (parts.length > 2) {

                    try {
                        propertyOne = Property.valueOf(parts[2].toUpperCase());
                    } catch (IllegalArgumentException e) {
                        propertyOneError = true;
                        errorParts.add(0, parts[2].toUpperCase());
                    }
                }

                if (propertyOneError && propertyTwoError) {
                    System.out.println("The properties [" + (String.join(", ", errorParts)) + "] are wrong");
                    System.out.println(AVAILABLE_PROPS);
                    continue;
                }

                if (propertyOneError || propertyTwoError) {
                    System.out.println("The property [" + (String.join(", ", errorParts)) + "] is wrong");
                    System.out.println(AVAILABLE_PROPS);
                    continue;
                }


                if (propertyOne == Property.ODD && propertyTwo == Property.EVEN
                        || propertyOne == Property.EVEN && propertyTwo == Property.ODD
                        || propertyOne == Property.SUNNY && propertyTwo == Property.SQUARE
                        || propertyOne == Property.SQUARE && propertyTwo == Property.SUNNY
                        || propertyOne == Property.SPY && propertyTwo == Property.DUCK
                        || propertyOne == Property.DUCK && propertyTwo == Property.SPY) {
                    System.out.println("The request contains mutually exclusive properties: [" + propertyOne + ", " + propertyTwo + "]");
                    System.out.println("There are no numbers with these properties.");
                    continue;
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
            NumberAnalyzer.numberProperties(userNumber, howMany, propertyOne, propertyTwo);
        }

    }
}
