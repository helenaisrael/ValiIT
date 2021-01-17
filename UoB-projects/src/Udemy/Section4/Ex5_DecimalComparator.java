package Udemy.Section4;

import java.sql.SQLOutput;

public class Ex5_DecimalComparator {
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175)); // true
        System.out.println(areEqualByThreeDecimalPlaces(3.1756, 3.176)); // false
        System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0)); // true
        System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123)); // false
    }

    public static boolean areEqualByThreeDecimalPlaces(double a, double b) {
        int aRounded = (int) (a * 1000);
        int bRounded = (int) (b * 1000);
        System.out.println("Rounded results: " + aRounded + " & " + bRounded);
        if (aRounded == bRounded) {
            return true;
        }
        return false;
    }
}
