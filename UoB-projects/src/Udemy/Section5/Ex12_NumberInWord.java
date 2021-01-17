package Udemy.Section5;

import jdk.swing.interop.SwingInterOpUtils;

public class Ex12_NumberInWord {
    public static void main(String[] args) {
        printNumberInWord(1);
        printNumberInWord(7);
        printNumberInWord(-1);
        printNumberInWord(11);
    }

//    public static void printNumberInWord(int x) {
//        switch (x) {
//            case 0:
//                System.out.println("ZERO");
//                break;
//            case 1:
//                System.out.println("ONE");
//                break;
//            case 2:
//                System.out.println("TWO");
//                break;
//            case 3:
//                System.out.println("THREE");
//                break;
//            case 4:
//                System.out.println("FOUR");
//                break;
//            case 5:
//                System.out.println("FIVE");
//                break;
//            case 6:
//                System.out.println("SIX");
//                break;
//            case 7:
//                System.out.println("SEVEN");
//                break;
//            case 8:
//                System.out.println("EIGHT");
//                break;
//            case 9:
//                System.out.println("NINE");
//                break;
//            default:
//                System.out.println("OTHER");
//                break;
//        }
//    }

    public static void printNumberInWord(int x) {
        if (x == 0) {
            System.out.println("ZERO");
        } else if (x == 1) {
            System.out.println("ONE");
        } else if (x == 2) {
            System.out.println("TWO");
        } else if (x == 3) {
            System.out.println("THREE");
        } else if (x == 4) {
            System.out.println("FOUR");
        } else if (x == 5) {
            System.out.println("FIVE");
        } else if (x == 6) {
            System.out.println("SIX");
        } else if (x == 7) {
            System.out.println("SEVEN");
        } else if (x == 8) {
            System.out.println("EIGHT");
        } else if (x == 9) {
            System.out.println("NINE");
        } else { // kas else võiks siit ka ära jätta tegelikult? Udemy kontrollis väitis, et muidu saab 0 vastuseks ZEROOTHER
            System.out.println("OTHER");
        }
    }
}
