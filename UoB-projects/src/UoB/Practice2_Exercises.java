package UoB;

import java.util.Scanner;

public class Practice2_Exercises {

   public static void main(String[] args) {
       /*
       // Ex1
       Scanner scanner1 = new Scanner(System.in);
       System.out.println("Ex1 - please enter a number.");
       int input1 = scanner1.nextInt();
       if (input1 % 2 == 0) {
           System.out.println(input1 + " is even.");
       } else { // NB: "else" võib siit vahelt ka ära jätta!
           System.out.println(input1 + " is odd.");
       }

       // Ex2
       System.out.println();
       Scanner scanner2 = new Scanner(System.in);
       System.out.println("Ex2 - please enter a number.");
       int input21 = scanner2.nextInt();
       System.out.println("Please enter another number.");
       int input22 = scanner2.nextInt();
       int product2 = input21 * input22;
       if (product2 < 100) {
          System.out.println("Product of the numbers entered is < 100, i.e. " + product2);
       }

       // Ex3
       System.out.println();
       Scanner scanner3 = new Scanner(System.in);
       System.out.println("Ex3 - please enter a number.");
       int input31 = scanner3.nextInt();
       System.out.println("Please enter another number.");
       int input32 = scanner3.nextInt();
       System.out.println("Please enter one more number.");
       int input33 = scanner3.nextInt();
       int sum3 = input31 + input32;
       if (sum3 != input33) {
           System.out.println("The sum of the first two numbers " +
                   "is not equal to the value of the third number");
       } else {
           System.out.println(input31 + " and " + input32 +
                   " are a number bond of " + input33);
       }


       // Ex4
       System.out.println();
       Scanner scanner4 = new Scanner(System.in);
       System.out.println("Ex4 - please enter your age (in numbers): ");
       int input4 = scanner4.nextInt();
       if (input4 > 0) {
           if (input4 < 18) {
               System.out.println("You are too young.");
           } else if (input4 > 18 && input4 <= 50) {
               System.out.println("You may proceed.");
           } else {
               System.out.println("You are too old.");
           }
       }
       */

       //Ex5
       System.out.println();
       Scanner scanner5 = new Scanner(System.in);
       System.out.println("Ex5 - please enter 3 numbers:");
       int input51 = scanner5.nextInt();
       int input52 = scanner5.nextInt();
       int input53 = scanner5.nextInt();
       int maxValue;
       if (input51 >= input52 && input52 >= input53) {
           maxValue = input51;
       } else if (input52 >= input51 && input51 >= input53) {
           maxValue = input52;
       } else {
           maxValue = input53;
       }
       System.out.println("The biggest number is " + maxValue);

       // Ex6
       System.out.println();
       Scanner scanner6 = new Scanner(System.in);
       System.out.println("Ex6 - please enter a code of 2 numbers " +
               "followed by 2 characters and another number:");
       String input61 = scanner6.nextLine();
       





    }
}
