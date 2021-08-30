package quizmodel;

import view.QuizCLI;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static quizmodel.ApiQuestions.ApiQuiz;
import static quizmodel.OOPQuestions.OOPQuiz;

public class DatabaseQuestions extends QuizCLI {


    public DatabaseQuestions(DataSource dataSource) {
        super(dataSource);
    }

    public static Map<String, String> questions(){

        Map<String, String> quizQuestions = new HashMap<>();
        quizQuestions.put("A relational database is one in which the data is organized around columns and tables, Yes or No?", "Yes");
        quizQuestions.put("The language used to interact with relational database management system is called what?", "SQL");
        quizQuestions.put("Which type of join returns the rows in Table A that has a matching key value in Table B?", "inner join");
        quizQuestions.put("Rules imposed on table upon creation that limits the ability to change data is called what?", "constraint");
        quizQuestions.put("What uniquely identifies the row in a table and doesn't allow duplicates?","primary key");
        quizQuestions.put("Mapping a database table to an existing class is the sole responsibility of a what?", "Database Access Object");
        quizQuestions.put("A field in one table that uniquely identifies a row of another table is called what?", "Foreign key");
        quizQuestions.put("The 'INSERT', 'UPDATE', 'DELETE' statements is part of what language of the database?", "Data Manipulation Language");
        quizQuestions.put("JDBC Template class provides the means which a query can be made to the database, Yes or No", "Yes");
        quizQuestions.put("Which keyword statement is always used in Data Query Language?", "Select");

        return quizQuestions;
    }





    public static void databaseQuiz()  {

        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println(" ################################### ");
        System.out.println(" #                                 # ");
        System.out.println(" #             DATABASE            # ");
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
                System.out.println("*********************************************");
                System.out.println();
                ApiQuiz();
            } else {
                System.out.println("You got " + correctAnswerCount + " out of 10 questions. I think you need to study more");
                System.out.print("\nDo you want to try again? Yes or No >>> ");

                String userInput = input.nextLine();

                if (userInput.equalsIgnoreCase("yes")) {
                    Thread.sleep(1500);
                    databaseQuiz();
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
