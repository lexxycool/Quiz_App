package quizmodel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static quizmodel.DataTypesAndArrayQuestions.dataQuiz;

public class OOPQuestions {


    public static Map<String, String> questions(){

        Map<String, String> quizQuestions = new HashMap<>();
        quizQuestions.put("Can we overload a static method in Java  Yes or No?", "Yes");
        quizQuestions.put("What keyword can be used to refer to the parent's variables and methods?", "super");
        quizQuestions.put("Which class is the superclass of all classes?", "Object");
        quizQuestions.put("The type of programming that focuses on objects is called?", "Object Oriented Programming");
        quizQuestions.put("Which concept in OOP is applied when combining properties and methods in a single unit", "Encapsulation");
        quizQuestions.put("A hidden process in the JVM that automatically scoops up and destroys objects not in use is called?", "Garbage Collection");
        quizQuestions.put("The final keyword at the class level means it can't be inherited?  Yes or No", "Yes");
        quizQuestions.put("In Java are objects passed by value or by reference?", "value");
        quizQuestions.put("The ability of our code to take different forms is known as ?", "Polymorphism");
        quizQuestions.put("Which principle of OOP is described as parent-child relationship?", "Inheritance");

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
