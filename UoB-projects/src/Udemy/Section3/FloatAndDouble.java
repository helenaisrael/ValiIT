package Udemy.Section3;

public class FloatAndDouble {

    public static void main(String[] args) {
        /*
        float myMinFloatValue = Float.MIN_VALUE;
	    float myMaxFloatValue = Float.MAX_VALUE;
	    System.out.println("Float min value = " + myMinFloatValue);
	    System.out.println("Float max value = " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double min value = " + myMinDoubleValue);
        System.out.println("Double max value = " + myMaxDoubleValue);

        int myIntValue = 5 / 3;
        //float myFloatValue = 5.25f;
        float myFloatValue = 5f / 3f;
        double myDoubleValue = 5.00 / 3.00;
        System.out.println("My IntValue = " + myIntValue);
        System.out.println("My FloatValue = " + myFloatValue);
        System.out.println("My DoubleValue = " + myDoubleValue);
        */

        double nrOfPounds = 1000d;
        double nrOfKilograms = nrOfPounds * 0.45359237d;
        System.out.println("Converted kg-s = " + nrOfKilograms);

        double pi = 3.1415927d;
        double anotherNumber = 3000000.4567890d;
        System.out.println(pi);
        System.out.println(anotherNumber);
    }
}
