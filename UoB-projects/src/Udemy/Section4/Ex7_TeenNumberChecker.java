package Udemy.Section4;

public class Ex7_TeenNumberChecker {
    public static void main(String[] args) {
        System.out.println(hasTeen(9, 99, 19)); // true
        System.out.println(hasTeen(23, 15, 42)); // true
        System.out.println(hasTeen(22, 23, 34)); // false
    }

//    public static boolean hasTeen(int a, int b, int c) {
//        boolean aRange = (a >= 13 && a <= 19);
//        boolean bRange = (b >= 13 && b <= 19);
//        boolean cRange = (c >= 13 && c <= 19);
//        if (aRange || bRange || cRange) {
//            return true;
//        }
//        return false;
//    }

//    public static boolean hasTeen(int a, int b, int c) {
//        if ((a >= 13 && a <= 19) || (b >= 13 && b <= 19) || (c >= 13 && c <= 19)) {
//            return true;
//        }
//        return false;
//    }


    public static boolean hasTeen(int a, int b, int c) {
        boolean isTeen = false;
        return isTeen(a) || isTeen(b) || isTeen(c); // if isTeen with a value of nr1 or nr2 or nr3 is true, then it's true
    }

    public static boolean isTeen(int x) {  // isTeen is using the variable (int type) nr1... he/she could have made this x or any other variable.
        return (x >= 13 && x <= 19);  // value is passed into isTeen and checks if the value is within 13-19. if it is, then it's true
    }
}