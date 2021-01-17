package UoB;

import java.util.Scanner;

public class Practice1_Exercises {

    public static void main(String[] args){
        // Write a program that outputs the result of the following expressions
        // Before you run the program, state what you think the output will be.

        // Ex1
        System.out.println("Ex1 output is: " + (14-3*8/2));
        System.out.println("Output should be: 2");
        System.out.println();

        // Ex2
        System.out.println("Ex2 output is: " + (20- -2*5/2));
        System.out.println("Output should be: 25");
        System.out.println();

        // Ex3
        System.out.println("Ex3 output is: " + ((2+5)*2*5.0/2));
        System.out.println("Output should be: 35");
        System.out.println();

        // Ex4
        System.out.println("Ex4 output is: " + (!true || true && (false || !false && true)));
        System.out.println("Output should be: true");
        System.out.println();
/*
        // Ex5
        int a = 5;
        int b = 6;
        int c = 7;
        int d = a + b++ + b; //NB: a5+b6+b7, sest enne järgm (viimast) tehet b6+1!!!
        System.out.println("Ex5 output for \"d\" is: " + d);
        System.out.println("Output should be: (5+6+7=)18");
        System.out.println();

        // Ex6
        int a = 5;
        int b = 6;
        int c = 7;
        int e = ++b - a + ++c + b; //NB: (1+b6)-a5+(1+c7)+b7, st lõpus on b väärtus 7!!!
        System.out.println("Ex6 output for \"e\" is: "+ e);
        System.out.println("Output should be: 17");
        System.out.println();

        // Ex7
        int a = 5;
        int b = 6;
        int c = 7;
        int f = a * b++ - c * b; // (5*6)-(7*7)
        System.out.println("Ex7 output is: " + (f));
        System.out.println("Output should be: -19");
        System.out.println();

        // Ex8
        int a = 5;
        int b = 6;
        int c = 7;
        boolean b1 = a < --b; // 5 < 5
        System.out.println("Ex8 output is: " + b1);
        System.out.println("Output should be 5<5, i.e.: false");
        System.out.println();

        // Ex9
        int a = 5;
        int b = 6;
        int c = 7;
        boolean b2 = c-- <= ++a +1; // 7 >> 6<=6+1
        System.out.println("Ex9 output is: " + b2);
        System.out.println("Output should be 6<7, i.e.: true");
        System.out.println();

        // Ex10
        int a = 5;
        int b = 6;
        int c = 7;
        c--; // ehk c=6 (uus väärtus)
        boolean b3 = c == b && a++ < c; // 6=6 & 5<6 >> NB: a väärtus ei muutu, kuna ++ on pärast!!!
        System.out.println("Ex10 output is: " + b3);
        System.out.println("Output should be: true");
        System.out.println();

        // Ex11
        int num1 = 4;
        int num2 = 6;
        int num3 = 4;
        int sum1 = num1 + num2;
        float result = sum1 / num3; // NB: 10/4=2.5 AGA kuna sum1 on int, siis result täisarv e 2!!!
        System.out.println("Ex11 output is: " + result);
        System.out.println("Output should be: 2.0");
        float sum2 = num1 + num2;
        float result2 = sum2 / num3; // kui sum2 on float, siis result2 tulemus on 2.5
        System.out.println("Ex11 output as float would be: " + result2);
        System.out.println();

        // Ex12
        float val1 = 1;
        float val2 = 2;
        float val3 = 3;
        float val4 = 4;
        float total = val1 + val2 + val3 + val4;
        float mean = total/4;
        System.out.println("Ex12 output is: " + mean);
        System.out.println("Output should be: 2.5");
        System.out.println();

        // Ex13
        int a = 1;
        int b = a*2;
        int c = b*2;
        int d = c*2;
        int e = d*2;
        float sum = a+b+c+d+e;
        float mean = sum/5;
        System.out.println("Ex13 output for \"mean\" is: " + mean);
        System.out.println("Output should be: 6.2");
        System.out.println();
*/
        // Ex14
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number.");
        int inputInt = scanner.nextInt(); // input.nextInt() võtab sisest nr, annan selle väärtuse int'ile
        System.out.println("Ex14 output is: (entered number) * 10 = " + inputInt * 10);
        System.out.println();
        // input.close(); see sulgeb skänneri!

        // Ex15
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a number.");
        int input1 = in.nextInt();
        System.out.println("Please enter another number.");
        int input2 = in.nextInt();
        int sum = input1 + input2;
        int product = input1 * input2;
        System.out.println("Ex15 output for sum of the entered numbers is:" + sum);
        System.out.println("The sum of the two numbers is: " + (input1+input2)); // teine võimalus kuvada summa
        System.out.println("The sum of the two numbers is: " + input1+input2); // NB: nii ei tohi >> teeb concatenate!!!
        System.out.println("Output for product of the entered numbers is: " + product);

        scanner.close(); // sulgeb skänneri
    }
}
