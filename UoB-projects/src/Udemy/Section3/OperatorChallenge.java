package Udemy.Section3;

public class OperatorChallenge {

    public static void main(String[] args) {
        double firstVar = 20.00d;
        double secondVar = 80.00d;
        double combinedVar = (firstVar + secondVar) * 100.00d;
        System.out.println("combinedVar = " + combinedVar);
        double remainderVar = combinedVar % 40.00d;
        System.out.println("remainderVar = " + remainderVar);
        boolean isNoRemainder = (remainderVar == 0) ? true : false;
        System.out.println("isNoRemainder = " + isNoRemainder);
        if (!isNoRemainder) {
            System.out.println("Got some remainder");
        }
    }
}
