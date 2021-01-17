package Udemy.Section5;

public class Ex13_NumberOfDaysInMonth {
    public static void main(String[] args) {
        System.out.println(getDaysInMonth(1, 2020)); // 31
        System.out.println(getDaysInMonth(2, 2020)); // 29
        System.out.println(getDaysInMonth(2, 2018)); // 28
        System.out.println(getDaysInMonth(-1, 2020)); // -1
        System.out.println(getDaysInMonth(1, -2020)); // -1
    }

    public static boolean isLeapYear(int year) {
        if ((year > 0 && year < 10000) && (year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)) {
            return true;
        } else if ((year >= 1 && year <= 9999) == (year % 4 == 0) && (year % 100 != 0)) {
            return true;
        }
        return false;
    }


    public static int getDaysInMonth(int month, int year) {
        if (year > 0 && year < 10000) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                case 2:
                    if (isLeapYear(year)) {
                        return 29;
                    } else {
                        return 28;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return -1;
            }
        }
        return -1;
    }
}