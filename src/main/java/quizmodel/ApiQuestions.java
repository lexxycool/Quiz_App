package quizmodel;

import view.QuizCLI;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ApiQuestions extends QuizCLI {

    public ApiQuestions(DataSource dataSource) {
        super(dataSource);
    }

    public static Map<String, String> questions(){

        Map<String, String> quizQuestions = new HashMap<>();
        quizQuestions.put("The data used to interact with the API must be in what format?", "JSON");
        quizQuestions.put("What does the status code '501' mean?", "Internal Server Error");
        quizQuestions.put("A set of functions and/or procedures designed to interact with an external system is called what?", "API");
        quizQuestions.put("The request type ideally suited to insert new data into the datasource is what?", "POST");
        quizQuestions.put("The process of converting JSON objects to Java objects is known as ?","Deserialization");
        quizQuestions.put("The JdbcTemplate is to the server as restTemplate is to?", "Client");
        quizQuestions.put("A well defined route that can be able to communicate with an external application is what?", "Endpoint");
        quizQuestions.put("A web service could potentially consume another API in order to function, Yes or No?", "Yes");
        quizQuestions.put("What is the process of verifying that a user is able to access a system?", "Authentication");
        quizQuestions.put("Which annotation helps you to create an object of a class without invoking the constructor manually?", "@component");

        return quizQuestions;
    }





    public static void ApiQuiz()  {

        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println(" ################################### ");
        System.out.println(" #                                 # ");
        System.out.println(" #          API SERVICES           # ");
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
                    newCount = ++correctAnswerCount;
                    userDAO.scores(newCount, username);
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
                System.out.println("************************************************************");
                System.out.println("\nThank you for taking the quiz.");
            } else {
                System.out.println("You got " + correctAnswerCount + " out of 10 questions. I think you need to study more");
                System.out.print("\nDo you want to try again? Yes or No >>> ");

                String userInput = input.nextLine();

                if (userInput.equalsIgnoreCase("yes")) {
                    Thread.sleep(1500);
                   ApiQuiz();
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
