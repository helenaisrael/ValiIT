package Udemy.Section5;

public class Challenge_SwitchStatement {

    public static void main(String[] args) {
//        int value = 3;
//        if(value == 1) {
//            System.out.println("Value was 1");
//        } else if(value == 2) {
//            System.out.println("Value was 2");
//        } else {
//            System.out.println("Was not 1 or 2");
//        }

        int switchValue = 6;

        switch(switchValue) { // similar to if, BUT we cannot introduce a different variable type like with if (see example above)
            case 1:
                System.out.println("Value was 1");
                break; // do not forget to put a break after each case (i.e. condition)!

            case 2:
                System.out.println("Value was 2");
                break;

            case 3:case 4:case 5: // this is a shortcut
                System.out.println("was a 3 or a 4, or a 5");
                System.out.println("Actually it was a " + switchValue); // to get the specific value
                break;

            default: // similar to else, i.e. all other cases not covered before
                System.out.println("Was not 1, 2, 3, 4 or 5");
                break;
        }



        // Create a new switch statement using char instead of int
        // create a new char variable
        // create a switch statement testing for
        // A, B, C, D, or E
        // display a message if any of these are found and then break
        // Add a default which displays a message saying not found

//        char charValue = 'A';
//        char charValue = 'B';
//        char charValue = 'D';
//        char charValue = 'a';
        char charValue = 'G';
        switch(charValue) {
            case 'A':
                System.out.println("A was found");
                break;
            case 'B':
                System.out.println("B was found");
                break;
            case 'C': case 'D' : case 'E':
                System.out.println(charValue + " was found");
                break;

            default:
                System.out.println("Could not find A, B, C, D or E");
                break;
        }

        String month = "JuNE";
        switch(month.toUpperCase()) { // or .toLowercase - needed to ensure that despite input a correct match is found (if not actually misspelled)
            case "JANUARY": // remember to use the same upper-/lowercase in cases!
                System.out.println("Jan");
                break;
            case "JUNE":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
                break; // could actually be left out in the last case
        }
    }
}
