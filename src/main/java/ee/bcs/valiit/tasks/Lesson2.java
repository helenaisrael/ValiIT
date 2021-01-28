package ee.bcs.valiit.tasks;

import java.util.*;

public class Lesson2 {

    public static void main(String[] args) {

        int[] arrayList = new int[10];
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("Sisesta 10 nr-it: ");
        for (int i = 0; i < 10; i++) {
            arrayList[i] = scannerInput.nextInt();
        }

        exercise1(arrayList);
        exercise1Web(arrayList);
        exercise2(5);
        exercise3(4, 4);
        exercise4(6);
        exercise5(3, 1);
    }


    // TODO loo 10 elemendile täisarvude massiv
    // TODO loe sisse konsoolist 10 täisarvu
    // TODO trüki arvud välja vastupidises järiekorras
    public static int[] exercise1(int[] array) {
        int[] arrayNew = new int[10];
        int j = 0;
        for (int i = 9; i >= 0; i--) {
            System.out.print(array[i] + " ");
            arrayNew[j] = array[i];
            j++;
        }
        System.out.println();
        return arrayNew;
    }

    public static int[] exercise1Web(int[] array) {
        int[] resultArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            resultArray[array.length - 1 - i] = array[i]; // siin real vahetab kohad ära jadades
//            resultArray[0] = array[i]; i = 9; array.length = 9
//            resultArray[1] = array[i]; i = 8; array.length = 9
//            resultArray[2] = array[i]; i = 7; array.length = 9
//            resultArray[3] = array[i]; i = 6; array.length = 9
//            jne...
        }
        return resultArray;
    }


    // TODO prindi välja x esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] exercise2(int x) {
        int even = 0;
        int num = 1;
        int[] array = new int[x];
        int i = 0; // i on array's index
        while (even < x) {
            if (num % 2 == 0) {
                even++;
                array[i] = num;
                System.out.println(num);
                i++; // iga kord, kui leiab paarisarvu. suurendab array indexit 1 võrra
            }
            num++;
        }
        return array;
    }


    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada tabeli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void exercise3(int x, int y) {
        System.out.println(" ");
        /*
        for (int i = 1; i <= x; i++) {
            System.out.print(i + " ");
            System.out.println(" ");
        }
        System.out.println(" ");
        */
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    // tagastada kas Stringina või 2-mõõtmelise array'na


    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element
    public static int exercise4(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0; // üleeelmine väärtus
            int b = 1; // eelmine väärtus
            for (int i = 1; i < n; i++) {
                int tmp = a; // ajutine väärtus, et meeles pidada a eelmist väärtust
                a = b;
                b = b + tmp; // sisuliselt a + b
            }
            return b;
        }
    }


    public static String exercise5(int x, int y) {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        // TODO 1 (tee alamfunktsioon) mis leiab 3n+1 sequenci pikkuse
        // kui on paaris, siis /2; kui on paaritu, siis *3+1
        // TODO 2 tee tsükkel mis leiab i -> j kõige suurema tsükli pikkuse

        int maxLength = 0; // suurima tsükli pikkuse alguspunkt
        for (int i = x; i <= y; i++) {
            int mySeqLength = seqLength(i); //siin defineerin sequence nime
            if (mySeqLength > maxLength) {
                maxLength = mySeqLength; // kõige pikem tsükli pikkus selles vahemikus
            }
            return x + " " + y + " " + maxLength;
        }
        return null;
    }

    public static int seqLength(int n) { // funktsioon, mis leiab 3n + 1 jada pikkuse
        int count = 1; // tsükli alguspunkt
        while (n > 1) {
            count++; // liida 1
            if (n % 2 == 0) {
                n = n / 2; // kui n on paarisarv
            } else {
                n = n * 3 + 1; // kui n on paaritu arv
            }
        }
        return count;
    }
}
