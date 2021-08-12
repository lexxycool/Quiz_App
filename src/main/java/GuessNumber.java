import java.io.*;
import java.util.*;

import static java.util.Scanner.*;

public class GuessNumber {

    private Scanner input = new Scanner(System.in);


    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println();
        System.out.println("######################################################");
        System.out.println("#                                                    #");
        System.out.println("#               GUESS NUMBER GAME                    #");
        System.out.println("#                                                    #");
        System.out.println("#####################################################*");


        System.out.println();
        System.out.println();


        guessNumber();

        tryAgain();


    }












    public static void guessNumber() throws InterruptedException {

        try (Scanner input = new Scanner(System.in)) {

            int randomNumber = 1 + (int) (Math.random() * 100); // random number from 1 - 100

            int numberOfTries = 0;   // number of tries

            while (true) {
                System.out.println();
                System.out.println();
                System.out.print("Guess my lucky number between 1 to 100 >>> ");

                int guessNumber = Integer.parseInt(input.nextLine()); // read the guess number from user input
                numberOfTries++;

                if (randomNumber == guessNumber) {
                    System.out.println();
                    System.out.println();
                    System.out.println("WOoow!!!..You guessed right. " + guessNumber + " is the magic number and " +
                            "you did it in " + numberOfTries + " tries.");
                    System.out.println("*****************************************************************************");
                    break;
                } else if (guessNumber > 100) {
                    System.out.println();
                    System.out.println();
                    System.out.println("Please enter numbers between 1 to 100...");
                } else if (guessNumber <= 0) {
                    System.out.println();
                    System.out.println();
                    System.out.println("Please enter numbers between 1 to 100...");
                } else if (randomNumber < guessNumber) {
                    System.out.println();
                    System.out.println();
                    System.out.println("Cm'on!!! Try Again..The number is less than " + guessNumber);

                } else if (randomNumber > guessNumber) {
                    System.out.println();
                    System.out.println();
                    System.out.println("Uh oh!!! your missed it..The number is greater than " + guessNumber);

                }
                if (numberOfTries == 5) {
                    System.out.println();
                    System.out.println();
                    System.out.println("You didn't get it this time..You have exhausted your " + numberOfTries + " tries");
                    System.out.println();
                    System.out.println("************************");
                    System.out.print("The magic number was ");
                    Thread.sleep(3000);
                    System.out.print(randomNumber);
                    System.out.println();
                    System.out.println("************************");
                    break;
                }

            }

        }
    }

    public static void tryAgain() throws InterruptedException {
        System.out.println();
        Scanner inputStr = new Scanner(System.in);
        System.out.println("Do you want to play again?  Yes, No?");


        if(inputStr.nextLine().equalsIgnoreCase("Yes")) {
            guessNumber();
        }else if(inputStr.nextLine().equalsIgnoreCase("No")) {
            System.out.println();
            System.out.println("Thank you...Bye!!!");
        }
    }
}
