package Udemy.Section4;

public class Ex4_LeapYearCalculator {
    public static void main(String[] args) {
        System.out.println(isLeapYear(-1600)); // false
        System.out.println(isLeapYear(1600)); // true
        System.out.println(isLeapYear(2017)); // false
        System.out.println(isLeapYear(2000)); // true
        System.out.println(isLeapYear(1924)); // true
        System.out.println(isLeapYear(0)); // false
        System.out.println(isLeapYear(1800)); // false

    }

    /*
    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) {
            if (year % 4 == 0) { // step 1
                if (year % 100 == 0) {
                    if (year % 400 == 0) { // step 2 & 3
                        return true; // step 4
                    }
                    return false;
                }
                return true;
            }
            return false; // step 5
        }
        return false;
    }
    */


    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) { // precondition for leap year
            if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)) { // step 1-3
                return true;
            } else if ((year % 4 == 0) && (year % 100 != 0)) {
                return true;
            }
            return false;
        }
        return false;
    }
}