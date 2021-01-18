package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {
    public static void main(String[] args) {
//        System.out.println("Suurim paarisarv selles fibonacci jadas on: " + evenFibonacci(8));
//        System.out.println();
//
//        randomGame();
//        System.out.println();

        System.out.println(morseCode("vali-it"));
        System.out.println(morseCode("sos help"));
        System.out.println(morseCode("? on küsimärk"));
        System.out.println(morseCode("helena israel"));
        System.out.println(morseCode("3 poega ja 1 tütar"));
    }

    public static int evenFibonacci(int x){
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x (st kuni väärtuseni)
        boolean isEven;
        int sum = 0;
        if (x == 0) { // loon fibonacci jada
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            int a = 0; // üle-eelmine väärtus
            int b = 1; // eelmine väärtus
            while (b <= x) { // tee ümber while tsükliks!
                if (b % 2 == 0) { // kui b on paarisarv
                    sum = sum + b; // sama mis sum += b;
                }
                int tmp = a; // ajutine väärtus, et meeles pidada a eelmist väärtust
                a = b;
                b = b + tmp; // sisuliselt b + a >> b ehk b saab jadas viimase väärtuse
            }
            return sum;
        }
    }

    public static void randomGame(){
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema, kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära arvamise korral peab programm välja trükkima, mitu katset läks numbri ära arvamiseks
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 0; // NB: oluline def ära ENNE tsüklit
        int randomNumber = random.nextInt(100); // NB: oluline def ära ENNE tsüklit!!!
        System.out.println("Arvuti valis ühe numbri vahemikus 1-100. Arva see ära! Sul on 10 võimalust");

        while (true) { // infinite loop, sest ei tea, mitu x kasutaja hakkab arvama
            count++;
            System.out.println("Sisesta number");
            int guess = scanner.nextInt();
            if (guess == randomNumber) {
                System.out.println("Tubli, arvasid ära " + count + ". korraga!");
                break;
            } else if (count >= 10) {
                System.out.println("Ei arvanud ära. Tegelik number oli " + randomNumber);
                break;
            } else if (guess > randomNumber) {
                System.out.println("Proovi uuesti, number on väiksem " + guess + "-st");
            } else {
                System.out.println("Proovi uuesti, number on suurem " + guess + "-st");
            }
        }
    }

    public static String morseCode(String text){
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        // kasuta HashMap
        // charString
        Map<String, String> morseCodes = new HashMap<>();
        morseCodes.put("a", ".- ");
        morseCodes.put("b", "-... ");
        morseCodes.put("c", "-.-. ");
        morseCodes.put("d", "-.. ");
        morseCodes.put("e", ". ");
        morseCodes.put("f", "..-. ");
        morseCodes.put("g", "--. ");
        morseCodes.put("h", ".... ");
        morseCodes.put("i", ".. ");
        morseCodes.put("j", ".--- ");
        morseCodes.put("k", "-.- ");
        morseCodes.put("l", ".-.. ");
        morseCodes.put("m", "-- ");
        morseCodes.put("n", "-. ");
        morseCodes.put("o", "--- ");
        morseCodes.put("p", ".--. ");
        morseCodes.put("q", "--.- ");
        morseCodes.put("r", ".-. ");
        morseCodes.put("s", "... ");
        morseCodes.put("t", "- ");
        morseCodes.put("u", "..- ");
        morseCodes.put("v", "...- ");
        morseCodes.put("w", ".-- ");
        morseCodes.put("ä", ".-.- ");
        morseCodes.put("ö", "---. ");
        morseCodes.put("õ", "---. ");
        morseCodes.put("ü", "..-- ");
        morseCodes.put("x", "-..- ");
        morseCodes.put("y", "-.-- ");
        morseCodes.put("z", "--.. ");
        morseCodes.put("1", ".---- ");
        morseCodes.put("2", "..--- ");
        morseCodes.put("3", "...-- ");
        morseCodes.put("4", "....- ");
        morseCodes.put("5", "..... ");
        morseCodes.put("6", "-.... ");
        morseCodes.put("7", "--... ");
        morseCodes.put("8", "---.. ");
        morseCodes.put("9", "----. ");
        morseCodes.put("0", "----- ");
        morseCodes.put(".", ".-.-.- ");
        morseCodes.put(",", "--..-- ");
        morseCodes.put(":", "---... ");
        morseCodes.put("?", "..--.. ");
        morseCodes.put("-", "--...- ");
        morseCodes.put("(", "-.--.- ");
        morseCodes.put(")", "-.--.- ");
        morseCodes.put(" ", "   ");

        String result = "";
        for(int i = 0; i < text.length(); i++){
            String character = text.substring(i, i+1);
            result += morseCodes.get(character) + " ";
        }
        return result;
    }
}
