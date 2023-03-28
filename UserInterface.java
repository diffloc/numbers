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
            + "  * the second parameter shows how many consecutive numbers are to be printed;\n"
            + "- two natural numbers and properties to search for;\n"
            + "- separate the parameters with one space;\n"
            + "- enter 0 to exit.");
    static final String END_MSG = ("\nGoodbye!");

    static final String PROMPT = ("\nEnter a request: ");
    static final String INVALID_FIRST = ("\nThe first parameter should be a natural number or zero.");
    static final String INVALID_SECOND = ("\nThe second parameter should be a natural number.");
    static final String AVAILABLE_PROPS = ("Available properties: " + getAvailableProperties());
    public UserInterface() {
        this.uiScan = new Scanner(System.in);
    }

    public static String getAvailableProperties() {
        StringBuilder sb = new StringBuilder();
        Property[] properties = Property.values();
        for (int i = 0; i < properties.length; i++) {
            sb.append(properties[i]);
            if (i < properties.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void run() {
        System.out.println(BEGIN_MSG);
        System.out.println(INSTRUCTIONS);

        while (true) {
            System.out.print(PROMPT);
            String userInput = uiScan.nextLine();
            System.out.println();
            if (userInput.isEmpty()) {
                System.out.println(INSTRUCTIONS);
                continue;
            }

            String[] parts = userInput.split(" ");
            long userNumber;
            int howMany = 0;

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

            ArrayList<String> errorParts = new ArrayList<>();
            if (parts.length > 2) {
                Property[] properties = new Property[parts.length - 2];
                for (int i = 2; i < parts.length; i++) {
                    try {
                        properties[i - 2] = Property.valueOf(parts[i].toUpperCase());
                    } catch (IllegalArgumentException e) {
                        errorParts.add(parts[i].toUpperCase());
                    }
                }
                if (!errorParts.isEmpty()) {

                    if (errorParts.size() == 1) {
                        System.out.println("The property [" + errorParts.get(0) + "] is wrong");
                    } else {
                        System.out.println("The properties [" + String.join(", ", errorParts) + "] are wrong");
                    }
                    System.out.println("Available properties: [" + getAvailableProperties() + "]");
                    continue;
                }
                NumberAnalyzer.numberProperties(userNumber, howMany, properties);
            } else {
                NumberAnalyzer.numberProperties(userNumber, howMany);
            }
        }
    }
}
