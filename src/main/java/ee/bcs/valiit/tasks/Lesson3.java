package ee.bcs.valiit.tasks;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(array));
        System.out.println(sum(array));

        System.out.println(" ");

        int x = 5;
        System.out.println("Faktoriaal = " + factorial(x));

        System.out.println(" ");

        int[] a = new int[]{1, 4, 3, 0, 2};
        System.out.println("Sortimisharjutuse vastus " + sort(a));
    }

    public static int sum(int[] x) {
        // TODO liida kokku kõik numbrid massiivis x
        int sumNum = 0;
        for (int i = 0; i < x.length; i++) {
            System.out.println("i väärtus: " + i);
            System.out.println("sumNum väärtus: " + sumNum);
            System.out.println("Toimub tehe: sumNum = " + sumNum + " + " + x[i]);
            sumNum += x[i];
        }
        return sumNum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // 5! = 1*2*3*4*5 = 120 <- faktoriaal
        // return 5*4*3*2*1 = 120
        int fact = 1;
        for (int i = 1; i <= x; i++) {
            fact = fact * i; // fact *= i;
        }
        return fact;

        // Kui teha faktoriaal tagurpidi (5*4*3*2*1)
        /*for (int i = x; i >= 1; i--) {
            fact = fact * i;
        }
        return fact;
        */
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi.
        // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
        int sortArray = 0;
        for (int i = 0; i < a.length; i++) {

        }
        return new int[0];
    }


    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi

        return "";
    }

    public static boolean isPrime(int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)

        return false;
    }
}
