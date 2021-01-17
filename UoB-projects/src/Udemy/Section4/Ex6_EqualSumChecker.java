package Udemy.Section4;

public class Ex6_EqualSumChecker {
    public static void main(String[] args) {
        System.out.println(hasEqualSum(1, 1, 1)); // false
        System.out.println(hasEqualSum(1, 1, 2)); // true
        System.out.println(hasEqualSum(1, -1, 0)); // true
    }

    public static boolean hasEqualSum(int a, int b, int c) {
        if(a+b==c) {
            return true;
        }
        return false;
    }
}
