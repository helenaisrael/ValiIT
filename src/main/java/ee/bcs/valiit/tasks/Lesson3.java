package ee.bcs.valiit.tasks;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {
        /*
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(array));
        System.out.println(sum(array));
        System.out.println("");

        int x = 5;
        System.out.println("Faktoriaal = " + factorial(x));
        System.out.println("");
        */

        int[] newArray = new int[]{5, -6, 9, 12, 7};
        System.out.println("Algne massiiv: " + Arrays.toString(newArray));
        System.out.println("Sortimisharjutuse vastus " + Arrays.toString(sort(newArray)));
        System.out.println("Sortimisharjutuse vastus " + Arrays.toString(sortNew(newArray)));
        System.out.println("Sortimisharjutuse vastus " + Arrays.toString(sort2(newArray)));
        System.out.println();

        System.out.println(reverseString("Pastöriseeritud piim"));
        System.out.println(reverseString2("Helena testib"));
        System.out.println();

        System.out.println(isPrime(8)); // nt 4, 6, 8, 9 ei ole primaararvud
        System.out.println(isPrime(29)); // nt 2, 3, 5, 7 on primaararvud
        System.out.println(isPrime(44));
        System.out.println(isPrime(19));
    }

    public static int sum(int[] x) {
        // TODO liida kokku kõik numbrid massiivis x
        int sumNum = 0; // inits. sama asi, mille all returnin
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


    // bubble sort
    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi.
        // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni

        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length - 1 - j; i++) { // -1 JA -j et tsükkel oleks lühem ja ei võrdleks enam lõpus juba õigeid nr-id!
                if (a[i] > a[i + 1]) {
                    int tempValue = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tempValue;
                }
            }
        }
        return a;
    }

    // 5, -6, 9, 12, 7
    // selection sort - leiab esimese minimaalse ja jätab paika, seejärel võrdleb allesjäänud massiivi
    // ja asetab järgmisele kohale suuruselt järgmise
    public static int[] sortNew(int[] b) {
        int[] temp = b;
        for (int i = 0; i < b.length - 1; i++) { // leian
            int min = b[getMin(b, i)];
            temp[i] = min;
        }
        return temp;
    }

    private static int getMin(int[] b, int i) { // see funkts leiab ainult min indexi ehk positsiooni
        int min = i;
        for (int j = i + 1; j < b.length; j++) {
            if (b[j] < b[min]) {
                min = j;
            }
        }
        return min;
    }


    // Siimu lahenduskäik (selection sort):
    public static int[] sort2(int[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            int minIndex = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            int tmp = array[j];
            array[j] = array[minIndex];
            array[minIndex] = tmp;
        }
        return array;
    }


    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        String reverse = ""; // teen string muutuja, millel pole sisu (0-pikkusega tekst), kuhu hakkan lisama tähti
        for (int i = a.length() - 1; i >= 0; i--) { // kontr. stringi pikkus-1, kas on suurem kui 0
            reverse = reverse + a.charAt(i); // lisab stringi 1. tähe lõpust, seejärel hüppab tagasi for'i ja kontr. sama
        } // ... kuni kõik tähed on tagurpidises jrk-s lisatud stringi
        return reverse; //tagastab reverse nimelise stringi
    }
    public static String reverseString2(String a) { // Siimu lahendus, kasut .substringi funkts
        // TODO tagasta string tagurpidi
        String result = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            result += a.substring(i, i + 1);
        }
        return result;
    }

    public static boolean isPrime(int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        boolean prime = false;
        for (int i = 2; i <= x / 2; ++i) { // kas jagub 2...x/2-ni (a number is not divisible by more than its half!)
            if (x % i == 0) { // kui ei ole primaararv, siis ... või siin sulgudes võiks olla sama hästi ka x/x==1...?
                prime = true;
                break;
            }
        }
        if (!prime) {
            System.out.println(x + " on primaararv");
        } else {
            System.out.println(x + " ei ole primaararv.");
        }
        return !prime;
    }
}




