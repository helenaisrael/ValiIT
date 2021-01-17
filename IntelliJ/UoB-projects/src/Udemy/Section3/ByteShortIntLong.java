package Udemy.Section3;

public class ByteShortIntLong {

    public static void main(String[] args) {
        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte minimum value is " + myMinByteValue);
        System.out.println("Byte maximum value is " + myMaxByteValue);

        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Short minimum value is " + myMinShortValue);
        System.out.println("Short maximum value is " + myMaxShortValue);

        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println("Integer minimum value is " + myMinIntValue);
        System.out.println("Integer maximum value is " + myMaxIntValue);
        //System.out.println("Busted max integer value is " + (myMaxIntValue +1));

        //int myMaxIntTest = 2_147_483_647;

        //long myLongValue = 100L;
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("Long minimum value is " + myMinLongValue);
        System.out.println("Long maximum value is " + myMaxLongValue);

        //short bigShortLiteralValue = 32767;

        int myTotal = (myMaxIntValue /2);
        byte myNewByteValue = (byte) (myMinByteValue /2);
        short myNewShortValue = (short) (myMinShortValue /2);
    }
}

