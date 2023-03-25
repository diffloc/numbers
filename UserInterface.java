package numbers;

import java.util.Scanner;

public class UserInterface {

    private final Scanner uiScan;

    public UserInterface() {
        this.uiScan = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Enter a natural number:");
        String userNumberString = uiScan.nextLine();

        try {
            int userNumber = Integer.parseInt(userNumberString);

            if (userNumber < 1) {
                System.out.println("This number is not natural!");
                return;
            }

            NumberAnalyzer.numberProperties(userNumber, userNumberString);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + userNumberString + " is not a natural number!");
        }
    }


}
