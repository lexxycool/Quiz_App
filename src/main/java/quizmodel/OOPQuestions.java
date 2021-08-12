package quizmodel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class OOPQuestions {


    public static void main(String[] args) throws InterruptedException {


                quizPrint();

        }





    public static Map<String, String> questions(){

        Map<String, String> quizQuestions = new HashMap<>();
        quizQuestions.put("Which principle of OOP describes a new class based on an existing class?", "Inheritance");
        quizQuestions.put("If a class has more than one method with same name but different list of parameters. It is called what?", "Method Overloading");
        quizQuestions.put("Which type of collection can be used to store key value pairs?", "Map");
        quizQuestions.put("Exploratory testing is a type of automated testing, Yes or No? ", "No");
        quizQuestions.put("The process of converting a primitive data type to a reference type is known as what?","Autoboxing");
        quizQuestions.put("Which data structure is commonly described as 'Last In First Out'?", "Stack");
        quizQuestions.put("Which type of testing validates that existing functionality continues to operate as normal?", "Regression testing");
        quizQuestions.put("What keyword at the class level means no concrete objects can be created?", "Abstract");
        quizQuestions.put("Strings have the ability to be instantiated without the keyword 'new' , Yes or No?", "Yes");
        quizQuestions.put("Checked exceptions are compiled-time exceptions that must be handled or declared...Yes or No?", "Yes");

        return quizQuestions;
    }





    public static void quizPrint() throws InterruptedException {

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
            }

            System.out.println();

        }
        if(correctAnswerCount > 6) {
            System.out.println("Nice job!!!...You got " + correctAnswerCount + " questions right out of 10 questions. ");
            System.out.println("*********************************************");
        }else {
            System.out.println("You got " + correctAnswerCount + " out of 10 questions. I think you need to study more");
            System.out.println();
            System.out.print("Do you want to try again? Yes or No >>> ");

            String userInput = input.nextLine();

            if (userInput.equalsIgnoreCase("yes")) {
                quizPrint();
            } else {
                System.out.println("Thank you...");

            }
        }

    }

}
