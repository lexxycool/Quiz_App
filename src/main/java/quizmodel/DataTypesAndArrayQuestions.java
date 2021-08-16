package quizmodel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DataTypesAndArrayQuestions {


    public static Map<String, String> questions(){

        Map<String, String> quizQuestions = new HashMap<>();
        quizQuestions.put("A data structure where each link contains a connection to another link is called?", "Linked List");
        quizQuestions.put("If a class has more than one method with same name but different list of parameters. It is called what?", "Method Overloading");
        quizQuestions.put("Which type of collection can be used to store key value pairs?", "Map");
        quizQuestions.put("What is responsible for converting byte code to machine readable code", "Java Virtual Machine");
        quizQuestions.put("The process of converting a primitive data type to a reference type is known as what?","Autoboxing");
        quizQuestions.put("Which data structure is commonly described as 'Last In First Out'?", "Stack");
        quizQuestions.put("A singleton class in Java can have only one instance Yes or No?", "Yes");
        quizQuestions.put("What keyword at the class level means no concrete objects can be created?", "Abstract");
        quizQuestions.put("Strings have the ability to be instantiated without the keyword 'new' , Yes or No?", "Yes");
        quizQuestions.put("Access specifier that can be accessible from anywhere is classified as?", "Public");

        return quizQuestions;
    }





    public static void dataQuiz()  {

        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println(" ################################### ");
        System.out.println(" #                                 # ");
        System.out.println(" #      DATA TYPES AND ARRAYS      # ");
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
                System.out.println("*********************************************");
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
