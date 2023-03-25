package numbers;

import java.util.Scanner;

public class UserInterface {

    private final Scanner uiScan;
    private final NumberAnalyzer numberAnalyzer;

    public UserInterface() {
        this.uiScan = new Scanner(System.in);
        this.numberAnalyzer = new NumberAnalyzer();
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

            numberAnalyzer.numberProperties(userNumber, userNumberString);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + userNumberString + " is not a natural number!");
        }
    }


}
