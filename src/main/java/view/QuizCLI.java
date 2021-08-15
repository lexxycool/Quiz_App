package view;

import dao.JdbcUserDAO;
import dao.UserDAO;
import org.apache.commons.dbcp2.BasicDataSource;
import quizdata.User;

import javax.sql.DataSource;


import java.util.List;
import java.util.Scanner;


import static quizmodel.quizMenu.displayBanner;
import static quizmodel.quizMenu.runDisplay;

public class QuizCLI {


        private static UserDAO quizUser;
        private static Scanner user = new Scanner(System.in);
        private static boolean isLoggedIn = true;
        private static String username;
        private static String password;
        private static UserDAO userDAO;


        public static void main(String[] args) {

            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:postgresql://localhost:5432/QuizDatabase");
            dataSource.setUsername("postgres");
            dataSource.setPassword("postgres1");


            QuizCLI application = new QuizCLI(dataSource);
            application.run();

        }

        public QuizCLI(DataSource dataSource) {
            userDAO = new JdbcUserDAO(dataSource);
        }






    public static boolean loginMenu() {

        displayBanner();

        while(isLoggedIn) {
            try {
                System.out.println("1. New user");
                System.out.println("2. Log in");
                System.out.println("3. Show all users");
                System.out.println("4. Show user by id");
                System.out.println("5. Show user and score");
                System.out.println("6. Quit");
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
                    getAllUsers();
                    isLoggedIn = false;
                }
                else if(newUser == 4) {
                    System.out.print("\nPlease enter the id of the user: ");
                    int userId = Integer.parseInt(user.nextLine());
                    User user = userDAO.getUserById(userId);
                    System.out.println(user);

                    isLoggedIn = false;
                }else if(newUser == 5) {
                    System.out.println("user and score");

                    isLoggedIn = false;
                }
                else if(newUser == 6) {
                  System.out.println("\nThank you for using Quiz Time Application");
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

    public static void  getAllUsers() {
        List<User> user = userDAO.getAllUsers();
        int count = 1;
        for(User users: user) {
         System.out.println(count + ". " + users);
          count++;
        }
    }

   /* public User getUser(int id){
            return userDAO.getUserById(id);
    }*/











 }
