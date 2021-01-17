package Udemy.Section5;

public class Challenge_ForStatement {

    public static void main(String[] args) {
        System.out.println("10,000 at 2% interest = " + calculateInterest(10000.0, 2.0));
        System.out.println("10,000 at 3% interest = " + calculateInterest(10000.0, 3.0));
        System.out.println("10,000 at 4% interest = " + calculateInterest(10000.0, 4.0));
        System.out.println("10,000 at 5% interest = " + calculateInterest(10000.0, 5.0));
        System.out.println();

        //remember i is only used inside that loop (does not exist after exiting the loop), it can be reused in the next loop
        for (int i = 0; i < 5; i++) { // typically i or j or k are used
            System.out.println("Loop " + i + " hello!");
        }
        System.out.println();


        // using the for statement, call the calculateInterest method with
        // the amount of 10000 with an interestRate of 2,3,4,5,6,7, and 8
        // and print the results to the console window.
        for (int i = 2; i < 9; i++) { // ND: remeber, when i reaches 9, the loop is exited
            System.out.println("10,000 at " + i + "% interest = " + calculateInterest(10000.0, i)); //i is casted to int here, but could also be: (double) i
            System.out.println("10,000 at " + i + "% interest = "
                    + String.format("%.2f", calculateInterest(10000.0, i))); // we're passing the value to String.format command
            // %.2f converts the nr and outputs it with 2 decimal points
        }

        System.out.println("****************");

        // How would you modify the for loop above to do the same thing as shown but to start from 8% and work back to 2%
        for (int i = 8; i >= 2; i--) {
            System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000.0, i)));
        }
        System.out.println();

        // Create a for statement using any range of numbers
        // Determine if the number is a prime number using the isPrime method
        // if it is a prime number, print it out AND increment a count of the
        // number of prime numbers found
        // if that count is 3, exit the loop
        // hint:  Use the break; statement to exit

        // NB: prime nr can only be: 1) greater than 1; and 2) divided with only 1 or itself!
//        public static boolean isPrime (int n) {
//            int count = 0;
//            for (int i = 10; i < 50; i++) {
//                if (isPrime(i)) {
//                    count++;
//                    System.out.println("Number " + i + " is a prime number");
//                    if (count == 3) { // when 3 prime nrs have been found, loop is exited
//                        System.out.println("Exiting for loop");
//                        break;
//                    }
//                }
//            }
//        }

    }

//    public static boolean isPrime(int m) {
//        if (m == 1) { // testing that m is not 1 (which is not a prime nr), therefore in for loop i=2 (i.e. starts from 2)!
//            return false;
//        }
//
//        for (int i = 2; i <= m / 2; i++) { // n/2 because we only want to find nr-s that divide into m (because no nr that is >n/2 is going to divide with n!)
//            // OR: for (int = 2; i <= (long) Math.sqrt(n); ++) { // casting to long and using the Math square root > less processing, thus faster - TEST!
//            System.out.println("Looping " + i);
//            if (m % i == 0) { // checking whether there is a remainder, if no remainder, it means it is not a prime nr
//                return false;
//            }
//        }
//
//        return true;
//    }
//        // NB: prime nr can only be: 1) greater than 1; and 2) divided with only 1 or itself!
//        public static boolean isPrime (int n) {
//            int count = 0;
//            for (int i = 10; i < 50; i++) {
//                if (isPrime(i)) {
//                    count++;
//                    System.out.println("Number " + i + " is a prime number");
//                    if (count == 10) {
//                        System.out.println("Exiting for loop");
//                        break;
//                    }
//                }
//            }
//        }
//    }

    public static boolean isPrime(int n) {

        if (n == 1) { // testing that n is not 1 (which is not a prime nr), therefore in for loop i=2 (i.e. starts from 2)!
            return false;
        }

        for (int i = 2; i <= n / 2; i++) { // n/2 because we only want to find nr-s that divide into n (because no nr that is >n/2 is going to divide with n!)
            System.out.println("Looping " + i);
            if (n % i == 0) { // checking whether there is a remainder, if no remainder, it means it is not a prime nr
                return false;
            }
        }

        return true;

    }



    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }
}
