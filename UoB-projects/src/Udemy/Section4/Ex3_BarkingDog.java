package Udemy.Section4;

public class Ex3_BarkingDog {

    public static void main(String[] args) {
        System.out.println(shouldWakeUp(true,1));
        System.out.println(shouldWakeUp(false,2));
        System.out.println(shouldWakeUp(true,8));
        System.out.println(shouldWakeUp(true,-1));
    }

    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay) {

        if (hourOfDay >= 0 && hourOfDay <= 23) { // ööpäevas on 24h (0-23)
            if (isBarking && hourOfDay < 8 || hourOfDay > 22) {
                return true;
            }
            return false;
        }
        return false;
    }
}
