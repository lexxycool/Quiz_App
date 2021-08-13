package quizmodel;

import java.util.Scanner;

import static quizmodel.OOPQuestions.quizPrint;

public class quizMenu {
    private static Scanner userInput = new Scanner(System.in);
    private static boolean isRunning = true;

    public static void displayBanner() {

        System.out.println();
        System.out.println(" #####################################");
        System.out.println(" #                                   #");
        System.out.println(" #             QUIZ TIME             #");
        System.out.println(" #                                   #");
        System.out.println(" #####################################");

        System.out.println();
    }

    public static void displayMenu() {

        System.out.println("1. Data Types and Arrays");
        System.out.println("2. Object-Oriented Programming");
        System.out.println("3. Unit Testing");
        System.out.println("4. Database");
        System.out.println("5. API SERVICES");
        System.out.println("6. Exit");
        System.out.println();
        System.out.print("choose from the following concepts: ");

    }
    public static void runDisplay() {

        displayBanner();

        while (isRunning) {
            try {
                displayMenu();
                int selected = Integer.parseInt(userInput.nextLine());
                promptForInt(selected);

            }catch (NumberFormatException e) {
                System.out.println("Invalid choice...please enter a number");
                System.out.println();
            }
        }
        isRunning = false;
    }

    private static void promptForInt(int num) {

        if (num == 1) {
            quizPrint();
          //1 isRunning = !isRunning;
        } else if (num == 2) {
            System.out.println("Object-Oriented Programming");
            isRunning = !isRunning;
        } else if (num == 3) {
            System.out.println("Unit Testing");
            isRunning = !isRunning;
        } else if (num == 4) {
            System.out.println("Database");
            isRunning = !isRunning;
        } else if (num == 5) {
            System.out.println("Api Services");
            isRunning = !isRunning;
        } else if (num == 6) {
            System.exit(1);
        } else {
            System.out.println("Invalid choice number...Please try again");
            System.out.println();

        }

    }

}
