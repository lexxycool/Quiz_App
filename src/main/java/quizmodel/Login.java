package quizmodel;

import java.util.Scanner;

import static view.CLI.displayBanner;
import static view.CLI.runDisplay;


public class Login {
    private static Scanner user = new Scanner(System.in);
    private static boolean isLoggedIn = true;




    public static void loginMenu() {

        displayBanner();

        while(isLoggedIn) {
            try {
                System.out.println("1. New User");
                System.out.println("2. Log in");
                System.out.println("3. Quit");
                System.out.println();
                System.out.print("Select from the given option: ");

                int newUser = Integer.parseInt(user.nextLine());
                if (newUser == 1) {
                    firstLogIn();
                }else if(newUser == 2) {
                    System.out.println("log in as old user");
                    isLoggedIn = false;
                }else if(newUser == 3) {
                    System.out.println();
                    System.out.println("Thank you for using Quiz Time Application");
                    isLoggedIn = false;
                }
                else {
                    System.out.println("Invalid option: please choose option (1) or (2)");
                    System.out.println();
                }
            }catch(NumberFormatException e) {
                System.out.println("Invalid option: please enter a number");
                System.out.println();
            }

        }
        isLoggedIn = false;

    }


    private static void firstLogIn() {

        System.out.print("Username: ");
        String username = user.nextLine();
        System.out.print("Password: ");
        String password = user.nextLine();

        if(!username.isBlank() && !password.isBlank()) {
            System.out.println();
            System.out.println("\t\t\t" + "Welcome " + username);
                runDisplay();

                isLoggedIn = false;

        }


    }




}
