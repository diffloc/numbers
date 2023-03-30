package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {

    private final Scanner uiScan;
    static final String BEGIN_MSG = ("Welcome to Amazing Numbers!");
    static final String INSTRUCTIONS = ("\nSupported requests:\n"
            + "- enter a natural number to know its properties;\n"
            + "- enter two natural numbers to obtain the properties of the list:\n"
            + "  * the first parameter represents a starting number;\n"
            + "  * the second parameter shows how many consecutive numbers are to be processed;\n"
            + "- two natural numbers and properties to search for;\n"
            + "- a property preceded by minus must not be present in numbers;\n"
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

            ArrayList<String> mutualProps = new ArrayList<>();
            ArrayList<Property> excludeProps = new ArrayList<>();
            ArrayList<Property> propertiesList = new ArrayList<>();

            ArrayList<String> propertyList = new ArrayList<>();
            for (String p1 : parts) {
                if (p1.startsWith("-")) {
                    propertyList.add(p1);
                } else {
                    propertyList.add(p1.replace("-", ""));
                }

            }

            for (String p1 : parts) {
                String p2 = p1.replace("-", "");

                if (p1.equals("-even") && propertyList.contains("-odd")
                        || p1.equals("-even") && propertyList.contains(p2)
                        || p1.equals("even") && propertyList.contains("-even")
                        || p1.equals("-odd") && propertyList.contains("-even")
                        || p1.equals("-odd") && propertyList.contains(p2)
                        || p1.equals("odd") && propertyList.contains("-odd")
                        || p1.equals("-duck") && propertyList.contains("-spy")
                        || p1.equals("-duck") && propertyList.contains(p2)
                        || p1.equals("duck") && propertyList.contains("-duck")
                        || p1.equals("-spy") && propertyList.contains("-duck")
                        || p1.equals("-spy") && propertyList.contains(p2)
                        || p1.equals("spy") && propertyList.contains("-spy")
                        // || p1.equals("-sunny") && propertyList.contains("-square")
                        || p1.equals("-sunny") && propertyList.contains(p2)
                        || p1.equals("sunny") && propertyList.contains("-sunny")
                        // || p1.equals("-square") && propertyList.contains("-sunny")
                        || p1.equals("-square") && propertyList.contains(p2)
                        || p1.equals("square") && propertyList.contains("-square")
                        || p1.equals("-happy") && propertyList.contains("-sad")
                        || p1.equals("-happy") && propertyList.contains(p2)
                        || p1.equals("happy") && propertyList.contains("-happy")
                        || p1.equals("-sad") && propertyList.contains("-happy")
                        || p1.equals("-sad") && propertyList.contains(p2)
                        || p1.equals("sad") && propertyList.contains("-sad")
                        || p1.equals("-buzz") && propertyList.contains(p2)
                        || p1.equals("buzz") && propertyList.contains("-buzz")
                        || p1.equals("-palindromic") && propertyList.contains(p2)
                        || p1.equals("palindromic") && propertyList.contains("-palindromic")
                        || p1.equals("-gapful") && propertyList.contains(p2)
                        || p1.equals("gapful") && propertyList.contains("-gapful")
                        || p1.equals("-jumping") && propertyList.contains(p2)
                        || p1.equals("jumping") && propertyList.contains("-jumping")) {
                    if (!mutualProps.contains(p1)) {
                        String upperP1 = p1.toUpperCase();
                        mutualProps.add(upperP1);
                    }
                }
            }

            if (!mutualProps.isEmpty()) {
                System.out.println("The request contains mutually exclusive properties: " + mutualProps);
                System.out.println("There are no numbers with these properties.");
                continue;
            }


            if (parts.length > 2 || (parts.length == 2 && parts[1].startsWith("-"))) {
                int startIdx = parts.length > 2 ? 2 : 1;

                ArrayList<String> errorParts = new ArrayList<>();

                for (int i = startIdx; i < parts.length; i++) {
                    try {
                        String prop = parts[i].toUpperCase();
                        if (prop.startsWith("-")) {
                            prop = prop.replace("-", "");
                            excludeProps.add(Property.valueOf(prop));
                        } else {
                            propertiesList.add(Property.valueOf(prop));
                        }
                    } catch (IllegalArgumentException e) {
                        errorParts.add(parts[i].toUpperCase());
                    }
                }


                /**/

                /**/

                if (!errorParts.isEmpty()) {

                    if (errorParts.size() == 1) {
                        System.out.println("The property [" + errorParts.get(0) + "] is wrong");
                    } else {
                        System.out.println("The properties [" + String.join(", ", errorParts) + "] are wrong");
                    }
                    System.out.println("Available properties: [" + getAvailableProperties() + "]");
                    continue;
                }
            }

            Property[] properties = propertiesList.toArray(new Property[0]);
            if (!excludeProps.isEmpty() || properties.length > 0) {
                NumberAnalyzer.findNumberProps(userNumber, howMany, excludeProps, properties);
            } else if (howMany != 0) {
                NumberAnalyzer.rangeNumberProps(userNumber, howMany);
            } else {
                NumberAnalyzer.singleNumberProps(userNumber);
            }
        }
    }
}
