package Udemy.Section4;

public class Challenge_SecondsAndMinutes {

    private static final String INVALID_MESSAGE_MESSAGE = "Invalid value"; // final = constant, i.e value cannot be changed, NB: name in UPPER CASE!

    public static void main(String[] args) {
        System.out.println(getDurationString(65,45));
        System.out.println(getDurationString(3945));
        System.out.println(getDurationString(-41));
        System.out.println(getDurationString(65,9));
    }

    private static String getDurationString(int minutes, int seconds) { // could be also public class
        if ((minutes < 0) || (seconds < 0) || (seconds > 59)) {
            System.out.println("Invalid value"); // either this way or use the constant (see line 15), both not needed
            return INVALID_MESSAGE_MESSAGE; // constant
        }

        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;

//        // lines 18-29 are for adding the 0 before 1-digit values (optional)
//        String hoursString = hours + "h";
//        if (hours < 10) {
//            hoursString = "0" + hoursString;
//        }
//        String minutesString = remainingMinutes + "m";
//        if (remainingMinutes < 10) {
//            minutesString = "0" + minutesString;
//        }
//        String secondsString = seconds + "s";
//        if (seconds < 10) {
//            secondsString = "0" + secondsString;
//        }
//        return hoursString + " " + minutesString + " " + secondsString + " ";

        return hours + "h " + remainingMinutes + "m " + seconds + "s";
    }

    private static String getDurationString(int seconds) {
        if (seconds < 0) {
            // System.out.println("Invalid value");
            return INVALID_MESSAGE_MESSAGE;
        }

        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return getDurationString(minutes, remainingSeconds);
    }
}
