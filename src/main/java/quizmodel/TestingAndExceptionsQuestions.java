package quizmodel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static quizmodel.DataTypesAndArrayQuestions.dataQuiz;

public class TestingAndExceptionsQuestions {


    public static Map<String, String> questions(){

        Map<String, String> quizQuestions = new HashMap<>();
        quizQuestions.put("The process of checking the functionality of an application fulfills the requirement " +
                            "or not is called?", "Testing");
        quizQuestions.put("What type of exceptions are compile-time exceptions that must be handled?", "Checked Exceptions");
        quizQuestions.put("Which annotation is used to indicate that a method is a test method?", "@Test");
        quizQuestions.put("The type of testing that validates that existing functionality continues to operate " +
                          "as expected is called what?", "Regression Testing");
        quizQuestions.put("Abnormal occurrences that disrupts the normal flow of a program is called?", "Exceptions");
        quizQuestions.put("Which type of test tests how various units of a program interact with each other?", "Integration Testing");
        quizQuestions.put("Exploratory tests are better done manually?  Yes or No", "Yes");
        quizQuestions.put("Which three statements can be used to handle exceptions in Java?", "try,catch,finally");
        quizQuestions.put("Which method is used to print detailed information about occurred exceptions?", "PrintTrace()");
        quizQuestions.put("Automation testing is a software testing process where minimal manual intervention is required  Yes or No?", "Yes");

        return quizQuestions;
    }




    public static void OOPQuiz()  {

        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println(" ################################### ");
        System.out.println(" #                                 # ");
        System.out.println(" #   Object-Oriented Programming   # ");
        System.out.println(" #                                 # ");
        System.out.println(" ################################### ");


        System.out.println();

        System.out.println("Please answer correctly to the questions below:");
        System.out.println();



        int count = 1;

        int correctAnswerCount = 0;




        for (Map.Entry<String, String> map : questions().entrySet()) {


            try {

                Thread.sleep(1000);
                System.out.println("Question " + count++ + ".   " + map.getKey());
                System.out.println();

                System.out.print("Answer >>>  ");

                String quizInput = input.nextLine();

                if (map.getValue().equalsIgnoreCase(quizInput)) {
                    System.out.println();
                    Thread.sleep(1000);
                    System.out.println("correct answer");
                    System.out.println("**************");
                    correctAnswerCount++;
                } else {
                    System.out.println();
                    Thread.sleep(1000);
                    System.out.println("wrong answer");
                    System.out.println("************");

                    System.out.println();
                    Thread.sleep(1000);
                    System.out.print("The correct answer is " + map.getValue() + ".");
                    System.out.println();

                }
                System.out.println();

            } catch (InterruptedException e) {
                System.out.println("An error occurred!");
            }

        }

        try {
            Thread.sleep(1500);
            if (correctAnswerCount > 6) {
                System.out.println("Nice job!!!...You got " + correctAnswerCount + " questions right out of 10 questions. ");
                System.out.println("******************************************************");
            } else {
                System.out.println("You got " + correctAnswerCount + " out of 10 questions. I think you need to study more");
                System.out.println();
                System.out.print("Do you want to try again? Yes or No >>> ");

                String userInput = input.nextLine();

                if (userInput.equalsIgnoreCase("yes")) {
                    Thread.sleep(1500);
                    dataQuiz();
                } else {
                    System.out.println();
                    Thread.sleep(1500);
                    System.out.println("Thank you for taking the questions");
                    System.exit(1);

                }

            }
        }catch(InterruptedException e) {
            System.out.println("An error occurred");
        }

    }
}
