package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {
    public static void main(String[] args) {
        System.out.println("Suurim paarisarv selles fibonacci jadas on: " + evenFibonacci(8));
        System.out.println();

        System.out.println(morseCode("SOS help"));
        System.out.println(morseCode("Helena Israel"));
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
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int randomNumber = random.nextInt(100); // NB: oluline def ära ENNE tsüklit!
        int count = 0; // NB: oluline def ära ENNE tsüklit

        System.out.println("Arvuti valis ühe numbri vahemikus 1-100. Arva see ära!");
        while (true) { // infinite loop, sest ei tea, mitu x kasutaja hakkab arvama
            count++;
            System.out.println("");
            int guess = scanner.nextInt();
        }
    }

    public static String morseCode(String text){
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        // kasuta HashMap
        // charString
        return "";
    }
}
