package view;

import dao.JdbcUserDAO;
import dao.UserDAO;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;


import java.util.Scanner;


import static quizmodel.OOPQuestions.quizPrint;
import static quizmodel.quizMenu.displayBanner;
import static quizmodel.quizMenu.runDisplay;

public class QuizCLI {


        private static UserDAO quizUser;
        private static Scanner user = new Scanner(System.in);
        private static boolean isLoggedIn = true;
        private static String username;
        private static String password;



        public static void main(String[] args) {

            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:postgresql://localhost:5432/quiztable");
            dataSource.setUsername("postgres");
            dataSource.setPassword("postgres1");

            QuizCLI application = new QuizCLI(dataSource);
            application.run();

        }

        public QuizCLI(DataSource dataSource) {
            this.quizUser = new JdbcUserDAO(dataSource);
        }






    public static boolean loginMenu() {

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
        return true;
    }


    private static void firstLogIn() {

        System.out.print("Username: ");
        username = user.nextLine();
        System.out.print("Password: ");
        password = user.nextLine();

        if(!username.isBlank() && !password.isBlank()) {

            System.out.println();
            System.out.println("\t\t\t" + "Welcome " + username);

            runDisplay();

            isLoggedIn = false;

        }


    }

    private void run() {
        loginMenu();

    }








 }
