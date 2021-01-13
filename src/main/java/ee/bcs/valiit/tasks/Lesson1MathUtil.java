package ee.bcs.valiit.tasks;

public class Lesson1MathUtil {
    private String test;

    // TODO kirjuta ise (if/else) ära kasuta java.lang.Math
    public Lesson1MathUtil(String test) {
        this.test = test;
    }

    public static void main(String[] args) {
        System.out.println(min(5,7,7));
        System.out.println(max(915,9,2));
        //System.out.println(abs(a));
        //System.out.println(isEven(a));

    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a <= b) {
            return a;
        } else {
            return b; // reaalselt tagastab
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluutarv (positiivsel kujul arvu number ilma potentsiaalse miinumärgita)
    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) { // näitab, kas on paarisarv
            return true;
        } else {
            return false;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min(int a, int b, int c) {
        //return min(min(a, b), c);
        // VÕI pikem ja potentsiaalselt riskantsem variant:

        if (a <= b && a <= c){
            return a;
        } else if (b <= a && b <= c){
            return b;
        } else {
            return c;
        }
    }



    // TODO tagasta kolmest arvust kõige suurem >>> Vt see üle!!!
    public static int max(int a, int b, int c) {
        return max(max(a, b), c);

    }
}